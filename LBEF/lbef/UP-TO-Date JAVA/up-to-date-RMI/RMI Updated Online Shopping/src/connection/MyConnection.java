
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class MyConnection {
    public static final String username = "root";  //set mysql username
    public static final String password = "suman";
    public static final String url = "jdbc:mysql://localhost/smsa";
    public static Connection con = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ""+ex,"",JOptionPane.WARNING_MESSAGE);
        }
        return con; 
            
    }
    
}
