package fr.formation.credit.models;

/**
 * @author Pati
 */
public enum Type {
    REAL_ESTATE {

	@Override
	public Integer getMaxMonth() {
	    return 360;
	}
    },
    AUTOMOBILE {

	@Override
	public Integer getMaxMonth() {
	    return 84;
	}
    },
    WORKS {

	@Override
	public Integer getMaxMonth() {
	    return 180;
	}
    };

    /**
     * Determine the max months time to get the credit
     *
     * @return Integer years
     */
    public abstract Integer getMaxMonth();
}
