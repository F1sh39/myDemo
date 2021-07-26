import Dao.UserDao;
import User.User;
import Utils.JdbcUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class myTest {
    @Test
    public void test1(){
        JdbcTemplate tep = new JdbcTemplate(JdbcUtil.getDataSource());
        String sql = "insert mydb_user value (6,'new','123')";
        tep.update(sql);
    }
    @Test
    public void test2(){
        User myuser = new User();
        myuser.setUsername("root");
        myuser.setPassword("123456");
        User dbuser = new UserDao().Login(myuser);
        System.out.println(dbuser);
    }
}
