# 基本设置和概念

安装完 Git 应该做的第一件事就是设置你的用户名称与邮件地址
git config --global user.name "John Doe"
git config --global user.email johndoe@example.com

查看配置信息
git config --list

工作区：就是你在电脑上看到的目录

版本库(Repository)：工作区有一个隐藏目录.git,这个不属于工作区，这是版本库。其中版本库里面存了很多东西，其中最重要的就是stage(暂存区)，还有Git为我们自动创建了第一个分支master,以及指向master的一个指针HEAD。

# 获取仓库

## 在现有目录中初始化仓库

进入对应目录并使用git init命令，然后可以发现该目录下生成了一个.git文件

## 克隆现有的仓库

### clong和checkout的区别

git clone 命令的时候，默认配置下远程 Git 仓库中的每一个文件的每一个版本都将被拉取下来。

git clone [url]
或
git clone [url] 新名字

# 基本操作

cat 文件名 查看文件

git add 文件名 跟踪一个文件

git add . ：他会监控工作区的状态树，使用它会把工作时的所有变化提交到暂存区，包括文件内容修改(modified)以及新文件(new)，但不包括被删除的文件。

git add -u ：他仅监控已经被add的文件（即tracked file），他会将被修改的文件提交到暂存区。add -u 不会提交新文件（untracked file）。（git add --update的缩写）

git add -A ：是上面两个功能的合集（git add --all的缩写）

git status 检查当前文件状态

git status -s 查看简略信息

新添加的未跟踪文件前面有 ?? 标记
新添加到暂存区中的文件前面有 A 标记
修改过的文件前面有 M 标记 M 有两个可以出现的位置，出现在右边的 M 表示该文件被修改了但是还没放入暂存区，出现在靠左边的 M 表示该文件被修改了并放入了暂存区。

git commit 提交更新

git commit -m “提示信息” 给提交添加注释

git commit 加上 -a 选项 Git 就会自动把所有已经跟踪过的文件暂存起来一并提交，从而跳过 git add 步骤

git diff 文件名 查看修改情况

git log 查看历史提交记录

git log --pretty=oneline 简略信息

git reflog 获取版本号，可以根据版本号来恢复到对应版本

git reset --hard HEAD^ 回退到上一个版本

git reset --hard 版本号 根据版本号来恢复到对应版本

git checkout -- 文件名 取消修改，其中 -- 很重要，没有这个就变成创建分支了


# 远程仓库

## 上传到远程仓库

创建SSH Key。在用户主目录下，看看有没有.ssh目录，如果有，再看看这个目录下有没有id_rsa和id_rsa.pub这两个文件，如果有的话，直接跳过此如下命令，如果没有的话，打开命令行，输入如下命令：


ssh-keygen -t rsa –C “你的邮箱地址”

第二步：登录github,打开” settings”中的SSH Keys页面，然后点击“Add SSH Key”,填上任意title，在Key文本框里黏贴id_rsa.pub文件的内容。

添加远程库

登录github上，然后创建一个新的仓库。

根据github的提示把本地仓库推送到GitHub仓库

然后只要本地作了提交，就可以通过如下命令：
git push origin master

git push origin 分支名 推送到远程的对应分支去

## 从远程仓库下载

进入到目标目录然后使用git clone GitHub地址

# 分支

git branch 查看分支，当前分支前会有一个星号

git branch 分支名 创建分支

git checkout 分支名 切换分支

git checkout -b 分支名 创建并切换分支

git branch -d 分支名 删除分支

git merge 分支名 合并分支到当前分支上

git merge --no-ff -m "注释" 分支名 合并分支到当前分支上但是禁用fast forward模式，因为这种模式下删除分支后会丢掉分支信息


















#
