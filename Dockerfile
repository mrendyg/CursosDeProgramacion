FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/CursosDeProgramacion-0.0.1jar
COPY ${JAR_FILE} app_cursos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_cursos.jar"]