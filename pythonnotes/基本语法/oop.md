# 类

```python
class Student(object):
    pass
```

class后面紧接着是类名，即Student，类名通常是大写开头的单词，紧接着是(object)，表示该类是从哪个类继承下来的，继承的概念我们后面再讲，通常，如果没有合适的继承类，就使用object类，这是所有类最终都会继承的类。

```python
bart = Student()
```
可以自由地给一个实例变量绑定属性
```python
bart.name = 'Bart Simpson'
```
通过定义一个特殊的__init__方法，在创建实例的时候，就把name，score等属性绑上去：

`__init__`方法的第一个参数永远是self，表示创建的实例本身，因此，在`__init__`方法内部，就可以把各种属性绑定到self，因为self就指向创建的实例本身。
```python
def __init__(self, name, score):
        self.name = name
        self.score = score
```
有了`__init__`方法，在创建实例的时候，就不能传入空的参数了，必须传入与`__init__`方法匹配的参数，但self不需要传，Python解释器自己会把实例变量传进去

和普通的函数相比，在类中定义的函数只有一点不同，就是**第一个参数永远是实例变量self**，并且，调用时，不用传递该参数。

双下划线开头的实例变量是不是一定不能从外部访问呢？其实也不是。不能直接访问`__name`是因为Python解释器对外把`__name`变量改成了`_Student__name`，所以，仍然可以通过`_Student__name`来访问`__name`变量：

但是强烈建议不要这么干，因为不同版本的Python解释器可能会把__name改成不同的变量名。

错误写法
```python
>>> bart = Student('Bart Simpson', 98)
>>> bart.get_name()
'Bart Simpson'
>>> bart.__name = 'New Name' # 设置__name变量！
>>> bart.__name
'New Name'
```
表面上看，外部代码“成功”地设置了__name变量，但实际上这个__name变量和class内部的__name变量不是一个变量！内部的__name变量已经被Python解释器自动改成了_Student__name，而外部代码给bart新增了一个__name变量。

## 继承和多态

具体调用的方法由运行时该对象的确切类型决定

对于静态语言（例如Java）来说，如果需要传入Animal类型，则传入的对象必须是Animal类型或者它的子类，否则，将无法调用run()方法。

对于Python这样的动态语言来说，则不一定需要传入Animal类型。我们只需要保证传入的对象有一个run()方法就可以了：

## 获取对象信息

`type()`判断对象类型

判断一个对象是否是函数可以使用types模块中定义的常量：
```python
>>> import types
>>> def fn():
...     pass
...
>>> type(fn)==types.FunctionType
True
>>> type(abs)==types.BuiltinFunctionType
True
>>> type(lambda x: x)==types.LambdaType
True
>>> type((x for x in range(10)))==types.GeneratorType
True
```
`isinstance()`判断一个对象是否是某种类型

`dir()`获得一个对象的所有属性和方法

## 实例属性和类属性

由于Python是动态语言，根据类创建的实例可以任意绑定属性和方法。

给实例绑定属性的方法是通过实例变量，或者通过self变量：

```python
class Student(object):
    def __init__(self, name):
        self.name = name

s = Student('Bob')
s.score = 90
```
在class中定义属性，这种属性是类属性，归Student类所有：
```python
class Student(object):
    name = 'Student'
```

## 使用`__slots__`限制实例

Python允许在定义class的时候，定义一个特殊的`__slots__`变量，来限制该class实例能添加的属性：
```python
class Student(object):
    __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称
```
`__slots__`定义的属性仅对当前类实例起作用，对继承的子类是不起作用的：
在子类中也定义`__slots__`，这样，子类实例允许定义的属性就是自身的`__slots__` **加上** 父类的`__slots__`。

## @property

把一个getter方法变成属性，只需要加上@property就可以了，此时，@property本身又创建了另一个装饰器@score.setter，负责把一个setter方法变成属性赋值

```python
class Student(object):

    @property
    def score(self):
        return self._score

    @score.setter
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value
```

## 多重继承

## 特殊方法

### `__str__()`

### `__repr__()`

### `__iter__()`

如果一个类想被用于for ... in循环，类似list或tuple那样，就必须实现一个`__iter__()`方法，该方法返回一个迭代对象，然后，Python的for循环就会不断调用该迭代对象的`__next__()`方法拿到循环的下一个值，直到遇到StopIteration错误时退出循环。

### `__getitem__()`

要表现得像list那样按照下标取出元素，需要实现`__getitem__()`方法：

`__getitem__()`传入的参数可能是一个int，也可能是一个切片对象slice，所以要做判断：

对step参数作处理：

也没有对负数作处理，所以，要正确实现一个`__getitem__()`还是有很多工作要做的。

此外，如果把对象看成dict，`__getitem__()`的参数也可能是一个可以作key的object，例如str。

