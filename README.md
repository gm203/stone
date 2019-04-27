# stone

#### 介紹
基于SpringBoot2.1的权限管理系统：易读易懂、界面简洁美观，没有任何重度依赖；
核心技术采用Spring Boot、MyBatis、Druid、Shiro、Thymeleaf、Lombok、Fastjson。

#### 架構
架構說明

####  V-1.0.0 已实现功能

1、用户管理：用户是系统操作者，该功能主要完成系统用户配置；

2、部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限；

3、岗位管理：配置系统用户所属担任职务；

4、菜单管理：配置系统菜单，操作权限，按钮权限标识等；

5、角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分；

6、字典管理：对系统中经常使用的一些较为固定的数据进行维护；

7、参数管理：对系统动态配置常用参数；

8、通知公告：系统通知公告信息发布维护；

9、操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询；

10、登录日志：系统登录日志记录查询包含登录异常；

11、在线用户：当前系统中活跃用户状态监控；

12、定时任务：在线（添加、修改、删除)任务调度包含执行结果日志；

13、系统接口：根据业务代码自动生成相关的API接口文档；

14、服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息；

15、连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈；

#### 请码农喝杯咖啡

![WAI](http://files.git.oschina.net/group1/M00/07/71/PaAvDFy-zdiAVryAAAClnmDz64I389.jpg)

#### 技术视频分享 （链接: https://pan.baidu.com/s/12rMXHU8CVlb1UqBdcb-Dng 提取码: ri6v ）

1、Java 基础视频
2、设计模式讲解
3、系统架构视频
4、SpringCloud 视频
5、MongoDB


#### 后续迭代功能

一、V-1.1.0 租户模式的实现：

1、租户管理（可管理配置租户的数据源）；

2、数据库级别的动态数据源；


二、V-2.0.0 服务化 （计划用SpringCloud拆分整个系统）

1、 将系统用户抽象成统一用户系统；

2、 加入门户系统；

3、 集成ELK， ES作为数据中心， L作为分布式日志的收集方案，K作为可视化展现方案；


最终形成底层、中台和门户三维一体的解决方案，路很长，欢迎志同道合的朋友加入！