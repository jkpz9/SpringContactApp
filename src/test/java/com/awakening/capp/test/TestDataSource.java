/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awakening.capp.test;

import com.awakening.capp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hoangit
 */
public class TestDataSource {
    
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param  = new Object[] {"Belinda", "0967000001", "Belinda9x@hotmail.com", "Berlin", "Belinda", "Belinda123"};
        jt.update(sql, param);
        System.out.println("------------ SQL execute ---------------");
    }
    
}
