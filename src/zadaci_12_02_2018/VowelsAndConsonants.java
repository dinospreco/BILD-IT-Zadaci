package zadaci_12_02_2018;

/*
 * BILD-IT Zadaci 12.02.2018.
 *
 * Zadatak 2: Napisati program koji pita korisnika da unese string te mu ispise broj samoglasnika i suglasnika u datom strignu
 *
 * @author: Dino Spreco
 * @date: 13.02.2018.
 */

import java.util.Scanner;

public class VowelsAndConsonants {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence;

        System.out.print("Type in a string: ");
        sentence = input.nextLine();

        vowelAndConsonantCount(sentence);
    }

    public static boolean isVowel(char letter) {
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                letter == 'A'|| letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
            return true;
        }
        else {
            return false;
        }
    }

    public static void vowelAndConsonantCount(String sentence) {
        int vowelCount = 0;
        int consonantCount = 0;

        for(int i = 0 ; i < sentence.length() ; i++) {
            if (Character.isLetter(sentence.charAt(i)) && isVowel(sentence.charAt(i))) {
                vowelCount++;
            }
            else if (Character.isLetter(sentence.charAt(i)) && !isVowel(sentence.charAt(i))) {
                consonantCount++;
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }
}
