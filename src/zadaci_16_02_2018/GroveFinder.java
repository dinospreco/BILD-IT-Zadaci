package zadaci_16_02_2018;

/*
 * BILD-IT Zadaci 16.02.2018.
 *
 * Zadatak 4: Zamislite da steu naslijedje dobili neku parcelu, predstavljenu kao matrica ispunjena karakterima X i o.
 *            Na svakoj poziciji na kojoj je X znaci da na tom mjestu raste drvo.
 *
 *            Olaksajte posao voji i napissite program koji ispisuje koliko imate sumaraka na toj parceli.
 *
 *            Za dio parcele koji nazivamo sumarkom, mora da sadrzi najmanje 3 ulancana X karaktera.
 *
 *            Nakon pokretanja programa korisnik moze da unese velicinu parcele, te mu program ispisuje generisanu
 *            parcelu i ispisuje koliko se sumaraka nalazi na toj parceli.
 *
 * @author: Dino Spreco
 * @date: 18.02.2018.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GroveFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfTreesPerGrove = 3;
        int parcelSize = 0;

        System.out.print("Enter an inreger for parcel size: ");
        while (parcelSize <= 0) {
            parcelSize = zadaci_15_02_2018.Palindrome.inputInteger();
            if (parcelSize <= 0) {
                System.out.print("Parcel size must be grater than 0. Try again: ");
            }
        }

        char[][] parcel = generateParcel(parcelSize);
        ArrayList<ArrayList<Tree>> groves = markGrove(scanTrees(parcel));

        printParcel(parcel);

        System.out.println();
        System.out.print("Your parcel has " + numberOfGrovesWithSpecNumberOfTrees(groves, numberOfTreesPerGrove) + " groves with more than " + numberOfTreesPerGrove + " trees");



    }

    public static int numberOfGrovesWithSpecNumberOfTrees(ArrayList<ArrayList<Tree>> groves, int specNumberOfTrees) {
        int numberOfGroves = 0;

        for (ArrayList<Tree> grove : groves) {
            if (grove.size() >= specNumberOfTrees) {
                numberOfGroves++;
            }
        }

        return numberOfGroves;
    }

    //For testing
    public static char[][] markedGroves(ArrayList<ArrayList<Tree>> groves) {
        int max = 0;

        for (ArrayList<Tree> grove : groves) {
            for (Tree tree : grove) {
                if (tree.xCoordinate > max) {
                    max = tree.xCoordinate;
                }
                if (tree.yCoordinate > max) {
                    max = tree.yCoordinate;
                }
            }
        }

        int size = max + 1;
        char[][] makedParcel = new char[size][size];

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                makedParcel[i][j] = ' ';
            }
        }

        for (ArrayList<Tree> grove : groves) {
            for (Tree tree : grove) {
                makedParcel[tree.xCoordinate][tree.yCoordinate] = (char)(groves.indexOf(grove) + 48);
            }
        }

        return makedParcel;

    }


    //generates parcel
    public static char[][] generateParcel(int size) {
        char[][] parcel = new char[size][size];

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                if (Math.random() < 0.2) {
                    parcel[i][j] = 'X';
                }
                else {
                    parcel[i][j] = 'o';
                }
            }
        }

        return parcel;
    }

    //Prints parcel
    public static void printParcel(char[][] parcel) {

        for (int i = 0 ; i < parcel.length ; i++) {
            for (int j = 0 ; j < parcel[i].length ; j++) {
                System.out.print(parcel[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printParcelWithGrid(char[][] parcel) {
        for (int i = 0 ; i < parcel.length ; i++) {
            for (int j = 0 ; j < parcel[i].length ; j++) {
                System.out.print(parcel[i][j]);
                if (j < (parcel[i].length - 1)) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (i < (parcel.length-1)) {
                for (int k = 0 ; k < parcel.length + (parcel.length - 1) ; k++) {
                    System.out.print("-");
                }

                System.out.println();

            }
        }
    }

    public static ArrayList<ArrayList<Tree>> markGrove(ArrayList<Tree> trees) {
        ArrayList<ArrayList<Tree>> groves = new ArrayList<ArrayList<Tree>>();

        while (!trees.isEmpty()) {

            ArrayList<Tree> grove = new ArrayList<Tree>();
            grove.add(trees.get(0));
            trees.remove(trees.get(0));

            boolean hasNearbyTree = false;


            for (int i = 0 ; i < grove.size() ; i++) {

                for (Tree tree : trees) {
                    if (tree.treeDistance(grove.get(i)) < 2) {
                        grove.add(tree);
                        hasNearbyTree = true;
                    }
                }


                for (Tree tree : grove) {
                    trees.remove(tree);
                }

            }

            groves.add(grove);
        }

        return groves;
    }

    public static ArrayList<Tree> scanTrees(char[][] parcel) {
        ArrayList<Tree> trees = new ArrayList<Tree>();
        for (int i = 0 ; i < parcel.length ; i++) {
            for (int j = 0 ; j < parcel[i].length ; j++) {

                if (parcel[i][j] == 'X') {
                    trees.add(new Tree(i,j));
                }

            }
        }
        return trees;
    }

}

class Tree {
    public int xCoordinate;
    public int yCoordinate;

    public Tree() {
        xCoordinate = 0;
        yCoordinate = 0;
    }

    public Tree(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public boolean equals(Tree tree){
        return  (this.xCoordinate == tree.xCoordinate && this.yCoordinate == tree.yCoordinate);
    }

    public double treeDistance(Tree newTree) {
        return Math.sqrt(Math.pow((this.xCoordinate - newTree.xCoordinate),2) + Math.pow((this.yCoordinate - newTree.yCoordinate),2));
    }
}
