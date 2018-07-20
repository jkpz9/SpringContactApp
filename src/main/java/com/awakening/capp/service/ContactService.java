package com.awakening.capp.service;

import com.awakening.capp.domain.Contact;
import java.util.List;

/**
 *
 * @author hoangit
 */
public interface ContactService {
    
    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer contactId);
    public void delete(Integer[] contactId);
    public List<Contact> findUserContact(Integer userId);
    public List<Contact> findUserContact(Integer userId, String txt);
    
    public Contact findById(Integer contactId);
    
}
