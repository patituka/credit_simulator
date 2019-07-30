package fr.formation.credit.models;

import java.time.LocalDate;

/**
 * @author Administrateur
 */
public class ScannerInput {

    private int amount;

    private Type type;

    private LocalDate dateStart;

    private int duration;

    private double assuranceRating;

    private double creditRating;

    public int getAmount() {
	return amount;
    }

    private void setAmount(int amount) {
	this.amount = amount;
    }

    public Type getType() {
	return type;
    }

    private void setType(Type type) {
	this.type = type;
    }

    public LocalDate getDateStart() {
	return dateStart;
    }

    private void setDateStart(LocalDate dateStart) {
	if (dateStart.isBefore(LocalDate.now())) {
	    throw new IllegalArgumentException(
		    "Date must be later than today!!!");
	}
	this.dateStart = dateStart;
    }

    public int getDuration() {
	return duration;
    }

    private void setDuration(int duration) {
	if (duration * 12 > type.getMaxMonth()) {
	    throw new IllegalArgumentException(
		    type.name() + " loan must have a duration of "
			    + type.getMaxMonth() / 12 + "years maximum !!");
	}
	this.duration = duration;
    }

    public double getAssuranceRating() {
	return assuranceRating;
    }

    private void setAssuranceRating(double assuranceRating) {
	this.assuranceRating = assuranceRating;
    }

    public double getCreditRating() {
	return creditRating;
    }

    private void setCreditRating(double creditRating) {
	this.creditRating = creditRating;
    }

    /**
     * @param amount
     * @param type
     * @param dateStart
     * @param duration
     * @param assuranceRating
     * @param creditRating
     */
    public ScannerInput(int amount, Type type, LocalDate dateStart,
	    int duration, double assuranceRating, double creditRating) {
	this.amount = amount;
	this.type = type;
	setDateStart(dateStart);
	setDuration(duration);
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
