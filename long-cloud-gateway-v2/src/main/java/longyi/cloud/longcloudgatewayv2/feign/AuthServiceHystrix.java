package longyi.cloud.longcloudgatewayv2.feign;

import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-20 9:59 下午
 * @discription 描述
 */
@Component
public class AuthServiceHystrix implements AuthServiceFeign {
    @Override
    public Result byFeignGet(Map<String, Object> params) {
        return Result.fail("服务正忙，请稍后重试，byFeignGet");
    }

    @Override
    public Result byFeignPost(Map<String, Object> params) {
        return Result.fail("服务正忙，请稍后重试，byFeignPost");
    }
}
