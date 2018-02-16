package zadaci_12_02_2018;

/*
 * BILD-IT Zadaci 12.02.2018.
 *
 * Zadatak 3: Napisati metodu koja prima dva cijela broja te vraca najveci zajednicki djelilac
 *
 * @author: Dino Spreco
 * @date: 13.02.2018.
 */

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1;
        int num2;

        System.out.println("Type in 2 integers:");
        System.out.print("Number 1: ");
        num1 = Input.integerInput();
        System.out.print("Number 2: ");
        num2 = Input.integerInput();

        System.out.println("Greatest common divisor for numbers " + num1 + " and " + num2 + " is " + greatestCommongDivisor(num1,num2));

    }

    public static int greatestCommongDivisor(int num1, int num2) {
        int min = num1;
        int gcd = 1; // gdc = greatest common divisor
        if (num1 > num2) {
            min = num2;
        }

        for (int i = 2 ; i <= min ; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
