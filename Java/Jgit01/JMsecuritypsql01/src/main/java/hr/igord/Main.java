
package hr.igord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver load error: " + ex.getMessage());
        }
    }

    private void logErr(Exception ex) {
        System.err.println("Error: " + ex.getMessage());
    }
    
    public Main() {

        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:postgresql://localhost/wmssecurity01db01";
            String username = "wmssecurity01admin";
            String password = "wmssecurity01password";
            con = DriverManager.getConnection(url, username, password);
            stat = con.createStatement();
//            rs = stat.executeQuery("select username,password,enabled from users where username='mujo'");
//            while (rs.next()) {
//                System.out.println(rs.getString("username"));
//                System.out.println(rs.getString("password"));
//                System.out.println(rs.getInt("enabled"));
//            }
            
//            rs = stat.executeQuery("select username,role from user_roles where username='mujo'");
            rs = stat.executeQuery("select username,role from user_roles where username='mkyong'");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("role"));
            }
            
        } catch (Exception ex) {
            logErr(ex);
            
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
                
            } catch (Exception ex) {
                logErr(ex);
            }
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }

}
