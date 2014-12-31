/**
 * 
 */
package edu.clarkson.catalfmr.ee363.project3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import edu.clarkson.rolfens.ee363.cornucopia.decorators.Produce;

/**
 * @author Matt
 *
 */
public class Supplier extends Observable implements Observer {

	ArrayList<ArrayList> inventory = new ArrayList<ArrayList>(); // gets updated
																	// from
																	// producer
	ArrayList<Produce> productAvailable = new ArrayList<Produce>(); // sends to
																	// consumer
	int purchasingQuantity; // gets updated from consumer

	/**
	 * @param inventory
	 * @param productAvailable
	 * @param purchasingQuantity
	 */
	public Supplier() {
		super();
		this.inventory = inventory;
		this.productAvailable = productAvailable;
		this.purchasingQuantity = purchasingQuantity;
	}

	/**
	 * @return the inventory
	 */
	public ArrayList<ArrayList> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            the inventory to set
	 */
	public void setInventory(ArrayList<ArrayList> inventory) {
		this.inventory = inventory;
	}

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
	 * @return the purchasingQuantity
	 */
	public int getPurchasingQuantity() {
		return purchasingQuantity;
	}

	/**
	 * @param purchasingQuantity
	 *            the purchasingQuantity to set
	 */
	public void setPurchasingQuantity(int purchasingQuantity) {
		this.purchasingQuantity = purchasingQuantity;
	}

	// public void printSupplier(){
	// for(int x=0; x<inventory.size(); x++){
	// for(int y=0; y<inventory.get(x).size(); y++){
	// System.out.println(productAvailable.get(y).getName());
	//
	// }
	// }
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		int i = 0;
		if (arg instanceof ArrayList<?>) {
			inventory.add((ArrayList) arg);
			System.out.println("Supplier Recieved Inventory from Producer");
			for (i = 0; i < inventory.size(); i++) {
				productAvailable.addAll(inventory.get(i));
				setChanged();
				notifyObservers(productAvailable);
				System.out.println("New product sent to consumers");
				clearChanged();
				productAvailable.removeAll(productAvailable);
			}

		}
		if (arg instanceof Integer) {
			purchasingQuantity = (Integer) arg;
			System.out.println("The Consumer has purchased "
					+ purchasingQuantity + productAvailable.get(i).getName());
			for (int x = 0; x < purchasingQuantity; x++) {
				inventory.get(i).remove(x);
			}
		}
	}

}
