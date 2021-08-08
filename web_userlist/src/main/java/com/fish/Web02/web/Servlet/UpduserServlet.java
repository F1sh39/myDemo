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

@WebServlet("/upduser")
public class UpduserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(req.getAttribute("oldemail"));
        if ( user.getEmail() == "" ){
            Object oldemail = req.getSession().getAttribute("oldemail");
            user.setEmail( (String) oldemail );
        }
        UserService service = new UserServiceImpl();
        service.UpdateUser(user);
        resp.sendRedirect(req.getContextPath()+"/userlist");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
