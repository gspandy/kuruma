# =====================================================================================================================
# Docker镜像构建
# =====================================================================================================================

FROM yingzhuo/java:8
MAINTAINER yingzhuo <yingzhuo@gmail.com>
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8
WORKDIR /
ADD kuruma-config-server.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]