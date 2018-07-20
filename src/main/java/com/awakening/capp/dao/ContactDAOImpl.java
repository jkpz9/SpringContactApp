package com.awakening.capp.dao;

import com.awakening.capp.domain.Contact;
import com.awakening.capp.rm.ContactRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author hoangit
 */
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

    @Override
    public void save(Contact c) {
         String sql = "INSERT INTO user(userId, name, phone, email, address, remark)"
                            +" VALUES(:userId, :name, :phone, :email, address, :remark)";
        // Binding
        Map m = new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        
        Integer contactId = kh.getKey().intValue();
        c.setContactId(contactId);
        
    }

    @Override
    public void update(Contact c) {
        String sql = "UPDATE contact SET"
                    +" name = :name"
                    +", phone = :phone"
                    +", email=:email"
                    +", address = :address"
                    +", remark = :remark"
                    +" WHERE contactId = :contactId";
        
        
        // Binding
        Map m = new HashMap();
        m.put("contactId", c.getContactId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
        super.getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Contact c) {
        this.delete(c.getContactId());
    }

    @Override
    public void delete(Integer contactId) {
        String sql = "DELETE FROM contact WHERE contactId=?";
        getJdbcTemplate().update(sql, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
         String sql = "SELECT contactId, userId, name, phone, email, address, remark"
                    +" FROM contact WHERE contactId = ?";
        Contact c = getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
        
        return c;
    }

    @Override
    public List<Contact> findAll() {
         String sql = "SELECT contactId, userId, name, phone, email, address, remark"
                    +" FROM contact";
        List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper());
        
        return contacts;
    }

    @Override
    public List<Contact> findByProperty(String propName, Object propValue) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark"
                    +" FROM contact WHERE "+propName+"-?";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
    }
    
}
