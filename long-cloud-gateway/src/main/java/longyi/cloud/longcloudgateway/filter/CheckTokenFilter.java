package longyi.cloud.longcloudgateway.filter;

import longyi.cloud.longcloudcommon.response.Result;
import longyi.cloud.longcloudgateway.feign.AuthServiceByFeign;
import longyi.cloud.longcloudgateway.http.AuthServiceByHttp;
import longyi.cloud.longcloudgateway.resttemplate.AuthServiceByRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-18 1:13 上午
 * @discription 描述
 */

@RestController
@RequestMapping("checkToken")
public class CheckTokenFilter {

    @Autowired
    AuthServiceByHttp authServiceByHttp;

    @Autowired
    AuthServiceByFeign authServiceByFeign;

    @Autowired
    AuthServiceByRestTemplate authServiceByRestTemplate;

    @GetMapping("byHttpGet")
    public Result byHttpGet(@RequestParam Map<String,Object> params){
        return authServiceByHttp.byHttpGet(params);
    }

    @GetMapping("byHttpPost")
    public Result byHttpPost(@RequestParam Map<String,Object> body){
        return authServiceByHttp.byHttpPost(body);
    }

    @GetMapping("byFeignGet")
    public Result byFeignGet(@RequestParam Map<String,Object> params){
        return authServiceByFeign.byFeignGet(params);
    }

    @GetMapping("byFeignPost")
    public Result byFeignPost(@RequestParam Map<String,Object> params){
        return authServiceByFeign.byFeignPost(params);
    }


    @GetMapping("byRestGet")
    public Result byRestGet(@RequestParam Map<String,Object> params){
        return authServiceByRestTemplate.byRestGet(params);
    }

    @GetMapping("byRestPost")
    public Result byRestPost(@RequestParam Map<String,Object> params){
        return authServiceByRestTemplate.byRestPost(params);
    }

//    @GetMapping("byRestGetBetter")
//    public Result byRestGetBetter(@RequestParam Map<String,Object> params){
//        return authServiceByRestTemplate.byRestGetBetter(params);
//    }
}
