package cornet_desktop.Model;

import java.io.Serializable;

public class Users implements Serializable {
    private String username;
    private String password;
    
    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String[] getData(){
        String[] data = {getUsername(), getPassword()};
        return data;
    }

    @Override
    public String toString() {
        return "INSERT INTO users(username, password) VALUES('%s', '%s')";
    }
}
