package com.fish.Web02.web.Servlet;

import com.fish.Web02.Service.UserService;
import com.fish.Web02.Service.UserServiceImpl;
import com.fish.Web02.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        String checkcode = (String) session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        String inputCheckcode = req.getParameter("checkcode");
        if ( checkcode.equalsIgnoreCase(inputCheckcode) ){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            UserServiceImpl service = new UserServiceImpl();
            User user = service.AdminLogin(username, password);
            if(user != null){
                session.setAttribute("adminuser", user);
                resp.sendRedirect(contextPath+"/index.jsp");
            }
            else{
                req.setAttribute("loginMsg", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
        else{
            System.out.println(checkcode+",,,"+inputCheckcode);
            req.setAttribute("loginMsg", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
