# 服务器类别

## 重量级服务器

指实现了javaEE规范的Web服务器，如oracle的weblogic，IBM的websphere，redhat公司的jboss（JBoss核心服务不包括支持servlet/JSP的WEB容器，一般与Tomcat或Jetty绑定使用。）

## 轻量级服务器

Apache的Tomcat，只是JavaEE规范中 **Servlet/JSP规范** 的实现者，也称为Web容器，但不能称为JavaEE容器


# tomcat

## 安装与启动

下载时记得把源码也下载下来，再把压缩文件解压到目录就可以了

新版本的tomcat不需要配CATALINA_HOME，因为在bin目录下的startup.bat文件中已经配置过了

启动只需要运行bin目录下的startup.bat文件，能访问http://localhost:8080/ 则启动成功  

## 目录结构

bin：存放的是可执行文件
conf：存放的是Tomcat服务器的各种全局配置文件，其中包括server.xml（Tomcat的主要配置文件）、tomcat-users.xml和web.xml等配置文件。
lib：存放tomcat服务器所需的各种jar文件。
logs:存放Tomcat的日志文件目录，记录了Tomcat启动和关闭的信息，以及异常信息等。
temp：存放Tomcat的临时文件，这个目录下的东西可以停止后删除。
webapps：存放web项目的目录，其中每个文件夹都是一个项目。
work：运行时生成的文件，最终运行的文件都在这里。通过webapps中的项目生成的。删除后再次运行会重新生成。当客户端用户访问一个JSP文件时，Tomcat会通过JSP生成Java文件，然后再编译Java文件生成class文件，生成的java和class文件都会存放到这个目录下。
LICENSE：许可证。
NOTICE：说明文件。

# 打war包

项目完成后需要打war后发布，war包在Tomcat的webapps中会被自动解压

打包过程

进入到项目目录然后输入命令

`jar cvf 路径 .`

`.`代表将整个目录下所有文件

例如`jar cvf d:\hello.war .`

# 配置文件

















#
