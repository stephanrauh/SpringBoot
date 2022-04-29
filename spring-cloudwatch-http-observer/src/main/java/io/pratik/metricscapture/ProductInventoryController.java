/**
 * 
 */
package io.pratik.metricscapture;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.pratik.metricscapture.models.Order;
import io.pratik.metricscapture.models.Product;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Stephan Rauh
 *
 */
@RestController
@Slf4j
public class ProductInventoryController {

	@Autowired
	ProductInventoryController(){}

	@GetMapping("/products/{productName}/available")
	@ResponseBody
	public int fetchProducts(@PathVariable String productName) {
		if ("Book".equals(productName)) {
			return 50;
		}
		if ("Television".equals(productName)) {
			return 10;
		}
	    	
		return 0;
	}
}
