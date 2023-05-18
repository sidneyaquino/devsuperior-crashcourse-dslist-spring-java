# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
ADD .mvn/ .mvn
ADD mvnw pom.xml ./
RUN ./mvnw dependency:resolve
ADD src ./src
RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add ca-certificates
WORKDIR /app
# COPY ./target/dslist-0.0.1-SNAPSHOT.jar ./dslist.jar
COPY --from=builder /app/target/dslist-0.0.1-SNAPSHOT.jar ./dslist.jar
# EXPOSE 8080
# ENV PORT=8080
# "-Dserver.port=$PORT"
# "-Dspring.profiles.active=test"
CMD ["java", $JAVA_OPTS "-jar", "dslist.jar"]
# ENTRYPOINT ["java", $JAVA_OPTS "-jar", "dslist.jar"]