rm -f ./src/main/docker/app.jars
cp ./target/*.jar ./src/main/docker/app.jar
cd src/main/docker

docker build -t beyondjava/spring-boot-on-docker .