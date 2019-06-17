package dao;

import entity.Course;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程数据访问层
 *
 * @author denghaijing
 */
public class CourseDAO {

    private static CourseDAO instance = null;

    /**
     * 单例
     *
     * @return
     */
    public static CourseDAO getInstance() {
        if (instance == null) {
            instance = new CourseDAO();
        }
        return instance;
    }

    /**
     * 保存课程
     *
     * @param course
     * @return
     */
    public boolean saveCourse(Course course) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConnection();
            // ? : 占位符，防止SQL注入
            String sql = "insert into t_course (name, teacher) values (?,?)";
            ps = conn.prepareStatement(sql);
            // 为SQL语句第1个参数赋值
            ps.setString(1, course.getName());
            // 为SQL语句第2个参数赋值
            ps.setString(2, course.getTeacher());
            int d = ps.executeUpdate();
            if (d != 1) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 查询所有课程
     *
     * @return
     */
    public List<Course> courseList() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            String sql = "select id,name,teacher from t_course";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setTeacher(rs.getString("teacher"));
                list.add(course);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 课程详情
     *
     * @param id 课程id
     * @return
     */
    public Course courseDetail(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "select id,name,teacher from t_course where id = ?";
            ps = conn.prepareStatement(sql);
            // 为SQL语句第1个参数赋值
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setTeacher(rs.getString("teacher"));
            }
            return course;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 更新课程
     *
     * @param course 课程对象
     * @param id     更新课程id
     * @return
     */
    public boolean updateCourse(Course course, Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "update t_course set name = ?, teacher = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            // 为SQL语句第1个参数赋值;
            ps.setString(1, course.getName());
            // 为SQL语句第2个参数赋值;
            ps.setString(2, course.getTeacher());
            // 为SQL语句第3个参数赋值;
            ps.setInt(3, id);
            int d = ps.executeUpdate();
            if (d != 1) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 删除课程
     *
     * @param id 课程id
     * @return
     */
    public boolean deleteCourse(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConnection();
            String sql = "delete from t_course where id = ? ";
            ps = conn.prepareStatement(sql);
            // 为SQL语句第1个参数赋值;
            ps.setInt(1, id);
            int d = ps.executeUpdate();
            if (d != 1) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
