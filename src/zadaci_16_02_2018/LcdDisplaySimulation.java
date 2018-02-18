package zadaci_16_02_2018;

/*
 * BILD-IT Zadaci 16.02.2018.
 *
 * Zadatak 2: Napisati program koji simulira LCD display za prikaz brojeva.
 *
 *            Za svaku horizontalnu liniju koristiti "-" a za svaku vertikalnu " | "
 *
 *            Korisnik ili programer (trazite unos ili specificirate u kodu) moze mijenjati velicinu brojeva od 2 do 5
 *            sto znaci da za velicinu 2 program ce koristiti po dva karaktera za svaki dio broja.
 *
 * @author: Dino Spreco
 * @date: 17.02.2018.
 */

import java.util.Scanner;

public class LcdDisplaySimulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter an integer for LCD representation: ");
        number = zadaci_15_02_2018.Palindrome.inputInteger();

        printSegments(numberToLcd(number,3));
    }

    // This method maps states for led diodes inside one 7 segments LCD
    public static boolean[] segmentTranslation(int oneDigitNumber) {
        boolean[] segmentStates = {false,false,false,false,false,false,false};

        if (oneDigitNumber < 0 || oneDigitNumber > 10) {
            return null;
        }

        /* Segments index;
         *     00000
         *    1     2
         *    1     2
         *    1     2
         *     33333
         *    4     5
         *    4     5
         *    4     5
         *     66666
         */

        if (oneDigitNumber == 0) {
            segmentStates[0] = true;
            segmentStates[1] = true;
            segmentStates[2] = true;
            segmentStates[3] = false;
            segmentStates[4] = true;
            segmentStates[5] = true;
            segmentStates[6] = true;
        }
        else if (oneDigitNumber == 1) {
            segmentStates[0] = false;
            segmentStates[1] = false;
            segmentStates[2] = true;
            segmentStates[3] = false;
            segmentStates[4] = false;
            segmentStates[5] = true;
            segmentStates[6] = false;
        }
        else if (oneDigitNumber == 2) {
            segmentStates[0] = true;
            segmentStates[1] = false;
            segmentStates[2] = true;
            segmentStates[3] = true;
            segmentStates[4] = true;
            segmentStates[5] = false;
            segmentStates[6] = true;
        }
        else if (oneDigitNumber == 3) {
            segmentStates[0] = true;
            segmentStates[1] = false;
            segmentStates[2] = true;
            segmentStates[3] = true;
            segmentStates[4] = false;
            segmentStates[5] = true;
            segmentStates[6] = true;
        }
        else if (oneDigitNumber == 4) {
            segmentStates[0] = false;
            segmentStates[1] = true;
            segmentStates[2] = true;
            segmentStates[3] = true;
            segmentStates[4] = false;
            segmentStates[5] = true;
            segmentStates[6] = false;
        }
        else if (oneDigitNumber == 5) {
            segmentStates[0] = true;
            segmentStates[1] = true;
            segmentStates[2] = false;
            segmentStates[3] = true;
            segmentStates[4] = false;
            segmentStates[5] = true;
            segmentStates[6] = true;
        }
        else if (oneDigitNumber == 6) {
            segmentStates[0] = true;
            segmentStates[1] = true;
            segmentStates[2] = false;
            segmentStates[3] = true;
            segmentStates[4] = true;
            segmentStates[5] = true;
            segmentStates[6] = true;
        }
        else if (oneDigitNumber == 7) {
            segmentStates[0] = true;
            segmentStates[1] = false;
            segmentStates[2] = true;
            segmentStates[3] = false;
            segmentStates[4] = false;
            segmentStates[5] = true;
            segmentStates[6] = false;
        }
        else if (oneDigitNumber == 8) {
            segmentStates[0] = true;
            segmentStates[1] = true;
            segmentStates[2] = true;
            segmentStates[3] = true;
            segmentStates[4] = true;
            segmentStates[5] = true;
            segmentStates[6] = true;
        }
        else if (oneDigitNumber == 9) {
            segmentStates[0] = true;
            segmentStates[1] = true;
            segmentStates[2] = true;
            segmentStates[3] = true;
            segmentStates[4] = false;
            segmentStates[5] = true;
            segmentStates[6] = true;
        }

        /* Segments index;
         *     00000
         *    1     2
         *    1     2
         *    1     2
         *     33333
         *    4     5
         *    4     5
         *    4     5
         *     66666
         */

        return segmentStates;
    }

    // This method generates array of strings for each segment, each string representing one line.
    public static String[] drawSegment(int oneDigitNumber, int size) {
        boolean[] segmetStates = segmentTranslation(oneDigitNumber);
        String[] lcdNumber = new String[size + size + 3];
        String line = "";

        //0 led
        line = line + " ";
        for (int i = 0 ; i < size ; i++) {
            if (segmetStates[0]) {
                line = line + "-";
            }
            else {
                line = line + " ";
            }
        }
        line = line + " ";
        lcdNumber[0] = new String(line);


        //1 and 2 leds
        for (int i = 0 ; i < size ; i++) {
            line = "";

            if (segmetStates[1]) {
                line = line + "|";
            }
            else {
                line = line + " ";
            }

            for (int j = 0 ; j < size ; j++) {
                line = line + " ";
            }

            if (segmetStates[2]) {
                line = line + "|";
            }
            else {
                line = line + " ";
            }

            lcdNumber[i+1] = new String(line);
        }

        //3 led
        line = "";
        line = line + " ";
        for (int i = 0 ; i < size ; i++) {
            if (segmetStates[3]) {
                line = line + "-";
            }
            else {
                line = line + " ";
            }
        }
        line = line + " ";
        lcdNumber[size + 1] = new String(line);

        //4 and 5 leds
        for (int i = 0 ; i < size ; i++) {
            line = "";

            if (segmetStates[4]) {
                line = line + "|";
            }
            else {
                line = line + " ";
            }

            for (int j = 0 ; j < size ; j++) {
                line = line + " ";
            }

            if (segmetStates[5]) {
                line = line + "|";
            }
            else {
                line = line + " ";
            }

            lcdNumber[size + 2 + i] = new String(line);
        }

        //6 led
        line = "";
        line = line + " ";
        for (int i = 0 ; i < size ; i++) {
            if (segmetStates[6]) {
                line = line + "-";
            }
            else {
                line = line + " ";
            }
        }
        line = line + " ";
        lcdNumber[size + size + 2] = new String(line);

        return lcdNumber;
    }

    // Method prints segment(s)
    public static void printSegments(String[] segments) {
        for (int i = 0 ; i < segments.length ; i++) {
            System.out.println(segments[i]);
        }
    }

    // This method translates combines multiple digits into one display.
    public static String[] numberToLcd(int number, int size) {
        String[] lcdDisplay = new String[size + size + 3];
        int reversedNumber = 0;
        int numberOfDigits = 0;
        boolean wasNegativeNumber = false;

        if (number < 0) {
            wasNegativeNumber = true;
            number = number * -1;
        }

        //reversing the number
        while (number > 0) {
            reversedNumber = reversedNumber + (number % 10);
            number = number/10;
            reversedNumber = reversedNumber * 10;
            numberOfDigits++;
        }
        reversedNumber = reversedNumber / 10;

        //Drawing lcd
        if (wasNegativeNumber) {
            String generatedMinus = "";
            String generatedSpaces = "";

            for (int i = 0 ; i < size ; i++) {
                generatedMinus = generatedMinus + "-";
                generatedSpaces = generatedSpaces + " ";
            }

            lcdDisplay[0] = generatedSpaces;

            for (int i = 1 ; i <= size ; i++) {
                lcdDisplay[i] = generatedSpaces;
            }

            lcdDisplay[size + 1] = generatedMinus;

            for (int i = 0 ; i < size ; i++) {
                lcdDisplay[i+size+2] = generatedSpaces;
            }
            lcdDisplay[size+size+2] = generatedSpaces;

            for (int i = 0 ; i < lcdDisplay.length ; i++) {
                lcdDisplay[i] = lcdDisplay[i] + " ";
            }
        }
        else {
            for (int i = 0 ; i < lcdDisplay.length ; i++) {
                lcdDisplay[i] = "";
            }
        }

        for (int i = 0 ; i < numberOfDigits ; i++) {
            String[] drawnDigit = drawSegment(reversedNumber%10, size);
            for (int j = 0 ; j < lcdDisplay.length ; j++) {
                lcdDisplay[j] = lcdDisplay[j] + drawnDigit[j];
            }

            for (int j = 0 ; j < lcdDisplay.length ; j++) {
                lcdDisplay[j] = lcdDisplay[j] + "  ";
            }

            reversedNumber = reversedNumber / 10;
        }

        return lcdDisplay;
    }

}
