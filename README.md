## 简介

本项目是一个演示项目，旨在展示使用`SpringCloud`框架与`Docker`技术构建一个分布式的、微服务化的分布式Java服务器应用。本项目虚构一个需求，服务器用来管理用户的车辆和有车辆产生的指出。模块划分大致有以下几个部分：

* kuruma-corenode: 服务的注册与发现
* kuruma-config-server: 中心化的配置服务
* kuruma-user: 用户服务
* kuruma-car: 车辆管理服务
* kuruma-bill: 车辆账单服务
* kuruma-common: 通用工具等

> 注意: 本项目代码实际使用的是[Kotlin](http://kotlinlang.org/)语言。这也是一种在JVM上执行的编程语言。

## 开发环境

#### 软件环境

* **os**: Linux Ubuntu 16.04.1
* **docker**: 1.11.2
* **docker-compose**: 1.7.1
* **jdk**: java8
* **maven**: 3.3.9

> 注意: 本人的docker宿主机为 Linux Ubuntu 16.04.1，这并不是硬性要求。

#### docker基础镜像

* **yingzhuo/java:8**: 这个镜像封装了JDK8，本项目所有SpringCloud程序都以这个为基础镜像。
* **mysql:5.5.49**: MySQL
* **redis:3.2.3**: Redis

在中国🇨🇳境内，下载镜像要花费较长时间。强烈建议在尝试启动本项目之前，完成镜像拉取。命令如下:

```bash
docker pull yingzhuo/java:8
docker pull mysql:5.5.49
docker pull redis:3.2.3
```

## 启动目录

在docker宿主机上构建一个目录，用于文件的统一管理。

```bash
mkdir -p /home/yingzhuo/projects/kuruma
```

> 注意: 本人的启动目录在`/home/yingzhuo/projects/kuruma`，并不意味你的启动目录页必须在这里。

启动目录的结构如下:

```
kuruma/
├── config
│   ├── mysql
│   │   └── mysql-docker.cnf📃
│   └── redis
│       └── redis-docker.cnf📃
├── docker-compose.yml📃
├── logs
│   ├── bill
│   │   └── old
│   ├── car
│   │   └── old
│   ├── config-server
│   │   └── old
│   ├── corenode
│   │   └── old
│   └── user
│       └── old
├── rerun.sh📃
└── volume
    ├── mysql
    │   └── data
    └── redis
        └── data
```

> 注意: 上面被emoji📃标出的是文件，文件内容下面给出。其余的都是目录，依次自行创建即可。

* [mysql-docker.cnf](https://github.com/yingzhuo/kuruma/tree/master/docker-cnf/mysql/mysql-docker.cnf)
* [redis-docker.cnf](https://github.com/yingzhuo/kuruma/tree/master/docker-cnf/redis/redis-docker.cnf)
* [docker-compose.yml](https://github.com/yingzhuo/kuruma/blob/master/docker-cnf/docker-compose.yml)
* [rerun.sh](https://github.com/yingzhuo/kuruma/blob/master/rerun.sh)

## 启动项目

> 注意: 如果没有特别说明，那么工作目录就是上面所说的启动目录。

#### 拷贝数据库脚本
拷贝脚本[kuruma.sql](https://github.com/yingzhuo/kuruma/blob/master/data/kuruma.sql)到宿主机的`/tmp`目录下

#### 数据库初始化

第一启动本应用时，数据库初始化非常重要。如果跳过这个步骤的话，会导致所有依赖数据库的服务启动失败。
为什么呢？原因很简单，第一启动`MySQL`镜像时，数据库还没有被简历。会导致数据库连接池Bean构建失败。

```bash
docker run \
	--name duck \
	-v /home/yingzhuo/projects/kuruma/config/mysql/:/etc/mysql/conf.d \
	-v /home/yingzhuo/projects/kuruma/volume/mysql/data:/var/lib/mysql \
	-v /tmp:/tmp \
	-e MYSQL_ROOT_PASSWORD=root \
	-p 13306:3306 \
	-d \
	mysql:5.5.49
```

这样，MySQL的镜像就启动起来了。 接下来，我们需要创建名为`kuruma`的数据库。

以下命令用户“登录”到容器内部。

```bash
docker exec -it duck bash
```

这样，就可以使用`mysql`客户端工具建数据库并导入表结构。

```
mysql -uroot -proot
```

```
create database kuruma
\. /tmp/kuruma.sql
```

> 注意1: `duck`是给MySQL容器临时起的名字，为了方便记忆。其他地方用不到了。

> 注意2: 如果愿意用图形化的MySQL管理工具(如: Navicat等)，其实也可以。容器的端口已经映射到`13306`了。

> 注意3: 启动命令中的启动目录应当替换掉。

最后，名为`duck`的MySQL容器就用不到了，停止容器删除即可。 

```bash
docker stop duck
docker rm duck
```

如果愿意的话，建表脚本也可以删除。

```bash
rm /tmp/kuruma.sql
```

#### 启动!

```bash
bash rerun.sh
```

使用启动脚本即可，本脚本会自动成Github下载源代码，完成编译、打包、构建镜像、启动容器等一系列工作。

> 注意: 这个过程需要从Maven中央库下载众多依赖的Jar包，可能耗时较长，要有耐心。

#### 检查启动结构

通过浏览器访问 `http://宿主机IP:8761`即可看到`Spring Eureka`的统计页面。 如果有四个服务被发现和注册那么说明启动成功了。

## 其他

1. `kuruma`是日语罗马字，是“汽车”的意思。

## 联系我

![QQ](http://img.shields.io/badge/QQ-23007067-blue.svg)
![WeChat](http://img.shields.io/badge/WeChat-yingzhor-blue.svg)
![Email](http://img.shields.io/badge/Email-yingzhor@gmail.com-blue.svg)
![Phone](http://img.shields.io/badge/Phone-+86_189_1694_4373-blue.svg)
