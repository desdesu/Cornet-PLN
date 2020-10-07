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
public class MEMModel {
    private String material;
    private String satuan;
    private String refrensi;
    private String harga;
    

    public MEMModel(String material, String satuan, String refrensi, String harga) {
       
        this.material = material;
        this.satuan = satuan;
        this.refrensi = refrensi;
        this.harga = harga;
    }

    public String getMaterial() {
        return material;
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
