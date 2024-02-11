FROM debian:bullseye-slim
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk

EXPOSE 8080
ADD target/staff-poc-0.0.1.jar staff-poc-0.0.1.jar
WORKDIR /app
COPY . /app

# Set environment variables if needed
# Example for connecting to MySQL
 ENV MYSQL_HOST=localhost \
     MYSQL_PORT=3306 \
     MYSQL_USER=root \
     MYSQL_PASSWORD=password@123 \
     MYSQL_DATABASE=staff-db
ENTRYPOINT ["java","-jar","staff-poc-0.0.1.jar"]
