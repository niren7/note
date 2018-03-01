在HotSpot VM中，对象、类的元数据（InstanceKlass）、类的Java镜像，三者之间的关系是这样的：

```
Java object      InstanceKlass       Java mirror
 [ _mark  ]                          (java.lang.Class instance)
 [ _klass ] --> [ ...          ] <-\              
 [ fields ]     [ _java_mirror ] --+> [ _mark  ]
                [ ...          ]   |  [ _klass ]
                                   |  [ fields ]
                                    \ [ klass  ]
```


每个Java对象的对象头里，`_klass`字段会指向一个VM内部用来记录类的元数据用的InstanceKlass对象；InsanceKlass里有个`_java_mirror`字段，指向该类所对应的Java镜像——java.lang.Class实例。HotSpot VM会给Class对象注入一个隐藏字段“klass”，用于指回到其对应的InstanceKlass对象。这样，klass与mirror之间就有双向引用，可以来回导航。

这个模型里，java.lang.Class实例并不负责记录真正的类元数据，而只是对VM内部的InstanceKlass对象的一个包装供Java的反射访问用
