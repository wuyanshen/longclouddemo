package longyi.cloud.longcloudauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LongCloudAuthApplication2 {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","server2");
        SpringApplication.run(LongCloudAuthApplication2.class, args);
    }

}
