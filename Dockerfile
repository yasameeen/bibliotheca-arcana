FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY *.java .

RUN mkdir -p lib && \
    wget -q -O lib/junit.jar \
    https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar && \
    javac -cp lib/junit.jar *.java

CMD ["java", "Main"]