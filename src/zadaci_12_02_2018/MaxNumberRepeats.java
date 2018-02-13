package zadaci_12_02_2018;

/*
 * BILD-IT Zadaci 12.02.2018.
 *
 * Zadatak 5: Napisati program koji ucitatva niz brojeva, pronalazi najveci te ispisuje koliko se taj broj puta ponavlja.
 *            Pretpostaviti 0 za kraj unosa:
 *
 * @author: Dino Spreco
 * @date: 13.02.2018.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MaxNumberRepeats {
    public static void main(String[] args) {
        int maxCount = 0;
        int max;
        int tmp;
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        System.out.println("Type in array of integers (0 for end)");
        while ((tmp = Input.integerInput()) != 0) {
            numbers.add(tmp);
        }

        max = max(numbers);

        for (Integer number : numbers) {
            if (number.equals(max)) {
                maxCount++;
            }
        }

        System.out.println("Max number is " + max + " and appears " + maxCount + " times in your array");


    }

    public static int max(ArrayList<Integer> list) {
        int max = 0;

        if (list == null || list.size() == 0) {
            System.out.println("No elements in the list");
        }
        else {
            max = new Integer(list.get(0));
        }

        for (Integer integer : list) {
            if (integer.compareTo(max) == 1) {
                max = integer;
            }
        }

        return max;
    }
}
