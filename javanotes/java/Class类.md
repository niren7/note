# Class对象

Class **对象**(java.lang.Class instance) 是类的java镜像(Java mirror)

# Class对象存放的区域

Class对象如同堆中其他对象一样，存在于GC堆中。

# Class对象何时创建

类加载器加载过程中创建

# 作用

java.lang.Class实例并不负责记录真正的类元数据，而只是对VM内部的InstanceKlass对象的一个包装 **供Java的反射访问用。**

# 注意事项

基本类型也有对应的Class对象(https://www.zhihu.com/question/55857335/answer/146837989),
并且和它们对应的包装类的Class对象不是同一个
