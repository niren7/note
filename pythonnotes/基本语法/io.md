# 读文件

* open()函数，传入文件名和标示符：

* 调用read()方法可以一次读取文件的全部内容，Python把内容读到内存，用一个str对象表示：

* 最后一步是调用close()方法关闭文件。文件使用完毕后必须关闭，因为文件对象会占用操作系统的资源，并且操作系统同一时间能打开的文件数量也是有限的：
```Python
f = open('/Users/michael/test.txt', 'r')
f.read()
f.close()
```
Python引入了with语句来自动帮我们调用close()方法来避免try catch的繁琐
```Python
with open('/path/to/file', 'r') as f:
    print(f.read())
```
反复调用read(size)方法，每次最多读取size个字节的内容。
调用readline()可以每次读取一行内容。
调用readlines()一次读取所有内容并按行返回list。

要读取非UTF-8编码的文本文件，需要给open()函数传入encoding参数，例如，读取GBK编码的文件：
```Python
f = open('/Users/michael/gbk.txt', 'r', encoding='gbk')
```
遇到有些编码不规范的文件，你可能会遇到UnicodeDecodeError，因为在文本文件中可能夹杂了一些非法编码的字符。遇到这种情况，open()函数还接收一个errors参数，表示如果遇到编码错误后如何处理。最简单的方式是直接忽略：
```Python
f = open('/Users/michael/gbk.txt', 'r', encoding='gbk', errors='ignore')
```

## file-like Object

像open()函数返回的这种有个read()方法的对象，在Python中统称为file-like Object。除了file外，还可以是内存的字节流，网络流，自定义流等等。file-like Object不要求从特定类继承，只要写个read()方法就行。

StringIO就是在内存中创建的file-like Object，常用作临时缓冲。

## 二进制文件

要读取二进制文件，比如图片、视频等等，用'rb'模式打开文件即可：
```Python
f = open('/Users/michael/test.jpg', 'rb')
```
```Python

```

# 写文件

写文件和读文件是一样的

```Python
with open('/Users/michael/test.txt', 'w') as f:
    f.write('Hello, world!')
```


# StringIO

StringIO顾名思义就是在内存中读写str。
```Python
>>> from io import StringIO
>>> f = StringIO()
>>> f.write('hello')
5
>>> f.write(' ')
1
>>> f.write('world!')
6
>>> print(f.getvalue())
hello world!
```
```Python
>>> from io import StringIO
>>> f = StringIO('Hello!\nHi!\nGoodbye!')
>>> while True:
...     s = f.readline()
...     if s == '':
...         break
...     print(s.strip())
...
Hello!
Hi!
Goodbye!
```

# BytesIO

StringIO操作的只能是str，如果要操作二进制数据，就需要使用BytesIO。

```Python
>>> from io import BytesIO
>>> f = BytesIO()
>>> f.write('中文'.encode('utf-8'))
6
>>> print(f.getvalue())
b'\xe4\xb8\xad\xe6\x96\x87'
```
```Python
>>> from io import BytesIO
>>> f = BytesIO(b'\xe4\xb8\xad\xe6\x96\x87')
>>> f.read()
b'\xe4\xb8\xad\xe6\x96\x87'
```

# 操作文件和目录

Python内置的os模块可以直接调用操作系统提供的接口函数。

操作文件和目录的函数一部分放在os模块中，一部分放在os.path模块中

```Python
# 查看当前目录的绝对路径:
>>> os.path.abspath('.')
'/Users/michael'
# 在某个目录下创建一个新目录，首先把新目录的完整路径表示出来:
>>> os.path.join('/Users/michael', 'testdir')
'/Users/michael/testdir'
# 然后创建一个目录:
>>> os.mkdir('/Users/michael/testdir')
# 删掉一个目录:
>>> os.rmdir('/Users/michael/testdir')
```
把两个路径合成一个时，不要直接拼字符串，而要通过os.path.join()函数，这样可以正确处理不同操作系统的路径分隔符。

同样的道理，要拆分路径时，也不要直接去拆字符串，而要通过os.path.split()函数，这样可以把一个路径拆分为两部分，后一部分总是最后级别的目录或文件名：
```Python
>>> os.path.split('/Users/michael/testdir/file.txt')
('/Users/michael/testdir', 'file.txt')
```
os.path.splitext()可以直接让你得到文件扩展名，很多时候非常方便：
```Python
>>> os.path.splitext('/path/to/file.txt')
('/path/to/file', '.txt')
```
这些合并、拆分路径的函数并不要求目录和文件要真实存在，它们只对字符串进行操作。

