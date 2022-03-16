package org.example.controller;

import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/Save", produces = "text/html;charset=UTF-8")
    public String save(Account account){
        System.out.println(account);
        accountService.save(account);
        return "保存成功";
    }

    @RequestMapping("/List")
    public ModelAndView findAll(ModelAndView mav){
        List<Account> accountList = accountService.findAll();
        mav.addObject("accountList", accountList);
        mav.setViewName("list");
        return mav;
    }
}
