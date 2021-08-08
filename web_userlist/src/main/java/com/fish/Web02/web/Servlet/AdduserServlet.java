package com.fish.Web02.web.Servlet;

import com.fish.Web02.Service.UserService;
import com.fish.Web02.Service.UserServiceImpl;
import com.fish.Web02.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/adduser")
public class AdduserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        if(req.getParameter("name")!="" && req.getParameter("email")!=""){
            Map<String, String[]> parameterMap = req.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UserService service = new UserServiceImpl();
            service.Adduser(user);
            resp.sendRedirect(req.getContextPath() + "/userlist");
        }
        else{
            if (req.getParameter("name") == "")
                req.setAttribute("namenull", "name_null");
            if (req.getParameter("email") == "")
                req.setAttribute("emailnull", "email_null");
            req.getRequestDispatcher("/adduser.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
