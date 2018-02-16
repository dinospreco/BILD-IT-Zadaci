package zadaci_12_02_2018;

/*
 * BILD-IT Zadaci 12.02.2018.
 *
 * Zadatak 4: Napisati program koji generise 100 random brojva od 0 do 9 te ispisuje koji se broj koliko puta ponovio.
 *
 * @author: Dino Spreco
 * @date: 13.02.2018.
 */

public class HundredRandomNumbers {
    public static void main(String[] args) {
        int[] randomNumbers = generateHundredRandomNumbers();
        int[] repetition = new int[10];

        System.out.println("100 Random numbers:");
        printArrayOfIntegers(randomNumbers,20);
        System.out.println();

        countNumbersInArray(randomNumbers);

    }
    public static void countNumbersInArray(int[] numbers) {
        int[] counter = new int[max(numbers)+1];

        for (int i = 0 ; i < numbers.length ; i++) {
            counter[numbers[i]]++;
        }

        System.out.println("Number | Repeats");
        for (int i = 0 ; i < counter.length ; i++) {
            System.out.printf("%6d | %-6d \n",i,counter[i]);
        }

    }

    public static int max(int[] numbers) {
        int max = numbers[0];

        for (int i = 0 ; i < numbers.length ; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        return max;
    }

    public static int[] generateHundredRandomNumbers() {
        int[] numbers = new int[100];
        for (int i = 0 ; i < 100 ; i++) {
            numbers[i] = (int)(Math.random()*10);
        }
        return numbers;
    }

    public static void printArrayOfIntegers(int[] array, int numbersInOneRow) {
        for (int i = 0 ; i < array.length ; i++) {
            System.out.print(array[i]);
            if ((i+1) % numbersInOneRow == 0) {
                System.out.println();
            }
            else {
                System.out.print(", ");
            }
        }
    }
}
