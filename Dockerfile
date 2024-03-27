FROM eclipse-temurin:21
WORKDIR /opt
ENV PORT 8080
#ENV POSTGRESQL_URL="jdbc:postgresql://db-transaction:5432/transaction" POSTGRESQL_USERNAME="postgres" POSTGRESQL_PASSWORD="postgres"
EXPOSE 8080
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar