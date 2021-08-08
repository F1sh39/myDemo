package com.fish.Web02.web.Servlet;

import com.fish.Web02.Service.UserService;
import com.fish.Web02.Service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectdel")
public class SelectDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] idStrList = req.getParameterValues("selid");
        UserService userService = new UserServiceImpl();
        userService.DelSetUser(idStrList);
        resp.sendRedirect(req.getContextPath()+"/userlist");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
