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
    docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=1234 -v /home/docker/mysql-data:/var/lib/mysql -d mysql:latest
    docker exec -it mysql bash
        mysql -u root -p
        SHOW DATABASES;
        CREATE DATABASE tasklogs;
    docker logs some-mysql

Using RabbitMQ
    https://hub.docker.com/_/rabbitmq
    docker run -d -h rabbit-host --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.8.2-management
    (command starts both: rabbitmq and rabbitmq-managemen)
    management: http://localhost:15672/
        guest:guest

    Intellij Idea fix: Run -> Edit Configuration -> TaskSinkApplication
        Disable: 'Enable launch optimization' and 'Enable JMX agent' checkboxes

Zipkin
    https://hub.docker.com/r/openzipkin/zipkin-ui
    docker run -d -p 9411:9411 openzipkin/zipkin
    http://localhost:9411/

Hystrix
    implements the circuit breaker pattern
    https://cloud.spring.io/spring-cloud-netflix/reference/html/#circuit-breaker-spring-cloud-circuit-breaker-with-hystrix
    https://cloud.spring.io/spring-cloud-netflix/multi/multi__circuit_breaker_hystrix_clients.html

Redis (REmote DIctionary Server)
    https://hub.docker.com/_/redis/
    docker run --name redis -p 6379:6379 -d redis

Spring Data Flow
    https://repo.spring.io/release/org/springframework/cloud/spring-cloud-dataflow-server/2.3.0.RELEASE/spring-cloud-dataflow-server-2.3.0.RELEASE.jar
    https://repo.spring.io/release/org/springframework/cloud/spring-cloud-dataflow-shell/2.3.0.RELEASE/spring-cloud-dataflow-shell-2.3.0.RELEASE.jar
    java -jar spring-cloud-dataflow-server-2.3.0.RELEASE.jar
        --spring.datasource.url=jdbc:mysql:3306//dcdf --spring.datasource.username=root --spring.datasource.password=1234 --spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
        --spring.rabbitmq.host=localhost --spring.rabbitmq.port=5672 --spring.rabbitmq.username=quest --spring.rabbitmq.password=quest
    in the directory of docker-compose.yml run:
        set DATAFLOW_VERSION=2.3.0.RELEASE
        set SKIPPER_VERSION=2.2.1.RELEASE
        docker-compose up

    Shell:
    (spec https://docs.spring.io/spring-cloud-dataflow/docs/current-SNAPSHOT/reference/htmlsingle)
    java -jar spring-cloud-dataflow-shell-2.3.0.RELEASE.jar
    app import --uri https://dataflow.spring.io/rabbitmq-maven-latest
    app list
    app info --name file --type sink
    stream create --definition "http --port=8086 | file --directory=C:/DEV --suffix=txt --name=output" --name hellodataflow
    stream list
    stream deploy --name hellodataflow
    (accessgin tammingmq management always hangs!)

netstat -fo | findstr 15672
tasklist | findstr 15188