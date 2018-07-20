package com.awakening.capp.service;

import com.awakening.capp.dao.BaseDAO;
import com.awakening.capp.dao.ContactDAO;
import com.awakening.capp.domain.Contact;
import com.awakening.capp.rm.ContactRowMapper;
import com.awakening.capp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoangit
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{

    @Autowired
    private ContactDAO contactDAO;
    
    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer contactId) {
        contactDAO.delete(contactId);
    }

    @Override
    public void delete(Integer[] contactId) {
       String ids = StringUtil.toCommaSeparateString(contactId);
       String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
       getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark from contact WHERE userId = ? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper(), userId, txt);
        return contacts;
    }

    @Override
    public Contact findById(Integer contactId) {
        Contact  c = contactDAO.findById(contactId);
        return c;
    }
    
}
