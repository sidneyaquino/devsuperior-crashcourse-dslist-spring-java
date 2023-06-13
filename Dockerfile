FROM ghcr.io/graalvm/graalvm-ce:ol9-java17 AS build
WORKDIR /tmp
COPY --link .mvn/ .mvn
COPY --link mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 ./mvnw dependency:resolve
COPY --link src/ src
RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests -Djacoco.skip
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM bellsoft/liberica-runtime-container:jre-17-slim-musl
RUN addgroup --system javauser && \
   adduser -S -s /usr/sbin/nologin -D -H -G javauser javauser  # alpine
   # adduser --system --disabled-login --disabled-password --no-create-home --ingroup javauser javauser
ARG DEPENDENCY=/tmp/target/dependency
COPY --link --chown=javauser --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --link --chown=javauser --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --link --chown=javauser --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENV JAVA_OPTS="-XX:+UseContainerSupport -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8"
USER javauser
CMD java \
   $JAVA_OPTS \
   -Dserver.port=$PORT \
   -Dspring.profiles.active=test \
   -cp app:app/lib/* \
   $(find app/com -name '*Application*' | sed 's/\//./g' | sed 's/app.//' | sed 's/.class//')