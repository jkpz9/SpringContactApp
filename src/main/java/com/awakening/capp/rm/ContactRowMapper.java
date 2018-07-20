package com.awakening.capp.rm;

import com.awakening.capp.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author hoangit
 */
public class ContactRowMapper implements RowMapper<Contact>{

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact c = new Contact();
        c.setName(rs.getString("name"));
        c.setAddress(rs.getString("address"));
        c.setContactId(rs.getInt("contactId"));
        c.setEmail(rs.getString("email"));
        c.setUserId(rs.getInt("userId"));
        c.setRemark(rs.getString("remark"));
        c.setPhone(rs.getString("phone"));
        
        return c;
        
    }
    
}
