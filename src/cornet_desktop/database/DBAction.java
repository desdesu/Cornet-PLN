package cornet_desktop.database;

import java.sql.*;

public class DBAction {
    private final DBConnection db = new DBConnection();
    
    private Connection getConnection(){
        return db.getMyConnection();
    }
    
    // isi parameter condition diawali dengan string where
    public ResultSet getDataFromDatabase(String tableName, String condition) throws SQLException{
        String query = "SELECT * FROM " + tableName + " " + condition;
        Statement st = getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    
    // untuk mengambil seluruh data dari table database
    public ResultSet getDataFromDatabase(String tableName) throws SQLException{
        String query = "SELECT * FROM " + tableName;
        Statement st = getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    
    //untuk mengambil data dengan spesifik kolom tabel
    public ResultSet getSpecificColumn(String columnName, String tableName, String conditional) throws SQLException{
        String query = "SELECT " + columnName + " FROM " + tableName +conditional;
        System.out.println(query);
        Statement st = getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    
    //untuk mengambil data tanpa ada data duplikat
    public ResultSet getWithoudDuplicateData(String columnName, String tableName) throws SQLException{
        String query = "SELECT DISTINCT " + columnName + " FROM " + tableName;
        Statement st = getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    
    // query berisi hasil convert to string dari masing-masing class
    // data berisi variabel variabel dari data yang di tambahkan, sesuaikan urutan dengan hasil convert query
    public Boolean insertDataToDatabase(String query, String ... data) throws SQLException{
        query = String.format(query, data);
        PreparedStatement ps = getConnection().prepareStatement(query);
        Boolean result = ps.execute();
        getConnection().close();
        return result;
    }
    
    // isi parameter condition diawali dengan string where
    public int deleteDataDatabase(String tableName, String condition) throws SQLException{
        String query = "DELETE FROM " + tableName + " " + condition;
        System.out.println(query);
        Statement st = getConnection().createStatement();
        int result = st.executeUpdate(query);
        return result;
    }
}
