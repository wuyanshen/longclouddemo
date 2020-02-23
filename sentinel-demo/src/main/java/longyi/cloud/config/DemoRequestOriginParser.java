package longyi.cloud.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuyanshen
 * @date 2020-02-22 6:59 下午
 * @discription 根据来源限流，返回值就是
 */
@Component
public class DemoRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String userAgent = httpServletRequest.getHeader("user-agent");
        System.out.println(userAgent);
        String device = "";
        if(userAgent.contains("iPhone")){
            device = "iphone";
        }else if (userAgent.contains("Mac")){
            device = "mac";
        }
        return device;
    }
}
