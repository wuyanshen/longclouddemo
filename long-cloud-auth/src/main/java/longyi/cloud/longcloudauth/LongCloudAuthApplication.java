package longyi.cloud.longcloudauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LongCloudAuthApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","server1");
        SpringApplication.run(LongCloudAuthApplication.class, args);
    }

}
