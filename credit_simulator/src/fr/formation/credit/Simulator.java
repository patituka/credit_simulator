package fr.formation.credit;

import java.time.LocalDate;

import fr.formation.credit.models.ScannerInput;
import fr.formation.credit.models.Type;

public class Simulator {

    /**
     * @return ScannerInput Object
     */
    public static ScannerInput start() {
	int amount = Utils.inputAmount();
	Type type = Utils.inputType();
	LocalDate dateStart = Utils.inputStartDate();
	int duration = Utils.inputDuration();
	double assuranceRating = Utils.inputRatingAssurance();
	double creditRating = Utils.inputRatingCredit();
	return new ScannerInput(amount, type, dateStart, duration,
		assuranceRating, creditRating);
    }
}
