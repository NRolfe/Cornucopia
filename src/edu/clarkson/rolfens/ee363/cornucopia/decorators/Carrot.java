/**
 * 
 */
package edu.clarkson.rolfens.ee363.cornucopia.decorators;

/**
 * @author Matt
 *
 */
public class Carrot extends ProduceDecorator {

	/**
	 * 
	 * @param tempProduce
	 * @param freshness
	 * @param organic
	 * @param gmo
	 */
	public Carrot(Produce tempProduce) {
		super(tempProduce);
		this.setName("Carrot");

	}

	
	
}
