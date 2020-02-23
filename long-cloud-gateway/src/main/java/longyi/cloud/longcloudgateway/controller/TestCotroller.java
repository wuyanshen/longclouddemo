package longyi.cloud.longcloudgateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyanshen
 * @date 2020-02-18 7:05 下午
 * @discription 刷新配置http://localhost:8085/actuator/refresh
 */
@RestController
@RefreshScope
public class TestCotroller {

    @Value("${custom.pic.path}")
    private String path;

//    @Value("${logging.level.root}")
//    private String root;

    @GetMapping("path")
    public String getPath(){
        return path +" - ";
    }
}
