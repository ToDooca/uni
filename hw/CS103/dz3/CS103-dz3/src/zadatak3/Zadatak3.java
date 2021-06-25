package zadatak3;

public class Zadatak3 {
    public static void main(String[] args) {
        int n1 = 12345;
        int n2 = 674;
        int n3 = 1074;
        System.out.println(reverseDigits(n1));
        System.out.println(reverseDigits(n2));
        System.out.println(reverseDigits(n3));
    }
    public static int reverseDigits(int num) {
        int temp = 0;
        if(num < 1) return 0;
        temp = num % 10;
        return temp * ((int)Math.pow(10, (int) Math.log10(num))) + reverseDigits(num/10);
    }
}
