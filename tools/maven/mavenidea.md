# 资料

idea
https://www.jetbrains.com/help/idea/maven.html
maven官方中链接
http://books.sonatype.com/mvnex-book/reference/

# 创建多模块项目

## 创建父模块

File | New | Project

Select **Maven** from the options on the left.

Specify project's SDK (JDK) Click Next.

specify
   * GroupId - a package of a new project.
   * ArtifactId - a name of your project.
   * Version - a version of a new project. By default, this field is specified automatically.
Click Next.

创建父模块不使用archetype

Specify the name and location settings. Click Finish.

删除src文件夹

## 创建子模块

In the **Project** tool window, right-click your project (or in the main menu, click File) and select **New | Module** to add a sub project.

然后用正常方式创建模块

# 创建web项目

http://zhuanlan.51cto.com/art/201706/542811.htm

* 创建一个基于Maven的Java Web工程
    有两个webapp模板,要选择maven-archetype-webapp模板

* 创建完成后在pom.xml添加Servlet和jsp的依赖
```
<dependency>  
<groupId>javax.servlet</groupId>  
<artifactId>javax.servlet-api</artifactId>  
<version>3.1.0</version>
<scope>provided</scope>  
</dependency>  
<dependency>  
<groupId>javax.servlet.jsp</groupId>  
<artifactId>javax.servlet.jsp-api</artifactId>  
<version>2.3.1</version>
<scope>provided</scope>  
</dependency>
```

* 配置tomcat
    选择菜单Run/Edit Configurations…
    在弹出的对话框中选择左上角的+号，添加本地Tomcat服务
    在右侧窗口中点击server对应的Configure按钮，在新弹出的对话框中，选择一个tomcat的安装目录
    在界面的右下角会有个警告，点击fix按钮，会将web工程部署到tomcat上去
    同时还可以在server的name后面勾选share复选框,这样在后续的web工程中就不需要反复的去配置tomcat了




































#
