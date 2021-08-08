package com.fish.Web02.Service;

import com.fish.Web02.domain.PageBean;
import com.fish.Web02.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findAll();
    public User AdminLogin(String username, String password);
    public void Adduser(User user);
    public void Deluser(Integer id);
    public User findUserbyId(Integer id);
    public void UpdateUser(User user);
    public void DelSetUser(String[] idStrList);
    public PageBean<User> findRows(Map<String, String> conditionMap, int nowpage, int rows);
}
