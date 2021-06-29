/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.helper;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Faisal
 */
public class KoneksiDatabase {
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=DATA_KEPEGAWAIAN_SEKOLAH";
    public static String username = "sa";
    public static String password = "rahasiabanget";
    public Connection conn = null;
    protected int newId = 0;
    
    public boolean connect(){
        boolean res = false;
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            res = true;            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean disconnect(){
        boolean res = false;
        try {
            conn.close();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public int getNewId(){
        return this.newId;
    }
}
