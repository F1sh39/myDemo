package com.fish.Web02.Dao;

import com.fish.Web02.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();
    public User findUserbyUNandPSW(String username, String password);
    public void Adduser(User user);
    public void UpdateField(Integer id, String field, String value);
    public void Deluser(Integer id);
    public User findUserbyID(Integer id);
    public void Upduser(User user);
    public List<User> findRows(Map<String,String> map, int begin, int rows);
    public int countAll(Map<String,String> map);
}
