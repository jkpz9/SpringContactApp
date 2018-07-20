package com.awakening.capp.test;

import com.awakening.capp.config.SpringRootConfig;
import com.awakening.capp.dao.UserDAO;
import com.awakening.capp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hoangit
 */
public class TestUserDAO {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        // TODO: the user details will be taken from User-Reg-Form
        
//        // Save method
//        User u = new User();
//        u.setName("QuocHoang");
//        u.setPhone("09082238970");
//        u.setEmail("QuocHoang9x@handsome.inv");
//        u.setAddress("District 3, Ho Chi Minh City");
//        u.setLoginName("KingKiller");
//        u.setPassword("kingkaka312");
//        u.setRole(1);
//        u.setLoginStatus(1); // Active;
//        
//        userDAO.save(u);
//        
//        System.out.println("----------- DATA SAVED! ----------");


        // Update method
        
        
        // Delete method
        //userDAO.delete(2);
        
        
        
        // FindBy Single
//        User u = userDAO.findById(1);
//        if(u == null){
//            System.out.println("USER NOT EXISTED!");
//        }
//        else{
//             System.out.println("------------- USER DETAIL ---------------------");
//             System.out.println(u.getUserId());
//             System.out.println(u.getName());
//             System.out.println(u.getPhone());
//             System.out.println(u.getEmail());
//             System.out.println(u.getAddress());
//             System.out.println(u.getLoginName());
//        }
//        
        
        // Fetch All
        
//        List<User> users = userDAO.findAll();
//        for (User u : users) {
//             System.out.println(u.getUserId()+ " " + u.getName() + " " + u.getRole() );
//        }
        
        
        // Fetch List Based on Prop
        
           List<User> users = userDAO.findByProperty("userId", 1);
        for (User u : users) {
             System.out.println(u.getUserId()+ " " + u.getName() + " " + u.getRole() );
        }
        
    }
    
}
