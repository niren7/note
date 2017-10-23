[TOC]

# 概念

当我们编写完一个 Java 项目之后，所有的 Java 文件都会被编译成一个.class 文件，这些 Class 对象承载了这个类型的父类、接口、构造函数、方法、属性等原始信息，这些 class 文件在程序运行时会被 ClassLoader 加载到虚拟机中。**当一个类被加载以后，Java 虚拟机就会在内存中自动产生一个 Class 对象。**我们通过 new 的形式创建对象实际上就是通过这些 Class 来创建，只是这个过程对于我们是不透明的而已。

编译生成的Class文件包括了类的许多信息如字段信息，方法信息，常量池等等，详情见深入理解java虚拟机



# Class

构造方法私有，只有JVM能创建Class对象

## 获取方式

Class c1 = Foo.class;

表明任何一个类都有一个隐含的静态成员变量class

Class c2 = foo1.getClass();

获得的Class对象为运行时真正所指的对象所属的类的Class对象
如父类对象的引用指向子类对象，这时返回的为子类的的Class，**具体细节记得看虚拟机细节**

Class c3 = Class.forName("com.imooc.reflect.Foo");

一个类只可能是Class类的一个实例对象，所以c1,c2,c3相等


# 静态加载和动态加载

静态加载 在编译时刻就需要加载所有的可能使用到的类

例如用new创建对象

动态加载 运行时刻才加载类

例如Class.forName();


# 反射时访问私有将Accessible设置为true

Accessible熟悉**并不是**用来决定是否可以访问的，是用来判断是否需要进行安全检查，






































