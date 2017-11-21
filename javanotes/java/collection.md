[TOC]

# 工具类注意事项

原始类型数组不能作为asList()的输入参数，因为asList方法输入的是一个泛型变长参数，而基本类型是不能泛型化的，所以传递给asList()的会是个数组对象

asList产生的List对象不可更改
它返回的是工具类Arrays类的一个内部类ArrayList，而不是util中的ArrayList。

