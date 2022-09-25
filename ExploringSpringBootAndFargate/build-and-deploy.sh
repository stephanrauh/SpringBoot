# export DOCKER_DEFAULT_PLATFORM='linux/amd64'
# DOCKER_DEFAULT_PLATFORM='linux/amd64' ./mvnw compile jib:dockerBuild
# ./mvnw compile jib:dockerBuild
./mvnw clean package
./_buildDocker.sh
cd cdk
npm install
# DOCKER_DEFAULT_PLATFORM='linux/amd64' npm run cdk deploy
npm run cdk deploy