

# Linux相关的学习笔记



学习网站： https://www.guru99.com/unix-linux-tutorial.html

1. Linux简介：开源的一个操作系统或者说内核，其功能和Unix极为相似

2. Linux同其他操作系统（如：Windows、Mac OS）的区别是什么？

   > 1. 免费、开源
   >
   > 2. 安全！因为有全球性的开发者社区不断的通过各种措施增强其安全性和健壮性
   >
   > 3. 服务器首选操作系统，因为它相当稳定
   >
   > 4. 文件系统结构不同
   >
   >    > Linux 是树形结构、而Windows是分成了ABCD...等几个盘
   >    >
   >    > <img src="../../JAVAWeb/images/FolderStructure.png" style="zoom:67%;" />
   >
   > 5. 在Linux中，一切都是文件，文件夹、外设、文本、图片等等都是文件
   >
   > 6. 账户
   >
   >    > * Linux上有三种账户：Regular User、Root User、Service User
   >    >
   >    > ### Regular User
   >    >
   >    > A regular user account is created for you when you install Ubuntu on your system. All your files and folders are stored in /home/ which is your home directory. As a regular user, you do not have access to directories of other users.
   >    >
   >    > ### Root User
   >    >
   >    > Other than your regular account another user account called root is created at the time of installation. The root account is a **superuser** who can access restricted files, install software and has administrative privileges. Whenever you want to install software, make changes to system files or perform any administrative task on Linux; you need to log in as a root user. Otherwise, for general tasks like playing music and browsing the internet, you can use your regular account.
   >    >
   >    > ### Service user
   >    >
   >    > Linux is widely used as a Server Operating System. Services such as Apache, Squid, email, etc. have their own individual service accounts.  Having service accounts increases the security of your computer. Linux can allow or deny access to various resources depending on the service.
   >    >
   >    > * Windows上的几种账户 Administrator、Standard、Child、Guest
   >
   > 7. Linux的其他重要文件夹
   >
   >    > <img src="../../JAVAWeb/images/LinuxDirectories.png" style="zoom:67%;" />

3. Linux是怎么诞生的？

   > Linus Torvalds读计算机科学的时候使用Unix操作系统，他觉得该系统有需要优化的地方，但是他的建议（他的建议是什么？）被Unix设计者给拒绝了，因此他便思考着搞一个尊重使用者提出的修改建议和意见的操作系统，于是Linux（Linux is not Unix）1991年便诞生了。

4. Linux

5. cd-Change Directory

   > * cd / 进入根目录
   > * cd ~ 进入用户主目录
   > * cd xxx 进入某个具体目录
   > * cd .. 进入上级目录

6. pwd-Present Working Directory

7. CLI

   > <img src="../../JAVAWeb/images/Terminal_Description.png" alt="Terminal_Description" style="zoom:50%;" />
   >
   > **#**代表root用户
   >
   > **$**代表regular用户
   >
   > 

### Basic Linux/Unix Commands with Examples & Syntax

##### Listing files (ls)

1. `ls`展示当前文件夹下的文件夹/文件

2. `ls -R`递归展示文件夹下的文件夹/文件

3. `ls -a`展示当前文件夹下的全部(包含隐藏的)文件夹/文件

4. `ls -al`展示当前文件夹下的文件的详细信息

   > 每列表示的意义
   >
   > <img src="/Users/feng/gits/JAVAWeb/images/ls-al(2).png" alt="ls-al(2)" style="zoom:50%;" />

##### Creating & Viewing Files

1. `cat > filename`创建一个文本文件

   > 1.  cat > filename
   > 2.  Add content
   > 3.  Press 'ctrl + d' to return to command prompt.

2. `cat filename`查看一个文本文件

3. `cat file1 file2 > file`将file1和file2组合成一个file文件

##### Deleting Files

1. `rm filename`删除一个文件

##### Moving and Re-naming files

1. `mv filename new_file_location`移动filename到new_file_location
2. `mv filename newfilename`给filename重命名

##### Directory Manipulations

1. `mkdir directoryname`创建一个文件夹

   > 1. 也可以是`mkdir /xx/xx/directoryname`这种形式
   > 2. 一次可以创建多个文件夹，如：`mkdir directoryname1 directoryname2`

2. `rmdir directoryname`删除一个文件夹，**要求文件夹为空才能删除**

3. `mv directoryname newdirectoryname`文件夹重命名

##### other

1. `pr -n filename`显示文本文件内容并附带行号
2. `apt-get install packagename`Linux安装软件
3. `clear`清空屏幕
4. `history`显示历史命令

### File Permission

##### Ownership of Linux files

1. User

   > A user is the owner of the file. By default, the person who created a file becomes its owner

2. Group

3. Other

##### Permissions

1. Read 读权限

2. Write 写权限

3. Execute 执行权限

4. `ls -l`

   > ![Permis_system](../../JAVAWeb/images/Permis_system.png)
   >
   > ![Directory](../../JAVAWeb/images/Directory.png)
   >
   > ![its_a_file](../../JAVAWeb/images/its_a_file.png)
   >
   > ![permission(1)](../../JAVAWeb/images/permission(1).png)
   >
   > ![no_execute](../../JAVAWeb/images/no_execute.png)
   >

##### Change Permission

1. 通过数字

   > chmod 777 filename

2. 通过字符

   > 1. 操作符
   >
   >    | **+** | Adds a permission to a file or directory                     |
   >    | ----- | ------------------------------------------------------------ |
   >    | **-** | Removes the permission                                       |
   >    | **=** | Sets the permission and overrides the permissions set earlier. |
   >
   > 2. 用户类型缩写
   >
   >    | u    | user/owner |
   >    | ---- | ---------- |
   >    | g    | group      |
   >    | o    | other      |
   >    | a    | all        |
   ><img src="../../JAVAWeb/images/Symbolic_Mode(1).png" alt="Symbolic_Mode(1)" style="zoom:70%;" />

##### Changing Ownership and Group

1. `chown username filename` 表示将filename设置其owner为username
2. `chown username:groupname filename`同时改变filename的owner和所属的群组
3. `chgrp gourpname filename`只改变filename所属的群组

##### Tips

- The file /etc/group contains all the groups defined in the system
- You can use the command "groups" to find all the groups you are a member of
- You cannot have 2 groups owning the same file.
- You do not have nested groups in Linux. One group cannot be sub-group of other
- x- eXecuting a directory means Being allowed to "enter" a dir and gain possible access to sub-dirs