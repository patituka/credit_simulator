package fr.formation.credit;

import fr.formation.credit.models.Type;

/**
 * @author Administrateur
 */
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Simulator simulator = new Simulator();
	boolean inputOk = false;
	System.out.println("How many do you want?");
	simulator.setAmount(Utils.readInt());
	System.out.println(
		"What kind of credit ? 1: REAL_ESTATE, 2: AUTOMOBILE, 3: WORKS");
	simulator.setType(Type.values()[Utils.readInt() + 1]);
	System.out.println("How much is your assurance rating percent?");
	simulator.setAssuranceRating(Utils.readDouble() / 100);
	System.out.println("How much is your credit rating percent?");
	simulator.setCreditRating(Utils.readDouble() / 100);
	while (!inputOk) {
	    System.out.println("Enter the date of start: yyyy-mm");
	    try {
		simulator.setDateStart(Utils.readDate());
		inputOk = true;
	    } catch (IllegalArgumentException e) {
		System.out.println(e.toString());
	    }
	}
	System.out.println("Enter the duration of the credit wanted in years:");
	simulator.setDuration(Utils.readInt());
	System.out.println(simulator.toString());
	System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	Amortization.calcul(simulator);
    }
}
