package cornet_desktop.presenter;

import cornet_desktop.Model.EMModel;
import cornet_desktop.database.DBAction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EMPresenter extends DBAction{
    private final List<String> namaStringing = new ArrayList<>();
    private final List<String> namaInsulator = new ArrayList<>();
    private final List<String> namaAksesoris = new ArrayList<>();
    private final List<String> hargaStringing = new ArrayList<>();
    private final List<String> satuanStringing = new ArrayList<>();
    private final List<EMModel> stringing = new ArrayList<>();
    private final List<EMModel> insulator = new ArrayList<>();
    private final List<EMModel> aksesoris = new ArrayList<>();
    
    public void loadDataStringing(){
        try {
            ResultSet result = getDataFromDatabase("stringing");
            while(result.next()){
                String data = result.getString("nama");
                String satuan = result.getString("satuan");
                String harga = result.getString("harga");
                namaStringing.add(data);
                satuanStringing.add(satuan);
                hargaStringing.add(harga);
                stringing.add(new EMModel(data, satuan, harga));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataInsulator(){
        try {
            ResultSet result = getDataFromDatabase("insulator");
            while(result.next()){
                String data = result.getString("nama");
                String satuan = result.getString("satuan");
                String harga = result.getString("harga");
                namaInsulator.add(data);
                insulator.add(new EMModel(data, satuan, harga));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataAksesoris(){
        try {
            ResultSet result = getDataFromDatabase("aksesoris");
            while(result.next()){
                String data = result.getString("nama");
                String satuan = result.getString("satuan");
                String harga = result.getString("harga");
                namaAksesoris.add(data);
                aksesoris.add(new EMModel(data, satuan, harga));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getNamaStringing() {
        return namaStringing;
    }

    public List<String> getNamaInsulator() {
        return namaInsulator;
    }

    public List<String> getNamaAksesoris() {
        return namaAksesoris;
    }

    public List<EMModel> getStringing() {
        return stringing;
    }

    public List<EMModel> getInsulator() {
        return insulator;
    }

    public List<EMModel> getAksesoris() {
        return aksesoris;
    }
    public List<String> getHargaStringing() {
        return hargaStringing;
    }
    public List<String> getSatuanStringing() {
        return satuanStringing;
    }
}
