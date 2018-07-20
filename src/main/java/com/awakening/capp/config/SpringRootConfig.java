package com.awakening.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author hoangit
 */

@Configuration
@ComponentScan(basePackages= {"com.awakening.capp.dao", "com.awakening.capp.service"})
@EnableWebMvc
public class SpringRootConfig extends WebMvcConfigurerAdapter {
    // DOTO: SERVICES, DAO, DataSource, Email Sender Or other business layer beans
    @Bean
    public BasicDataSource getDatasource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/capp_db");
        ds.setUsername("root");
        ds.setPassword("root");
        
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
