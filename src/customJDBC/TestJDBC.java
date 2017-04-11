package customJDBC;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author shivarajm
 *
 */
public class TestJDBC {

    static Connection databaseConnection;
    static String PREFIX = "jdbc:JDBCDriver:\\";

    @BeforeClass
    public static void runOnceBeforeClass() {

        try {
            Class.forName("customJDBC.CustomJdbc");
            databaseConnection = DriverManager.getConnection(PREFIX);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        try {
            databaseConnection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test_method_1() {
        // "select count(*) from user u where u.user_id=1"
        System.out.println();
        System.out.println("@Test - test_method_1");
        String sql = "select count(*) from   user u ";
        String expectedResult = "11";

        try {
            Statement statement = databaseConnection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsmd = result.getMetaData();

            while (result.next()) {
                System.out.println();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (result.getString(i + 1) != null) {
                        System.out.print(result.getString(i + 1) + " - ");
                        assertEquals(result.getString(i + 1), expectedResult);
                    } else
                        break;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test_method_2() {
        System.out.println();
        System.out.println("@Test - test_method_2");
        String sql = "select count(*) from   user u where u.user_id=1";
        String expectedResult = "2";

        try {
            Statement statement = databaseConnection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsmd = result.getMetaData();

            while (result.next()) {
                System.out.println();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (result.getString(i + 1) != null) {
                        System.out.print(result.getString(i + 1));
                        assertEquals(result.getString(i + 1), expectedResult);
                    } else
                        break;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test_method_3() {
        System.out.println();
        System.out.println("@Test - test_method_3");
        String sql = "select * from   user u ";

        try {
            Statement statement = databaseConnection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsmd = result.getMetaData();

            while (result.next()) {
                System.out.println();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (result.getString(i + 1) != null) {
                        System.out.print(result.getString(i + 1));
                    } else
                        break;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test_method_4() {
        System.out.println();
        System.out.println("@Test - test_method_4");
        String sql = "select u.user_id, ua.user_att_value from   user u ";
        try {
            Statement statement = databaseConnection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsmd = result.getMetaData();

            while (result.next()) {
                System.out.println();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (result.getString(i + 1) != null)
                        System.out.print(result.getString(i + 1) + " - ");
                    else
                        break;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
