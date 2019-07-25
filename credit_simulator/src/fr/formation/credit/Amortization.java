package fr.formation.credit;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.credit.models.AmortizedLoan;

/**
 * @author Pati
 */
public class Amortization {

    /**
     * This method calculate the credit mensual amortization
     *
     * @param simulator
     *                  a simulator generated with the scanner
     */
    public static void calcul(Simulator simulator) {
	int month = 0;
	LocalDate date = simulator.getDateStart();
	double capital = simulator.getAmount();
	double annuity = capital / simulator.getDuration() / 12;
	double interest = capital * simulator.getCreditRating() / 12;
	double assurance = capital * simulator.getAssuranceRating() / 12;
	List<AmortizedLoan> amortizedLoans = new ArrayList<>();
	for (int i = 1; i <= simulator.getDuration(); i++) {
	    interest = capital * simulator.getCreditRating() / 12;
	    for (int j = 1; j <= 12; j++) {
		month++;
		capital -= annuity;
		AmortizedLoan amortizedLoan = new AmortizedLoan(
			date.plusMonths(month), decimal(capital),
			decimal(annuity), decimal(interest),
			decimal(assurance));
		amortizedLoans.add(amortizedLoan);
	    }
	}
	amortizedLoans.forEach(System.out::println);
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
     * This method convert the double
     *
     * @param num
     * @return a double number with 2 decimal only
     */
    public static double decimal(double num) {
	DecimalFormat df = new DecimalFormat("#.##");
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	dfs.setDecimalSeparator('.');
	df.setDecimalFormatSymbols(dfs);
	return Double.valueOf(df.format(num));
    }
}
