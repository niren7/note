# 数组

The Java Language Specification这样说

In the Java programming language, arrays are objects (§4.3.1), are dynamically created, and may be assigned to variables of type Object (§4.3.2). All methods of class Object may be invoked on an array.

数组是对象,但是这个数组对象并不是从某个类实例化来的，而是由JVM直接创建的，因此查看类名的时候会发现是很奇怪的类似于"[I"这样的样子，这个直接创建的对象的父类就是Object，所以可以调用Object中的所有方法

数组对象不是从某个类实例化来的，而是由JVM直接创建的.实际上也没有Array这个类（有是有，但只是java.lang.reflect包里的一个反射类）**但每个数组都对应一个Class对象**。通过RTTI（Run-Time Type Information）可以直接检查Array的运行时类型以及它的签名，它的基类，还有其他很多事。

```java
char[] c={'a','b','c'};
System.out.println(c.getClass().getName()); //[C
System.out.println(c.getClass().getSuperclass().getName()); //java.lang.Object
```

这里“[C”就是char[]的运行时类型签名。而且是它的 **全限定名**，没有包名。

每种类型的数组的签名都不同

还能用运行时类型签名得到Array的Class对象

```java
try {
    Class<?> theClass = Class.forName("[I");
    System.out.println(theClass.getName());
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```

# 不设计数组类的原因

数组的类名由若干个'['和数组元素类型的内部名称组成，'['的数目代表了数组的维度。

Java数组类的数量与元素类型、维度(最多255)有关，相当相当多了，是没法预先声明好的。所以需要JVM根据元素类型和维度，**动态的** 创建相应的数组类

```java
int a[] = new int[10];   
Class clazz = a.getClass();     
System.out.println(clazz.getDeclaredFields().length);    // 0
System.out.println(clazz.getDeclaredMethods().length);    // 0  
System.out.println(clazz.getDeclaredConstructors().length);   // 0   
System.out.println(clazz.getDeclaredAnnotations().length);    // 0  
System.out.println(clazz.getDeclaredClasses().length);     // 0
System.out.println(clazz.getSuperclass());   //class java.lang.Object
```

可见，[I这个类是java.lang.Object的直接子类，自身没有声明任何成员变量、成员方法、构造函数和Annotation

数组类中连length这个成员变量都没有,获取数组长度是由一条特定的指令arraylength实现


```java
public class Main {     
    public static void main(String[] args)   {   
        int a[] = new int[2]; int i = a.length;     
    }     
}  
```

```java
0 iconst_2                   //将int型常量2压入操作数栈    
1 newarray 10 (int)    //将2弹出操作数栈，作为长度，创建一个元素类型为int, 维度为1的数组，并将数组的引用压入操作数栈    
3 astore_1                 //将数组的引用从操作数栈中弹出，保存在索引为1的局部变量(即a)中    
4 aload_1                  //将索引为1的局部变量(即a)压入操作数栈    
5 arraylength            //从操作数栈弹出数组引用(即a)，并获取其长度(JVM负责实现如何获取)，并将长度压入操作数栈    
6 istore_2                 //将数组长度从操作数栈弹出，保存在索引为2的局部变量(即i)中    
7 return                    //main方法返回      
```

JVM创建数组类，应该就是由newarray这条指令触发的。






#
