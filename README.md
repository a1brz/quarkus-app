# Java App based on [Quarkus](https://quarkus.io)


## To run app with hot-reload:
```bash
./mvnw compile quarkus:dev
```

## To run app using Docker + OpenJDK:
```bash
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t a1brz/java-app .
docker run -i --rm -p 8080:8080 a1brz/java-app
```

## To run app using Docker + GraalVM:
```bash
./mvnw package -Pnative -Dnative-image.docker-build=true
docker build -f src/main/docker/Dockerfile.native -t a1brz/java-app-native .
docker run -i --rm -p 8080:8080 a1brz/java-app-native
```