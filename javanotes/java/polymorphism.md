[TOC]

# 特点

编译器是基于引用变量的声明类型而不是实际类型调用方法的，所以只能调用声明类型具有的方法

method invocations allowed by the compiler are based solely on
the declared type of the reference, regardless of the object type.

**7java采用的是动态连接**

java虚拟机知道对象的实际类型，实际调用的会是实际对象类型的方法，即会调用重载后的方法

the Java Virtual Machine (JVM) at runtime knows what the object really is.






























