[TOC]

# 基本语法

## 运算符

### and or

在Python 中，and 和 or 执行布尔逻辑演算。但是它们并不返回布尔值，而是返回它们实际进行**比较的值**之一。

使用 and 时，在布尔上下文中从左到右演算表达式的值。0、''、[]、()、{}、None 在布尔上下文中为假；其它任何东西都为真。

如果布尔上下文中的某个值为假，则 and 返回**第一个假值**。所有值都为真，则 and 返回最后一个真值。

```python
>>> 'a' and 'b'        
'b'
>>> '' and 'b'         
''
>>> 'a' and 'b' and 'c'
'c'
```


使用 or 时，如果有一个值为真，or 立刻返回该值。如果所有的值都为假，or 返回最后一个假值。


#### 使用技巧

实现类似三元表达式效果

bool and a or b
```python
a = "first"
b = "second"    
1 and a or b      #'first'    先判断and表达式计算结果为first然后 'first' or 'second' 的演算值为 'first'。
0 and a or b     #'second'
```

上面这张技巧当a在布尔上下文中的值为假时会**无效**，所以需要**确保 a 的值决不会为假**，最常用的方式是使 a 成为 [a] 、 b 成为 [b]，然后使用返回值列表的第一个元素，应该是 a 或 b中的某一个。

```python
a = ""
b = "second"
(1 and [a] or [b])[0]
```
这种形式比较复杂，但是在 Python 语言的某些情况下 if 语句是不允许使用的，比如在 lambda 函数中。
```python
```


#数据类型

## 可变性

数字、字符串、元组不可变

列表、字典可变

### 布尔

以下表达式值会被当作False：
* False
* None
* 0
* 空字符串，空列表，空字典，空集合


### 列表(list)

```python
lista = [123,'string',1.23]
matrix = [[1,2,3],[4,5,6][7,8,9]]
```

#### 替换

列表可以通过索引和分片来修改。

对于连续的分片（即步长为 1 ），Python采用的是整段替换的方法，两者的元素个数并不需要相同，例如，将 [11,12] 替换为 [1,2,3,4]：
```python
a = [10, 11, 12, 13, 14]
a[1:3] = [1, 2, 3, 4]
print a         # [10, 1, 2, 3, 4, 13, 14]
```

对于不连续（间隔step不为1）的片段进行修改时，两者的元素数目必须一致：

#### 删除

```python
del a[0]
del a[1:]
```
```python

```
```python

```

#### 常用函数

`count(ob)`返回列表中元素 ob 出现的次数。
`index(ob)`返回列表中元素 ob 第一次出现的索引位置，如果 ob 不在 l 中会报错。
`len`函数可以获得list元素的个数
`append(ob)`函数往list中追加元素到末尾,append每次**只添加一个元素**，并不会因为这个元素是序列而将其展开
```python
a.append([11, 12])
print a     # [10, 11, 12, 11, [11, 12]]
```


`insert`函数把元素插入到指定的位置
`pop`删除list末尾的元素也可以删除指定位置的元素

#### 列表生成式

生成`[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]`可以用`list(range(1, 11))`

生成`[1x1, 2x2, 3x3, ..., 10x10]`可以用`[x * x for x in range(1, 11)]`

for循环后面还可以加上if判断,例如得到偶数的平方

`[x * x for x in range(1, 11) if x % 2 == 0]`

还可以使用两层循环

`[m + n for m in 'ABC' for n in 'XYZ']`     
`['AX', 'AY', 'AZ', 'BX', 'BY', 'BZ', 'CX', 'CY', 'CZ']`

for循环可以同时使用两个甚至多个变量,因此，列表生成式也可以使用两个变量来生成list：
```python
d = {'x': 'A', 'y': 'B', 'z': 'C' }
[k + '=' + v for k, v in d.items()]
['y=B', 'x=A', 'z=C']
```

#### 生成器 generator

* 把一个列表生成式的[]改成()，就创建了一个generator

    `g = (x * x for x in range(10))`

    通过next()函数获得generator的下一个返回值：
    `next(g)`
* 用函数来实现。

    如果一个函数定义中包含yield关键字，那么这个函数就不再是一个普通函数，而是一个generator：

    斐波拉契数列
    ```python
    def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'
    ```
    generator和函数的执行流程不一样。函数是顺序执行，遇到return语句或者最后一行函数语句就返回。而变成generator的函数，在每次调用next()的时候执行，遇到yield语句返回，再次执行时从上次返回的yield语句处继续执行。

    ```python
    def odd():
        print('step 1')
        yield 1
        print('step 2')
        yield(3)
        print('step 3')
        yield(5)
    ```

    ```python
    >>> o = odd()
    >>> next(o)
    step 1
    1
    >>> next(o)
    step 2
    3
    >>> next(o)
    step 3
    5
    >>> next(o)
    Traceback (most recent call last):
      File "<stdin>", line 1, in <module>
    StopIteration
    ```

