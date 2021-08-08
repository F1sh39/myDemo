package com.fish.Web02.web.Servlet;

import com.fish.Web02.Service.UserService;
import com.fish.Web02.Service.UserServiceImpl;
import com.fish.Web02.domain.PageBean;
import com.fish.Web02.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/userlist")
public class UserlistServlet extends HttpServlet {
    static int ROWS = 5;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String topage = req.getParameter("topage");
        int nowpage = topage==null ? 1:Integer.valueOf(topage);
        String name = req.getParameter("name");
        String hometown = req.getParameter("hometown");
        String email = req.getParameter("email");
        HashMap<String, String> map = new HashMap<>();
        if (name!=null && name!="") {
            map.put("name", name);
            req.setAttribute("nameForm", name);
        }
        if (hometown!=null && hometown!="") {
            map.put("hometown", hometown);
            req.setAttribute("hometownForm", hometown);
        }
        if (email!= null && email!="") {
            map.put("email", email);
            req.setAttribute("emailForm", email);
        }
        PageBean<User> page = new UserServiceImpl().findRows(map, nowpage, ROWS);

        req.setAttribute("upage", page);
        req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}