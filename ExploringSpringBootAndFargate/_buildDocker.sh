cp -f ./target/ExploringSpringBootAndFargate-0.0.1-SNAPSHOT.jar ./src/main/docker/app.jar
cd src/main/docker

docker build -t beyondjava/spring-boot-on-docker .