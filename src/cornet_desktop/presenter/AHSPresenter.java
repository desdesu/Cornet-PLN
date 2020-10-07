/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornet_desktop.presenter;

import cornet_desktop.Model.MTModel;
import cornet_desktop.Model.PTModel;
import cornet_desktop.database.DBAction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AHSPresenter extends DBAction{
   
    private final List<String> namaMT = new ArrayList<>();
    private final List<String> namaPT = new ArrayList<>();
    private final List<String> classPT = new ArrayList<>();
    private final List<MTModel> material_tower= new ArrayList<>();
    private final List<PTModel> pondasi_tower = new ArrayList<>();
   
    //load tipe tower tanpa duplikat data
    public void loadTipePondasi(){
        try {
            ResultSet rs = getWithoudDuplicateData("tipe", "pondasi_tower");
            namaPT.clear();
            while(rs.next()){
                String result = rs.getString("tipe");
                System.out.println(result);
                namaPT.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //load pondasi tower tanpa duplikat data
    public void loadClassPondasi(){
        try {
            ResultSet rs = getWithoudDuplicateData("class", "pondasi_tower");
            classPT.clear();
            while(rs.next()){
                String result = rs.getString("class");
                System.out.println(result);
                classPT.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //load data basis material
    public void loadBasisMaterial(String tipe){
        try {
            ResultSet rs = getSpecificColumn("basis", "material_tower", " WHERE tipe_tower = '" + tipe + "'");
            namaMT.clear();
            while(rs.next()){
                String result = rs.getString("basis");
                System.out.println(result);
                namaMT.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //load material tower berdasarkan tipe dan basis
    public MTModel getMaterialTower(String tipeTower, String basisTower){
        MTModel material = new MTModel();
        try {
            ResultSet result = getSpecificColumn("*", "material_tower", " WHERE tipe_tower = '" + tipeTower + "' AND basis = '" + basisTower + "'");
            while(result.next()){
                String tipe = result.getString("tipe_tower");
                String basis = result.getString("basis");
                String berat = result.getString("berat");
                String harga_permenperin = result.getString("harga_permenperin");
                String harga_erection = result.getString("harga_erection");
                material = new MTModel(tipe, basis, berat, harga_permenperin, harga_erection);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return material;
    }
    
    public void loadDatanamaMT(){
        try {
            ResultSet result = getDataFromDatabase("material_tower");
            while(result.next()){
                String tipe = result.getString("tipe_tower");
                String basis = result.getString("basis");
                String berat = result.getString("berat");
                String harga_permenperin = result.getString("harga_permenperin");
                String harga_erection = result.getString("harga_erection");
                namaMT.add(tipe);
                material_tower.add(new MTModel(tipe, basis, berat, harga_permenperin, harga_erection));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void loadDatanamaPT(){
        try {
            ResultSet result = getDataFromDatabase("pondasi_tower");
            while(result.next()){
                String tipe = result.getString("tipe");
                String clas = result.getString("class");
                String harga_pondasi = result.getString("harga_pondasi");
                namaPT.add(tipe);
                pondasi_tower.add(new PTModel(tipe, clas, harga_pondasi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public void loadDataclassPT(){
        try {
            ResultSet result = getDataFromDatabase("pondasi_tower");
            while(result.next()){
                String clas = result.getString("class");
                String tipe = result.getString("tipe");
                String harga_pondasi = result.getString("harga_pondasi");
                classPT.add(clas);
                pondasi_tower.add(new PTModel(clas, tipe, harga_pondasi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

   public String getHargaPondasi(String tipeTower, String classPondasi){
       String hargaPondasi = "0.0";
        try {
            ResultSet result = getSpecificColumn("harga_pondasi", "pondasi_tower", " WHERE tipe = '"+ tipeTower + "' and class = '" + classPondasi + "'");
            while(result.next()){
                hargaPondasi = result.getString("harga_pondasi");
                System.out.println(hargaPondasi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AHSPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hargaPondasi;
   }
   
    public List<String> getNamaMT() {
        return namaMT;
    }

    public List<String> getNamaPT () {
        return namaPT;
    }
    
    public List<String> getClassPT () {
        return classPT;
    }
    
    public List<MTModel> getMaterial_tower() {
        return material_tower;
    }

    public List<PTModel> getPondasi_tower() {
        return pondasi_tower;
    }
}
