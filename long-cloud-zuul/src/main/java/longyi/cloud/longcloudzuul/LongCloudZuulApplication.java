package longyi.cloud.longcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableZuulProxy
public class LongCloudZuulApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","dev");
        ApplicationContext context = SpringApplication.run(LongCloudZuulApplication.class, args);
        String port = context.getEnvironment().getProperty("server.port");
        String name = context.getEnvironment().getProperty("spring.application.name");
        System.out.println("端口："+port);
        System.out.println("应用名称："+name);
    }

}
