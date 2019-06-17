package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据连接工具类
 *
 * @author denghaijing
 */
public class DbUtil {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/api_demo?useUnicode=true&characterEncoding=utf-8";
    private static final String username = "";
    private static final String password = "";

    private static Connection conn = null;

    /**
     * 静态代码块负责加载驱动
     */
    static {
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 单例模式返回数据库连接对象
     */
    public static Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn;
    }

    /**
     * 测试连接是否正常
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Connection conn = DbUtil.getConnection();
            if (conn != null) {
                System.out.println("数据库连接正常！");
            } else {
                System.out.println("数据库连接异常！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
