package cornet_desktop.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class Utils {
    
    // untuk merubah string angka biasa menjadi format mata uang
    public String getCurrencyFormat(String mooney){
        Locale locale = new Locale("ca", "CA");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        String result = format.format(Double.parseDouble(mooney));
        result = result.replaceAll("CAD", "Rp.");
        return result;
    }
    
    public String getCurrencyFormat(Double mooney){
        Locale locale = new Locale("ca", "CA");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        String result = format.format(mooney);
        result = result.replaceAll("CAD", "Rp.");
        return result;
    }
    
    public double getNumberFormat(String currency){
        double number = 0.0;
        currency = currency.replace("Rp. ", "");
        currency = currency.replace(".", "");
        currency = currency.replace(",", ".");
        number = Double.parseDouble(currency);
        return number;
    }
}
