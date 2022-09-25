import {
  aws_ec2 as ec2,
  aws_ecs as ecs,
  aws_ecs_patterns as ecs_patterns,
  Duration,
  Stack,
  StackProps
} from 'aws-cdk-lib';
import {Construct} from 'constructs';
import * as path from "path";
import {Protocol} from "aws-cdk-lib/aws-elasticloadbalancingv2";

export class CdkStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    console.log(process.env.DOCKER_DEFAULT_PLATFORM);

    const vpc = new ec2.Vpc(this, 'SpringBootOnFargateVpc', {
      maxAzs: 3,
    });

    const cluster = new ecs.Cluster(this, 'SpringBootOnFargateCluster', {
      vpc: vpc
    });

    const fargate = new ecs_patterns.ApplicationLoadBalancedFargateService(this, 'SpringBootOnFargateFargateService', {
      cluster: cluster,
      cpu: 512,
      memoryLimitMiB: 2048,
      desiredCount: 1,
      taskImageOptions: {
        image: ecs.ContainerImage.fromAsset(path.join(__dirname, '../../src/main/docker/')),
//        image: ecs.ContainerImage.fromAsset(path.join(__dirname, '../src/')),
        environment: {
          "name": "Spring Boot on Fargate",
        },
      },
    });
    /*
    fargate.targetGroup.configureHealthCheck({
      path: "/",
      port: "80",
      healthyHttpCodes: "200",
      interval: Duration.seconds(30),
      protocol: Protocol.HTTP

    })
*/
  }
}
