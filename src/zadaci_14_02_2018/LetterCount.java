package zadaci_14_02_2018;

/*
 * BILD-IT Zadaci 14.02.2018.
 *
 * Zadatak 5: Napisati metodu koja broji slova u stringu.
 *
 *            Metoda koristi sljedeci header:
 *            public static int countLetters(String s)
 *
 *            Napisati program koji pita korisnika da unese string te mu ispise koliko taj string ima slova
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class LetterCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;

        System.out.println("Enter string: ");
        s = input.nextLine();

        System.out.println("Your string have " + countLetters(s) + " letter(s)");
    }

    public static int countLetters(String s) {
        int lettersCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                lettersCount++;
            }
        }
        return lettersCount;
    }
}
