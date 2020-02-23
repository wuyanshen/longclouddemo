package longyi.cloud.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.experimental.UtilityClass;

/**
 * @author wuyanshen
 * @date 2020-02-22 6:50 下午
 * @discription 描述
 */
@UtilityClass
public class ExceptionUtil {
    public static String eHandler(BlockException e){
        return "resource error";
    }

    public static String paramHandler(String type,BlockException e){
        return "热点限流生效...";
    }
}
