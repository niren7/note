# 步骤

* 选择新建maven工程,勾选create a simple project

* packaging选择war

* 工程右键点properties

* 选中project facets

* 先取消勾选dynamic web module 再勾选

* 在下方选中Further configuration available

* 将Content directory中的内容改为webapp的路径即src/main/webapp,并勾选Generate web.xml
    Context root为工程名
    Content directory

* 新建jsp文件会在最前面报错,这是确少运行时环境,在pom文件中加入servlet-api的依赖
