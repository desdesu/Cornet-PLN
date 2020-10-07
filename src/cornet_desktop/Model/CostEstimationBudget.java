package cornet_desktop.Model;



public class CostEstimationBudget {
    private final double hargaSagging = 5280556.75;
    private final double hargaClamping = 1491150.95;
    private final double hargaAromourRod = 421385.420575111;
    private final double hargaIsolatorST = 14363968.2622575;
    private final double hargaIsolatorDT = 27154159.4100118;
    private final double hargaIsolatorSS = 9128566.82905751;
    private final double hargaIsolatorDS = 17976137.0753451;   
    private double totalHargaSagging = 0.0;
    private double totalHargaClamping = 0.0;
    private double totalHargaAromourRod = 0.0;
    private double totalHargaTower = 0.0;
    private double totalHargaPondasiTower = 0.0;
    private double totalHargaIsolatorST = 0.0;
    private double totalHargaIsolatorDT = 0.0;
    private double totalHargaIsolatorSS = 0.0;
    private double totalHargaIsolatorDS = 0.0;
    private double sagging = 0.0;
    private double clamping = 0.0;

    public void setSagging(double sagging) {
        this.sagging = sagging;
        setTotalHargaSagging(sagging);
    }

    public void setClamping(double clamping) {
        this.clamping = clamping;
        setTotalHargaClamping(clamping);
    }

    public void setTotalHargaTower(double totalHargaTower) {
        this.totalHargaTower = totalHargaTower;
    }

    public void setTotalHargaPondasiTower(double totalHargaPondasiTower) {
        this.totalHargaPondasiTower = totalHargaPondasiTower;
    }

    public void setTotalHargaSagging(double jumlahSagging) {
        this.totalHargaSagging = jumlahSagging * hargaSagging;
    }

    public void setTotalHargaClamping(double jumlahClamping) {
        this.totalHargaClamping = jumlahClamping * hargaClamping;
    }

    public void setTotalHargaAromourRod(double totalHargaAromourRod) {
        this.totalHargaAromourRod = totalHargaAromourRod * hargaAromourRod;
    }

    public void setTotalHargaIsolatorST(double totalHargaIsolatorST) {
        this.totalHargaIsolatorST = totalHargaIsolatorST * hargaIsolatorST;
    }

    public void setTotalHargaIsolatorDT(double totalHargaIsolatorDT) {
        this.totalHargaIsolatorDT = totalHargaIsolatorDT * hargaIsolatorDT;
    }

    public void setTotalHargaIsolatorSS(double totalHargaIsolatorSS) {
        this.totalHargaIsolatorSS = totalHargaIsolatorSS * hargaIsolatorSS;
    }

    public void setTotalHargaIsolatorDS(double totalHargaIsolatorDS) {
        this.totalHargaIsolatorDS = totalHargaIsolatorDS * hargaIsolatorDS;
    }
    
    public double getTotalKeseluruhan(){
        double total = totalHargaAromourRod + totalHargaClamping + totalHargaIsolatorDS + totalHargaIsolatorDT + totalHargaIsolatorSS + 
                totalHargaIsolatorST + totalHargaSagging + totalHargaTower + totalHargaPondasiTower;
        return total;
    }

    public double getSagging() {
        return sagging;
    }

    public double getClamping() {
        return clamping;
    }

    public double getTotalHargaSagging() {
        return totalHargaSagging;
    }

    public double getTotalHargaClamping() {
        return totalHargaClamping;
    }

    public double getTotalHargaAromourRod() {
        return totalHargaAromourRod;
    }

    public double getTotalHargaTower() {
        return totalHargaTower;
    }

    public double getTotalHargaPondasiTower() {
        return totalHargaPondasiTower;
    }

    public double getTotalHargaIsolatorST() {
        return totalHargaIsolatorST;
    }

    public double getTotalHargaIsolatorDT() {
        return totalHargaIsolatorDT;
    }

    public double getTotalHargaIsolatorSS() {
        return totalHargaIsolatorSS;
    }

    public double getTotalHargaIsolatorDS() {
        return totalHargaIsolatorDS;
    }
    
    private void clear(){
        this.totalHargaSagging = 0.0;
        this.totalHargaClamping = 0.0;
        this.totalHargaAromourRod = 0.0;
        this.totalHargaTower = 0.0;
        this.totalHargaPondasiTower = 0.0;
        this.totalHargaIsolatorST = 0.0;
        this.totalHargaIsolatorDT = 0.0;
        this.totalHargaIsolatorSS = 0.0;
        this.totalHargaIsolatorDS = 0.0;
    }
}
