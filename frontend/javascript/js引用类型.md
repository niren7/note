# 引用类型

## 基本类型和引用类型的区别

### 基本类型和引用类型的值

基本类型值指的是
简单的数据段，而引用类型值指那些可能由多个值构成的对象。

基本数据类型是按值访问
的，因为可以操作保存在变量中的 **实际的值**。

引用类型的值是保存在内存中的对象。**JavaScript 不允许直接访问内存中的位置**，
也就是说不能直接操作对象的内存空间。在操作对象时，**实际上是在操作对象的引用而不是实际的对象。
为此，引用类型的值是按引用访问的**。

### 复制变量值

从一个变量向另一个变量复制基本类型的值，会在变量对象上创建一个新值，然后把该值复制
到为新变量分配的位置上。

num2中的 5 与 num1 中的 5 是完全独立的
```JavaScript
var num1 = 5;
var num2 = num1;
```

当从一个变量向另一个变量复制引用类型的值时，同样也会将存储在变量对象中的值复制一份放到
为新变量分配的空间中。不同的是，这个值的副本实际上是一个指针，而这个指针指向存储在堆中的一个对象。复制操作结束后，两个变量实际上将引用同一个对象。因此，改变其中一个变量，就会影响另一个变量：

```JavaScript
var obj1 = new Object();
var obj2 = obj1;
obj1.name = "Nicholas";
alert(obj2.name); //"Nicholas"
```

## (object)

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

#### 对象字面量是向函数传递大量可选参数的首选方式

这种传递参数的模式最适合需要向函数传入大量可选参数的情形。一般来讲，命
名参数虽然容易处理，但在有多个可选参数的情况下就会显示不够灵活。**最好的做法
是对那些必需值使用命名参数，而使用对象字面量来封装多个可选参数**。

```JavaScript
function displayInfo(args) {
  var output = "";
  if (typeof args.name == "string"){
  output += "Name: " + args.name + "\n";
  }
  if (typeof args.age == "number") {
  output += "Age: " + args.age + "\n";
  }
  alert(output);
}
displayInfo({name: "Nicholas",age: 29});
displayInfo({name: "Greg"});
```

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

## 函数

**JavaScript中函数是一种对象**

每个函数都是Function 类型的实例，而且都与其他引用类型一样具有属性和方法。由于函数是对象，因此函数名实际上也是一个指向函数对象的指针，不会与某个函数绑定。

### 参数

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

### 函数声明

function 函数名(参数，...) {
	函数体
}
```JavaScript
function sum(a,b) {
	return Number(a) + Number(b);
}
```

函数声明时不必指定形参的类型，因此开发者需要考虑接受错误类型的值的情况。

### 匿名函数

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
