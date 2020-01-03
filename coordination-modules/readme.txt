endpoints:
    http://localhost:8761/

    http://localhost:8081/dashboard?stationId=3
    http://localhost:8081/actuator/hystrix.stream

    http://localhost:8082/customerdetails?fastpassid=101
    http://localhost:8082/actuator/hystrix.stream
    http://localhost:8082/actuator/health

    http://localhost:8085/hystrix

    http://localhost:8087/turbine.stream
    http://localhost:8087/clusters

    http://localhost:8087/turbine.stream
    http://localhost:8087/turbine.stream?cluster=default
    http://localhost:8087/turbine.stream?cluster=tollrate-billboard

Full explanation in the spec:
    https://cloud.spring.io/spring-cloud-netflix/reference/html/#circuit-breaker-hystrix-dashboard
    https://cloud.spring.io/spring-cloud-netflix/reference/html/#turbine
    https://cloud.spring.io/spring-cloud-netflix/reference/html/#turbine-stream