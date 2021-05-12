# Java application based on [Quarkus](https://quarkus.io) framework
 - [GitHub Actions](https://github.com/features/actions) as a CI/CD
 - [GitHub Packages](https://github.com/features/packages) as a Docker images storage
 - [Kubernetes](https://kubernetes.io) as a container management tool
 - [AWS EKS](https://aws.amazon.com/eks/) as a managed Kubernetes service
 - GraalVM and HotSpot implementation available
 - Reactive RESTful Web Service

![](https://github.com/a1brz/quarkus-app/workflows/Build/badge.svg)

## Useful commands:


#### Run app locally:
```bash
./mvnw package
java -jar target/quarkus-app-runner.jar
```

#### Run app locally with hot-reload:
```bash
./mvnw compile quarkus:dev
```

#### Run app in Docker container with OpenJDK HotSpot:
```bash
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t a1brz/quarkus-app .
docker run -i --rm -p 8080:8080 a1brz/quarkus-app
```

#### Run app in Docker container with GraalVM:
```bash
./mvnw package -Pnative -Dnative-image.docker-build=true
docker build -f src/main/docker/Dockerfile.native -t a1brz/quarkus-app .
docker run -i --rm -p 8080:8080 a1brz/quarkus-app
```

#### Push Docker image into [GitHub Packages](https://github.com/features/packages):
```bash
./mvnw package -Pnative -Dnative-image.docker-build=true
docker build -f src/main/docker/Dockerfile.native -t a1brz/quarkus-app .
docker login docker.pkg.github.com -u enter-github-username -p enter-personal-access-token
docker tag IMAGE_ID docker.pkg.github.com/a1brz/quarkus-app/quarkus-app:latest
docker push docker.pkg.github.com/a1brz/quarkus-app/quarkus-app:latest      
```

#### Deploy with Kubernetes: 
```bash
kubectl apply -f kubernetes.yml
```

#### For [AWS EKS](https://aws.amazon.com/eks/) please update kubectl configuration first using [AWS CLI](https://aws.amazon.com/cli/):
```bash
aws eks update-kubeconfig --name test-cluster
kubectl apply -f kubernetes.yml
```

##### Scaling in Kubernetes:
```bash
kubectl scale --replicas=10 deployment quarkus-app
```

##### Kubernetes pods monitoring:
```bash
kubectl get pod -w
```
