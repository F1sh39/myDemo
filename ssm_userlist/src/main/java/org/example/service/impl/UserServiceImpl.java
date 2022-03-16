package org.example.service.impl;

import org.example.dao.RoleDao;
import org.example.dao.UserDao;
import org.example.domain.Role;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            int userId = user.getId();
            List<Role> roleList = roleDao.findRoleById(userId);
            user.setRoleList(roleList);
        }
        return userList;
    }

    public  List<Role> savaUI(){
        return roleDao.findAll();
    }

    @Override
    public void save(User user, Long[] rolesId) {
        userDao.save_User(user);
        int id = userDao.findIdByUsername(user.getUsername());
        userDao.saveUserRoleRel(id, rolesId);
    }

    @Override
    public void del(Long userId) {
        userDao.delUserRoleRel(userId);
        userDao.delUser(userId);
    }

    @Override
    public User login(User in_user) {
        try {
            User user = userDao.findUserByNameAndPsw(in_user);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
