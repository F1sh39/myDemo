package org.example.controller;

import org.example.domain.Role;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User in_user, HttpSession session){
        User user = userService.login(in_user);
        if (user != null){
            session.setAttribute("adminUser", user);
            return "main";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav){
        List<User> userList = userService.list();
        mav.addObject("userList", userList);
        mav.setViewName("user-list");
        return mav;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(ModelAndView mav){
        List<Role> roleList = userService.savaUI();
        mav.addObject("roleList", roleList);
        mav.setViewName("user-add");
        return mav;
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roles){
        userService.save(user, roles);
        return "redirect:/user/list";
    }

    @RequestMapping("/del")
    public String del(Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }
}
