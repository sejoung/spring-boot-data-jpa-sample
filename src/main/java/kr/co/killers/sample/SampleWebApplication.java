
package kr.co.killers.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SampleWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleWebApplication.class, args);
	}

}
