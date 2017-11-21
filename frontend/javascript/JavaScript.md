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

## JavaScript中的对象(object)

JavaScript中的对象是一个名称与值配对的集合，这种名称与值配对被称为**属性**，所以对象可以看做是**属性**的**集合**

### new创建对象

```JavaScript
var o = new Object();
```

### 对象字面量表达式

可以通过对象字面量表达式来生成对象
对象的 key 可以省略引号

```JavaScript
var taoer = {
    // key: value
    name: 'gua',
    height: 169,
}
```

{ 属性名：属性值，属性名：属性值，....}

属性名可以是标识符，字符串值，数字等
属性值可以是一个函数

对对象字面量表达式求值的结果为生成对象的一个引用

### 属性

赋值给尚不存在的属性名，将会新建该属性并赋值

可以通过 . 和 [] 来访问属性

obj['x'] 相当于 obj.x

`[]`里可以是字符字面量，也可以是值为字符串的变量,`.`后则不能是变量

var name = 'x';
obj[name] 相当于 obj.x

删除属性
delete 对象名.属性名
delete 对象名['属性名']
```JavaScript
delete gua.sex
delete gua['sex']
```

## 数组

数组每一项可以保存任何类型的数据
数组的大小是可以动态调整的，即可以随着数据的添加自动增长以容纳新增数据。

JavaScript中数组不是一种内建类型，不过由于有数组字面量的表达方式，所以一般情况下，可以将其作为内建类型使用

### 创建方式

* Array 构造函数

    ```JavaScript
    var colors = new Array();
    ```

    如果预先知道数组要保存的项目数量，也可以给构造数传递该数量，而该数量会自动变成length属性的值。

    ```JavaScript
    var colors = new Array(20);
    ```

    也可以向Array 构造函数传递数组中应该包含的项。

    ```JavaScript
    var colors = new Array("red","blue","green");
    ```

    给构造函数传递一个值的情况

    如果传递的是数值，则会按照该数值创建包含给定项数的数组；而如果传递的是其他类型的参数，则会创建包含那个值的只有一项的数组。

    ```JavaScript
    var colors = Array(3); // 创建一个包含3 项的数组
    var names = Array("Greg"); // 创建一个包含1 项，即字符串"Greg"的数组
    ```

* 使用数组字面量表示法

    ```JavaScript
    var arr = [1,2,3];
    ```

### 检测是否为数组

对于**一个网页**，或者**一个全局作用域**而言，使用`instanceof` 操作符就能得到满意的结果：

```JavaScript
if (value instanceof Array){
    //对数组执行某些操作
}
```

instanceof 操作符的问题在于，它假定只有一个全局执行环境。如果网页中包含多个框架，那实际上就存在两个以上不同的全局执行环境，从而存在两个以上不同版本的Array 构造函数。如果你从一个框架向另一个框架传入一个数组，那么传入的数组与在第二个框架中原生创建的数组分别具有各自不同的构造函数。

ECMAScript 5 新增了`Array.isArray()`方法。

这个方法的目的是最终**确定某个值到底是不是数组**，而不管它是在哪个全局执行环境中创建的。
```JavaScript
if (Array.isArray(value)){
//对数组执行某些操作
}
```

## 动态数据类型

JavaScript中，值和对象具有数据类型，而**变量没有数据类型**

如jav中变量有其数据类型，限制了对该变量赋值的值或对象所引用的类型，而JavaScript则可以对其赋任意类型的值，也可以引用任意类型的对象

变量具有数据类型的语言，被称为静态数据类型语言，如java；

变量没有数据类型的语言，被称为东态数据类型语言，如JavaScript；

## 操作符

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

# 函数

**JavaScript中函数是一种对象**

每个函数都是Function 类型的实例，而且都与其他引用类型一样具有属性和方法。由于函数是对象，因此函数名实际上也是一个指向函数对象的指针，不会与某个函数绑定。

## 参数

在向参数传递基本类型的值时，被传递的值会被复制给一个 **局部变量**（即命名参数，或者用
ECMAScript 的概念来说，就是arguments 对象中的一个元素）。在向参数传递引用类型的值时，会把
这个值在内存中的 **地址** 复制给一个局部变量，因此这个局部变量的变化会反映在函数的外部。

```JavaScript
function addTen(num) {
    num += 10;
    return num;
}
var count = 20;
var result = addTen(count);
alert(count); //20，没有变化
alert(result); //30
```

## 函数声明

function 函数名(参数，...) {
	函数体
}
```JavaScript
function sum(a,b) {
	return Number(a) + Number(b);
}
```

函数声明时不必指定形参的类型，因此开发者需要考虑接受错误类型的值的情况。

## 匿名函数

通过**匿名函数表达式**来定义函数

function (参数，...){
	函数体
}

匿名函数表达式是一种表达式而不是语句，所以可以在表达式内使用。因为是表达式所以它有返回值。

```JavaScript
var sum2 = function (a,b) {
	return Number(a) + Number(b);
}
```

匿名函数的返回值是一个Function对象的引用

上面的例子代表将Function对象的一个引用赋值给sum2

所以可以通过`sum2(1,2);`的方式来调用
