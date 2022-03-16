package org.example.dao;

import org.example.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();
    public void add(Role role);
    public List<Role> findRoleById(int userId);
}
