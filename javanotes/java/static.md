[TOC]

# 静态域存放的位置

从JDK 1.3到JDK 6的HotSpot VM，静态变量保存在类的元数据（InstanceKlass）的末尾
从JDK 7开始的HotSpot VM，静态变量则是保存在类的Java镜像（java.lang.Class实例）的末尾。

静态域存储于定义类型的Class对象中(详细见https://www.zhihu.com/question/59174759)

ClassLoader加载过程中，对字节码流解析的过程中会创建对应类元数据类型Klass的java镜像-Class对象，参考Class对象的创建函数java_lang_Class::create_mirror()会发现，创建Class对象的同时会对用户定义类型中的static成员变量做初始化赋值，当然这里的初始化仅仅是根据相应static field的类型赋予相应的初始值，并非用户实际给定的值——除非用户没有给static field指定初始值或者用户指定了一个与默认值相同的初始值；字节码流解析完成之后，在类加载的初始化阶段，会调用< clinit >这样一个特殊的函数

# 静态变量

从JDK 7开始的HotSpot VM，静态变量则是保存在类的Java镜像（java.lang.Class实例）的末尾。

## 静态变量一定要先声明后赋值

java通用的开发规范“变量先声明后使用”

静态变量在类加载时就被分配到Data Area。地址保持不变，所有赋值操作都是值改变。

静态变量在类初始化被加载，jvm会去查找类中的所有静态声明，然后分配空间，但此时还 **没有赋值** ，之后jvm按照类中静态赋值（包括静态类赋值和静态块赋值）的 **先后顺序** 来执行，不先声明再使用的话，程序可能不按期望运行，见“改善java程序151”的32


```java
public class Client {  
     public static  int i=1;  
     static{  
         i=100;  
     }  
     public static void main(String[] args) {  
          System.out.println(i);  //输出为100
    }  
}
```

```java
public class Client {  
     static{  
         i=100;  
     }  
     public static  int i=1;  
     public static void main(String[] args) {  
          System.out.println(i);  //输出为1
     }  
}
```

因为先给静态变量i分配空间,然后按顺序进行赋值.

# 静态方法

# 注意事项

静态方法里只能直接调用同类中其他的静态成员（包括变量和方法）

静态方法不能以任何方式引用this和super关键字，因为静态方法在使用前不用创建任何实例对象，当静态方法调用时，this所引用的对象根本没有产生。

# 静态代码块

类加载的初始化阶段会执行类构造器<clinit>()方法,该方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块static{}中的语句合并产生的

static代码块也叫静态代码块，是在类中独立于类成员的static语句块，可以有多个，位置可以随便放，它不在任何的方法体内，JVM加载类时会执行这些静态的代码块，如果static代码块有多个，JVM将按照它们在类中出现的 **先后顺序** 依次执行它们，每个代码块**只执行一次**。
