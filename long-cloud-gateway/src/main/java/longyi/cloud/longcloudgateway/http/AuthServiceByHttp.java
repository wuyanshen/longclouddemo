package longyi.cloud.longcloudgateway.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import longyi.cloud.longcloudcommon.response.Result;
import longyi.cloud.longcloudcommon.util.HttpRequestUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-18 1:34 上午
 * @discription 描述
 */
@Component
public class AuthServiceByHttp {

    public Result byHttpGet(@RequestParam Map<String,Object> params){
       String html = HttpRequestUtil.getData("http://localhost:8001/auth/hasPermission?token="+params.get("token").toString());
        return JSON.parseObject(html, Result.class);
    }

    public Result byHttpPost(@RequestParam Map<String,Object> body){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",body.get("token").toString());
        String html = HttpRequestUtil.postData("http://localhost:8001/auth/hasPermission",jsonObject);
        return JSON.parseObject(html, Result.class);
    }
}
