FROM azul/zulu-openjdk:17 AS builder
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
RUN ./mvnw clean package -DskipTests -Djacoco.skip

FROM azul/zulu-openjdk:17-jre
ARG JAR_FILE=demo-0.0.1.jar
# "-Dserver.port=$PORT", "-Dspring.profiles.active=test"
ENV JAVA_OPTS="-XX:+UseContainerSupport -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8"
WORKDIR /app
COPY --from=builder /app/target/${JAR_FILE} app.jar
ENTRYPOINT java $JAVA_OPTS -jar app.jar
EXPOSE 8080