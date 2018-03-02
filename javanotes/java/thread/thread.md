[TOC]

# 基本概念

Java虚拟机规范定义所有对基本类型的操作，除了某些对long类型和double类型的操作之外，都必须是原子级的。（这个只有才32位的JVM成立 **未确定**）

所有申明为volatile的变量（包括long和double变量）的读、写都是原子性的

由于在32位JVM中对64位的数据的读、写分两步，每一步读或者写32位的数据，这样就会造成两个线程对同一个变量的读写出现一个线程写高32位、另一个线程写入低32位数据。这样此变量的数据就出现不一致的情况。这时候volatile关键字可以防止这种现象发生，因为java的内存模型保证了valotile修饰的long、double变量的读写是原子性的。





#

Thread中的run方法

@Override
public void run() {
    if (target != null) {
        target.run();
    }
}

target为Runnable对象，所以通过实现Runnable接口也能创建线程

所以如果覆盖了父类的run方法则不会去调用runnable对象中的run方法

synchronized需要使用同一个对象来实现同步，可以使用this指定本类来进行同步

synchronized方法使用的是this锁

静态的同步函数使用锁是该所属字节码文件对象

实现 RunnableRunnable Runnable Runnable Runnable接口的好处： 接口的好处： 接口的好处： 接口的好处：
1，将线程的任务从子类中分离出来，进行了单独封装。
按照面向对象的思想将任务封装成。
2，避免了java单继承的局限性。

# 线程范围共享数据

使用ThreadLocal类

# 多个线程访问共享对象和数据的方式

## 如果每个线程执行的代码相同

可以使用同一个Runnable对象，在Runnable对象中保存共享数据，例如卖票系统就可以这样实现

## 如果每个线程执行的代码不同

1. 将共享数据封装在另一个对象中，然后将这个对象传递给各个Runnable对象，线程对共享数据的操作方法也分配到那个对象上

2. 将Runnable对象作为某一个类中的内部类，共享数据作为外部类德尔成员变量，操作数据的方法也分配给外部类，**以便实现对共享数据进行的操作的互斥和通信**

# lock

将锁释放代码放到finally中以确保资源被释放
