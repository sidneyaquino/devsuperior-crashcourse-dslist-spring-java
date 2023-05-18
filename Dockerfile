# syntax=docker/dockerfile:1

# FROM eclipse-temurin:17-jdk-alpine AS builder
# WORKDIR /app
# ADD .mvn/ .mvn
# ADD mvnw pom.xml ./
# RUN ./mvnw dependency:resolve
# ADD src ./src
# RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine
# RUN apk --no-cache add ca-certificates
# EXPOSE 8080
WORKDIR /app
# COPY --from=builder /app/target/dslist-0.0.1-SNAPSHOT.jar ./dslist.jar
COPY ./target/dslist-0.0.1-SNAPSHOT.jar ./dslist.jar
CMD ["java", "-jar", "dslist.jar"]
# ENTRYPOINT ["java", "-jar", "dslist.jar"]
# CMD ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=test", "-jar", "dslist.jar"]
# ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=test", "-jar", "dslist.jar"]