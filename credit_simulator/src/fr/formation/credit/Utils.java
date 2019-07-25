package fr.formation.credit;

import java.time.LocalDate;
import java.util.Scanner;

public class Utils {

    public static Scanner scan = new Scanner(System.in);

    public static String readString() {
	String res = scan.nextLine();
	return res;
    }

    public static int readInt() {
	int res = scan.nextInt();
	scan.nextLine();
	return res;
    }

    public static boolean readBoolean() {
	boolean res = scan.nextBoolean();
	scan.nextLine();
	return res;
    }

    public static double readDouble() {
	double res = scan.nextDouble();
	scan.nextLine();
	return res;
    }

    public static LocalDate readDate() {
	CharSequence res = scan.nextLine().concat("-01");
	scan.nextLine();
	if (LocalDate.parse(res).isBefore(LocalDate.now())) {
	    throw new IllegalArgumentException("The date must be after today");
	}
	return LocalDate.parse(res);
    }
}
