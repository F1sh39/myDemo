package org.example.service;

import org.example.domain.Role;
import org.example.domain.User;

import java.util.List;

public interface UserService {
    public List<User> list();
    public List<Role> savaUI();
    public void save(User user,Long[] rolesId);
    public void del(Long userId);
    public User login(User user);
}
