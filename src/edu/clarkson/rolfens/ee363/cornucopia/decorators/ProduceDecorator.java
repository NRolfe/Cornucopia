/**
 * 
 */
package edu.clarkson.rolfens.ee363.cornucopia.decorators;

/**
 * @author Matt
 *
 */
public abstract class ProduceDecorator extends Produce {

	protected Produce tempProduce;

	/**
	 * @param tempProduce
	 */
	public ProduceDecorator(Produce tempProduce) {
		super();
		this.tempProduce = tempProduce;
	}

	/**
	 * @return the tempProduce
	 */
	public Produce getProduce() {
		return tempProduce;
	}
	
}
