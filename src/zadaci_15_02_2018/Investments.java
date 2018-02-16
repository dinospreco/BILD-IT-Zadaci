package zadaci_15_02_2018;

/*
 * BILD-IT Zadaci 15.02.2018.
 *
 * Zadatak 1: Napisati program koji ucitava iznos investicije, godinjsu interesnu stopu, i broj godina
 *            te vraca buducu vrijednost investicije koristeci se sljedecom formulom.
 *
 *            buducaVrijednostInvesticije = iznosInvesticije * (1 + mjesecnaInteresnaStopa)^brojGodina * 12
 *
 *            Npr: ukoliko unesete kao iznos investicije 1000, 3.25 kao godisnju interesnu stopu i 1 kao broj godina
 *            program vam vraca 1032.98 kao buducu vrijednost investicije.
 *
 * @author: Dino Spreco
 * @date: 16.02.2018.
 */

public class Investments {
    public static void main(String[] args) {
        double initialInvestment = -1;
        int numberOfYears = -1;
        double yearlyInterestRate = -1; //in %

        System.out.print("Input your investment ($): ");
        while (initialInvestment <= 0) {
            initialInvestment = RunwayLenght.inputDouble();
            if (initialInvestment <= 0) {
                System.out.println("Initial investment must be positive number!");
            }
        }

        System.out.print("Input interest rate (%): ");
        while (yearlyInterestRate <= 0) {
            yearlyInterestRate = RunwayLenght.inputDouble();
            if (yearlyInterestRate <= 0) {
                System.out.println("Yearly interest must be positive number!");
            }
        }

        System.out.print("Input number of years: ");
        while (numberOfYears <= 0) {
            numberOfYears = Palindrome.inputInteger();
            if (numberOfYears <= 0) {
                System.out.println("Number of years must be positive number!");
            }
        }

        System.out.printf("Your investment after %d years will be $%.3f ",numberOfYears ,futureValueOfInvestment(initialInvestment,yearlyInterestRate,numberOfYears));


    }

    public static double futureValueOfInvestment(double initialInvestment, double yearlyInterestRate, int numberOfYears) {
        return initialInvestment * Math.pow((1 + ( (yearlyInterestRate)/100 )/12 ) , numberOfYears * 12 );
    }


}
