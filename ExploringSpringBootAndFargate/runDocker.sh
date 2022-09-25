./mvnw clean package
./_buildDocker.sh
docker run -p 80:80 beyondjava/spring-boot-on-docker
