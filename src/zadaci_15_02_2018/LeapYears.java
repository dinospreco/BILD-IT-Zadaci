package zadaci_15_02_2018;

/*
 * BILD-IT Zadaci 15.02.2018.
 *
 * Zadatak 2: Napisati program koji ispisuje sve prestupne godine, 10 po liniji
 *            u rasponu godina koji korisnik unese.
 *
 *            Program pita korisnika da unese pocetnu godinu, krajnju godinu,
 *            te ispisuje sve godine u tom rasponu.
 *
 *            Razmak izmedju godina treba biti jedan space.
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */


import java.util.Scanner;

public class LeapYears {

    public static void main(String[] args) {
        int upperLimit = 0;
        int lowerLimit = 0;
        int printCount = 0;

        System.out.print("Enter lower limit:");
        lowerLimit = inputPositiveInteger();
        System.out.print("Enter upper limit:");
        upperLimit = inputPositiveInteger();

        if (lowerLimit > upperLimit) {
            System.out.println("Lower limit must be less than upper limit. No worries, we got your back.");
            int tmp = lowerLimit;
            lowerLimit = upperLimit;
            upperLimit = tmp;
        }

        System.out.println();
        System.out.println("Leap Years from year " + lowerLimit + " to year " + upperLimit + " are: ");

        for (int i = lowerLimit ; i <= upperLimit ; i++) {
            if(isLeapYear(i)) {
                System.out.print(i + " ");
                printCount++;
                if (printCount % 10 == 0) {
                    System.out.println();
                }
            }
        }

    }

    public static int inputPositiveInteger() {
        Scanner input = new Scanner(System.in);
        int positiveInt = -1;

        while (input.hasNext()) {

            if (input.hasNextInt()) {
                positiveInt = input.nextInt();
            }
            else {
                System.out.print("Year must be positive integer, try again: ");
                input.next();
                continue;
            }

            if (positiveInt < 0) {
                System.out.print("Year must be positive integer, try again: ");
                continue;
            }
            else {
                return positiveInt;
            }
        }

        return positiveInt;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
