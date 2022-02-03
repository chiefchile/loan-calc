FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} loan-calc.jar
ENTRYPOINT ["java","-jar","/loan-calc.jar"]