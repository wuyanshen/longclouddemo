package longyi.cloud.longcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LongCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LongCloudEurekaApplication.class, args);
	}

}
