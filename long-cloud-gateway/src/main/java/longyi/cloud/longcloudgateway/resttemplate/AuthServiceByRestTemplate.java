package longyi.cloud.longcloudgateway.resttemplate;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import longyi.cloud.longcloudcommon.CommonConstants;
import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-18 11:44 上午
 * @discription 描述
 */
@Component
public class AuthServiceByRestTemplate {

    @Autowired
    public RestTemplate restTemplate;

    public Result byRestGet(@RequestParam Map<String,Object> params){
        String url = String.format("http://%s/auth/hasPermission?token="+params.get("token").toString(), CommonConstants.AUTH_SERVICE_NAME);
        return restTemplate.getForObject(url,Result.class);

    }

    public Result byRestPost(@RequestParam Map<String,Object> body){
        String url = String.format("http://%s/auth/hasPermission",CommonConstants.AUTH_SERVICE_NAME);
        return restTemplate.postForObject(url,body,Result.class);

    }

//    @HystrixCommand(fallbackMethod="byRestGetBetterError")
//    public Result byRestGetBetter(@RequestParam Map<String,Object> params){
//        String url = String.format("http://%s/auth/hasPermission?token="+params.get("token").toString(), CommonConstants.AUTH_SERVICE_NAME);
//        return restTemplate.getForObject(url,Result.class);
//
//    }
//
//    public Result byRestGetBetterError(@RequestParam Map<String,Object> params){
//        return Result.fail("hystrix熔断降级。。。");
//    }
}
