package cornet_desktop.Model;

import cornet_desktop.utils.Utils;


public class Konduktor {
    private final Utils utils = new Utils();
    private final double totalHargaACSR = 327514120.214599; //per KMR
    private final double totalHargaOPGW = 73666626.1537878; //per KMR
    private final double totalHargaGSW = 39388308.4447714; // per KMR
    private final double totalHargaRepairSlave = 208897.910726667; // per KMR
    private final double harga_gwvdOPGW = 1001330.18079722; // per tower.
    private final double harga_gwvdGSW = 978776.633922222; // per tower
    private final double harga_gwssOPGW = 1655001.32546667; // per clamping
    private final double harga_gwtsOPGW = 1908791.07842222; // per sagging
    private final double harga_gwssGSW = 1063443.97226667; // per clamping
    private final double harga_gwtsGSW = 1469649.77786667; // per sagging
    private final double hargaLineConduktor = 6377071.05602667; // per tower
    private final double hargaMidSpanJoint = 839509.342868889; // per tower
    private double totalHarga_gwvdOPGW; // per tower
    private double totalHarga_gwvdGSW; // per tower
    private double totalHarga_gwssOPGW; // per clamping
    private double totalHarga_gwtsOPGW; // per sagging
    private double totalHarga_gwssGSW; // per clamping
    private double totalHarga_gwtsGSW; // per sagging
    private double totalHargaLineConduktor; // per tower
    private double totalHargaMidSpanJoint; // per tower
    private double jumlahTower;
    private double jumlahSagging;
    private double jumlahClamping;

    public void setJumlahTower(double jumlahTower) {
        this.jumlahTower = jumlahTower;
        setTotalHargaLineConduktor(jumlahTower);
        setTotalHargaMidSpanJoint(jumlahTower);
        setTotalHarga_gwvdGSW(jumlahTower);
        setTotalHarga_gwvdOPGW(jumlahTower);
    }

    public void setJumlahSagging(double jumlahSagging) {
        this.jumlahSagging = jumlahSagging;
        setTotalHarga_gwtsGSW(jumlahSagging);
        setTotalHarga_gwtsOPGW(jumlahSagging);
    }

    public void setJumlahClamping(double jumlahClamping) {
        this.jumlahClamping = jumlahClamping;
        setTotalHarga_gwssGSW(jumlahClamping);
        setTotalHarga_gwssOPGW(jumlahClamping);
    }

    private void setTotalHargaMidSpanJoint(double jumlahTower) {
        this.totalHargaMidSpanJoint = jumlahTower * hargaMidSpanJoint;
        //System.out.println("total harga mid span joint = " + utils.getCurrencyFormat(String.valueOf(this.totalHargaMidSpanJoint)));
    }

    private void setTotalHargaLineConduktor(double jumlahTower) {
        this.totalHargaLineConduktor = jumlahTower * hargaLineConduktor;
        //System.out.println("total harga line conduktor = " + utils.getCurrencyFormat(String.valueOf(this.totalHargaLineConduktor)));
    }

    private void setTotalHarga_gwssGSW(double totalClamping) {
        this.totalHarga_gwssGSW = totalClamping * harga_gwssGSW;
        //System.out.println("total harga ground wire suspension set GSW = " + utils.getCurrencyFormat(this.totalHarga_gwssGSW));
    }

    private void setTotalHarga_gwtsGSW(double totalSagging) {
        this.totalHarga_gwtsGSW = totalSagging * harga_gwtsGSW;
        //System.out.println("total harga ground wire tension set GSW = " + utils.getCurrencyFormat(this.totalHarga_gwtsGSW));
    }

    private void setTotalHarga_gwtsOPGW(double totalSagging) {
        this.totalHarga_gwtsOPGW = totalSagging * harga_gwtsOPGW;
        //System.out.println("total harga ground wire tension set OPGW = " + utils.getCurrencyFormat(this.totalHarga_gwtsOPGW));
    }

    private void setTotalHarga_gwssOPGW(double totalClamping) {
        this.totalHarga_gwssOPGW = totalClamping * harga_gwssOPGW;
        //System.out.println("total harga ground wire suspension set OPGW = " + utils.getCurrencyFormat(this.totalHarga_gwssOPGW));
    }

    private void setTotalHarga_gwvdGSW(double jumlahTower) {
        this.totalHarga_gwvdGSW = jumlahTower * harga_gwvdGSW;
        //System.out.println("total harga ground wire vibration damper GSW = " + utils.getCurrencyFormat(this.totalHarga_gwvdGSW));
    }

    private void setTotalHarga_gwvdOPGW(double jumlahTower) {
        this.totalHarga_gwvdOPGW = jumlahTower * harga_gwvdOPGW;
        //System.out.println("total harga ground wire vibration damper OPGW = " + utils.getCurrencyFormat(this.totalHarga_gwvdOPGW));
    }
    
    public double getTotalKeseluruhan(){
        double total = 0.0;
        total = totalHargaACSR + totalHargaGSW + totalHargaLineConduktor + totalHargaMidSpanJoint + totalHargaOPGW + totalHargaRepairSlave + 
                totalHarga_gwssGSW + totalHarga_gwssOPGW + totalHarga_gwtsGSW + totalHarga_gwtsOPGW + totalHarga_gwvdGSW + totalHarga_gwvdOPGW;
        System.out.println("total harga konduktor 1 keseluruhan = " + utils.getCurrencyFormat(total));
        return total;
    }
}
