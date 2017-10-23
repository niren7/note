[TOC]

# 配置

## DispatcherServlet

dispatcherServlet配置/可以实现RESTful风格的url
/*配置不对，最终转到jsp页面是，任然会由dispatcherServlet解析jsp地址，不能根据jsp页面转到handler，会报错

在springmvc的配置文件中配置HandlerAdapter，handlermapping等

如果不配置，DispatcherServlet会从org.springframework.web.servlet包下的一个DispatcherServlet.properties启用默认加载


## HandlerAdapter 处理器适配器

所有处理器适配器都实现了HandlerAdapter，而其中的support方法表明了支持的handler类型

采用simplecontrollerHandlerAdapter支持的handler类型（实现了controller接口）

httprequestHandlerAdapter要求实现httprequesthandler接口，采用这种方法可以通过response修改响应内容，比如json

## 开发handler（controller）

需要实现controller接口才能被simplecontrollerHandlerAdapter

controller接口只有一个handleRequest方法

在springmvc的配置文件中配置handler，根据handlermapping来配置

## handlermapping 处理器映射器

BeanNameUrlHandlerMapping 将bean的name作为url进行查找，需要在配置handler时候指定bean的name，即在配置handler的时候用name配置url

SimpleUrlHandlerMapping配置bean的id通过key-value配置bean（handler）和url的关系，key配置url，value为bean的id

多个映射器可以并存，前端控制器判断url能让那些映射器处理就让那些映射器处理

所有的映射器都实现来handlermapping接口

## 视图解析器


# 注解的处理器映射器，处理器适配器

spring3.1之前使用org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping，如果不配置就会启用这个过时的

使用org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter注解适配器


3.1后使用org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping注解映射器

org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter注解适配器


## 配置

使用<mvc:annotation-driven></mvc:annotation-driven>可以代替单独配置映射器和适配器
并且默认加载了许多的参数绑定方法，比如说json转换解析器，使用这种方法就不用配置上面的了

## 开发注解的handler

使用@controller注解

注解的映射器和注解的适配器必须佩对使用，可以理解为不能使用非注解的映射器进行映射

通过@requestmapping来配置url


## 在sping中加载

可以单个配置

实际开发中使用组件扫描

# 源码分析

通过前端控制器源码分析springmvc的执行过程

第一步前端控制器接受请求

调用dodispatch()

第二部 前端控制器调用处理器映射器找到handler

gethandler

第三步 调用处理器适配器执行handler，的到mav

dandle方法返回modleandview

第4步 视图渲染，将model数据填充request域


# springmvc和mybatis整合

## spring和mybatis整合

mybatis的配置文件下

配置mapper
使用spring，mybatis的整合包进行mapper扫描，所以不用单个配置
此种方式要求xml和接口文件同名并在同一文件下

配置批量扫描的别名

全局setting配置需要的时候加

spring和mybatis整合配置文件

基本配置
数据源
sqlsessionfactory
mapper扫描器


逆向工程生成po类和mapper拷贝到工程中

手动定义商品查询mapper












