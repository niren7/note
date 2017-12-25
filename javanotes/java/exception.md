# 什么时候抛出异常

http://www.bug315.com/article/99.htm

异常应于何时抛出？答案归于一条原则：

**如果方法遇到一个不知道如何处理的意外情况（abnormal condition），那么它应该抛出异常**

一个更有用的经验法则是：“在有充足理由将某情况视为该方法的典型功能（typical functioning ）部分时，避免使用异常”。

* 如果方法遭遇了一个无法处理的意外情况，那么抛出一个异常。

* 避免使用异常来指出可以视为方法的常用功能的情况。

* 如果发现客户违反了契约（例如，传入非法输入参数），那么抛出非检查型异常。

* 如果方法无法履型契约，那么抛出检查型异常，也可以抛出非检查型异常。

* 如果你认为客户程序员需要有意识地采取措施，那么抛出检查型异常。

# finally块

当try和catch中有return时，finally仍然会执行；执行顺序为：

## finally块不会被执行的情况

* 程序进入try块之前就出现异常时，会直接结束（**finally块一定执行是指从try代码块出来才一定会执行相应的finally代码块。**）

* 在前面的代码中用了System.exit()退出程序。
    System.exit(int) 等价于 Runtime.getRuntime().exit(int) ，也就是说调用的是Runtime.exit(int) 方法。
    Runtime.exit(int) 方法中，一开始会先看当前是否由激活的SecurityManager，如果有则会调用其 SecurityManager.checkExit(int) 方法。该方法的本意是检查程序是否有权限以传入的int status值调用 exit(int) ，如果有权限则什么都不做，否则应该抛出SecurityException。

* 在finally语句块中发生了异常。
    编译期间就会提示unreachable statement

* 程序所在的线程死亡。

* 关闭CPU。

# 抛出异常的类型

Use checked exceptions for recoverable conditions and runtime exceptions for programming errors
——Effective Java

可恢复错误（即程序可以处理并解决错误，例如遇到 io 错误，重试 3次再报告最终用户）的抛出受检异常，程序错误就抛出运行时异常。
# 提早抛出

```java
java.lang.NullPointerException
at java.io.FileInputStream.open(Native Method)
at java.io.FileInputStream.<init>(FileInputStream.java:103)
at jcheckbook.JCheckbook.readPreferences(JCheckbook.java:225)
at jcheckbook.JCheckbook.startup(JCheckbook.java:116)
at jcheckbook.JCheckbook.<init>(JCheckbook.java:27)
at jcheckbook.JCheckbook.main(JCheckbook.java:318)
```

以 上展示了FileInputStream类的open()方法抛出NullPointerException的情况。不过注意 FileInputStream.close()是标准Java类库的一部分，很可能导致这个异常的问题原因在于我们的代码本身而不是Java API。所以问题很可能出现在前面的其中一个方法，幸好它也在堆栈信息中打印出来了。不幸的是，NullPointerException是Java中信息量最少的（却也是最常遭遇且让人崩溃的）异常。它压根不提我们最关心的事情：到底哪里是null。所以我们不得不回退几步去找哪里出了错。

最终确定错误原因是向readPreferences()传入了一个空文件名参数。既然readPreferences()知道它不能处理空文件名，所以 **应该马上检查该条件** ：

```java
public void readPreferences(String filename)
throws IllegalArgumentException{
    if (filename == null){
         throw new IllegalArgumentException("filename is null");
    }  //if
   InputStream in = new FileInputStream(filename);
}
```

通过提早抛出异常（又称＂**迅速失败**＂），异常得以 **清晰又准确**。堆栈信息立即反映出什么出了错（提供了非法参数值），为什么出错（文件名不能为空值），以及哪里出的错（readPreferences()的前部分）。这样我们的堆栈信息就能如实提供：

```java
java.lang.IllegalArgumentException: filename is null
at jcheckbook.JCheckbook.readPreferences(JCheckbook.java:207)
at jcheckbook.JCheckbook.startup(JCheckbook.java:116)
at jcheckbook.JCheckbook.<init>(JCheckbook.java:27)
at jcheckbook.JCheckbook.main(JCheckbook.java:318)
```

# 延迟捕获

没法处理的异常不要捕获，抛到上层再处理

程序有能力处理异常之前就捕获异常，通常会导致更严重的错误和其他异常。不能处理或者不应该由当前对象处理抛出可能会是更好的选择。

没有能力处理异常而catch这样会导致错误在之后发生，在查找错误的时候会误导开发人员出错的真正原因和错误发生位置。

例如readPreferences()方法在调用FileInputStream构造方法时立即捕获和记录可能抛出的FileNotFoundException

```java
public void readPreferences(String filename){
   InputStream in = null;
   // DO NOT DO THIS!!!
  try{
     in = new FileInputStream(filename);
  }
  catch (FileNotFoundException e){
      logger.log(e);
  }
  in.read(...);
}
```

如果文件无法找到，下面的方法显然无法读取它。如果 readPreferences()被要求读取不存在的文件时会发生什么情况？当然，FileNotFoundException会被记录下来，如果我们 当时去看日志文件的话，就会知道。然而当程序尝试从文件中读取数据时会发生什么？既然文件不存在，变量in就是空的，一个 NullPointerException就会被抛出。

调试程序时，本能告诉我们要看日志最后面的信息。那将会是NullPointerException，非常让人讨厌的是这个异常非常不具体。**错误信息不仅误导我们什么出了错（真正的错误是FileNotFoundException而不是NullPointerException），还误导了错误的出处。** 真正的问题出在抛出NullPointerException处的数行之外，这之间有可能存在好几次方法的调用和类的销毁。我们的注意力被这条小鱼从真正的错误处吸引了过来，一直到我们往回看日志才能发现问题的源头。

readPreferences() **真正应该做的事情不是捕获这些异常**，那应该是什么？看起来有点有悖常理，通常最合适的做法其实是什么都不做，不要马上捕获异常。把 **责任** 交给 readPreferences()的 **调用者**，让它来研究处理配置文件缺失的恰当方法，它有可能会提示用户指定其他文件，或者使用默认值，实在不行的话也 许警告用户并退出程序。

在声明可能抛出的异常时，注意越具体越好。这用于标识出调用你方法的程序需要知晓并且准备处理的异常类型。

```java
public void readPreferences(String filename)
throws IllegalArgumentException,
FileNotFoundException, IOException{
    if (filename == null){
           throw new IllegalArgumentException("filename is null");
     }  //if
     InputStream in = new FileInputStream(filename);
}

```
