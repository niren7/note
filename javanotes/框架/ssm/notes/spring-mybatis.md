[TOC]

## 整合思路

要想生成mapper对象，需要先生成sqlsession，需要spring通过单例方式来sqlsessionfactory

spring和mapper整合生成代理对象(应该指的是sqlsessionfactory的代理对象)，使用sqlsessionfactory创建sqlsession(这一步由spring和mybatis整合自动完成)

持久层的mapper需要由spring来管理

## 整合环境

jar包
mybatis的jar包
spring的jar包
mybatis和spring的整合包，早期由spring官方提供，现在由mybatis提供

## 配置sqlsessionfactory

在application.xml配置sqlsessionfactory

sqlsessionfactory在mybatis和spring的整合包下org.mybatis.spring.SqlSessionFactoryBean.class

configLocation属性代表了mybatis的配置文件

dataSource属性代表数据源，因此需要在本配置文件中配置所需要的配置源
	加载配置文件，再配置数据源

## 原始dao开发(和spring整合后)

### map.xml

要在sqlmapconfig.xml(不是application.xml)中加载user.xml，运行环境environment被整合到spring里所以就去掉了

### dao

dao接口实现类需要注入到sqlsessionfactory ，通过spring进行注入
这里使用spring的声明配置方式，配置dao的bean

即在application.xml中配置
`<bean id="" class="全限定名">`

让dao实现类继承sqlsessiondaosupport类，通过this。getsqlsession()得到sqlsession，同时关闭sqlsession也由spring来管理

### 配置dao

在application.xml配置dao的sqlsessionfactory属性

## mapper代理开发

### xml

### 创建代理对象

#### 通过org.mybatis.spring.mapper.MapperFactoryBean类来配置mapper

mapperInterface属性指定接口

sqlSessionFactory属性指定sqlSessionFactory

加载mapper

但是这种需要针对每个mapper进行配置 


#### org.mybatis.spring.mapper.MapperScannerConfigurer配置(推荐使用)



mapper批量扫描，从包中扫描出mapper接口，与加载mapper扫描所不同的的是加载mapper时加载到运行环境加载的是mapper的配置，即应该是将xml和接口联系起来到环境中，而这是在自动创建代理对象并且在spring容器中注入，
通过批量扫描后因为和spring整合后，使用mapper扫描器，所以1也不需要在mybatis的配置文件中配置扫描了
自动扫描出来的mapper的bean的id为mapper类名(小字母少写)
如果想要扫描多个包，每个包中间用半角逗号分隔

不需要指定id了，因为扫描的是包
basePackage属性指定扫描包
sqlSessionFactoryBeanName属性指定sqlSessionFactory
之所以用sqlSessionFactoryBeanName而不是使用sqlSessionFactory是因为加载配置文件会在sqlSessionFactory后执行，而sqlSessionFactoryBeanName会在加载配置文件后执行

# 逆向工程

mybatis可以针对单表自动生成mybatis执行所需要的代码

实际开发中，常用的逆向工程方式是由数据库的表生成java代码

建议使用java程序方式运行逆向工程，不依赖开发工具

将生成的代码拷贝到自己的工程中，不直接生成到工程是怕覆盖已有的文件










