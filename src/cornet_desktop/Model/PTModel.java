/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornet_desktop.Model;

/**
 *
 * @author User
 */
public class PTModel {
  private String tipe;
  private String clas;
  private String harga_pondasi;
 
    

    public PTModel (String tipe, String clas, String harga_pondasi) {
       
        this.tipe = tipe;
        this.clas = clas;
        this.harga_pondasi = harga_pondasi;
    }

    public String getTipe() {
        return tipe;
    }
    
    public String getClas() {
        return clas;
    }
  
    public String getHarga_pondasi() {
        return harga_pondasi;
    }  
    
}