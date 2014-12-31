/**
 * 
 */
package edu.clarkson.catalfmr.ee363.project3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import edu.clarkson.rolfens.ee363.cornucopia.decorators.Produce;

/**
 * @author Matt
 *
 */
public class TransactionTest {

	/**
	 * Tests to make sure the Producer is making inventory and the Supplier is
	 * getting inventory the inventory from the Producer
	 */
	@Test
	public void InventoryTest() {

		Producer farm = new Producer();
		Supplier sysco = new Supplier();
		Consumer resturant = new Consumer();
		farm.addObserver(sysco);
		sysco.addObserver(resturant);
		farm.grow();

		if (farm.bananaInventory.size() > 0 || farm.carrotInventory.size() > 0) {

			assertTrue("The producer has inventory", true);

			System.out.println("Supplier Inv:" + sysco.inventory.size());

			if (sysco.inventory.size() > 0) {

				assertTrue("The supplier has inventory", true);

			} else {

				assertTrue("The supplier does not have inventory", false);
			}
		} else {
			assertTrue("The producer does not have inventory", false);
		}
	}

}