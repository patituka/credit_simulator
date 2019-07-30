package fr.formation.credit;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.formation.credit.models.Type;

/**
 * @author Pati
 */
public class Utils {

    public static Scanner scan = new Scanner(System.in);

    static int inputAmount() {
	while (true) {
	    System.out.println("Insert amount:");
	    try {
		return scan.nextInt();
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    static Type inputType() {
	while (true) {
	    System.out.println(
		    "Insert type number: 1-REAL_ESTATE 2-AUTOMOBILE 3-WORKS");
	    try {
		return Type.values()[scan.nextInt() - 1];
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    static double inputRatingAssurance() {
	while (true) {
	    System.out.println("How much is your assurance rating percent?");
	    try {
		return scan.nextDouble() / 100;
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    static double inputRatingCredit() {
	while (true) {
	    System.out.println("How much is your credit rating percent?");
	    try {
		return scan.nextDouble() / 100;
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    static LocalDate inputStartDate() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	while (true) {
	    System.out.println("Enter the date of start dd/MM/yyyy");
	    try {
		LocalDate date = LocalDate.parse(scan.nextLine(), formatter);
		return date;
	    } catch (InputMismatchException e) {
		System.out.println(e.getMessage());
		scan.nextLine();
	    } catch (DateTimeParseException e) {
		System.out.println(e.getMessage());
		scan.nextLine();
	    }
	}
    }

    static int inputDuration(Type type) {
	while (true) {
	    System.out.println("Enter the duration (" + type.getMaxMonth() / 12
		    + " years maximum for " + type.name() + " loan )");
	    try {
		return scan.nextInt();
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    /**
     * Static methode to add month in a date
     *
     * @param date
     *              string
     * @param month
     *              int
     * @return string of date
     */
    public static String incremente(String date, Integer month) {
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMM");
	return LocalDate.parse(date).plusMonths(month).format(format);
    }

    /**
     * This method convert the double
     *
     * @param num
     * @return a double number with 2 decimal only
     */
    public static double decimal(double num) {
	DecimalFormat df = new DecimalFormat("#.##");
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	dfs.setDecimalSeparator('.');
	df.setDecimalFormatSymbols(dfs);
	return Double.valueOf(df.format(num));
    }
}
