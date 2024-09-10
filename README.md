# Training project "E-Commerce platform"
Project for 'Spring Cloud' infrastructure discover.

## Spring Cloud tools:
- Eureka discovery service
- Gateway
- Configuration server

## Environment requirements
- JDK 17
- Docker
- Docker Compose

## Setup and Run project
- `gradlew clean build` - build project
- `docker compose up -d ecommerce_db` - up database

### Up infrastructure applications
- `java -jar discovery/build/libs/discovery.jar` - run discovery server. Use `--server.port=<PORT>` for port specifying, default is `9090`.
- `java -jar config-server/build/libs/config.jar` - run config server. Use `--server.port=<PORT>` for port specifying, default is `9190`.
- `java -jar gateway/build/libs/gateway.jar` - run gateway. Use `--server.port=<PORT>` for port specifying, default is `8080`.
- `java -jar gateway/build/libs/notification-service.jar` - run notification service. Use `--server.port=<PORT>` for port specifying, default is `8050`.

### Up services
Use `.sh` for Linux or `.bat` for Windows.
- `./scripts/startCatalogCluster.sh` - run three catalog services (ports - `8040`, `8041`, `8042`).
- `./scripts/startInventoryCluster.sh` - run three inventory services (ports - `8030`, `8031`, `8032`).
- `./scripts/startOrderCluster.sh` - run three order services (ports - `8030`, `8031`, `8032`).
- `./scripts/startUserCluster.sh` - run three users services (ports - `8010`, `8011`, `8012`).
