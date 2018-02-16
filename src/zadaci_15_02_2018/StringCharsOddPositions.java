package zadaci_15_02_2018;

/*
 * BILD-IT Zadaci 15.02.2018.
 *
 * Zadatak 4: Napisati program koji pita korisnika da unese neki string te mu ispise sve karaktere
 *            koji se nalaze na neparnim pozicijama
 *
 * @author: Dino Spreco
 * @date: 16.02.2018.
 */

import java.util.Scanner;

public class StringCharsOddPositions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;

        System.out.print("Type in a string: ");
        str = input.nextLine();

        System.out.println("All characters from odd positions: ");
        System.out.println(oddPositionChars(str));

    }

    public static String oddPositionChars(String str) {
        String oddPosString = "";

        for (int i = 0 ; i < str.length() ; i++) {
            if (i % 2 == 0) {
                oddPosString = oddPosString + str.charAt(i);
            }
        }

        return oddPosString;
    }
}
