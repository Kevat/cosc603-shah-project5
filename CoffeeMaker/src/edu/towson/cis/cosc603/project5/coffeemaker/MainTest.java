package edu.towson.cis.cosc603.project5.coffeemaker;

import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MainTest {
	//Testing variables
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
	
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    Main.makeNewCoffeeMaker(); 
	}
	
	@Test
	public void checkOptions1() {
		Main.showOptions();
		
		String outStr = outContent.toString();
		assertTrue(outStr.contains("1. Add a recipe"));
		assertTrue(outStr.contains("2. Delete a recipe"));
		assertTrue(outStr.contains("3. Edit a recipe"));
		assertTrue(outStr.contains("4. Add inventory"));
		assertTrue(outStr.contains("5. Check inventory"));
		assertTrue(outStr.contains("6. Make coffee"));
		assertTrue(outStr.contains("0. Exit"));
		assertTrue(outStr.contains("0. Exit"));
		
		in = new ByteArrayInputStream("0".getBytes());
		System.setIn(in);
	}
	
	@Test
	public void addRecipeToList1() {
		Main.addRecipeToList("Coffee", 50, 5, 5, 5, 5);
		String outStr = outContent.toString();
		assertTrue(outStr.contains("Coffee successfully added."));
	}
	
	@Test
	public void editRecipeInList1() {
		Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		Main.addRecipeObject(r1);
		Main.editRecipeInList(r1, "Coffee 2", 60, 10, 10, 10, 10);
		String outStr = outContent.toString();
		assertTrue(outStr.contains("Coffee successfully edited."));
	}
	
	@After
	public void tearDown() {
	    System.setOut(System.out);
	    System.setErr(System.err);
		System.setIn(System.in);
	}
}