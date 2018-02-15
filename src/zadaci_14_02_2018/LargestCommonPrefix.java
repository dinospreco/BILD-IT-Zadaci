package zadaci_14_02_2018;

/*
 * BILD-IT Zadaci 14.02.2018.
 *
 * Zadatak 3: Napisati program koji pita korisnika da unese 2 stringa te ispisuje najveci zajednicki prefix za ta dva stringa
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class LargestCommonPrefix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1;
        String str2;
        String prefix;

        System.out.print("Enter string 1: ");
        str1 = input.nextLine();
        System.out.print("Enter string 2: ");
        str2 = input.nextLine();

        prefix = commonPrefix(str1,str2);

        if (prefix.equals("")) {
            System.out.println("Stringovi: ");
            System.out.println("\"" + str1 + "\"");
            System.out.println("i");
            System.out.println("\"" + str2 + "\"");
            System.out.println("Nemaju zajednickog prefixa");
        }
        else {
            System.out.println("Zajednicki prefix za stringove: ");
            System.out.println("\"" + str1 + "\"");
            System.out.println("i");
            System.out.println("\"" + str2 + "\"");
            System.out.println("je: \"" + prefix + "\"");
        }
    }

    public static String commonPrefix(String str1, String str2) {
        String prefix = "";
        for (int i = 0 ; i < str1.length() ; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                prefix = prefix + str1.charAt(i);
            }
            else {
                break;
            }
        }
        return prefix;
    }

}
