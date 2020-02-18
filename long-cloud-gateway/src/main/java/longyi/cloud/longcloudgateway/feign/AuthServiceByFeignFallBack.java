package longyi.cloud.longcloudgateway.feign;

import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-18 11:27 上午
 * @discription 描述
 */
@Component
public class AuthServiceByFeignFallBack implements AuthServiceByFeign {
    @Override
    public Result byFeignGet(Map<String, Object> params) {
        return Result.fail("服务调用失败，降级处理。。。");
    }

    @Override
    public Result byFeignPost(Map<String, Object> params) {
        return Result.fail("服务调用失败，降级处理。。。");
    }
}
