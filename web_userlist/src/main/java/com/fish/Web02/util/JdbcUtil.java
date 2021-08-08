package com.fish.Web02.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource DS;
    static {
        try {
            Properties pros = new Properties();
            InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);
            DS = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return DS;
    }
}
