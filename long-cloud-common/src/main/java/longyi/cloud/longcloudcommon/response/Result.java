package longyi.cloud.longcloudcommon.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuyanshen
 * @date 2020-02-18 12:44 上午
 * @discription 描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable{
    private int code;
    private String msg;
    private T data;

    public static <T> Result ok(T data){
        return  new Result(0,"成功",data);
    }

    public static <T> Result  fail(T data){
        return new Result(1,"失败",data);
    }

    public static <T> Result ok(){
        return  new Result(0,"成功",null);
    }

    public static <T> Result  fail(){
        return new Result(1,"失败",null);
    }
}
