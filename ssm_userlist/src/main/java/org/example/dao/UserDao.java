package org.example.dao;

import org.example.domain.Role;
import org.example.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public void save_User(User user);
    public void saveUserRoleRel(int userId, Long[] rolesId);
    public int findIdByUsername(String username);
    public void delUserRoleRel(Long userId);
    public void delUser(Long userId);
    public User findUserByNameAndPsw(User user) throws EmptyResultDataAccessException;
}
