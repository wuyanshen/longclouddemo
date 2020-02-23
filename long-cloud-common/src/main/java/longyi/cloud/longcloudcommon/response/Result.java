package longyi.cloud.longcloudcommon.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyanshen
 * @date 2020-02-18 12:44 上午
 * @discription 描述
 */
public class Result extends HashMap<String, Object>{

    public Result() {
        put("code", 200);
        put("message", "操作成功");
    }

    public boolean isOk()
    {
        return this.get("code").equals(500);
    }

    public boolean isSuccess()
    {
        return this.get("code").equals(500);
    }

    public static Result fail() {
        return fail(500, "操作失败");
    }

    public static Result fail(String message) {
        return fail(500, message);
    }

    public static Result fail(int code, String message) {
        Result r = new Result();
        r.put("code", code);
        r.put("message", message);
        return r;
    }

    public static Result fail(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result fail(int code) {
        Result r = new Result();
        r.put("code", code);
        r.put("message", "");
        return r;
    }

    public static Result ok(String message) {
        Result r = new Result();
        r.put("message", message);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static Result buildEmptyR(String message) {
        Result r = new Result();
        r.put("code", 500);
        r.put("message", message+"超时，熔断器返回");
        return r;
    }

    public boolean insertDataOk(){
        return this.get("code").equals(200);
    }

    public boolean checkRowDataOk(){
        return this.get("code").equals(200);
    }
}
