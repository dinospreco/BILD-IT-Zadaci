package zadaci_15_02_2018;

/*
 * BILD-IT Zadaci 15.02.2018.
 *
 * Zadatak 5: Ako znamo ubrzanje aviona [a] te brzinu pri kojoj avion uzlijece [v], mozemo izracunati minimalnu duzinu piste
 *            potrebne da avion uzleti koristeci se formulom:
  *
  *           duzina = v*v/2a
 *
 *            Napisati program koji pita korisnika da unese brzinu  u [m/s] i ubzranje u [m/s²]
 *            te ispisuje korisniku minimalnu duzinu piste
 *
 *            Primjer: v = 60, a = 3.5, duzina = 514.286
 *
 * @author: Dino Spreco
 * @date: 16.02.2018.
 */

import java.util.Scanner;

public class RunwayLenght {
    public static void main(String[] args) {
        double takeoffSpeed;
        double acceleration;

        System.out.print("Input takeoff speed [m/s]: ");
        takeoffSpeed = inputDouble();
        System.out.print("Input acceleration [m/s²]: ");
        acceleration = inputDouble();

        System.out.print("Minimal runway length for plane with takeoff speed " + takeoffSpeed + " m/s and acceleration " + acceleration + " m/s² is ");
        System.out.printf("%.3f m", runwayLenght(takeoffSpeed,acceleration));
    }

    public static double inputDouble() {
        Scanner input = new Scanner(System.in);
        double number = 0;

        while (input.hasNext()) {

            if (input.hasNextDouble()) {
                number = input.nextDouble();
                return number;
            }
            else {
                System.out.print("Not a number, try again: ");
                input.next();
                continue;
            }
        }

        return number;
    }

    public static double runwayLenght(double takeoffSpeed, double acceleration) {
        return (takeoffSpeed*takeoffSpeed)/(2*acceleration);
    }
}
