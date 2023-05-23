FROM azul/zulu-openjdk-alpine:17 AS builder
ARG JAR_FILE=demo-0.0.1.jar
WORKDIR /tmp
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
RUN ./mvnw clean package -DskipTests -Djacoco.skip
RUN java -Djarmode=layertools -jar target/${JAR_FILE} extract

FROM azul/zulu-openjdk-alpine:17-jre
EXPOSE 8080
# "-Dserver.port=$PORT", "-Dspring.profiles.active=test"
ENV JAVA_OPTS="-XX:+UseContainerSupport -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8"
WORKDIR /app
COPY --from=builder /tmp/dependencies/ ./
COPY --from=builder /tmp/snapshot-dependencies/ ./
COPY --from=builder /tmp/spring-boot-loader/ ./
COPY --from=builder /tmp/application/ ./
ENTRYPOINT java $JAVA_OPTS org.springframework.boot.loader.JarLauncher