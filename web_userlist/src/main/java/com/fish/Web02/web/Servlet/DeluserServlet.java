package com.fish.Web02.web.Servlet;

import com.fish.Web02.Service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deluser")
public class DeluserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userid = Integer.valueOf(req.getParameter("userid"));
        UserServiceImpl service = new UserServiceImpl();
        service.Deluser(userid);
        req.removeAttribute("userid");
        req.getRequestDispatcher("/userlist").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
