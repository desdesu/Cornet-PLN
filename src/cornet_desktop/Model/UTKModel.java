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
public class UTKModel {
   
    private String nama;
    private String refrensi;
    private String harga;
    

    public UTKModel(String nama, String refrensi, String harga) {
       
        this.nama = nama;
        this.refrensi = refrensi;
        this.harga = harga;
    }

    public String getHarga() {
        return harga;
    }
  
    public String getNama() {
        return nama;
    }

    public String getRefrensi() {
        return refrensi;
    }
    
}
