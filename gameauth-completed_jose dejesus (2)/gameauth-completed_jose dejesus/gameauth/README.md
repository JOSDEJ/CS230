# GameAuth

**Jose de Jesus**
**CS 230 - Module Four Assignment**

A small Dropwizard REST API for The Gaming Room's player management, secured with Basic Authentication and role-based authorization (guest / user / admin).

How to start the GameAuth application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/gameauth-0.0.1-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