复制文件的函数居然在os模块中不存在！原因是复制文件并非由操作系统提供的系统调用。理论上讲，我们通过上一节的读写文件可以完成文件复制，只不过要多写很多代码。

shutil模块提供了copyfile()的函数，你还可以在shutil模块中找到很多实用函数，它们可以看做是os模块的补充。

# 序列化

把变量从内存中变成可存储或传输的过程称之为序列化，在Python中叫pickling

序列化之后，就可以把序列化后的内容写入磁盘，或者通过网络传输到别的机器上。

序列化之后，就可以把序列化后的内容写入磁盘，或者通过网络传输到别的机器上。

Python提供了pickle模块来实现序列化。

把一个对象序列化并写入文件：
```Python
>>> import pickle
>>> d = dict(name='Bob', age=20, score=88)
>>> pickle.dumps(d)
b'\x80\x03}q\x00(X\x03\x00\x00\x00ageq\x01K\x14X\x05\x00\x00\x00scoreq\x02KXX\x04\x00\x00\x00nameq\x03X\x03\x00\x00\x00Bobq\x04u.'
```

pickle.dumps()方法把任意对象序列化成一个bytes，然后，就可以把这个bytes写入文件。或者用另一个方法pickle.dump()直接把对象序列化后写入一个file-like Object：
```Python
>>> f = open('dump.txt', 'wb')
>>> pickle.dump(d, f)
>>> f.close()
```
要把对象从磁盘读到内存时，可以先把内容读到一个bytes，然后用pickle.loads()方法反序列化出对象，也可以直接用pickle.load()方法从一个file-like Object中直接反序列化出对象。
```Python
>>> f = open('dump.txt', 'rb')
>>> d = pickle.load(f)
>>> f.close()
>>> d
{'age': 20, 'score': 88, 'name': 'Bob'}
```

# JSON

JSON表示的对象就是标准的JavaScript语言的对象，JSON和Python内置的数据类型对应如下：

JSON类型|Python类型
--------|--------
{}|dict
[]|list
"string"|str
1234.56|int或float
true/false|True/False
null|True/False

Python内置的json模块提供了非常完善的Python对象到JSON格式的转换。

把Python对象变成一个JSON：
```Python
>>> import json
>>> d = dict(name='Bob', age=20, score=88)
>>> json.dumps(d)
'{"age": 20, "score": 88, "name": "Bob"}'
```
dumps()方法返回一个str，内容就是标准的JSON。类似的，dump()方法可以直接把JSON写入一个file-like Object。

JSON反序列化为Python对象

用loads()或者对应的load()方法，前者把JSON的字符串反序列化，后者从file-like Object中读取字符串并反序列化：

```Python
>>> json_str = '{"age": 20, "score": 88, "name": "Bob"}'
>>> json.loads(json_str)
{'age': 20, 'score': 88, 'name': 'Bob'}
```

## 转换class

```Python
import json

class Student(object):
    def __init__(self, name, age, score):
        self.name = name
        self.age = age
        self.score = score
```
dumps()方法的参数列表除了第一个必须的obj参数外，dumps()方法还提供了一大堆的可选参数：

这些可选参数就是让我们来定制JSON序列化。前面的代码之所以无法把Student类实例序列化为JSON，是因为默认情况下，dumps()方法不知道如何将Student实例变为一个JSON的{}对象。

可选参数default就是把任意一个对象变成一个可序列为JSON的对象，我们只需要为Student专门写一个转换函数，再把函数传进去即可：
```Python
def student2dict(std):
    return {
        'name': std.name,
        'age': std.age,
        'score': std.score
    }
```
这样，Student实例首先被student2dict()函数转换成dict，然后再被顺利序列化为JSON：
```Python
print(json.dumps(s, default=student2dict))
```
不过，下次如果遇到一个Teacher类的实例，照样无法序列化为JSON。我们可以偷个懒，把任意class的实例变为dict：
```Python
print(json.dumps(s, default=lambda obj: obj.__dict__))
```
因为通常class的实例都有一个`__dict__`属性，它就是一个dict，用来存储实例变量。也有少数例外，比如定义了`__slots__`的class。

同样的道理，如果我们要把JSON反序列化为一个Student对象实例，loads()方法首先转换出一个dict对象，然后，我们传入的object_hook函数负责把dict转换为Student实例：
```Python
def dict2student(d):
    return Student(d['name'], d['age'], d['score'])
```
```Python

```



















#
