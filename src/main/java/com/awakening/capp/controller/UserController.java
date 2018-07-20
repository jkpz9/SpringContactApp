package com.awakening.capp.controller;

import com.awakening.capp.command.LoginCommand;
import com.awakening.capp.command.UserCommand;
import com.awakening.capp.domain.User;
import com.awakening.capp.exception.UserBlockException;
import com.awakening.capp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hoangit
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value = {"/", "/index"})
    public String index(Model m)
    {
        m.addAttribute("command", new LoginCommand());
        return "index";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) throws UserBlockException
    {
        try{
            User u = userService.Login(cmd.getLoginName(), cmd.getPassword());
            if(u == null){
                // add error message and go back to login form
                m.addAttribute("err", "Invalid Username or Password !");
                return "index";
            } else {
                // SUCCESSFULLY LOGGED IN
                // CHECKING ROLE AND REDIRECT TO SUITABLE DASHBOARD
                if(u.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserInSession(u, session);
                    return "redirect:admin/dashboard";
                } else if(u.getRole().equals(UserService.ROLE_USER)){
                    addUserInSession(u, session);
                    return "redirect:user/dashboard";
                } else {
                    m.addAttribute("err", "Invalid ROLE");
                    return "index";
                }
            }
        }catch(UserBlockException ex){
            // add error message and go back to login form
            m.addAttribute("err", ex.getMessage());
            return "index";
        }
        
    }
    
    @RequestMapping(value = "/user/dashboard")
    public String userDashBoard() {
        return "dashboard_user";
    }
    
    @RequestMapping(value = "/admin/dashboard")
    public String adminDashBoard() {
        return "dashboard_admin";
    }
    
    private void addUserInSession(User u, HttpSession session){
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }
    
    
   @RequestMapping(value="/logout")
   public String logout(HttpSession session)
   {
       session.invalidate();
       return "redirect:index?act=lo";
   }
   
   @RequestMapping(value="/register")
   public String registrationForm(Model m)
   {
       UserCommand cmd = new UserCommand();
       m.addAttribute("command", cmd);
       return "reg_form";
   }
   
   
   @RequestMapping(value="/register", method = RequestMethod.POST)
   public String registrationForm(@ModelAttribute("command") UserCommand cmd, Model m)
   {
       try {
            User u = cmd.getUser();
             u.setRole(UserService.ROLE_USER);
             u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
             userService.Register(u);
             return "redirect:index?act=reg";
       } catch(DuplicateKeyException e)
       {
           e.printStackTrace();
           String err = "Username is already taken. Please choose another username.";
           m.addAttribute("err",err);
           return "reg_form";
       }
    
    }
}
