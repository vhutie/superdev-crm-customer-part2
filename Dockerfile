FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS "-Xmx192m -Xms192m -Djava.security.egd=file:///dev/./urandom -XX:+HeapDumpOnOutOfMemoryError "
ENV TZ Africa/Johannesburg
# NOT USE YET -XX:+UseG1GC
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]