package fr.formation.credit.models;

import java.time.LocalDate;

import fr.formation.credit.Utils;

/**
 * @author Pati
 */
public class AmortizedLoan {

    private LocalDate date;

    private double capital;

    private double annuity;

    private double interest;

    private double assurance;

    private double amortization;

    private double outstanding;

    public double getOutstanding() {
	return outstanding;
    }

    public void setOutstanding(double outstanding) {
	this.outstanding = outstanding;
    }

    public double getAmortization() {
	return amortization;
    }

    public void setAmortization(double amortization) {
	this.amortization = amortization;
    }

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
     * The contructor generate the total payment and outstanding
     *
     * @param date
     *                  of start
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
	amortization = annuity - (interest + assurance);
	outstanding = capital - amortization;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("AmortizedLoan [date=");
	builder.append(date);
	builder.append(", capital=");
	builder.append(Utils.decimal(capital));
	builder.append(", annuity=");
	builder.append(Utils.decimal(annuity));
	builder.append(", interest=");
	builder.append(Utils.decimal(interest));
	builder.append(", assurance=");
	builder.append(Utils.decimal(assurance));
	builder.append(", amortization=");
	builder.append(Utils.decimal(amortization));
	builder.append(", outstanding=");
	builder.append(Utils.decimal(outstanding));
	builder.append("]");
	return builder.toString();
    }
}
