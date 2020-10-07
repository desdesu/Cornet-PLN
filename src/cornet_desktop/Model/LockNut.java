package cornet_desktop.Model;


public class LockNut {
    private int quantity = 0;
    private double hargaDasar;

    public LockNut(double hargaDasar) {
        this.hargaDasar = hargaDasar;
    }

    public void addQuantity(){
        this.quantity++;
    }
    
    public double getTotal(){
        return quantity * hargaDasar;
    }

    public int getQuantity() {
        return quantity;
    }
}
