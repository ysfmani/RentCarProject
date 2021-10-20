package DBConn;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cnx {
    
    public Connection DBcnx()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/gestionagence";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion avec Succès !");
            return (Connection) conn;
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connexion échouée !");
            Logger.getLogger(Cnx.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    //static Statement statement = null;
    //PreparedStatement pst;
    //DbConnection cnx = DbConnection.getInstance();
    //java.sql.Connection connection = cnx.getConnection();
    
}
