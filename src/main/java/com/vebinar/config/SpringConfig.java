package com.vebinar.config;

import com.vebinar.config.entity.User;
import com.vebinar.dao.UserDao;
import com.vebinar.dao.UserDaoImpl;
import com.vebinar.service.TestBean;
import com.vebinar.service.UserService;
import com.vebinar.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());

    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
          dataSource.setUrl("jdbc:mysql://localhost:3306/forjava?useSll=false");
          dataSource.setUsername("forjava");
          dataSource.setPassword("forjava!");
          dataSource.setDriverClassName("com.mysql.jdbc.Driver");
          return dataSource;
    }
    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean("/")
    public UserService getUserService(){
        return new UserServiceImpl();
    }

}
