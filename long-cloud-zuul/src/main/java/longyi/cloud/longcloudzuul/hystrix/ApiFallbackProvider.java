package longyi.cloud.longcloudzuul.hystrix;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.log4j.Log4j;
import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wuyanshen
 * @date 2020-02-19 4:14 下午
 * @discription 描述
 */
@Component
public class ApiFallbackProvider implements FallbackProvider {

    /**
     * 返回服务id，如果需要所有调用都支持回调，则return "*"或者return null
     *
     * @param
     * @return java.lang.String
     * @date 2020/2/19 4:16 下午
     * @author wuyanshen
     */
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        String message = "";
        if(cause instanceof HystrixTimeoutException){
            message = "timeout";
        }else {
            message = "Service Exception";
        }
        return fallbackResponse(message);
    }

    public ClientHttpResponse fallbackResponse(String message){
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                Result result = Result.fail("网关路由正忙，请稍后重试");
                return new ByteArrayInputStream(result.toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
