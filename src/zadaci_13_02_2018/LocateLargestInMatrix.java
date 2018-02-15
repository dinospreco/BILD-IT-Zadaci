package zadaci_13_02_2018;

/*
 * BILD-IT Zadaci 13.02.2018.
 *
 * Zadatak 4: Napisati metodu koja vraca lokaciju najveceg elementa u 2D nizu. Metoda treba da koristi sljedeci header:
 *            public static int[] locateLargest(double[][] a)
 *
 *            Napisati test program koji pita korisnika da unese 2D niz te mu ispisuje lokaciju najveceg elementa.
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class LocateLargestInMatrix {

    public static void main(String[] args) {
        double[][] matrix = inputMatrix();
        int[] location = locateLargest(matrix);

        System.out.println("Location of the largest element is (" + (location[0]+1) + "," + (location[1]+1) + ").");
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] inputMatrix() {

        Scanner input = new Scanner(System.in);

        int numberOfColumns = -1;
        int numberOfRows = -1;

        System.out.print("Type in number of rows: ");

        while (numberOfRows <= 0) {
            if (input.hasNextInt()) {
                numberOfRows = input.nextInt();
            }
            else {
                System.out.print("Number of rows must be positive integer, try again, ");
                input.next();
                continue;
            }
            if (numberOfRows <= 0) {
                System.out.print("Number of rows must be positive integer, try again, ");
                continue;
            }
        }

        System.out.print("Type in number of columns: ");

        while (numberOfColumns <= 0) {
            if (input.hasNextInt()) {
                numberOfColumns = input.nextInt();
            }
            else {
                System.out.print("Number of columns must be positive integer, try again, ");
                input.next();
                continue;
            }
            if (numberOfColumns <= 0) {
                System.out.print("Number of columns must be positive integer, try again, ");
                continue;
            }
        }

        System.out.println("Type in your elements:");

        double[][] matrix = new double[numberOfRows][numberOfColumns];

        for (int i = 0 ; i < numberOfRows ; i++) {
            for (int j = 0 ; j < numberOfColumns ; j++) {
                if (input.hasNextDouble()) {
                    matrix[i][j] = input.nextDouble();
                }
                else {
                    System.out.print("Not a decimal number, try again. ");
                    input.next();
                    i--;
                }
            }

        }

        return matrix;
    }

    public static int[] locateLargest(double[][] a) {
        int[] location = new int[2];
        double max = a[0][0];

        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < a[i].length ; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                    location[0] = i;
                    location[1] = j;
                }
            }
        }

        return location;
    }
}
