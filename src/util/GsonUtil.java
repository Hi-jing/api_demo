package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json、object转换工具类
 * <p>
 * 处理接口传参的转换
 *
 * @author denghaijing
 */
public class GsonUtil {

    /**
     * Object对象转json字符串
     *
     * @param object Object对象
     * @return json字符串
     */
    public static String object2Json(Object object) {
        if (object == null) {
            return null;
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    /**
     * json字符串转object对象
     *
     * @param json json字符串
     * @param type 对象类型
     * @param <T>  泛型
     * @return object对象
     */
    public static <T> T json2Object(String json, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }
}
