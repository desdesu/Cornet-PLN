package cornet_desktop.presenter;

import cornet_desktop.database.DBAction;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPresenter extends DBAction{
    
    public Boolean isUsers(String username, String password){
        Boolean result = false;
        if(!username.isEmpty() == !password.isEmpty()){
            try {
                ResultSet rs = getDataFromDatabase("users", "WHERE username='"+username+"' and password='"+password+"'");
                while(rs.next()){
                    result = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
}
