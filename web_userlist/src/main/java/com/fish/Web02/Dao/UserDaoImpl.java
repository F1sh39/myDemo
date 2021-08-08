package com.fish.Web02.Dao;

import com.fish.Web02.domain.User;
import com.fish.Web02.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from mydb_webuser;";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public User findUserbyUNandPSW(String username, String password) {
        String sql = "select * from mydb_webuser where username = ? and password = ?;";
        User user = null;
        try{
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                                        username,password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return user;
        }
    }

    @Override
    public void Adduser(User user) {
        String sql = "insert into mydb_webuser (name,gender,age,hometown,qq,email) values (?,?,?,?,?,?);";
        template.update(sql,
                user.getName(), user.getGender(), user.getAge(),
                user.getHometown(), user.getQq(), user.getEmail() );
    }

    @Override
    public void UpdateField(Integer id, String field, String value) {
        String sql = "update mydb_webuser set ? = ? where id = ?;";
        template.update(sql, field,value,id);
    }

    @Override
    public void Deluser(Integer id) {
        String sql = "delete from mydb_webuser where id = ?;";
        template.update(sql, id);
    }

    @Override
    public User findUserbyID(Integer id) {
        String sql = "select * from mydb_webuser where id = ?;";
        User user = null;
        try{
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                                        id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return user;
        }
    }

    @Override
    public void Upduser(User user) {
        String sql = "update mydb_webuser set gender=?,age=?,hometown=?,qq=?,email=? where id = ?;";
        template.update(sql,
                    user.getGender(), user.getAge(), user.getHometown(),
                    user.getQq(), user.getEmail(), user.getId() );
    }

    @Override
    public List<User> findRows(Map<String,String> map, int begin, int rows) {
        String sql = "select * from mydb_webuser where 1 = 1 ";
        StringBuffer sqlbf = new StringBuffer(sql);
        Set<String> keySet = map.keySet();
        List valueList = new ArrayList<>();
        for (String key : keySet) {
            sqlbf.append(" and "+key+" like ? ");
            valueList.add( "%"+map.get(key)+"%" );
        }
        sqlbf.append(" limit ? , ? ");
        sql = sqlbf.toString();
        valueList.add(begin);
        valueList.add(rows);
        System.out.println(sql);//check
        System.out.println(valueList);//check
        List<User> userList = template.query(sql,
                new BeanPropertyRowMapper<User>(User.class), valueList.toArray());
        return userList;
    }

    @Override
    public int countAll(Map<String,String> map) {
        String sql = "select count(id) from mydb_webuser where 1 = 1 ";
        StringBuffer sqlbf = new StringBuffer(sql);
        Set<String> keySet = map.keySet();
        List<String> valueList = new ArrayList<>();
        for (String key : keySet) {
            sqlbf.append(" and "+key+" like ? ");
            valueList.add( map.get(key) );
        }
        sql = sqlbf.toString();
        //System.out.println(sql);//check
        return template.queryForObject(sql, Integer.class, valueList.toArray());
    }
}
