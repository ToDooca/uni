package rs.ac.metropolitan.cs230;

import java.util.ArrayList;
import java.util.List;

public class StockPriceGenerator {

    private List<String> listaSimbola = new ArrayList<>();

    public StockPriceGenerator() {
        listaSimbola.add("YHOO");
        listaSimbola.add("MCFT");
        listaSimbola.add("AAPL");
        listaSimbola.add("IBM");
        listaSimbola.add("MOJISTOCK");
    }

    public String calculatePrice(String simbol, int brojAkcija) {
        if (brojAkcija < 1) {
            brojAkcija = 1;
        }
        if (listaSimbola.contains(simbol)) {
            int randNumber = (1 + (int) (Math.random() * 100)) * brojAkcija;
            return "Cena akcija je: " + randNumber + ". A cena jedne akcije je : " + randNumber / brojAkcija;
        } else {
            return "Simbol nije podržan";
        }
    }
}
