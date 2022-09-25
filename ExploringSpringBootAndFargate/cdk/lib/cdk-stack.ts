import { Stack, StackProps } from 'aws-cdk-lib';
import { Construct } from 'constructs';
import { aws_ec2 as ec2 } from 'aws-cdk-lib';
import { aws_ecs as ecs } from 'aws-cdk-lib';
import { aws_ecs_patterns as ecs_patterns } from 'aws-cdk-lib';
import * as path from "path";

export class CdkStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    console.log(process.env.DOCKER_DEFAULT_PLATFORM);

    const vpc = new ec2.Vpc(this, 'SpringBootOnFargateVpc', {
      maxAzs: 2,
    });

    const cluster = new ecs.Cluster(this, 'SpringBootOnFargateCluster', {
      vpc: vpc
    });

    const fargate = new ecs_patterns.ApplicationLoadBalancedFargateService(this, 'SpringBootOnFargateFargateService', {
      cluster: cluster,
      cpu: 256, // smallest CPU available
      memoryLimitMiB: 2048,
      desiredCount: 1,
      taskImageOptions: {
//        image: ecs.ContainerImage.fromRegistry("beyondjava/jib-docker-image"), // fromAsset(path.join(__dirname, '../src/')),
        image: ecs.ContainerImage.fromAsset(path.join(__dirname, '../src/')),
        environment: {
          "name": "Serverless Fargate",
        },
      },
    });
  }
}
