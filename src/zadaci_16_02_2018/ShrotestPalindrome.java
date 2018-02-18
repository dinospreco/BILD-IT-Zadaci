package zadaci_16_02_2018;

/*
 * BILD-IT Zadaci 16.02.2018.
 *
 * Zadatak 3: Napisati program koji nalazi najkraci palindrom u nekoj recenici
 *
 *            Npr: "hamo vidi mu glave", najkraci palindrom je "idi"
 *
 * @author: Dino Spreco
 * @date: 18.02.2018.
 */


import java.util.Scanner;

public class ShrotestPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence;

        System.out.print("Unesite recenicu: ");
        sentence = input.nextLine();
        System.out.println("Najkraci palindrom je \"" + shortestPalindrome(sentence) + "\"");
    }

    public static boolean isPalindrome(String sentence) {
        for (int i = 0 ; i < sentence.length()/2 ; i++) {
            if (sentence.charAt(i) != sentence.charAt(sentence.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static String shortestPalindrome(String sentence) {
        for (int size = 3 ; size < sentence.length() ; size++) {

            for (int i = 0 ; i <= sentence.length()-size; i++) {
                if (isPalindrome(sentence.substring(i,i+size))) {
                    return sentence.substring(i,i+size);
                }
            }

        }

        if (isPalindrome(sentence)) {
            return sentence;
        }

        return "";
    }
}
