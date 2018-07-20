package com.awakening.capp.service;

import com.awakening.capp.dao.BaseDAO;
import com.awakening.capp.dao.UserDAO;
import com.awakening.capp.domain.User;
import com.awakening.capp.exception.UserBlockException;
import com.awakening.capp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoangit
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public void Register(User u) {
        userDAO.save(u);
    }

    @Override
    public User Login(String loginName, String password) throws UserBlockException {
       String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName"
                    +" FROM user WHERE loginName=:ln AND password = :pw";
       Map m = new HashMap();
       m.put("ln", loginName);
       m.put("pw", password);
       
       try {
           
           User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
           if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_ACTIVE)) {
               throw new UserBlockException("Your account has been blocked. Contact to admin.");
           }
           else {
               return u;
           }
           
       }
       catch(EmptyResultDataAccessException ex){
           return null;
       }
    }

    @Override
    public List<User> getUserList() {
        return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }
    
}
