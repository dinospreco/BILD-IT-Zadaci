package zadaci_14_02_2018;

/*
 * BILD-IT Zadaci 14.02.2018.
 *
 * Zadatak 2: Napisati program koji nasumicno izvlaci karte iz spila od 52 karte.
 *            Program treba ispisati koja karta je izvucena (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
 *            te znak u kojem je data karta (Srce, Pik, Djetelina, Kocka)
 *
 *            Primjer: Karta koju ste izvukli je 10 u znaku kocke.
 *
 * @author: Dino Spreco
 * @date: 15.02.2018.
 */

import java.util.concurrent.ThreadLocalRandom;

public class RandomCardDrawing {

    public static void main(String[] args) {
        drawRandomCard();
    }

    public static void drawRandomCard() {
        //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int card = ThreadLocalRandom.current().nextInt(1, 13 + 1);
        int suit = ThreadLocalRandom.current().nextInt(1, 4 + 1);

        System.out.print("Karta koju ste izvukli je ");
        if (card == 1) {
            System.out.print("A");
        }
        else if (card == 11) {
            System.out.print("J");
        }
        else if (card == 12) {
            System.out.print("Q");
        }
        else if (card == 13) {
            System.out.print("K");
        }
        else {
            System.out.print(card);
        }

        System.out.print(" u znaku ");

        if (suit == 1) {
            System.out.print(" srca");
        }
        else if (suit == 2) {
            System.out.print(" pika");
        }
        else if (suit == 3) {
            System.out.print(" djeteline");
        }
        else {
            System.out.print(" kocke");
        }
    }
}
