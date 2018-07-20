package com.awakening.capp.service;

import com.awakening.capp.domain.User;
import com.awakening.capp.exception.UserBlockException;
import java.util.List;

/**
 *
 * @author hoangit
 */
public interface UserService {
    
    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;
    public static final Integer ROLE_ADMIN = 2;
    public static final Integer ROLE_USER = 1;
    
    public void Register(User u);
    public User Login(String loginName, String password)throws UserBlockException;
    public List<User> getUserList();
    public void changeLoginStatus(Integer userId, Integer loginStatus);
    
}
