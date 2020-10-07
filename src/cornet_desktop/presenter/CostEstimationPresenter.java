/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornet_desktop.presenter;

import cornet_desktop.Model.LockNut;
import cornet_desktop.database.DBAction;
import cornet_desktop.utils.Utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CostEstimationPresenter extends DBAction{
    private List<String> tipeTower = new ArrayList<>();
    private List<String> classPondasi = new ArrayList<>();
    private List<String> basisTower = new ArrayList<>();
    
    public void loadTipeTower(){
        try {
            String namaKolom = "tipe";
            ResultSet rs = getWithoudDuplicateData(namaKolom, "pondasi_tower");
            while(rs.next()){
                String tipe = rs.getString(namaKolom);
                tipeTower.add(tipe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostEstimationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadClassPondasi(){
        try {
            String namaKolom = "class";
            ResultSet rs = getWithoudDuplicateData(namaKolom, "pondasi_tower");
            while(rs.next()){
                String pondasi = rs.getString(namaKolom);
                classPondasi.add(pondasi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostEstimationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadBasisTower(String tipe){
        basisTower.clear();
        try {
            String namaKolom = "basis";
            ResultSet rs = getSpecificColumn(namaKolom, "material_tower", " WHERE tipe_tower='"+tipe+"'");
            while(rs.next()){
                String basis = rs.getString(namaKolom);
                basisTower.add(basis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostEstimationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HashMap<String, LockNut> getLockNut(){
        HashMap<String, LockNut> lockNut = new HashMap<>();
        try {
            ResultSet rs = getDataFromDatabase("lock_nut");
            while(rs.next()){
                String tipe = rs.getString("tipe_tower");
                String harga = rs.getString("harga");
                lockNut.put(tipe, new LockNut(Double.parseDouble(harga)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostEstimationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lockNut;
    }
    
    public double getHargaPondasi(String tipeTower, String classPondasi){
        double hargaPondasi = 0.0;
        String namaKolom = "harga_pondasi";
        try {
            ResultSet rs = getSpecificColumn(namaKolom, "pondasi_tower", " WHERE tipe='" + tipeTower + "' AND class='" + classPondasi +"'");
            while(rs.next()){
                hargaPondasi = Double.parseDouble(rs.getString(namaKolom));
            }
            return hargaPondasi;
        } catch (SQLException ex) {
            Logger.getLogger(CostEstimationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hargaPondasi;
    }
    
    public double getHargaTower(String tipeTower, String basisTower){
        double hargaTower = 0.0;
        try {
            ResultSet rs = getDataFromDatabase("material_tower", " WHERE tipe_tower='" + tipeTower + "' AND basis='" + basisTower +"'");
            while(rs.next()){
                double hargaPengadaan = Double.parseDouble(rs.getString("harga_permenperin"));
                double hargaTransport = Double.parseDouble(rs.getString("harga_transport"));
                double hargaErection = Double.parseDouble(rs.getString("harga_erection"));
                hargaTower = hargaPengadaan + hargaTransport + hargaErection;
            }
            return hargaTower;
        } catch (SQLException ex) {
            Logger.getLogger(CostEstimationPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hargaTower;
    }

    public List<String> getTipeTower() {
        return tipeTower;
    }

    public List<String> getClassPondasi() {
        return classPondasi;
    }

    public List<String> getBasisTower() {
        return basisTower;
    }
}
