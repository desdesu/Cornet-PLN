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
public class MSModel {
  private String nama;
  private String satuan;
  private String refrensi;
  private String harga;
    

    public MSModel(String nama, String satuan, String refrensi, String harga) {
       
        this.nama = nama;
        this.satuan = satuan;
        this.refrensi = refrensi;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }
    
    public String getHarga() {
        return harga;
    }
  
    public String getSatuan() {
        return satuan;
    }
    

    public String getRefrensi() {
        return refrensi;
    }
    
}
   

