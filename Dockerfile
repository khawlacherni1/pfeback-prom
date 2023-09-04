FROM openjdk:11
EXPOSE 8080
ADD target/myschool.jar myschool.jar
ENTRYPOINT ["java","-jar","/myschool.jar"]