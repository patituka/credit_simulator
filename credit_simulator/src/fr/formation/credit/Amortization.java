package fr.formation.credit;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.credit.models.AmortizedLoan;
import fr.formation.credit.models.ScannerInput;

/**
 * @author Pati
 */
public class Amortization {

    /**
     * This method calculate the credit mensual amortization the calcul of the
     * annuity is : Amount x INTEREST / (1 - 1 + txINTEREST) ^DURATION
     *
     * @param input
     *              a simulator generated with the scanner
     * @return a list of object s
     */
    public static List<AmortizedLoan> calcul(ScannerInput input) {
	int month = 0;
	LocalDate date = input.getDateStart();
	double capital = input.getAmount();
	int duration = input.getDuration();
	double tauxGlobal = input.getCreditRating()
		+ input.getAssuranceRating();
	double annuity = annuityCalcul(capital, tauxGlobal, duration);
	double mensualAnnuity = annuity / 12;
	double interest = 0;
	double assurance = capital * input.getAssuranceRating();
	List<AmortizedLoan> amortizedLoans = new ArrayList<>();
	for (int i = 0; i < duration; i++) {
	    System.out.println(annuity);
	    // calculate every years the interest amount
	    interest = capital * input.getCreditRating();
	    for (int j = 0; j < 12; j++) {
		// add the values amount in an object every month
		AmortizedLoan amortizedLoan = new AmortizedLoan(
			date.plusMonths(month), capital, annuity / 12,
			interest / 12, assurance);
		amortizedLoans.add(amortizedLoan);
		month++;
		// set the capital remaining
		capital = amortizedLoan.getOutstanding();
	    }
	}
	return amortizedLoans;
    }

    /**
     * @param month
     *              a month in number of the started date
     * @return all the months in plain letters
     */
    public static String monthFormat(int month) {
	return month > 12 ? new DateFormatSymbols().getMonths()[month - 1]
		: String.valueOf(month);
    }

    /**
     * Calculate the annuity for an amortization constante
     *
     * @param capital
     * @param rating
     * @param duration
     * @return the annuity in a double
     */
    public static double annuityCalcul(double capital, double rating,
	    int duration) {
	return capital * (rating / (1 - Math.pow(1 + rating, duration * -1)));
    }
}
