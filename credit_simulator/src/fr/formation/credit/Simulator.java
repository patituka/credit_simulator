package fr.formation.credit;

import java.time.LocalDate;

/**
 * @author Administrateur
 */
public class Simulator {

    private int amount;

    private Type type;

    private LocalDate dateStart;

    private int duration;

    private double assuranceRating;

    private double creditRating;

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
    }

    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public LocalDate getDateStart() {
	return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
	this.dateStart = dateStart;
    }

    public int getDuration() {
	return duration;
    }

    public void setDuration(int duration) {
	this.duration = duration;
    }

    public double getAssuranceRating() {
	return assuranceRating;
    }

    public void setAssuranceRating(double assuranceRating) {
	this.assuranceRating = assuranceRating;
    }

    public double getCreditRating() {
	return creditRating;
    }

    public void setCreditRating(double creditRating) {
	this.creditRating = creditRating;
    }

    public Simulator() {
    }

    /**
     * @param amount
     * @param type
     * @param dateStart
     * @param duration
     * @param assuranceRating
     * @param creditRating
     */
    public Simulator(int amount, Type type, LocalDate dateStart, int duration,
	    double assuranceRating, double creditRating) {
	this.amount = amount;
	this.type = type;
	this.dateStart = dateStart;
	this.duration = duration;
	this.assuranceRating = assuranceRating;
	this.creditRating = creditRating;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Simulator [amount=");
	builder.append(amount);
	builder.append(", type=");
	builder.append(type);
	builder.append(", dateStart=");
	builder.append(dateStart);
	builder.append(", duration=");
	builder.append(duration);
	builder.append(", assuranceRating=");
	builder.append(assuranceRating);
	builder.append(", creditRating=");
	builder.append(creditRating);
	builder.append("]");
	return builder.toString();
    }
}
