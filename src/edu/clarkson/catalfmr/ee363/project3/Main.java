package edu.clarkson.catalfmr.ee363.project3;

import java.util.Random;

import edu.clarkson.rolfens.ee363.cornucopia.decorators.Carrot;
import edu.clarkson.rolfens.ee363.cornucopia.decorators.Produce;
import edu.clarkson.rolfens.ee363.cornucopia.decorators.Vegetable;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Producer farm = new Producer();
		Supplier sysco = new Supplier();
		Consumer resturant = new Consumer();
		farm.addObserver(sysco);
		sysco.addObserver(resturant);
		farm.grow();
		System.out.println("Supplier Inv:" + sysco.inventory.size());

		Random buy = new Random();
		int toBuy = buy.nextInt(2) + 0;
		if (toBuy == 1) {
			farm.notifyObservers(farm.bananaInventory);
		} else {
			farm.notifyObservers(farm.carrotInventory);
		}
		System.out.println("Supplier Inv:" + sysco.inventory.size());
		System.out.println("Product Available: "
				+ resturant.getProductAvailable().get(0).getName());
		System.out.println("---End transaction----");
	}

}
