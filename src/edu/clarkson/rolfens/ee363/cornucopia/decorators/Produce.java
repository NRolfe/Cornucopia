package edu.clarkson.rolfens.ee363.cornucopia.decorators;

public abstract class Produce {
	private String name;
	private String freshness;
	private boolean organic;
	private boolean gmo;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the freshness
	 */
	public String getFreshness() {
		return freshness;
	}

	/**
	 * @param freshness
	 *            the freshness to set
	 */
	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}

	/**
	 * @return the organic
	 */
	public boolean isOrganic() {
		return organic;
	}

	/**
	 * @param organic
	 *            the organic to set
	 */
	public void setOrganic(boolean organic) {
		this.organic = organic;
	}

	/**
	 * @return the gmo
	 */
	public boolean isGmo() {
		return gmo;
	}

	/**
	 * @param gmo
	 *            the gmo to set
	 */
	public void setGmo(boolean gmo) {
		this.gmo = gmo;
	}

}
