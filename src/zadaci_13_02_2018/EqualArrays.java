package zadaci_13_02_2018;

/*
 * BILD-IT Zadaci 13.02.2018.
 *
 * Zadatak 3: Nizovi niz1 i niz2 su striktno identicni ako su njihovi elementi na istim pozicijama jednaki.
 *            Napisati metodu koja vraca true ukoliko su nizovi identicni ili false ukoliko nisu.
 *
 *            Koristiti sljedeci header:
 *            public static boolean equals(int[] niz1, int[] niz2)
 *
 *            Napisati testni program koji pita korisnika da unese dva niza cijelih brojeva te provjerava da li su striktno identicni
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        System.out.println("Input array 1");
        int[] niz1 = inputArray();
        System.out.println("Input array 2");
        int[] niz2 = inputArray();

        if (equals(niz1, niz2)) {
            System.out.println("Arrays are strictly identical");
        }
        else {
            System.out.println("Arrays are not strictly identical");
        }
    }

    public static int[] inputArray() {
        Scanner input = new Scanner(System.in);
        int lenght = -1;

        System.out.print("Type in array lenght: ");

        while (lenght <= 0) {
            if (input.hasNextInt()) {
                lenght = input.nextInt();
            }
            else {
                System.out.print("Array lenght must be positive integer, try again, ");
                input.next();
                continue;
            }
            if (lenght <= 0) {
                System.out.print("Array lenght must be positive integer, try again, ");
                continue;
            }
        }

        int[] array = new int[lenght];

        for (int i = 0 ; i < array.length ; i++) {
            if (input.hasNextInt()) {
                array[i] = input.nextInt();
            }
            else {
                System.out.print("Not an integer, try again. ");
                input.next();
                i--;
            }
        }

        return array;
    }

    public static boolean equals(int[] niz1, int[] niz2) {
        if (niz1.length != niz2.length) {
            return false;
        }

        for (int i = 0 ; i < niz1.length ; i++) {
            if (niz1[i] != niz2[i]) {
                return false;
            }
        }

        return true;
    }
}
