/**
 * 
 */
package io.pratik.metricscapture;

import java.time.Duration;
import java.util.Map;

import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.logging.Log4j2Metrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.micrometer.cloudwatch2.CloudWatchConfig;
import io.micrometer.cloudwatch2.CloudWatchMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.CloudWatchAsyncClient;

/**
 * @author pratikdas
 *
 */
@Configuration
public class AppConfig {
	@Bean
	public CloudWatchAsyncClient cloudWatchAsyncClient() {

		// AwsBasicCredentials awsCreds = AwsBasicCredentials.create("accessid", "secretaccesskey");
		// var provider = StaticCredentialsProvider.create(awsCreds);

		// return CloudWatchAsyncClient.builder().region(Region.EU_CENTRAL_1)
		// 		.credentialsProvider(provider).build();


		return CloudWatchAsyncClient.builder().region(Region.EU_CENTRAL_1)
				.credentialsProvider(ProfileCredentialsProvider.create("default")).build();
	}
	
	@Bean
	public MeterRegistry getMeterRegistry() {
		CloudWatchConfig cloudWatchConfig = setupCloudWatchConfig();
		
		MeterRegistry meterRegistry = new CloudWatchMeterRegistry(cloudWatchConfig, Clock.SYSTEM,
				cloudWatchAsyncClient());
		meterRegistry.config().commonTags("manual", "learning");
		new JvmMemoryMetrics().bindTo(meterRegistry);
		new JvmGcMetrics().bindTo(meterRegistry);
		new JvmThreadMetrics().bindTo(meterRegistry);
		new ProcessorMetrics().bindTo(meterRegistry);
		// new Log4j2Metrics().bindTo(meterRegistry);

		return meterRegistry;
	}

	private CloudWatchConfig setupCloudWatchConfig() {
		CloudWatchConfig cloudWatchConfig = new CloudWatchConfig() {
			
			private Map<String, String> configuration
	          = Map.of("cloudwatch.namespace",
							"BeyondJava/dev/jvm",
	                   "cloudwatch.step", Duration.ofSeconds(15).toString());

			@Override
			public String get(String key) {
				return configuration.get(key);
			}
		};
		return cloudWatchConfig;
	}

}
