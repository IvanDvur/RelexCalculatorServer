FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8081
ADD ./build/libs/CalculatorServer-0.0.1-SNAPSHOT-plain.jar calculator-server.jar
ENTRYPOINT ["java","-jar","calculator-server.jar"]