Decrypting configuration properties:

    1. Install Java Cryptography Extension
        download https://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
        copy all files to %JAVA_HOME%\jre\lib\security

    2. Create bootstrap.properties with encrypt.key

    3. Create encrypted string
        POST localhost:8888/encrypt
        POST localhost:8888/decrypt

    4. Use encrypted string as a configuration value starting with a '{cipher}' prefix

Refreshing configurations cache:
    Client side Actuator is turned ON.
    So if configuration has been updated on GIT the caches can be updated via
    POST localhost:8080/actuator/refresh

Using MySQL
    https://hub.docker.com/_/mysql
    docker pull mysql
    docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=1234 -v /home/docker/mysql-data:/var/lib/mysql -d mysql:latest
    docker exec -it mysql bash
        mysql -u root -p
        SHOW DATABASES;
        CREATE DATABASE tasklogs;
    docker logs some-mysql

Using RabbitMQ
    https://hub.docker.com/_/rabbitmq
    docker pull rabbitmq
    docker run -d --hostname localhost --name rabbitmq -p 5672:5672 -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=1234 rabbitmq:latest
    docker run -d --hostname localhost --name rabbitmq-management -p 15672:15672 -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=1234 rabbitmq:3-management