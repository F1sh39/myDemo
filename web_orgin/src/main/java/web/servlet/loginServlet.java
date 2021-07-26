package web.servlet;

import Dao.UserDao;
import User.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String contextPath = req.getContextPath();
        //1先确认验证码
        HttpSession session = req.getSession();
        String checkcode = (String) session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        String inputCheckcode = req.getParameter("checkcode");
        if( req.getParameter("checkcode").equalsIgnoreCase(checkcode) ){
            //2再确认用户和密码
            User loginUser = new User();
            loginUser.setUsername( req.getParameter("username") );
            loginUser.setPassword( req.getParameter("password") );
            User User = new UserDao().Login(loginUser);
            System.out.println(loginUser);//check
            System.out.println(User);//check
            if(User != null){
                session.setAttribute("username", req.getParameter("username") );
                resp.sendRedirect(contextPath+"/loginsuccess");
            }
            else {
                resp.sendRedirect(contextPath+"/login.html");
            }
        }
        else {
            resp.sendRedirect(contextPath+"/login.html");
        }


        /*

         */

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
