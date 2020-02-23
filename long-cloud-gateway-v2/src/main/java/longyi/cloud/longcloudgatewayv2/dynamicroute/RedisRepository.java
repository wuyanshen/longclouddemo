package longyi.cloud.longcloudgatewayv2.dynamicroute;

import com.alibaba.fastjson.JSON;
import longyi.cloud.longcloudcommon.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyanshen
 * @date 2020-02-19 11:27 下午
 * @discription 描述
 */
@Component
public class RedisRepository implements RouteDefinitionRepository {



    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        redisTemplate.opsForHash().values(CommonConstants.GATEWAY_ROUTE_KEY).stream()
                .forEach(routeDefinition -> routeDefinitions.add(JSON.parseObject(routeDefinition.toString(), RouteDefinition.class)));
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap( r -> {
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            return Mono.empty();
        });
    }
}
