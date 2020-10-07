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
public class MTModel {
  private String tipe;
  private String basis;
  private String berat;
  private String harga_permenperin;
  private String harga_erection;

    public MTModel() {
    }
  
    
    
    public MTModel (String tipe, String basis, String berat, String harga_permenperin, String harga_erection) {
       
        this.tipe = tipe;
        this.basis = basis;
        this.berat = berat;
        this.harga_permenperin = harga_permenperin;
        this.harga_erection = harga_erection;
    }

    public String getTipe() {
        return tipe;
    }
    
    public String getBasis() {
        return basis;
    }
    
    public String getBerat() {
        return berat;
    }
    
    public String getHarga_erection() {
        return harga_erection;
    }
    
    public String getHarga_permenperin() {
        return harga_permenperin;
    }  
}
    