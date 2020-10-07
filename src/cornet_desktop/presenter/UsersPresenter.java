package cornet_desktop.presenter;

import cornet_desktop.Model.Users;
import cornet_desktop.database.DBAction;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsersPresenter extends DBAction{
    
    public ArrayList<Users> getAllUsers(){
        ArrayList<Users> dataUsers = new ArrayList<>();
        try {
            ResultSet rs = getDataFromDatabase("users");
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                Users user = new Users(username, password);
                System.out.println(user.getData()[0]);
                dataUsers.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataUsers;
    }
    
    public boolean signIn(String username, String password){
        String query = "SELECT * FROM users WHERE username=" + username + "and password=" + password;
        Boolean isUsers = false;
        
        return isUsers;
    }
    
    public void insertUsers(Users user){
        try {
            Boolean insert = insertDataToDatabase(user.toString(), user.getUsername(), user.getPassword());
            System.out.println(insert);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Boolean deleteUsers(String condition){
        try {
            int result = deleteDataDatabase("users", condition);
            System.out.println("delete:" + result);
            if(result == 1) return true;
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsersPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
