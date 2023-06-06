FROM azul/zulu-openjdk-alpine:17 AS builder
WORKDIR /tmp
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src src
RUN ./mvnw clean package -DskipTests -Djacoco.skip
RUN java -Djarmode=layertools -jar $(ls target/*.jar) extract

FROM azul/zulu-openjdk-alpine:17-jre AS runner
WORKDIR /app
COPY --from=builder /tmp/dependencies/ ./
COPY --from=builder /tmp/spring-boot-loader/ ./
COPY --from=builder /tmp/snapshot-dependencies/ ./
COPY --from=builder /tmp/application/ ./
# "-Dserver.port=$PORT", "-Dspring.profiles.active=test"
ENV JAVA_OPTS="-XX:+UseContainerSupport -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8"
ENTRYPOINT java org.springframework.boot.loader.JarLauncher $JAVA_OPTS
EXPOSE 8080