package longyi.cloud.longcloudgatewayv2.dynamicroute;

import com.alibaba.fastjson.JSON;
import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author wuyanshen
 * @date 2020-02-19 10:11 下午
 * @discription 描述
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteServices routeServices;

    //增加路由
    @PostMapping("/add")
    public Result add(@RequestBody RouteDefinition routeDefinition) {
        try {
            return routeServices.add(routeDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("添加动态路由失败");
    }

    //删除路由
    @DeleteMapping("/routes/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        return routeServices.delete(id);
    }

    //更新路由
    @PostMapping("/update")
    public Result update(@RequestBody RouteDefinition definition) {
        return routeServices.update(definition);
    }
}
