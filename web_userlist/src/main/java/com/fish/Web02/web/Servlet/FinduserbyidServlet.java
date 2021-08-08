package com.fish.Web02.web.Servlet;

import com.fish.Web02.Service.UserService;
import com.fish.Web02.Service.UserServiceImpl;
import com.fish.Web02.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/finduserbyid")
public class FinduserbyidServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userid = Integer.valueOf(req.getParameter("userid"));
        UserService service = new UserServiceImpl();
        User user = service.findUserbyId(userid);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/updateuser.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
