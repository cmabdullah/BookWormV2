# Base Image
FROM gradle:6.8.3-jdk11 AS app-image

MAINTAINER cmabdullah21@gmail.com
# Copy the project to /app
#
# Copy the Gradle config, source code, and static analysis config
# into the build container.
#
RUN ls -la
COPY --chown=gradle:gradle . /app
#COPY build.gradle /app/
#COPY src /app/src/
# [Setting up working directory] tells docker to use app directory as a working directory.
# All commands now will run from this directory.
WORKDIR /app
# build this project
RUN gradle clean build

FROM adoptopenjdk/openjdk11:latest

# WORKDIR /app

# expose to port 8080
EXPOSE 8080
RUN echo $(ls -1 /app/build/libs/)
# copy the jar file to the app directory copy from old build image
# COPY build/libs/*.jar app-2.jar
# COPY build/libs/springboot-docker-example-2-0.0.1-SNAPSHOT.jar app-2.jar
COPY --from=app-image /app/build/libs/*.jar app-2.jar

RUN ls -la
# command tells docker the arrays of commands will run when a container gets starter from this image.
ENTRYPOINT ["java", "-jar","app-2.jar"]
# docker build -t cmabdullah21/spring-boot-docker-v10 --progress=plain .
# docker run -p 8082:8080 -d --name app-1 cmabdullah21/spring-boot-docker-v10

