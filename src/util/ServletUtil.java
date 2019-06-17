package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet工具类
 * <p>
 * 处理HttpServletRequest、HttpServletResponse数据
 *
 * @author denghaijing
 */
public class ServletUtil {

    /**
     * 读取流中的数据，并以json字符串返回
     *
     * @param request
     * @return
     */
    public static String readJsonString(HttpServletRequest request) {
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 响应返回json数据
     * <p>
     * 用于给前台数据渲染
     *
     * @param data     需返回的数据对象
     * @param response
     * @throws IOException
     */
    public static void responseData(Object data, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        //将数据对象传成json返回
        out.write(GsonUtil.object2Json(data));
        out.close();
    }
}
