package edu.towson.cis.cosc603.project5.coffeemaker;

import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

public class InventoryTest {
	Inventory i;
	
	@Before
	public void setUp() {
		i = new Inventory();
	}
	
	@Test
	public void setCoffee1() {
		i.setCoffee(-10);
		assertEquals(0,i.getCoffee());
	}

	@Test
	public void setMilk1() {
		i.setMilk(-10);
		assertEquals(0,i.getMilk());
	}

	@Test
	public void setSugar1() {
		i.setSugar(-10);
		assertEquals(0,i.getSugar());
	}

	@Test
	public void setChocolate1() {
		i.setChocolate(-10);
		assertEquals(0,i.getChocolate());
	}
	
	@Test
	public void toString1() {
		String expectedStr = "Coffee: 15" + System.getProperty("line.separator") +
				"Milk: 15" + System.getProperty("line.separator") +
				"Sugar: 15" + System.getProperty("line.separator") +
				"Chocolate: 15" + System.getProperty("line.separator");
		String returnStr = i.toString();
		assertEquals(expectedStr, returnStr);
	}
	
	@After
	public void tearDown() {
		i = null;
	}
}
