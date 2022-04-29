/**
 * 
 */
package io.pratik.metricscapture;

import java.util.Random;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author pratikdas
 *
 */
@Service
public class PricingEngine {
	
	private Double price;

	@Autowired
	private MeterRegistry registry;
	
	public Double getProductPrice() {
		return price;
		
	}

	@Timed("myFavoriteTimer")
	@Scheduled(fixedRate = 10000, initialDelay = 10)
	public void computePrice() {
		Timer timer = registry.timer("app.event");
		timer.record(() -> {
			Random random = new Random();
			price = random.nextDouble() * 100;
			System.out.println("computing price "+price);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("done computing price "+price);
		});
	}

}
