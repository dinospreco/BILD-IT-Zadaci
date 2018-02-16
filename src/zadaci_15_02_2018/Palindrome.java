package zadaci_15_02_2018;

/*
 * BILD-IT Zadaci 15.02.2018.
 *
 * Zadatak 3: Napisati metoda sa sljedecim headerima:
 *            public static int reverse(int number) koja vraca broj sa obrnutim ciframa, npr 123 returns 321
 *            public static boolean isPalindrome(int number) koja vraca true ukoliko je broj palindrom, ili false ukoliko nije.
 *
 *            Koristiti reverse() metodu da se implementira isPalindrome() metoda.
 *
 *            Napisati program koji pita korisnika da unese neki broj te mu ispise da li je broj palindrom ili nije.
 *
 * @author: Dino Spreco
 * @date: 16.02.2018.
 */

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        int number;
        System.out.print("Input number: ");
        number = inputInteger();

        if (isPalindrome(number)) {
            System.out.println("Number " + number + " is palindrome");
        }
        else {
            System.out.println("Number " + number + " is not palindrome");
        }

    }

    public static int inputInteger() {
        Scanner input = new Scanner(System.in);
        int integer = -1;

        while (input.hasNext()) {

            if (input.hasNextInt()) {
                integer = input.nextInt();
                return integer;
            }
            else {
                System.out.print("Not an integer, try again: ");
                input.next();
                continue;
            }
        }

        return integer;
    }

    public static boolean isPalindrome(int number) {
        if (number == reverse(number)) {
            return true;
        }
        return false;
    }

    public static int reverse(int number) {
        int reverseNum = 0;
        boolean isNegative = false;

        if (number < 0) {
            isNegative = true;
            number = number * -1;
        }

        while (number > 0) {
            reverseNum = reverseNum + (number % 10);
            number = number / 10;
            reverseNum = reverseNum * 10;
        }

        if (isNegative) {
            reverseNum = reverseNum * -1;
        }

        return reverseNum/10;
    }
}
