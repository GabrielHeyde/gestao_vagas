# Etapa de Build
FROM maven:3.9-eclipse-temurin-17 AS build
 
WORKDIR /app

# Copia apenas o pom.xml primeiro para otimizar o cache
COPY pom.xml .  

# Copia o código-fonte
COPY /src/ ./src/  

# Realiza o build do projeto
RUN mvn clean package -DskipTests

# Etapa de Runtime (Imagem Final)
FROM openjdk:17-jre-slim
FROM openjdk:17-jdk-slim

WORKDIR /app
EXPOSE 8080

# Copia o JAR gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Executa o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]