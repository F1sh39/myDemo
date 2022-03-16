package org.example.dao.impl;

import org.example.dao.RoleDao;
import org.example.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        String sql = "select * from sys_role";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void add(Role role) {
        String sql = "insert into sys_role (roleName,roleDesc) values (?,?);";
        jdbcTemplate.update(sql,
                role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleById(int userId) {
        String sql = "SELECT * FROM sys_user_role as ur LEFT JOIN sys_role as r on ur.roleId = r.id where ur.userId = ?;";
        List<Role> roleList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<Role>(Role.class),userId);
        return roleList;
    }
}
