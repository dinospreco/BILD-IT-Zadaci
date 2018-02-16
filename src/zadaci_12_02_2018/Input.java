package zadaci_12_02_2018;

/*
 * This class is just for checking input in rest of classes in package zadaci_12_02_2018
 */

import java.util.Scanner;

public class Input {

    public static int integerInput() {
        Scanner input = new Scanner(System.in);
        int integer = 0;
        while (true) {
            if (input.hasNextInt()) {
                integer = input.nextInt();
                break;
            }
            else {
                System.out.print("Not an integer. Try Again. ");
                input.next();
                continue;
            }
        }
        return integer;
    }
}
