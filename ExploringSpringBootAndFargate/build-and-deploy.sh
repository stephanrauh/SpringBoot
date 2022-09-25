export DOCKER_DEFAULT_PLATFORM='linux/amd64'
DOCKER_DEFAULT_PLATFORM='linux/amd64' ./mvnw compile jib:dockerBuild
cd cdk
DOCKER_DEFAULT_PLATFORM='linux/amd64' npm run cdk deploy
