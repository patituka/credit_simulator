package fr.formation.credit;

import java.util.List;

import fr.formation.credit.models.AmortizedLoan;
import fr.formation.credit.models.ScannerInput;

/**
 * @author Administrateur
 */
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
	ScannerInput si = Simulator.start();
	System.out.println(si.toString());
	System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	List<AmortizedLoan> list = Amortization.calcul(si);
	list.forEach(System.out::println);
    }
}
