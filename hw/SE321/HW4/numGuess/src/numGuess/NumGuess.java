package numGuess;

import java.util.Scanner;

public class NumGuess {
    public static class Guesser {
        public int lower;
        public int upper;

        public static class InvalidInputException extends Exception {
            public InvalidInputException() {
            }
        }

        public Guesser(int l, int u) {
            lower = l;
            upper = u;
        }

        public void quiz() {
            System.out.println("Zamislite broj između " + lower + " i " + upper);
            Scanner sc = new Scanner(System.in);
            int temp;
            int l = lower;
            int u = upper;
            while (l != u) {
                temp = l + (u - l) / 2;
                boolean gt;

                try {
                    gt = askIfGreaterThan(temp, sc);
                } catch (InvalidInputException e) {
                    System.out.println("odgovorite sa da ili ne");
                    continue;
                }

                if (gt) {
                    l = temp + 1;
                } else {
                    u = temp;
                }

            }

            System.out.println("Vaš broj je: " + u);
        }

        public boolean askIfGreaterThan(int n, Scanner sc) throws InvalidInputException {
            boolean output;

            System.out.println("da li je vaš broj veći od " + n + " ? ");
            String input = sc.nextLine();

            switch (input.toLowerCase()) {
                case "da":
                    output = true;
                    break;
                case "ne":
                    output = false;
                    break;
                default:
                    throw new InvalidInputException();
            }
            return output;
        }
    }

    public static void main(String[] args) {
        int lower = 0;
        int upper = 10;
        Guesser g = new Guesser(lower, upper);
        g.quiz();
    }
}