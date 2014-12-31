/**
 * 
 */
package edu.clarkson.rolfens.ee363.cornucopia.decorators;

/**
 * @author Matt
 * 
 */
public class Banana extends ProduceDecorator {
	/**
	 * 
	 * @param tempProduce
	 * @param freshness
	 * @param organic
	 * @param gmo
	 */
	public Banana(Produce tempProduce) {
		super(tempProduce);
		this.setName("Banana");
	}

}
