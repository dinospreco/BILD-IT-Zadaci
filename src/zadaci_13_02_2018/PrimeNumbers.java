package zadaci_13_02_2018;

/*
 * BILD-IT Zadaci 13.02.2018.
 *
 * Zadatak 1: Napisati metodu koja prima dva argumenta, pocetni i krajnji broj,
 *            te printa sve proste brojeve u zadanom rangu.
 *            BONUS: Metoda moze imati i treci argumen, broj ispisa brojeva u jednom redu
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

public class PrimeNumbers {

    public static void main(String[] args) {
        printPrimeNumbersWithinRange(100,-10, 10);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2 ; i < number/2 ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeNumbersWithinRange(int lowerBound, int upperBound) {

        if (lowerBound > upperBound) {
            int swap = lowerBound;
            lowerBound = upperBound;
            upperBound = swap;
        }

        for (int i = lowerBound ; i <= upperBound ; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void printPrimeNumbersWithinRange(int lowerBound, int upperBound, int numbersPerRow) {
        int digitCount = 0;
        int columnCount = 1;
        String printfStr;

        if (lowerBound > upperBound) {
            int swap = lowerBound;
            lowerBound = upperBound;
            upperBound = swap;
        }

        int tmp = upperBound;

        while (tmp > 0) {
            digitCount++;
            tmp = tmp/10;
        }

        printfStr = "%" + digitCount + "d";

        for (int i = lowerBound ; i <= upperBound ; i++) {
            if (isPrime(i)) {

                System.out.printf(printfStr,i);
                if (columnCount % numbersPerRow == 0) {
                    System.out.println();
                }
                else {
                    System.out.print(",");
                }
                columnCount++;
            }
        }
    }

}

