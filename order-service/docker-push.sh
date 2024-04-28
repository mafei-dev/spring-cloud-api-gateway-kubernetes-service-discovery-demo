./mvnw clean package -DskipTests=true
docker build -t mafeidev/spring-cloud-api-gateway-k8s-dns-demo-order-service:1.0.0 .
docker push mafeidev/spring-cloud-api-gateway-k8s-dns-demo-order-service:1.0.0
