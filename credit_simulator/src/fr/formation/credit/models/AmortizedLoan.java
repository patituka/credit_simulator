package fr.formation.credit.models;

import java.time.LocalDate;

public class AmortizedLoan {

    private LocalDate date;

    private double capital;

    private double annuity;

    private double interest;

    private double assurance;

    private double totalPayment;

    private double outstanding;

    public double getOutstanding() {
	return outstanding;
    }

    public void setOutstanding(double outstanding) {
	this.outstanding = outstanding;
    }

    public double getTotalPayment() {
	return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
	this.totalPayment = totalPayment;
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
	totalPayment = annuity + interest + assurance;
	outstanding = capital - annuity;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("AmortizedLoan [date=");
	builder.append(date);
	builder.append(", capital=");
	builder.append(capital);
	builder.append(", annuity=");
	builder.append(annuity);
	builder.append(", interest=");
	builder.append(interest);
	builder.append(", assurance=");
	builder.append(assurance);
	builder.append(", totalPayment=");
	builder.append(totalPayment);
	builder.append(", outstanding=");
	builder.append(outstanding);
	builder.append("]");
	return builder.toString();
    }
}
