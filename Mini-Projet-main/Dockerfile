FROM openjdk:19
EXPOSE  8082
ADD target/springProject-0.0.1-SNAPSHOT.jar springProject-docker.jar
ENTRYPOINT ["java", "-jar" , "springProject-docker.jar"]
