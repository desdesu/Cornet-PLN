/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornet_desktop.presenter;
import cornet_desktop.Model.MEMModel;
import cornet_desktop.Model.MSModel;
import cornet_desktop.Model.SAModel;
import cornet_desktop.Model.TSModel;
import cornet_desktop.Model.UTKModel;
import cornet_desktop.database.DBAction;
import cornet_desktop.utils.Utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HargaDasarPresenter extends DBAction{
    private final List<String> namaMEM = new ArrayList<>();
    private final List<String> namaMS = new ArrayList<>();
    private final List<String> namaSA = new ArrayList<>();
    private final List<String> UTK = new ArrayList<>();
    private final List<String> TS = new ArrayList<>();
    private final List<String> hargaUTK = new ArrayList<>();
    private final List<String> refUTK = new ArrayList<>();
    private final List<MEMModel> material_em= new ArrayList<>();
    private final List<MSModel> material_sipil = new ArrayList<>();
    private final List<SAModel> sewa_alat = new ArrayList<>();
    private final List<UTKModel> upah_tenaga_kerja = new ArrayList<>();
    private final List<TSModel> transport_material = new ArrayList<>();
    
    public void loadDatanamaMEM(){
        try {
            ResultSet result = getDataFromDatabase("material_em");
            while(result.next()){
                String material = result.getString("material");
                String satuan = result.getString("satuan");
                String harga = result.getString("harga");
                String refrensi = result.getString("referensi");
                namaMEM.add(material);
                material_em.add(new MEMModel(material, satuan, harga, refrensi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void loadDatanamaMS(){
        try {
            ResultSet result = getDataFromDatabase("material_sipil");
            while(result.next()){
                String nama = result.getString("nama");
                String satuan = result.getString("satuan");
                String harga = result.getString("harga");
                String refrensi = result.getString("referensi");
                namaMS.add(nama);
                material_sipil.add(new MSModel(nama, satuan, harga, refrensi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void loadDatanamaSA(){
        try {
            ResultSet result = getDataFromDatabase("sewa_alat");
            while(result.next()){
                String material = result.getString("material");
                String satuan = result.getString("satuan");
                String harga = result.getString("harga");
                String refrensi = result.getString("referensi");
                namaSA.add(material);
                sewa_alat.add(new SAModel(material, satuan, harga, refrensi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDatanamaTS(){
        try {
            ResultSet result = getDataFromDatabase("transport_material");
            while(result.next()){
                String material = result.getString("material");
                String harga = result.getString("harga_material");
                String biaya = result.getString("biaya_bongkar");
                TS.add(material);
                transport_material.add(new TSModel(material, harga, biaya));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataUTK(){
        try {
            ResultSet result = getDataFromDatabase("upah_tenaga_kerja");
            while(result.next()){
                String nama = result.getString("nama");
                String harga = result.getString("harga");
                String refrensi = result.getString("referensi");
                UTK.add(nama);
//                hargaUTK.add(harga);
//                refUTK.add(refrensi);
                upah_tenaga_kerja.add(new UTKModel(nama, harga, refrensi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EMPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Double getHargaTransportasi(String material, String namaKolom){
        String harga = "0";
        String conditional = " WHERE material = '"+material+"'";
        try {
            ResultSet rs = getSpecificColumn(namaKolom, "transport_material", conditional);
            while(rs.next()){
                harga = rs.getString(namaKolom);
                System.out.println(harga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HargaDasarPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Double.parseDouble(harga);
    }

    public List<String> getNamaMEM() {
        return namaMEM;
    }

    public List<String> getNamaMS() {
        return namaMS;
    }

    public List<String> getNamaSA() {
        return namaSA;
    }

    public List<String> getUTK() {
        return UTK;
    }
    
    public List<String> getTS() {
        return TS;
    }

    public List<String> getHargaUTK() {
        return hargaUTK;
    }
    
    public List<String> getRefUTK() {
        return refUTK;
    }

    public List<MEMModel> getMaterial_em() {
        return material_em;
    }

    public List<MSModel> getMaterial_sipil() {
        return material_sipil;
    }
    
    public List<SAModel> getSewa_alat() {
        return sewa_alat;
    }

    public List<UTKModel> getUpah_tenaga_kerja() {
        return upah_tenaga_kerja;
    }
    
    public List<TSModel> getTransport_material() {
        return transport_material;
    }

    public String getHargaUTK(String upahTK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}