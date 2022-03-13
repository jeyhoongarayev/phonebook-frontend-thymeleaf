FROM openjdk:11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} phonebook-frontend-thymeleaf-1.0.jar

ENTRYPOINT ["java", "-jar", "/phonebook-frontend-thymeleaf-1.0.jar"]