与之对应的是`__setitem__()`方法，把对象视作list或dict来对集合赋值。最后，还有一个`__delitem__()`方法，用于删除某个元素。

总之，通过上面的方法，我们自己定义的类表现得和Python自带的list、tuple、dict没什么区别，这完全归功于动态语言的“鸭子类型”，不需要强制继承某个接口。

### `__getattr__`

写一个`__getattr__()`方法，动态返回一个属性。

当调用不存在的属性时，比如score，Python解释器会试图调用`__getattr__(self, 'score')`来尝试获得属性

也可以返回函数,只是调用方式要变

只有在没有找到属性的情况下，才调用`__getattr__`，已有的属性，不会在`__getattr__`中查找。

注意到任意调用如s.abc都会返回None，这是因为我们定义的`__getattr__`默认返回就是None。要让class只响应特定的几个属性，我们就要按照约定，抛出AttributeError的错误：

### `__call__`

一个对象实例可以有自己的属性和方法，当我们调用实例方法时，我们用instance.method()来调用。能不能直接在实例本身上调用呢？在Python中，答案是肯定的。

任何类，只需要定义一个__call__()方法，就可以直接对实例进行调用。请看示例：
```python
class Student(object):
    def __init__(self, name):
        self.name = name

    def __call__(self):
        print('My name is %s.' % self.name)
```

```python
>>> s = Student('Michael')
>>> s() # self参数不要传入
My name is Michael.
```

`__call__()`还可以定义参数。对实例进行直接调用就好比对一个函数进行调用一样，所以你完全可以把对象看成函数，把函数看成对象，因为这两者之间本来就没啥根本的区别。

如果你把对象看成函数，那么函数本身其实也可以在运行期动态创建出来，因为类的实例都是运行期创建出来的，这么一来，我们就模糊了对象和函数的界限。

那么，怎么判断一个变量是对象还是函数呢？其实，更多的时候，我们需要判断一个对象是否能被调用，能被调用的对象就是一个Callable对象，比如函数和我们上面定义的带有`__call__()`的类实例：

## 枚举类

## 元类

### type()

type()函数可以查看一个类型或变量的类型

```python
>>> from hello import Hello
>>> h = Hello()
>>> h.hello()
Hello, world.
>>> print(type(Hello))
<class 'type'>
>>> print(type(h))
<class 'hello.Hello'>
```
Hello是一个class，它的类型就是type，而h是一个实例，它的类型就是class Hello。

type()函数可以创建出新的类型
```python
>>> def fn(self, name='world'): # 先定义函数
...     print('Hello, %s.' % name)
...
>>> Hello = type('Hello', (object,), dict(hello=fn)) # 创建Hello class
>>> h = Hello()
>>> h.hello()
Hello, world.
>>> print(type(Hello))
<class 'type'>
>>> print(type(h))
<class '__main__.Hello'>
```
要创建一个class对象，type()函数依次传入3个参数：

* class的名称；
* 继承的父类集合，注意Python支持多重继承，如果只有一个父类，别忘了tuple的单元素写法；
* class的方法名称与函数绑定，这里我们把函数fn绑定到方法名hello上。

通过type()函数创建的类和直接写class是完全一样的，因为Python解释器遇到class定义时，仅仅是扫描一下class定义的语法，然后调用type()函数创建出class。


### metaclass

除了使用type()动态创建类以外，要控制类的创建行为，还可以使用metaclass。

当我们定义了类以后，就可以根据这个类创建出实例，所以：先定义类，然后创建实例。

但是如果我们想创建出类呢？那就必须根据metaclass创建出类，所以：先定义metaclass，然后创建类。

连接起来就是：先定义metaclass，就可以创建类，最后创建实例。

所以，metaclass允许你创建类或者修改类。换句话说，你可以把类看成是metaclass创建出来的“实例”。

按照默认习惯，metaclass的类名总是以Metaclass结尾，以便清楚地表示这是一个metaclass

```python
# metaclass是类的模板，所以必须从`type`类型派生：
class ListMetaclass(type):
    def __new__(cls, name, bases, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)
```
有了ListMetaclass，我们在定义类的时候还要指示使用ListMetaclass来定制类，传入关键字参数metaclass：
```python
class MyList(list, metaclass=ListMetaclass):
    pass
```
当我们传入关键字参数metaclass时，魔术就生效了，它指示Python解释器在创建MyList时，要通过`ListMetaclass.__new__()`来创建，在此，我们可以修改类的定义，比如，加上新的方法，然后，返回修改后的定义。

`__new__()`方法接收到的参数依次是：

* 当前准备创建的类的对象；
* 类的名字；
* 类继承的父类集合；
* 类的方法集合。

```python

```
```python

```
