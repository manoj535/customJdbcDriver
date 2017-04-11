package customJDBC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import net.sf.jsqlparser.JSQLParserException;

/**
 * CustomJdbc which implements java.sql.Driver to create a connection with
 * underlying jdbc driver
 * 
 */
public class CustomJdbc implements java.sql.Driver {

    static String PREFIX = "jdbc:JDBCDriver:\\";

    public static void main(String[] args) throws JSQLParserException {

        Connection databaseConnection;

        try {
            String query = "select count(*) from   user u where u.user_id=1";
            Class.forName("customJDBC.CustomJdbc");
            databaseConnection = DriverManager.getConnection(PREFIX);
            Statement statement = databaseConnection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getString(1));
            }
            databaseConnection.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public CustomJdbc() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    static {
        try {
            DriverManager.registerDriver(new CustomJdbc());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith(PREFIX);
    }

    /**
     * creates a connection according to db.properties and passes the connection
     * reference to ConnectionImpl
     */
    @Override
    public Connection connect(String arg0, Properties arg1) throws SQLException {
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream("src/db.properties");
            prop.load(input);
            String dbUrl = prop.getProperty("url") + prop.getProperty("dbName");
            String username = prop.getProperty("userName");
            String pwd = prop.getProperty("password");
            System.out.println("connect");

            Connection con = DriverManager.getConnection(dbUrl, username, pwd);
            ConnectionImpl connection = new ConnectionImpl(con);
            return (Connection) connection;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int getMajorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMinorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean jdbcCompliant() {
        // TODO Auto-generated method stub
        return false;
    }
}
