FROM bellsoft/liberica-runtime-container:jdk-17-slim-musl AS builder
WORKDIR /tmp
COPY --link .mvn/ .mvn
COPY --link mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY --link src/ src
RUN ./mvnw clean package -DskipTests -Djacoco.skip
RUN java -Djarmode=layertools -jar $(ls target/*.jar) extract

FROM bellsoft/liberica-runtime-container:jre-17-slim-musl
RUN addgroup --system javauser && \
   # adduser --system --disabled-login --disabled-password --no-create-home --ingroup javauser javauser
   adduser -S -s /usr/sbin/nologin -D -H -G javauser javauser  # alpine
WORKDIR /app
COPY --link --from=builder /tmp/dependencies/ /tmp/spring-boot-loader/ /tmp/snapshot-dependencies/ /tmp/application/ ./
RUN chown -R javauser:javauser .
USER javauser
ENV JAVA_OPTS="-XX:+UseContainerSupport -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8"
CMD java \
   $JAVA_OPTS \
   -Dserver.port=$PORT \
   -Dspring.profiles.active=test \
   org.springframework.boot.loader.JarLauncher