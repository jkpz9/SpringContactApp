package com.awakening.capp.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author hoangit
 */

// NOTE: do not @Repository or @Service or @Component annatation
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
    public void setDataSource2(DataSource ds)
    {
        super.setDataSource(ds);
    }
}
