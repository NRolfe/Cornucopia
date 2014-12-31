/**
 * 
 */
package edu.clarkson.catalfmr.ee363.project3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import edu.clarkson.rolfens.ee363.cornucopia.decorators.Banana;
import edu.clarkson.rolfens.ee363.cornucopia.decorators.Carrot;
import edu.clarkson.rolfens.ee363.cornucopia.decorators.Fruit;
import edu.clarkson.rolfens.ee363.cornucopia.decorators.Produce;
import edu.clarkson.rolfens.ee363.cornucopia.decorators.Vegetable;

/**
 * @author Matt
 *
 */
public class Producer extends Observable {

	ArrayList<Produce> carrotInventory = new ArrayList<Produce>(0);
	ArrayList<Produce> bananaInventory = new ArrayList<Produce>(0);

	/**
	 * 
	 */
	public Producer() {
		super();
		this.carrotInventory = carrotInventory;
		this.bananaInventory = bananaInventory;
		// this.observers = observers;
	}

	public void growCarrot() {
		Random buy = new Random();
		int toGrow = buy.nextInt(150) + 0;
		for (int i = 0; i < toGrow; i++) {
			Produce carrot = new Vegetable();
			carrot = new Carrot(carrot); // decorates vegetable with a carrot
			carrotInventory.add(carrot); // adds carrot to carrot inventory
		}

		System.out.println(toGrow + " carrots grown");

	}

	public void growBanana() {
		Random buy = new Random();
		int toGrow = buy.nextInt(150) + 0;
		for (int i = 0; i < toGrow; i++) {
			Produce banana = new Fruit();
			banana = new Banana(banana); // decorates vegetable with a carrot
			bananaInventory.add(banana); // adds carrot to carrot inventory
		}

		System.out.println(toGrow + " bananas grown");
	}

	public void grow() {
		Random buy = new Random();
		int toGrow = buy.nextInt(2) + 0;
		if (toGrow == 1) {
			growBanana();
			setChanged();
			notifyObservers(bananaInventory);
			clearChanged();
		} else {
			growCarrot();
			setChanged();
			notifyObservers(carrotInventory);
			clearChanged();
		}

		// try {
		// Thread.sleep(2000); //1000 milliseconds is one second.
		// } catch(InterruptedException ex) {
		// Thread.currentThread().interrupt();
		// }

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observable#notifyObservers(java.lang.Object)
	 */

}
