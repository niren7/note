# final

final和static同时修饰变量时

final在一个对象类唯一，static final在多个对象中都唯一
static final修饰引用类型时引用地址不可变，但对象里面的内容可变
static final修饰基本类型时值不能被修改

* final标记的变量（成员变量或局部变量）即成为常量，只能赋值一次
    * 基本类型，是值不能被改变
    * 引用类型，是地址值不能被改变,对象中的属性可以改变
* final变量赋值
    * 定义时直接赋值
    * 构造函数中赋值
    * 还被static修饰时可以在静态代码块中赋值
    * final标记的局部变量可以只声明不赋值，然后再进行一次性的赋值
