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

