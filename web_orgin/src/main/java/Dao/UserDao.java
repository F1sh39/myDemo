package Dao;

import User.User;
import Utils.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User Login(User loginUser){
        try {
            JdbcTemplate tep = new JdbcTemplate(JdbcUtil.getDataSource());
            String sql = "select * from mydb_user where name = ? and password = ?";
            User user = tep.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
