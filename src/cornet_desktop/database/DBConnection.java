package cornet_desktop.database;

import java.awt.HeadlessException;
import java.sql.*;

public class DBConnection {
    private Connection myConnection;
    
    /** Creates a new instance of MyDBConnection */
    public DBConnection() {
        this.init();
    }

    private void init(){
    
       try{
        
        Class.forName("com.mysql.jdbc.Driver");
        myConnection=DriverManager.getConnection(
                "jdbc:mysql://localhost/cornet","root", ""
                );
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
    
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
  public void destroy(){
  
    if(myConnection !=null){
    
         try{
               myConnection.close();
            }
            catch(Exception e){}
        
        
    }
  }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    Connection con;
//    public Connection getConnection(){
//        try{
//            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/cornet", "root", "");
//            //JOptionPane.showMessageDialog(null, "Berhasil");
//        }
//        catch(HeadlessException | SQLException e){         
//            //JOptionPane.showMessageDialog(null, "Gagal");
//        }
//        return con;
//    }

    public Connection myConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
