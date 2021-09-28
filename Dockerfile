FROM frolvlad/alpine-oraclejre8:latest
ADD target/demo-0.0.1-SNAPSHOT.jar /usr/app/app.jar
EXPOSE 8082
WORKDIR /usr/app
VOLUME /usr/app/logs
ENV TimeZone=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TimeZone /etc/localtime && echo $TimeZone > /etc/timezone
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]