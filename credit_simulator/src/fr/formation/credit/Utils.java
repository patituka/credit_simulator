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

    /**
     * @return
     */
    public static String readString() {
	String res = scan.nextLine();
	return res;
    }

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
		return scan.nextInt() / 100;
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    static double inputRatingCredit() {
	while (true) {
	    System.out.println("How much is your credit rating percent?");
	    try {
		return scan.nextInt() / 100;
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

    static int inputDuration() {
	while (true) {
	    System.out.println("Enter the duration of the credit in years:");
	    try {
		return scan.nextInt();
	    } catch (InputMismatchException e) {
		scan.nextLine();
	    }
	}
    }

    /**
     * @param msg
     *            input in the console
     * @return int
     */
    public static int readInt(String msg) {
	int num = 0;
	boolean loop = true;
	while (loop) {
	    try {
		System.out.println(msg);
		num = scan.nextInt();
		loop = false;
	    } catch (InputMismatchException e) {
		System.out.println("Invalid value!");
		scan.next();
	    }
	}
	return num;
    }

    /**
     * @return
     */
    public static int readInt() {
	int res = scan.nextInt();
	scan.nextLine();
	return res;
    }

    /**
     * @return
     */
    public static double readDouble() {
	double res = scan.nextDouble();
	scan.nextLine();
	return res;
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
