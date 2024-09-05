# Imagem base Maven com JDK 21 para a fase de build
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Copia o diretório de código-fonte para o contêiner
COPY src /app/src
# Copia o arquivo pom.xml para o contêiner
COPY pom.xml /app

# Define o diretório de trabalho para a fase de build
WORKDIR /app
# Executa a compilação e instalação do projeto com Maven
RUN mvn clean install

# Imagem base OpenJDK 21 para a fase de execução
FROM openjdk:21

# Copia o JAR construído da fase de build para a fase de execução
COPY --from=build /app/target/techshop-1.0.jar /app/app.jar

# Define o diretório de trabalho para a fase de execução
WORKDIR /app

# Expõe a porta 8080 para acesso externo
EXPOSE 8080

 # Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
