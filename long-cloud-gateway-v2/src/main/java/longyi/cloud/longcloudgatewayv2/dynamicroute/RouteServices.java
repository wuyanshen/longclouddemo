package longyi.cloud.longcloudgatewayv2.dynamicroute;

import com.alibaba.fastjson.JSON;
import longyi.cloud.longcloudcommon.CommonConstants;
import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author wuyanshen
 * @date 2020-02-19 10:13 下午
 * @discription 描述
 */
@Service
public class RouteServices implements ApplicationEventPublisherAware {

    @Resource
    private RouteDefinitionWriter routeDefinitionWriter;
    private ApplicationEventPublisher publisher;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //增加路由
    public Result add(RouteDefinition definition) {
        stringRedisTemplate.opsForHash().put(CommonConstants.GATEWAY_ROUTE_KEY,definition.getId(), JSON.toJSONString(definition));
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
        return Result.fail("添加动态路由成功");
    }
    //更新路由
    public Result update(RouteDefinition definition) {
        stringRedisTemplate.opsForHash().put(CommonConstants.GATEWAY_ROUTE_KEY,definition.getId(), JSON.toJSONString(definition));
        try {
            this.routeDefinitionWriter.delete(Mono.just(definition.getId()));
        } catch (Exception e) {
            return Result.fail("更新动态路由失败，routeId: "+definition.getId());
        }
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            this.publisher.publishEvent(new RefreshRoutesEvent(this));
            return Result.fail("更新动态路由成功");
        } catch (Exception e) {
            return Result.fail("更新动态路由失败");
        }
    }
    //删除路由
    public Mono<ResponseEntity<Object>> delete(String id) {
        stringRedisTemplate.opsForHash().delete(CommonConstants.GATEWAY_ROUTE_KEY,id);
        return this.routeDefinitionWriter.delete(Mono.just(id))
                .then(Mono.defer(() -> Mono.just(ResponseEntity.ok().build())))
                .onErrorResume(t -> t instanceof NotFoundException, t -> Mono.just(ResponseEntity.notFound().build()));
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
