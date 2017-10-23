[TOC]

# 格式

定义注解格式：
public @interface 注解名 {定义体}

添加属性
类型 属性名称() default 默认值;
String password() default "123456";

支持的数据类型

1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
2.String类型
3.Class类型
4.enum类型
**5.Annotation类型	实现嵌套配置**
6.以上所有类型的一维数组

# 元注解

@Retention表示需要在什么级别保存该注释信息，用于描述注解的**生命周期**（即：被描述的注解在什么范围内有效）

**最常用的为@Retention(RetentionPolicy.RUNTIME)，只有标注为runtime才能在运行时获取到注解。所以一定要记得设定为runtime**

@Target说明了Annotation所修饰的对象范围（即：被描述的注解可以用在什么地方）

@Inherited：@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。

@Documented:

# 注解处理器

java.lang.reflect.AnnotatedElement

注解处理器通过反射来获取注解的信息

http://www.cnblogs.com/peida/archive/2013/04/26/3038503.html
