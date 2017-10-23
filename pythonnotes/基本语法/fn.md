# 函数

在Python中，定义一个函数要使用def语句，依次写出函数名、括号、括号中的参数和冒号:，然后，在缩进块中编写函数体，函数的返回值用return语句返回。

```python
def my_abs(x):
    if x >= 0:
        return x
    else:
        return -x
```

函数名其实就是指向一个函数对象的引用，完全可以把函数名赋给一个变量，相当于给这个函数起了一个“别名”：
```python
a = abs
a(-1)       #1
```


## 函数返回多个值

实际返回的是一个tuple

在语法上，返回一个tuple可以省略括号，而多个变量可以同时接收一个tuple，按位置赋给对应的值

## 默认参数

```python
def enroll(name, gender, age=6, city='Beijing'):
```

当不按顺序提供部分默认参数时，需要把参数名写上。
```python
enroll('Adam', 'M', city='Tianjin')
```
**默认参数必须指向不变对象**

## 可变参数

可变参数允许你传入0个或任意个参数，这些可变参数在函数调用时自动组装为一个tuple。

在参数前面加了一个*号，在函数内部，参数numbers接收到的是一个tuple
```python
def calc(*numbers):
```
Python允许你在list或tuple前面加一个*号，把list或tuple的元素变成可变参数传进去：
```python
nums = [1, 2, 3]
calc(*nums)
```

## 关键字参数

关键字参数允许你传入0个或任意个含参数名的参数，这些关键字参数在函数内部自动组装为一个dict。

`**extra`表示把extra这个dict的所有key-value用关键字参数传入到函数的`**kw`参数，kw将获得一个dict，注意kw获得的dict是extra的一份**拷贝**，对kw的改动不会影响到函数外的extra。

```python
def person(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)
person('Bob', 35, city='Beijing')
extra = {'city': 'Beijing', 'job': 'Engineer'}
person('Jack', 24, **extra)
```
如果要限制关键字参数的名字，就可以用命名关键字参数，例如，只接收city和job作为关键字参数。这种方式定义的函数如下：
```python
def person(name, age, *, city, job):
    print(name, age, city, job)
```
和关键字参数`**kw`不同，命名关键字参数需要一个特殊分隔符`*`，`*`后面的参数被视为命名关键字参数。

如果函数定义中已经有了一个可变参数，后面跟着的命名关键字参数就不再需要一个特殊分隔符*了：
```python
def person(name, age, *args, city, job):
    print(name, age, args, city, job)
```


## 参数组合
参数定义的顺序必须是：必选参数、默认参数、可变参数、命名关键字参数和关键字参数。
```python
```
```python
```


# 函数式编程

## 高阶函数

因为**函数名其实就是指向函数的变量**，而函数的参数能接收变量，所以一个函数就能接收另一个函数作为参数，这种函数就称之为高阶函数。
```python
def add(x, y, f):
    return f(x) + f(y)

add(-5, 6, abs)     #11
```

## map/reduce

### map

map()函数接收两个参数，一个是函数，一个是**Iterable**，map将传入的函数依次作用到序列的每个元素，并把结果作为新的 **Iterator(不是Iterable)** 返回。

```python
>>> def f(x):
...     return x * x
...
>>> r = map(f, [1, 2, 3, 4, 5, 6, 7, 8, 9])
>>> list(r)
[1, 4, 9, 16, 25, 36, 49, 64, 81]
```

map()传入的第一个参数是f，即函数对象本身。由于结果r是一个Iterator，Iterator是惰性序列，因此通过list()函数让它把整个序列都计算出来并返回一个list。

### reduce

reduce把一个函数作用在一个序列[x1, x2, x3, ...]上，这个函数必须接收两个参数，reduce把结果继续和序列的下一个元素做累积计算
```python
reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)
```
对一个序列求和
```python
>>> from functools import reduce
>>> def add(x, y):
...     return x + y
...
>>> reduce(add, [1, 3, 5, 7, 9])
25
```
把序列[1, 3, 5, 7, 9]变换成整数13579
```python
>>> from functools import reduce
>>> def fn(x, y):
...     return x * 10 + y
...
>>> reduce(fn, [1, 3, 5, 7, 9])
13579
```
把str转换为int的函数
```python
from functools import reduce

def str2int(s):
    def fn(x, y):
        return x * 10 + y
    def char2num(s):
        return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
    return reduce(fn, map(char2num, s))
```

## filter

filter()接收一个函数和一个序列。filter()把传入的函数依次作用于每个元素，然后根据返回值是True还是False决定保留还是丢弃该元素。

在一个list中，删掉偶数，只保留奇数
```python
def is_odd(n):
    return n % 2 == 1

list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15]))
# 结果: [1, 5, 9, 15]
```

## sorted

sorted()函数是一个高阶函数，它可以接收一个key函数来实现自定义的排序，例如按绝对值大小排序：
```python
sorted([36, 5, -12, 9, -21], key=abs)       # [5, 9, -12, -21, 36]
```
key指定的函数将作用于list的每一个元素上，并根据key函数返回的结果进行排序。

