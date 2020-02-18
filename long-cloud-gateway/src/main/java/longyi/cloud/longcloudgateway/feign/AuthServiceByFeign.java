package longyi.cloud.longcloudgateway.feign;

import longyi.cloud.longcloudcommon.CommonConstants;
import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(name = CommonConstants.AUTH_SERVICE_NAME,fallback = AuthServiceByFeignFallBack.class)
public interface AuthServiceByFeign {

    @GetMapping("/auth/hasPermission")
    Result byFeignGet(@RequestParam Map<String,Object> params);

    @PostMapping("/auth/hasPermission")
    Result byFeignPost(@RequestBody Map<String,Object> params);
}
