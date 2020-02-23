package longyi.cloud.longcloudauth.controller;

import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
    public Result hasPermission(@RequestParam Map<String,Object> params) throws InterruptedException, UnknownHostException {
        Object token = params.get("token");
        String ip = InetAddress.getLocalHost().getHostAddress();
        if (token!=null && token.toString().length()>5){
            return Result.ok(ip+":"+port);
        }else {
            Thread.sleep(2000L);
            return Result.fail(ip+":"+port);
        }
    }
    static int times = 0;
    @PostMapping("hasPermission")
    public Result hasPermissionByPost(@RequestBody Map<String,Object> body) throws InterruptedException, UnknownHostException {
        Object token = body.get("token");
        String ip = InetAddress.getLocalHost().getHostAddress();
        if (token!=null && token.toString().length()>5){
            return Result.ok(ip+":"+port);
        }else {
            if (times++ % 2 == 0){
                Thread.sleep(2000L);
            }else{
                Thread.sleep(3000L);
            }

            return Result.fail(ip+":"+port);
        }
    }
}
