package longyi.cloud.longcloudauth.controller;

import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-18 12:33 上午
 * @discription 描述
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @Value("${server.port}")
    public String port;

    @GetMapping("hasPermission")
    public Result hasPermission(@RequestParam Map<String,Object> params) throws InterruptedException {
        Object token = params.get("token");
        if (token!=null && token.toString().length()>5){
            return Result.ok(port);
        }else {
            Thread.sleep(2000L);
            return Result.fail(port);
        }
    }
    static int times = 0;
    @PostMapping("hasPermission")
    public Result hasPermissionByPost(@RequestBody Map<String,Object> body) throws InterruptedException {
        Object token = body.get("token");
        if (token!=null && token.toString().length()>5){
            return Result.ok(port);
        }else {
            if (times++ % 2 == 0){
                Thread.sleep(2000L);
            }else{
                Thread.sleep(3000L);
            }

            return Result.fail(port);
        }
    }
}
