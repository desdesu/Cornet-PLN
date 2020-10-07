package cornet_desktop.Model;

import cornet_desktop.utils.Utils;


public class Aksesoris2 {
    private final Utils utils = new Utils();
    private final double hargaKomisioning = 1999777;
    private final double hargaBusClearing = 9775837.28569361;
    private final double hargaMobDemob = 78748302.48;
    private final double hargaScoreBack = 43601538.125;
    private double totalKomisioning;
    
    public void setTotalKomisioning(double jumlahTower){
        totalKomisioning = jumlahTower * hargaKomisioning;
    }
    
    public double getTotalKeseluruhan(){
        double total = 0.0;
        total = totalKomisioning + hargaBusClearing + hargaMobDemob + hargaScoreBack;
        System.out.println("total aksesoris 2 = " + utils.getCurrencyFormat(total));
        return total;
    }

    public double getTotalKomisioning() {
        return totalKomisioning;
    }
    
    
}
