# 安装注意

修改`apache-maven-3.5.2\conf\settings.xml`的`<localRepository>D:\package\maven\.m2\repository</localRepository>`来修改本地仓库目录

# 构建过程中的环节

* 清理
    将以前编译的class文件删除
* 编译
    编译java源文件
* 测试
    自动测试，自动调用junit
* 报告
    测试程序执行结果
* 打包
    动态web工程打war包，java工程打jar包
* 安装
    maven特定的概念：把打包得到的文件复制到“仓库中”
* 部署
    将动态web工程生成的war包复制到servlet容器的指定目录下

# 常用maven命令

注意 执行与构建过程相关的maven命令，必须进入pom.xml所在的目录
