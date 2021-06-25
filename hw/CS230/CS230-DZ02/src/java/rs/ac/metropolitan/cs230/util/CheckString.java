
package rs.ac.metropolitan.cs230.util;


public class CheckString {
    public String welcomeMessage(String ime, String prezime, String index){
        if (ime.equals("") || prezime.equals("") || index.length() <= 4){
            return "Dobrodošli, " + ime + " " + prezime + ", vi ste student Univerziteta Metropolitan pod brojem indeksa: " + index;
        } else {
            return "Niste uneli traženi podatak";
        }
    }
}
