package longyi.cloud.longcloudgateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyanshen
 * @date 2020-02-18 7:05 下午
 * @discription 描述
 */
@RestController
public class TestCotroller {

    @Value("${custom.pic.path}")
    private String path;

    @GetMapping("path")
    public String getPath(){
        return path;
    }
}
