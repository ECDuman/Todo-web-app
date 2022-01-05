FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/todo-0.0.1-SNAPSHOT.jar todo-app.jar
ENTRYPOINT ["java","-jar","/todo-app.jar"]