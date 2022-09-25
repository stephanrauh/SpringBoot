# Goals of this project

This is a minimal Spring Boot project running on AWS Fargate. It's deployed by a small AWS CDK script.

## Getting the application up and running
It's a simple Maven project running on Java 17. You can start it
- by running the commmand mvn spring-boot:run,
- or by starting the class de.beyondjava.ExploringMapStructApplication,
- Running the script `runDocker.sh` runs the application in a local Docker container.
- Finally, `build-and-deploy.sh` compiles the application, packages it as a Docker container, and deploys it in the AWS. This takes roughly five Minutes. A few lines above the "Total time" output, the console window shows an URL. You can use this URL to test the application.

The project also contains a small Postman collection for local testing. If you want to test the application in the AWS, you'll want to edit the URLs of the Postman collection.

## Getting rid of the application
Don't forget to remove your test application because it costs money! You achieve this by running the command

```
cd cdk
npm run cdk destroy
```