传递reverse参数来反向拍下
```python
sorted([36, 5, -12, 9, -21], key=abs, reverse=True)
```


## 将函数作为返回值

如果不需要立刻求和，而是在后面的代码中，根据需要再计算。可以不返回求和的结果，而是返回求和的函数：
```python
def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum
```
调用lazy_sum()时，返回的并不是求和结果，而是求和函数：
```python
>>> f = lazy_sum(1, 3, 5, 7, 9)
>>> f
<function lazy_sum.<locals>.sum at 0x101c6ed90>
```
调用函数f时，才真正计算求和的结果：
```python
>>> f()
25
```

## 闭包

在一个内部函数中，对外部作用域的变量进行引用，(并且一般外部函数的返回值为内部函数)，那么内部函数就被认为是闭包。

## 匿名函数

lambda语法的定义如下：

`lambda [arg1 [,arg2, ... argN]] : expression`

`lambda x: x * x`实际就是

```python
def f(x):
    return x * x
```
匿名函数有个限制，就是只能有一个表达式，不用写return，返回值就是该表达式的结果。

## 装饰器

想要增强函数的功能，又不希望修改now()函数的定义，这种在代码运行期间动态增加功能的方式，称之为“装饰器”

本质上，decorator就是一个返回函数的高阶函数。

把@log放到now()函数的定义处，相当于执行了语句：`now = log(now)`
```python
@log
def now():
    print('2015-3-25')


#不完整的定义
def log(func):
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper
```

由于log()是一个decorator，返回一个函数，所以，原来的now()函数仍然存在，只是现在同名的now变量指向了新的函数，于是调用now()将执行新函数，即在log()函数中返回的wrapper()函数。

如果decorator本身需要传入参数，那就需要编写一个返回decorator的高阶函数
```python
def log(text):
    def decorator(func):
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator
```
这个3层嵌套的decorator用法如下：
```python
@log('execute')
def now():
    print('2015-3-25')
```
和两层嵌套的decorator相比，3层嵌套的效果是这样的：
```python
now = log('execute')(now)
```
首先执行log('execute')，返回的是decorator函数，再调用返回的函数，参数是now函数，返回值最终是wrapper函数。

函数也是对象，它有__name__等属性，但你去看经过decorator装饰之后的函数，它们的__name__已经从原来的'now'变成了'wrapper'：

因为返回的那个wrapper()函数名字就是'wrapper'，所以，需要把原始函数的__name__等属性复制到wrapper()函数中，否则，有些依赖函数签名的代码执行就会出错。

Python内置的functools.wraps就是干这个事的，所以，一个完整的decorator的写法如下：

```python
import functools

def log(func):
    @functools.wraps(func)
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper
```
或者针对带参数的decorator：
```python
import functools

def log(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator
```

## 偏函数 Partial function

偏函数的作用就是，把一个函数的某些参数给固定住（也就是设置默认值），返回一个新的函数，调用这个新函数会更简单。

int()函数可以把字符串转换为整数，当仅传入字符串时，int()函数默认按十进制转换。如果要转换大量的二进制字符串，每次都传入int(x, base=2)非常麻烦。

```python
int2 = functools.partial(int, base=2)
```
偏函数仅仅是把base参数重新设定默认值为2，但也可以在函数调用时传入其他值

创建偏函数时，实际上可以接收函数对象、*args和**kw这3个参数，当传入：
```python
int2 = functools.partial(int, base=2)
```
实际上固定了int()函数的关键字参数base，也就是：
```python
int2('10010')
```
```python
kw = { 'base': 2 }
int('10010', **kw)
```
当传入：
```python
max2 = functools.partial(max, 10)
```
实际上会把10作为*args的一部分自动加到左边，也就是：
```python
max2(5, 6, 7)
```
相当于：
```python
args = (10, 5, 6, 7)
max(*args)
```

# 模块

```python
' a test module '

__author__ = 'Michael Liao'

import sys

def test():
    args = sys.argv
    if len(args)==1:
        print('Hello, world!')
    elif len(args)==2:
        print('Hello, %s!' % args[1])
    else:
        print('Too many arguments!')

if __name__=='__main__':
    test()
```
第1行是一个字符串，表示模块的文档注释，任何模块代码的第一个字符串都被视为模块的文档注释；

第3行使用__author__变量把作者写进去

```python
if __name__=='__main__':
    test()
```
当我们在命令行运行hello模块文件时，Python解释器把一个特殊变量__name__置为__main__，而如果在其他地方导入该hello模块时，if判断将失败，因此，这种if测试可以让一个模块通过命令行运行时执行一些额外的代码，最常见的就是运行测试。

## 作用域

`__xxx__`这样的变量是特殊变量，可以被直接引用，但是有特殊用途，比如上面的`__author__`，`__name__`就是特殊变量，hello模块定义的文档注释也可以用特殊变量`__doc__`访问，我们自己的变量一般不要用这种变量名；

类似`_xxx`和`__xxx`这样的函数或变量就是非公开的（private），不应该被直接引用，比如`_abc`，`__abc`等；

## 安装第三方模块

在Python中，安装第三方模块，是通过包管理工具pip完成的。
```python

```
```python

```
```python

```
