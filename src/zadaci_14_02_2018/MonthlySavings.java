package zadaci_14_02_2018;

/*
 * BILD-IT Zadaci 14.02.2018.
 *
 * Zadatak 1: Pretpostavimo da uplatimo $100 svaki mjesec na stedni racun koji ima godisnju interesno stopu od 5%.
 *            Mjesecna interesna stopa je stoga 0.05/12 = 0.00417.
 *            Nakon prvog mjeseca vrijednost na racunu postaje 100 * (1+0.00417) = 100.417.
 *            Nakon drugog mjeseca, vrijednost na racunu postaje (100 + 100.417) * (1 + 0.00417) = 201.252.
 *            Nakon treceg mjeseca (100 + 201.252) * (1 + 0.00417) = 302.507 i tako dalje.
 *
 *            Napisati program koji pita korisnika da unese mjesecni iznos stednje i broj mjeseci
 *            nakon kojeg zeli znati stanje racuna
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.Scanner;

public class MonthlySavings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double monthlyPayment = -1;
        int numberOfMonths = -1;

        System.out.print("Type in your monthly saving: ");
        while (monthlyPayment <= 0) {
            if (input.hasNextDouble()) {
                monthlyPayment = input.nextDouble();
            }
            else {
                System.out.print("Monthly payment must be positive number, try again: ");
                input.next();
                continue;
            }
            if (monthlyPayment <= 0) {
                System.out.print("Monthly payment must be positive number, try again: ");
                continue;
            }
        }

        System.out.print("Type in number of months after which you want to know total savings: ");
        while (numberOfMonths <= 0) {
            if (input.hasNextInt()) {
                numberOfMonths = input.nextInt();
            }
            else {
                System.out.print("Number of months must be positive integer, try again, ");
                input.next();
                continue;
            }
            if (numberOfMonths <= 0) {
                System.out.print("Number of months must be positive integer, try again, ");
                continue;
            }
        }

        System.out.printf("Your saving after %-2d month(s) will be: $%.3f" ,numberOfMonths, monthlySaving(monthlyPayment,numberOfMonths));
    }

    public static double monthlySaving(double monthlyPayment, int numberOfMonths) {
        final int YEARLY_INTEREST_RATE = 5; // [%]
        double total = 0;
        for (int i = 0 ; i < numberOfMonths ; i++) {
            total = (monthlyPayment + total) * (1 + ((double)YEARLY_INTEREST_RATE)/100/12);
        }
        return total;
    }
}
