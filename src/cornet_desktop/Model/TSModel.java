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
public class TSModel {
   private String material;
   private String harga_material;
   private String biaya_bongkar; 

public TSModel(String biaya_bongkar, String harga_material, String material) {
        this.material = material;
        this.harga_material = harga_material;
        this.biaya_bongkar = biaya_bongkar;
    }

    public String getBiaya_bongkar() {
        return biaya_bongkar;
    }

    public String getHarga_material() {
        return harga_material;
    }

    public String getMaterial() {
        return material;
    }
}    