用for循环调用generator时，发现拿不到generator的return语句的返回值。如果想要拿到返回值，必须捕获StopIteration错误，返回值包含在StopIteration的value中：

```python
>>> g = fib(6)
>>> while True:
...     try:
...         x = next(g)
...         print('g:', x)
...     except StopIteration as e:
...         print('Generator return value:', e.value)
...         break
...
g: 1
g: 1
g: 2
g: 3
g: 5
g: 8
Generator return value: done
```

### 字典(dict)
```python
d = {'food':'spam','quantity':4,'color':'pink'}

d = {}
d['name'] = 'bob'
d['job'] = 'dev'
d['age'] = 40

rec = {'name': {'first': 'Bob', 'last': 'Smith'},
'jobs': ['dev', 'mgr'],
'age': 40.5}
```

#### 常用操作

* 判断判断key是否存在
    一是通过in判断key是否存在
    ```python
    d = {'Michael': 95, 'Bob': 75, 'Tracy': 85}
    'Thomas' in d       #False
    ```
    二是通过dict提供的get方法，如果key不存在，可以返回None，或者自己指定的value：
    ```python
    d.get('Thomas')
    d.get('Thomas', -1)
    ```
    ```python
    ```
    ```python
    ```

### 元组(tuple)
只有1个元素的tuple定义时必须加一个逗号,，来消除歧义

```python
t = (1,2,3,4)
```

### set

无序

```python
# 要创建一个set，需要提供一个list作为输入集合：
s = set([1, 2, 3])
# 可以用{}的形式来创建集合：
a = {1, 2, 3, 1}
a # {1, 2, 3}
# 但是创建空集合的时候只能用set来创建，因为在Python中{}创建的是一个空的字典：
```

#### set操作

```python
a = {1, 2, 3, 4}
b = {3, 4, 5, 6}
```

##### 并

可以用方法 a.union(b) 或者操作 a | b 实现。
```python
a.union(b)  
a | b
#{1, 2, 3, 4, 5, 6}
```

##### 交

用方法 a.intersection(b) 或者操作 a & b 实现。

##### 差

可以用方法 a.difference(b) 或者操作 a - b 实现。

##### 对称差

对称差集，返回在 a 或在 b 中，但是不同时在 a 和 b 中的元素组成的集合。

用方法 a.symmetric_difference(b) 或者操作 a ^ b 实现（异或操作符）。

##### 判断包含关系

要判断 b 是不是 a 的子集，可以用 b.issubset(a) 方法，或者更简单的用操作 b <= a ：

与之对应，也可以用 a.issuperset(b) 或者 a >= b 来判断a是不是b的父集：

方法只能用来测试子集，但是操作符可以用来判断真子集：

```python
a <= a      # True
a <= a      # False
```

#### 不可变集合

与集合不同的是，不可变集合一旦创建就不可以改变。使用 frozenset 来进行创建：

```python
s = frozenset([1, 2, 3, 'a', 1])
s   # frozenset({1, 2, 3, 'a'})
```

##### 应用

* 用来作为字典的键

用一个字典来记录两个城市之间的距离
```python


flight_distance = {}
city_pair = frozenset(['Los Angeles', 'New York'])
flight_distance[city_pair] = 2498
flight_distance[frozenset(['Austin', 'Los Angeles'])] = 1233
flight_distance[frozenset(['Austin', 'New York'])] = 1515
flight_distance
```
集合不分顺序，所以**不同顺序不会影响查阅结果**：
```python
flight_distance[frozenset(['New York','Austin'])]   # 1515
flight_distance[frozenset(['Austin','New York'])]   # 1515
```
```python

```
```python

```

### string

Python 3中字符串是以Unicode编码的

由于Python的字符串类型是str，在内存中以Unicode表示，一个字符对应若干个字节。如果要在网络上传输，或者保存到磁盘上，就需要把str变为以字节为单位的bytes。
```python
x = b'ABC'
```

以Unicode表示的str通过encode()方法可以编码为指定的bytes

```python
'中文'.encode('utf-8')
```

把bytes变为str，就需要用decode()方法：
```python
b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8')     #中文
```

三引号用来输入包含多行文字的字符串：

#### ord() char()

ord()函数获取字符的整数表示，chr()函数把编码转换为对应的字符：

```python
print(ord('a'))         #97
print(ord('中'))        #20013
print(chr(65))          #A
```

#### 格式化字符串

