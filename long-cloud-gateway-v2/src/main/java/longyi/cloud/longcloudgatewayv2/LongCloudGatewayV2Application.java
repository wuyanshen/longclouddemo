package longyi.cloud.longcloudgatewayv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LongCloudGatewayV2Application {

    public static void main(String[] args) {
//        System.setProperty("logging.level.root","debug");
        ApplicationContext context =  SpringApplication.run(LongCloudGatewayV2Application.class, args);
        String loginfo = context.getEnvironment().getProperty("logging.level.root");
        loginfo = String.format("日志级别是：%s",loginfo);
        System.out.println(loginfo);
    }

}
