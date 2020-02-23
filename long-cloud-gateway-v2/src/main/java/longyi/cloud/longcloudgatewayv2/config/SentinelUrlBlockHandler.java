package longyi.cloud.longcloudgatewayv2.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.io.IOException;

/**
 * @author wuyanshen
 * @date 2020-02-22 6:21 下午
 * @discription 描述
 */
public class SentinelUrlBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, BlockException e) throws IOException {

    }
}
