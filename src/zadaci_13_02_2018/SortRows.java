package zadaci_13_02_2018;

/*
 * BILD-IT Zadaci 13.02.2018.
 *
 * Zadatak 5: Implementirati sljedecu metodu da sortira redove u 2D nizu.
 *
 *            public static double[][] sortRows(double[][] array)
 *
 *            Napisati testni program koji pita korisnika da unese 3x3 matricu (ili da pita korisnika koliko zeli unijeti)
 *            te mu ispisuje na konzoli matricu sa sortiranim redovima od najmanjeg do najveceg
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */


import java.util.Arrays;

public class SortRows {
    public static void main(String[] args) {
        double[][] matrix = LocateLargestInMatrix.inputMatrix();
        System.out.println("\nUNSORTED:");
        LocateLargestInMatrix.printMatrix(matrix);

        matrix = sortRows(matrix);
        System.out.println("\nSORTED:");
        LocateLargestInMatrix.printMatrix(matrix);
    }

    public static double[][] sortRows(double[][] array) {
        //Since method returns new 2D array, i have to make copy
        double[][] matrix = new double[array.length][array[0].length];

        for (int i = 0 ; i < matrix.length ; i++) {
            matrix[i] = Arrays.copyOf(array[i],matrix[i].length);
            Arrays.sort(matrix[i]);
        }

        return matrix;
    }
}
