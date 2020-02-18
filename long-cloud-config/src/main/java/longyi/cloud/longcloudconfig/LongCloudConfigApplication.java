package longyi.cloud.longcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LongCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongCloudConfigApplication.class, args);
    }

}
