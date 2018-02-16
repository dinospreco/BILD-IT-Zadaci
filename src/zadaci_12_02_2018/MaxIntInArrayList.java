package zadaci_12_02_2018;

/*
 * BILD-IT Zadaci 12.02.2018.
 *
 * Zadatak 1: Napisati metodu koja vraca najveci element iz ArrayList<Integer>
 *            Metoda vraca null ako je lista null ili ima 0 elemenata
 *
 * @author: Dino Spreco
 * @date: 13.02.2018.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MaxIntInArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        addElementsToList(list);
        System.out.println("Max element of the list is: " + max(list));

    }

    public static void addElementsToList(ArrayList<Integer> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("ArrayList<Integer> input. (Type anything but number when you finish");
        while(input.hasNextInt()) {
            list.add(input.nextInt());
        }
    }

    public static Integer max(ArrayList<Integer> list) {
        Integer max;

        if (list == null || list.size() == 0) {
            return null;
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
