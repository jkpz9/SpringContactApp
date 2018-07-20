package com.awakening.capp.service;

import com.awakening.capp.config.SpringRootConfig;
import com.awakening.capp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hoangit
 */
public class TestUserServiceRegister {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);
    
        User u = new User();
        u.setName("Ngoc Chau");
        u.setEmail("ChauNguyen@hotmail.com");
        u.setAddress("Khanh Hoa Province");
        u.setPhone("0908008800");
        u.setLoginName("chaunguyen");
        u.setRole(userService.ROLE_ADMIN);
        u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
        u.setPassword("chau213");
        
        userService.Register(u);
        
        
        System.out.println("--------- USER REGISTER SUCCESSFULLY ----------");
    }
}
