package tn.esprit.reclamation_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.Enable;


@SpringBootApplication
@EnableEurekaClient
public class ReclamationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationMsApplication.class, args);
	}

}
