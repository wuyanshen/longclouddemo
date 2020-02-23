package longyi.cloud.longcloudmonitor.controller;

import longyi.cloud.longcloudcommon.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-20 10:42 下午
 * @discription 描述
 */

@RestController
@RequestMapping("monitor")
public class MonitorController {

    @GetMapping("list")
    public Result hasPermission(@RequestParam Map<String,Object> params){
        Result result = Result.ok("数据获取正常");
        result.put("count","10件");
        result.put("status","正常");
        return result;
    }
}
