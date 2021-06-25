
package rs.ac.metropolitan.cs230;

import java.io.Serializable;

public class StockBean implements Serializable{
    private String simbol;

    public StockBean() {
    }
    
    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }
}