```python
'{} {} {}'.format('a', 'b', 'c')
# 用数字指定传入参数的相对位置：
'{2} {1} {0}'.format('a', 'b', 'c')     # 'c b a'


```

```python
```


## 迭代器 Iterable

可以直接作用于for循环的对象统称为可迭代对象：Iterable

可以使用`isinstance()`判断一个对象是否是Iterable对象

```python
isinstance([], Iterable)
isinstance({}, Iterable)
```

生成器不但可以作用于for循环，还可以被next()函数不断调用并返回下一个值，直到最后抛出StopIteration错误表示无法继续返回下一个值了。

可以被next()函数调用并不断返回下一个值的对象称为迭代器：Iterator。

可以使用isinstance()判断一个对象是否是Iterator对象：
```python
isinstance([], Iterator)
isinstance({}, Iterator)
```

生成器都是Iterator对象，但list、dict、str虽然是Iterable，却**不是**Iterator。

把list、dict、str等Iterable变成Iterator可以使用`iter()`函数：
```python
isinstance(iter([]), Iterator)
isinstance(iter('abc'), Iterator)
```

### 为什么list、dict、str等数据类型不是Iterator？

Python的Iterator对象表示的是一个数据流，Iterator对象可以被next()函数调用并不断返回下一个数据，直到没有数据时抛出StopIteration错误。可以把这个数据流看做是一个有序序列，但我们却不能提前知道序列的长度，只能不断通过next()函数实现按需计算下一个数据，所以Iterator的计算是惰性的，只有在需要返回下一个数据时它才会计算。

Iterator甚至可以表示一个无限大的数据流，例如全体自然数。而使用list是永远不可能存储全体自然数的。


## slice(切片)

用法：`var[lower:upper:step]`

其范围包括 lower ，但不包括 upper ，即 [lower, upper)， step 表示取值间隔大小，如果没有默认为1。

lower和upper可以省略，省略lower意味着从开头开始分片，省略upper意味着一直分片到结尾。

当step的值为负时，省略lower意味着从结尾开始分片，省略upper意味着一直分片到开头。

``` python
s = 'abcde'
s[1:3]     # bc
s[1:]      # bcde              
s[:3]      # abc
s[:-1]     # abcd

# 当step的值为负时，省略lower意味着从结尾开始分片，省略upper意味着一直分片到开头。
s[::-1]     # edcba
```

### 使用[low, up)形式的原因

计算子串长度直接为 up - low，且表示方法下标从0开始

### 使用0-base的形式的原因



从头开始的n个元素；
    * 使用0-base：[0, n)
    * 使用1-base：[1, n+1)

第i+1个元素到第i+n个元素。
    * 使用0-base：[i, n+i)
    * 使用1-base：[i+1, n+i+1)

1-base有个+1部分，所以不推荐。

# Python 赋值机制

## 简单类型

```python
>>> x = 500
>>> y = x
>>> id(x)
3177350803184
>>> id(y)
3177350803184
>>> y = 'foo'
>>> id(y)
3177355717856
>>>
```

Python分配了一个 PyInt 大小的内存 pos1 用来储存对象 500 ，然后，Python在命名空间中让变量 x 指向了这一块内存

Python并没有使用新的内存来储存变量 y 的值，而是在命名空间中，让变量 y 与变量 x 指向了同一块内存空间。

Python此时分配一个 PyStr 大小的内存 pos2 来储存对象 foo ，然后改变变量 y 所指的对象。

### 不可变类型缓存

Python2.5.4以后简单整数缓存范围至少是(-5,256)。所有的短字符也都在缓存区。

```Python
>>> x = 2
>>> id(x)
1856030416
>>> y = 2
>>> id(y)
1856030416
>>>
```

## 容器类型

可通过id函数来验证
```Python
x = [500, 501, 502]
y = x
y[1] = 600
y = [700, 800]
# Python为3个PyInt分配内存 pos1 ， pos2 ， pos3 （不可变），然后为列表分配一段内存 pos4 ，它包含3个位置，分别指向这3个内存，最后再让变量 x 指向这个列表。
x = [500, 501, 502]
# 并没有创建新的对象，只需要将 y 指向 pos4 即可。
y = x
# 原来 y[1] 这个位置指向的是 pos2 ，由于不能修改 pos2 的值，所以首先为 600 分配新内存 pos5 。

#再把 y[1] 指向的位置修改为 pos5 。此时，由于 pos2 位置的对象已经没有用了，Python会自动调用垃圾处理机制将它回收。
y[1] = 600
# 首先创建这个列表，然后将变量 y 指向它。
y = [700, 800]
```
```Python

```
```Python

```
```Python

```




























































#
