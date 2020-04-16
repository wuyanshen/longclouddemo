package longyi.cloud.longcloudgatewayv2.reslover;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wuyanshen
 * @date 2020-02-23 10:45 下午
 * @discription 描述
 */
@Slf4j
@Component
public class MyKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        /**ip限流*/
        String address = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        log.info("ip={}，被gateway限流了",address);
        return Mono.just(address);

        /**用户限流 使用这种方式限流，请求路径中必须携带userId参数。*/
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
        /**接口限流*/
//        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}
