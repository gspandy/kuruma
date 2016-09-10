#!/usr/bin/env bash
########################################################################################################################
# 功能: 构建项目并运行
# 作者: 应卓
# 日期: 2016-09-03
########################################################################################################################

WORKDIR=/home/yingzhuo/projects/kuruma

# 停止容器
docker-compose -f "${WORKDIR}/docker-compose.yml" down 2> /dev/null

# 删除镜像
docker rmi yingzhuo/kuruma-car:latest 2> /dev/null
docker rmi yingzhuo/kuruma-user:latest 2> /dev/null
docker rmi yingzhuo/kuruma-bill:latest 2> /dev/null
docker rmi yingzhuo/kuruma-corenode:latest 2> /dev/null
docker rmi yingzhuo/kuruma-config-server:latest 2> /dev/null

# 下载源文件
rm -rf /tmp/kuruma 2> /dev/null
git clone https://github.com/yingzhuo/kuruma.git "/tmp/kuruma"

# 构建Jar文件
mvn -f /tmp/kuruma/pom.xml clean package -U -Dmaven.test.skip=true

# 构建docker镜像
mvn -f /tmp/kuruma/kuruma-bill/pom.xml docker:build
mvn -f /tmp/kuruma/kuruma-car/pom.xml docker:build
mvn -f /tmp/kuruma/kuruma-user/pom.xml docker:build
mvn -f /tmp/kuruma/kuruma-corenode/pom.xml docker:build
mvn -f /tmp/kuruma/kuruma-config-server/pom.xml docker:build

# 复制docker-compose.yml 文件
rm "${WORKDIR}/docker-compose.yml"
cp /tmp/kuruma/docker-cnf/docker-compose.yml "${WORKDIR}/docker-compose.yml"

# 清理项目生成物
mvn -f /tmp/kuruma/pom.xml clean -q

#重启项目
docker-compose -f "${WORKDIR}/docker-compose.yml" up -d

# 退出
exit 0