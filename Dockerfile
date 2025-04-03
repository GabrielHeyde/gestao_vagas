# Fase de build
FROM ubuntu:latest AS build

# Atualiza os pacotes e instala o JDK e Maven
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas os arquivos necessários primeiro (para melhorar o cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Agora copia o restante do código
COPY . .

# Compila o projeto
RUN mvn clean package -DskipTests

# Fase de execução
FROM openjdk:17-jdk-slim

# Define a porta da aplicação
EXPOSE 8080

# Copia o JAR gerado no build
COPY --from=build /app/target/gestao_vagas-0.0.1.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
