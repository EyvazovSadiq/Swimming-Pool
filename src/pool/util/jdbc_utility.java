package pool.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/23/17
 * Time: 3:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class jdbc_utility {

    public static Connection getConnection() throws Exception {

        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/swimming_pool");
        Connection c = ds.getConnection();
        return c ;
    }

    public static void close(Connection c, PreparedStatement ps, ResultSet rs )   throws Exception {

        if(ps!=null)
            ps.close();
        if(rs!=null)
            rs.close();
        if(c!=null)
            c.close();
    }

}
