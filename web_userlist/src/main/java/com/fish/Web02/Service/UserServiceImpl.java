package com.fish.Web02.Service;

import com.fish.Web02.Dao.UserDao;
import com.fish.Web02.Dao.UserDaoImpl;
import com.fish.Web02.domain.PageBean;
import com.fish.Web02.domain.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User AdminLogin(String username, String password) {
        return userDao.findUserbyUNandPSW(username, password);
    }

    @Override
    public void Adduser(User user) {
        if (user.getAge() == 0)
            user.setAge(null);
        if (user.getHometown().charAt(0) == '—')
            user.setHometown(null);
        if (user.getQq() == "")
            user.setQq(null);
        userDao.Adduser(user);
    }

    @Override
    public void Deluser(Integer id) {
        userDao.Deluser(id);
    }

    @Override
    public User findUserbyId(Integer id) {
        return userDao.findUserbyID(id);
    }

    @Override
    public void UpdateUser(User user) {
        if (user.getAge() == 0)
            user.setAge(null);
        if (user.getHometown().charAt(0) == '—')
            user.setHometown(null);
        if (user.getQq() == "")
            user.setQq(null);
        userDao.Upduser(user);
    }

    @Override
    public void DelSetUser(String[] idStrList) {
        for (String idstr : idStrList) {
            userDao.Deluser( Integer.valueOf(idstr) );
        }
    }

    @Override
    public PageBean<User> findRows(Map<String, String> conditionMap, int nowpage, int rows) {
        PageBean<User> page = new PageBean<>();
        page.setNowpage(nowpage);
        page.setRows(rows);
        int totalrows = userDao.countAll(conditionMap);
        page.setTotalrows(totalrows);
        page.setTotalpage( totalrows%rows==0 ?
                totalrows/rows : totalrows/rows+1 );
        page.setDatalist( userDao.findRows(conditionMap,(nowpage-1)*rows, rows) );

        return page;
    }

}
