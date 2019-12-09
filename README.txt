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
    docker run --name mysql -e MYSQL_ROOT_PASSWORD=1234 -d mysql:latest
    docker exec -it mysql bash
        mysql -u root -p
        SHOW DATABASES;
        CREATE DATABASE tasklogs;
    docker logs some-mysql