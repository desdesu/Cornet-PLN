package cornet_desktop.Model;

import cornet_desktop.utils.Utils;


public class Aksesoris {
    private final double hargaJoinBox = 13243575.6025889;
    private final double hargaGantiBox = 24516551.2051778;
    private final double hargaDangerPlate = 998313.49167451;
    private final double hargaNumberPlate = 998313.49167451;
    private final double hargaAntiClambing = 1817989.81985294;
    private double totalHargaDangerPlate = 0.0;
    private double totalHargaNumberPlate = 0.0;
    private double totalHargaAntiClambing = 0.0;

    public void setJumlahTower(double jumlahTower) {
        setTotalHargaAntiClambing(jumlahTower);
        setTotalHargaDangerPlate(jumlahTower);
        setTotalHargaNumberPlate(jumlahTower);
    }

    private void setTotalHargaDangerPlate(double jumlahTower) {
        this.totalHargaDangerPlate = jumlahTower * hargaDangerPlate;
    }

    private void setTotalHargaNumberPlate(double jumlahTower) {
        this.totalHargaNumberPlate = jumlahTower * hargaNumberPlate;
    }

    private void setTotalHargaAntiClambing(double jumlahTower) {
        this.totalHargaAntiClambing = jumlahTower * hargaAntiClambing;
    }
    
    public double getTotalKeseluruhan(){
        double total = 0.0;
        Utils utils = new Utils();
        total = totalHargaAntiClambing + totalHargaDangerPlate + totalHargaNumberPlate + hargaGantiBox + hargaJoinBox;
        return total;
    }
}
