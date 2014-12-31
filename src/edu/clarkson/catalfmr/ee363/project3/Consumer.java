package edu.clarkson.catalfmr.ee363.project3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import edu.clarkson.rolfens.ee363.cornucopia.decorators.Produce;

public class Consumer extends Observable implements Observer {

	ArrayList<Produce> productAvailable = new ArrayList<Produce>(); // gets
																	// updated
																	// from
																	// supplier
	int quantityToPurchase = 0; // gets sent to the supplier
	int quantityAvailable; // Gets updated from the supplier
	private int quantitiyAvailable;

	/**
	 * @return the productAvailable
	 */
	public ArrayList<Produce> getProductAvailable() {
		return productAvailable;
	}

	/**
	 * @param productAvailable
	 *            the productAvailable to set
	 */
	public void setProductAvailable(ArrayList<Produce> productAvailable) {
		this.productAvailable = productAvailable;
	}

	/**
	 * @return the quantityToPurchase
	 */
	public int getQuantityToPurchase() {
		return quantityToPurchase;
	}

	/**
	 * @param quantityToPurchase
	 *            the quantityToPurchase to set
	 */
	public void setQuantityToPurchase(int quantityToPurchase) {
		this.quantityToPurchase = quantityToPurchase;
	}

	/**
	 * @return the quantityAvailable
	 */
	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	/**
	 * @param quantityAvailable
	 *            the quantityAvailable to set
	 */
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	/**
	 * Generate a random quantity to buy
	 * 
	 * @param quantityAvailable
	 *            the quantityAvailable to buy
	 */
	public void calculatePurchaseQuantity(int quantityAvailable) {
		int calculatedQuantity = 0;
		int toBuy = 0; // 0 will not buy, 1 will buy
		/*
		 * Take in the quantity available from the supplier and generate a
		 * random quantity to buy
		 */
		Random buy = new Random();
		toBuy = buy.nextInt(2) + 0;
		if (toBuy == 1) {
			Random rn = new Random();
			calculatedQuantity = rn.nextInt(quantityAvailable + 1) + 1;
			setChanged();
			notifyObservers(calculatedQuantity);
			String item = productAvailable.get(0).getName();
			System.out.println(calculatedQuantity + " " + item
					+ "s purchased from the supplier");
			clearChanged();
		} else {
			calculatedQuantity = 0;
			String item = productAvailable.get(0).getName();
			System.out.println("0 " + item + "s purchased from the supplier");

		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof ArrayList<?>) {
			productAvailable.addAll((ArrayList) arg);
			quantityAvailable = productAvailable.size();
			System.out.println("Consumer recieved new product from supplier");

			calculatePurchaseQuantity(quantityAvailable);
		}

	}

}
