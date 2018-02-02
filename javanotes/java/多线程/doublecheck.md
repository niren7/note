# double check

为了保证某种资源只被初始化一次

这种写法在并发的情况会有问题,应该要给resource加上volatile关键字

```java
private Resource resource;

public Resource getResource() {
  Resource tmp = this.resource;                 //第1步
  if (tmp == null) {                            //第2步
    synchronized(this){                         //第3步
      tmp = this.resource                       //第4步
      if (tmp == null) {                        //第5步
        this.resource = tmp = new Resource();   //第6步    
      }     
    }    
  }  
  return tmp;  
}  
```

正确写法

```java
private volatile Resource resource;

public Resource getResource() {
  Resource tmp = this.resource;  
  if (tmp == null) {   
    synchronized(this){
      tmp = this.resource   
      if (tmp == null) {  
        this.resource = tmp = new Resource();    
      }     
    }    
  }  
  return tmp;  
}  
```


new Resource() 可以分解为:

```java
memory =allocate();     //1：分配对象的内存空间
ctorInstance(memory);   //2：初始化对象
instance =memory;       //3：设置instance指向刚分配的内存地址
```

如果被重排为

```java
memory = allocate();     //1：分配对象的内存空间
instance = memory;       //2：设置instance指向刚分配的内存地址
ctorInstance(memory);   //3：初始化对象
```

那么在已经完成将instance指向内存地址之后但对象初始化未完成的时候有另一个线程执行到第2步判断对象是否为空的时候,这时候就会直接将对象返回,但初始化未完成就会出错.

```java

```
```java

```
```java

```
```java

```
```java

```















































































































































#
