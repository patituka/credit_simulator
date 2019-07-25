package fr.formation.credit;

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
		"Wich type of credit do you want ? 1:REAL_ESTATE, 2:AUTOMOBILE, 3:WORKS");
	simulator.setType(Type.valueOf(Utils.readString().toUpperCase()));
	System.out.println("How much is your assurance rating ?");
	simulator.setAssuranceRating(Utils.readDouble());
	System.out.println("How much is your credit rating ?");
	simulator.setCreditRating(Utils.readDouble());
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
	Amortization.calcul(simulator);
	System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	Amortization.calculMensual(simulator);
    }
}
