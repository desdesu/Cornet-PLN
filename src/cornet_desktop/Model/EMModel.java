package cornet_desktop.Model;

public class EMModel {
    private String stringing;
    private String satuan;
    private String harga;

    public EMModel(String stringing, String satuan, String harga) {
        this.stringing = stringing;
        this.satuan = satuan;
        this.harga = harga;
    }

    public String getStringing() {
        return stringing;
    }

    public String getSatuan() {
        return satuan;
    }

    public String getHarga() {
        return harga;
    }
    
    
}
