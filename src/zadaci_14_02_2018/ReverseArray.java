package zadaci_14_02_2018;

/*
 * BILD-IT Zadaci 14.02.2018.
 *
 * Zadatak 4: Napisati program koji prima 10 cijelih brojeva te ih ispisuje u obrnutom redoslijedu
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = new int[10];

        System.out.println("Enter 10 integers");
        inputArray(array);
        System.out.println("Your array: ");
        printArray(array);
        reversArray(array);
        System.out.println("Reversed array");
        printArray(array);


    }
    public static void reversArray(int[] array) {
        int tmp;
        for (int i = 0 ; i < (array.length/2) ; i++) {
            tmp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = tmp;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void inputArray(int[] array) {
        Scanner input = new Scanner(System.in);
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
    }
}
