package zadaci_13_02_2018;

/*
 * BILD-IT Zadaci 13.02.2018.
 *
 * Zadatak 2: Napisati metodu koja vraca min vrijednost u nizu double vrijednosti koristeci se sljedecim headerom
 *            public static double min(double[] array)
 *
 *            Napisite test program koji pita korisnika da unese 10 decimalnih vrijednosti te poziva ovu metodu
 *            da vrati najmanji element u nizu
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class MinElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[10];

        System.out.println("Type 10 decimal numbers: ");
        for (int i = 0 ; i < array.length ; i++) {
            if (input.hasNextDouble()) {
                array[i] = input.nextDouble();
            }
            else {
                System.out.print("Not a decimal number, try again. ");
                input.next();
                i--;
            }
        }

        System.out.println("Min number is: " + min(array));
    }

    public static double min(double[] array) {
        double min = array[0];
        for (int i = 0 ; i < array.length ; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
