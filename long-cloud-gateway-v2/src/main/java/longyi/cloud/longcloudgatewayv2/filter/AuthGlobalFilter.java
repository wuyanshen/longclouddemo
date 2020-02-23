package longyi.cloud.longcloudgatewayv2.filter;

import longyi.cloud.longcloudcommon.response.Result;
import longyi.cloud.longcloudgatewayv2.feign.AuthServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-20 9:43 下午
 * @discription 描述
 */
//@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private AuthServiceFeign authServiceFeign;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("token");
        String url = exchange.getRequest().getURI().getPath();
        if (token !=null && !token.isEmpty()){
            Map<String,Object> params = new HashMap<>();
            params.put("token", token);
            Result r = authServiceFeign.byFeignPost(params);
            if(r.isSuccess())
            {
                return chain.filter(exchange);
            }
        }
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
