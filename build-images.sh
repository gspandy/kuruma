#!/usr/bin/env bash
########################################################################################################################
# 功能: 构建项目
# 作者: 应卓
# 日期: 2016-08-31
########################################################################################################################

# 构建Jar文件
mvn -f ./pom.xml clean package -U -Dmaven.test.skip=true

# 构建Docker镜像
mvn -f ./kuruma-config-server/pom.xml docker:build
mvn -f ./kuruma-user/pom.xml docker:build

# 清理
mvn -f ./pom.xml clean -q

exit 0
