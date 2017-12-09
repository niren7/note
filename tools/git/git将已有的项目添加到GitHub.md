* 先从github创建一个空的仓库,并复制链接地址,最好是复制ssh地址

* 用`git init`初始化本地仓库

* 添加`.gitignore`文件,
    可以把里`https://github.com/github/gitignore/blob/master/Java.gitignore`的文件内容复制到atom里去然后文件保存到对应的项目根目录下
    可以用git check-ignore命令检查
    `git check-ignore -v App.class`
    可以用-f强制添加到Git
    `git add -f App.class`



* `git add .`

* git commit -m ‘提交说明’

* 连接到远程仓库 `git remote add origin 远程仓库地址`
    连接到远程仓库并为该仓库创建别名 , 别名为origin . 这个别名是自定义的，通常用origin ;

* git push origin master
    本地代码推送到别名为 origin 的仓库中的 master 分支上
