package fr.formation.credit.models;

/**
 * @author Administrateur
 */
public enum Type {
    REAL_ESTATE(1), AUTOMOBILE(2), WORKS(3);

    private int value;

    private Type(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }
}
