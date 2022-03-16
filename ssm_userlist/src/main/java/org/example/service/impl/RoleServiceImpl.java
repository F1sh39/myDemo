package org.example.service.impl;

import org.example.dao.RoleDao;
import org.example.domain.Role;
import org.example.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }
}
