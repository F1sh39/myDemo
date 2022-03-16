package org.example.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class TemplateConfiguration {
    @Autowired
    private DruidDataSource dataSource;

    @Bean("template")
    public JdbcTemplate getTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
