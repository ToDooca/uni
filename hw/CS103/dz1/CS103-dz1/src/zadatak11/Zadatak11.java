//Napisati program kojim se štampaju svi trocifreni brojevi koji imaju osobinu da su deljivi sa brojem koji se
//dobija izbacivanjem srednje cifre tog istog broja.

package zadatak11;

public class Zadatak11 {

    public static void main(String[] args) {
        for(int i = 100; i<=999; i++){
            if(divisibleDigits(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean divisibleDigits(int num) {
        if (num < 100 || num > 999) return false;
        int first = num / 100;
        int third = num % 10;
        int divisor = first * 10 + third;
        return num % divisor == 0;
    }
}
