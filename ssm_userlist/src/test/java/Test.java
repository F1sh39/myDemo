import org.example.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test1(){
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        JdbcTemplate template = app.getBean(JdbcTemplate.class);
    }
}
