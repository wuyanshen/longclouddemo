package longyi.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import longyi.cloud.util.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyanshen
 * @date 2020-02-22 6:31 下午
 * @discription 描述
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("info")
    public String demo(){
        return "hello demo";
    }

    @GetMapping("resource")
    @SentinelResource(value = "resource2",blockHandler = "eHandler",blockHandlerClass = ExceptionUtil.class)
    public String resource(){
        return "hello resource";
    }

    @GetMapping("param")
    @SentinelResource(value = "param",blockHandler = "paramHandler",blockHandlerClass = ExceptionUtil.class)
    public String param(String type){
        return "hello param";
    }

}
