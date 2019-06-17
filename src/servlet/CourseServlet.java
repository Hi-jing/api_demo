package servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import entity.Course;
import util.GsonUtil;
import util.ServletUtil;
import dto.ResponseDTO;

/**
 * 课程servlet层
 * <p>
 * 处理课程请求，MVC中的Controller层
 *
 * @author denghaijing
 */
public class CourseServlet extends HttpServlet {

    private static final long serialVersionUID = -8277989554718155332L;

    public CourseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求的URI地址信息
        String url = request.getRequestURI();
        // 截取其中的方法名
        String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
        Method method = null;
        try {
            // 使用反射机制获取在本类中声明了的方法
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException("调用方法出错！");
        }

    }

    /**
     * 保存课程
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求传参的json数据，并转成Course对象
        Course course = GsonUtil.json2Object(ServletUtil.readJsonString(request), Course.class);
        boolean result = CourseDAO.getInstance().saveCourse(course);
        if (!result) {
            ServletUtil.responseData(new ResponseDTO(-1, "保存失败"), response);
        }
        ServletUtil.responseData(new ResponseDTO(0, "保存成功"), response);
    }

    /**
     * 课程列表查询
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Course> list = CourseDAO.getInstance().courseList();
        if (list == null) {
            ServletUtil.responseData(new ResponseDTO(-1, "查询失败"), response);
        }
        ServletUtil.responseData(new ResponseDTO(0, "查询成功", list), response);
    }

    /**
     * 查询课程详情
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Course course = CourseDAO.getInstance().courseDetail(id);
        if (course == null) {
            ServletUtil.responseData(new ResponseDTO(-1, "查询失败"), response);
        }
        ServletUtil.responseData(new ResponseDTO(0, "查询成功", course), response);
    }

    /**
     * 保存课程更新
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Course course = GsonUtil.json2Object(ServletUtil.readJsonString(request), Course.class);
        boolean result = CourseDAO.getInstance().updateCourse(course, id);
        if (!result) {
            ServletUtil.responseData(new ResponseDTO(-1, "保存更新失败"), response);
        }
        ServletUtil.responseData(new ResponseDTO(0, "保存更新成功"), response);
    }

    /**
     * 删除课程
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        boolean result = CourseDAO.getInstance().deleteCourse(id);
        if (!result) {
            ServletUtil.responseData(new ResponseDTO(-1, "删除失败"), response);
        }
        ServletUtil.responseData(new ResponseDTO(0, "删除成功"), response);
    }

}
