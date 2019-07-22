package model.dbutil;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceUtil  {
	
	private static DataSource instance;

    public static synchronized DataSource getDataSource() {
        if (instance == null) {
            InitialContext initialContext;
            try {
                initialContext = new InitialContext();
                Context context = (Context) initialContext.lookup("java:comp/env");
                instance = (DataSource) context.lookup("connpool");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}