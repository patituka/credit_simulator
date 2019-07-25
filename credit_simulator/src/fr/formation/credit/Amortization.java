package fr.formation.credit;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;

/**
 * @author Pati
 */
public class Amortization {

    /**
     * This method calculate the credit annual amortization
     *
     * @param simulator
     *                  a simulator generated with the scanner
     */
    public static void calcul(Simulator simulator) {
	int year = simulator.getDateStart().getYear();
	double capital = simulator.getAmount();
	double annuity = capital / simulator.getDuration();
	double interest = capital * simulator.getCreditRating();
	double assurance = capital * simulator.getAssuranceRating();
	double totalCost = interest + assurance;
	DecimalFormat df = new DecimalFormat("0.00");
	for (int i = 1; i <= simulator.getDuration(); i++) {
	    StringBuilder builder = new StringBuilder();
	    builder.append(" [Years=");
	    builder.append(year + i);
	    builder.append(", Capital=");
	    builder.append(capital);
	    builder.append(", Annuity=");
	    builder.append(annuity);
	    builder.append(", Interest=");
	    builder.append(interest);
	    builder.append(", Assurance=");
	    builder.append(assurance);
	    builder.append(", Total Cost=");
	    builder.append(totalCost);
	    builder.append("]");
	    System.out.println(builder);
	    capital -= annuity;
	    interest = capital * simulator.getCreditRating();
	    assurance = capital * simulator.getCreditRating();
	}
    }

    /**
     * This method calculate the credit mensual amortization
     *
     * @param simulator
     *                  a simulator generated with the scanner
     */
    public static void calculMensual(Simulator simulator) {
	int year = simulator.getDateStart().getYear();
	int month = simulator.getDateStart().getMonthValue();
	double capital = simulator.getAmount();
	double annuity = capital / simulator.getDuration() / 12;
	double interest = capital * simulator.getCreditRating();
	double assurance = capital * simulator.getAssuranceRating();
	double totalCost = interest + assurance;
	DecimalFormat df = new DecimalFormat("0.00");
	for (int i = 1; i <= simulator.getDuration(); i++) {
	    interest = capital * simulator.getCreditRating();
	    assurance = capital * simulator.getCreditRating();
	    for (int j = 1; j <= 12; j++) {
		capital -= annuity;
		StringBuilder builder = new StringBuilder();
		builder.append(" [Years=");
		builder.append(year + i);
		builder.append(" [Month=");
		builder.append(monthFormat(month + j));
		builder.append(", Capital=");
		builder.append(df.format(capital));
		builder.append(", Annuity=");
		builder.append(df.format(annuity));
		builder.append(", Interest=");
		builder.append(df.format(interest));
		builder.append(", Assurance=");
		builder.append(df.format(assurance));
		builder.append(", Total Cost=");
		builder.append(df.format(interest + assurance));
		builder.append("]");
		System.out.println(builder);
	    }
	}
    }

    public static String monthFormat(int month) {
	if (month > 12) {
	    month -= 12;
	}
	return new DateFormatSymbols().getMonths()[month - 1];
    }
}
