package fr.formation.credit.models;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class AmortizedLoan {

    private LocalDate date;

    private double capital;

    private double annuity;

    private double interest;

    private double assurance;

    DecimalFormat df = new DecimalFormat("0.00");

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public double getCapital() {
	return capital;
    }

    public void setCapital(double capital) {
	this.capital = capital;
    }

    public double getAnnuity() {
	return annuity;
    }

    public void setAnnuity(double annuity) {
	this.annuity = annuity;
    }

    public double getInterest() {
	return interest;
    }

    public void setInterest(double interest) {
	this.interest = interest;
    }

    public double getAssurance() {
	return assurance;
    }

    public void setAssurance(double assurance) {
	this.assurance = assurance;
    }

    /**
     * @return a string
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("AmortizedLoan [date=");
	builder.append(date);
	builder.append(", capital=");
	builder.append(df.format(capital));
	builder.append(", annuity=");
	builder.append(df.format(annuity));
	builder.append(", interest=");
	builder.append(df.format(interest));
	builder.append(", assurance=");
	builder.append(df.format(assurance));
	builder.append("]");
	return builder.toString();
    }

    /**
     * @param date
     * @param capital
     * @param annuity
     * @param interest
     * @param assurance
     */
    public AmortizedLoan(LocalDate date, double capital, double annuity,
	    double interest, double assurance) {
	this.date = date;
	this.capital = capital;
	this.annuity = annuity;
	this.interest = interest;
	this.assurance = assurance;
    }
}
