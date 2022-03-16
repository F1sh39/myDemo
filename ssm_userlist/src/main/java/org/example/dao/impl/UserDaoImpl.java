package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domain.Role;
import org.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from sys_user;";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public void save_User(User user) {
        String sql = "insert into sys_user values (null,?,?,?,?);";
        jdbcTemplate.update(sql,
                user.getUsername(), user.getEmail(),
                user.getPassword(), user.getPhoneNum() );
    }

    @Override
    public void saveUserRoleRel(int userId, Long[] rolesId) {
        String sql = "insert into sys_user_role (userId, roleId) values (?,?);";
        for (Long role : rolesId) {
            jdbcTemplate.update(sql, userId, role);
        }
    }

    @Override
    public int findIdByUsername(String username) {
        String sql = "select id from sys_user where username = ?;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return id;
    }

    @Override
    public void delUserRoleRel(Long userId) {
        String sql = "delete from sys_user_role where userId = ?;";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void delUser(Long userId) {
        String sql = "delete from sys_user where id = ?;";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public User findUserByNameAndPsw(User in_user) throws EmptyResultDataAccessException {
        String sql = "select * from sys_user where username = ? and password = ?;";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                in_user.getUsername(), in_user.getPassword());
        return user;
    }

}
