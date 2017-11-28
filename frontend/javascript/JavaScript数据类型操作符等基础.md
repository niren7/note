[TOC]


# 数据类型

5种基本数据类型

* 字符串
* 数值型
* Boolean型
* Null型
* Undefined型

除了这5种之外的都被称为Object类型

## Undefined

被声明但未进行任何赋值的变量，其值为undefined.
不过，包含undefined 值的变量与尚未定义的变量还是不一样的()

## Null

从逻辑角度来看，null 值表示一个空对象指针，所以使用typeof 操作符检测null 值时会返回"object"

## Boolean

Boolean 类型的字面值true 和false 是区分大小写的

要将一个值转换为其对应的Boolean 值，可以调用转型函数Boolean()



## 动态数据类型

JavaScript中，值和对象具有数据类型，而 **变量没有数据类型**

如jav中变量有其数据类型，限制了对该变量赋值的值或对象所引用的类型，而JavaScript则可以对其赋任意类型的值，也可以引用任意类型的对象

变量具有数据类型的语言，被称为静态数据类型语言，如java；

变量没有数据类型的语言，被称为东态数据类型语言，如JavaScript；




# 操作符

### ==

相等和不相等——先转换再比较

在转换不同的数据类型时，相等和不相等操作符遵循下列基本规则：

* 如果有一个操作数是布尔值，则在比较相等性之前先将其转换为数值——false 转换为 0，而
true 转换为 1；
* 如果一个操作数是字符串，另一个操作数是数值，在比较相等性之前先将字符串转换为数值；
* 如果一个操作数是对象，另一个操作数不是，则调用对象的 valueOf()方法，用得到的基本类
型值按照前面的规则进行比较；

* null 和 undefined 是相等的。
* 要比较相等性之前，不能将 null 和 undefined 转换成其他任何值。
* 如果有一个操作数是 NaN，则相等操作符返回 false，而不相等操作符返回 true。重要提示：
即使两个操作数都是 NaN，相等操作符也返回 false；因为按照规则， NaN 不等于 NaN。
* 如果两个操作数都是对象，则比较它们是不是同一个对象。如果两个操作数都指向同一个对象，
则相等操作符返回 true；否则，返回 false。

### ===

全等和不全等——在比较之前不转换操作数

#语句

## for-in

for (property in expression) statement

```JavaScript
for (var propName in window) {
document.write(propName);
}
```

## 输出


window.alert() 弹出警告框。
document.write() 方法将内容写到 HTML 文档中。
innerHTML 写入到 HTML 元素。
console.log() 写入到浏览器的控制台。



## 声明变量

var 变量名; 例：var foo;

被声明但未进行任何赋值的变量，其值为undefined.

var关键字是可以省略的，可以直接对变量进行赋值，这样的变量称为隐式声明变量。这样的变量**都是全局变量**，即使是在函数内部隐式声明的变量也属于全局变量。**应当完全避免使用隐式全局变量**
