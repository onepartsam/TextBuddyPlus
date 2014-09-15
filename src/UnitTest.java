import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testSortBasic() {
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		
		textBuddy.addText("B");
		textBuddy.addText("A");
		
		textBuddy.sortTexts();
		
		LinkedList<String> test = new LinkedList<String>();
		test.add("A");
		test.add("B");
		
		assertEquals(test, textBuddy.getTexts());
	}
	
	@Test
	public void testSortAdvance() {
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		
		textBuddy.addText("Samuel Lim Yi Jie");
		textBuddy.addText("Muzamir");
		textBuddy.addText("Candiie Bay Chuan Wei");
		textBuddy.addText("Lin Chen-Hsin");
		
		textBuddy.sortTexts();
		
		LinkedList<String> test = new LinkedList<String>();
		test.add("Candiie Bay Chuan Wei");
		test.add("Lin Chen-Hsin");
		test.add("Muzamir");
		test.add("Samuel Lim Yi Jie");
		
		assertEquals(test, textBuddy.getTexts());
	}
	
	@Test
	public void testSortExpert() {
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		
		textBuddy.addText("Speak at a business, tech, leadership, or web conference.");
		textBuddy.addText("Write and publish an ebook.");
		textBuddy.addText("Own a piece of art from an artist I admire.");
		textBuddy.addText("Attend a rave party.");
		textBuddy.addText("Hire my first intern.");
		textBuddy.addText("Start a product-based company.");
		
		textBuddy.sortTexts();
		
		LinkedList<String> test = new LinkedList<String>();
		test.add("Attend a rave party.");
		test.add("Hire my first intern.");
		test.add("Own a piece of art from an artist I admire.");
		test.add("Speak at a business, tech, leadership, or web conference.");
		test.add("Start a product-based company.");
		test.add("Write and publish an ebook.");
		
		assertEquals(test, textBuddy.getTexts());
	}
	
	
	@Test
	public void testFindBasic() {
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		
		LinkedList<String> test = new LinkedList<String>();
		
		assertEquals(test, textBuddy.findText(""));
	}
	
	@Test
	public void testFindBasic2() {
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		textBuddy.addText("A");
		textBuddy.addText("B");
		textBuddy.addText("C");
		
		LinkedList<String> test = new LinkedList<String>();
		test.add("B");
		
		assertEquals(test, textBuddy.findText("B"));
	}
	

	
	@Test
	public void testFindBasic3() { // Text not found
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		textBuddy.addText("A");
		textBuddy.addText("B");
		textBuddy.addText("C");
		
		LinkedList<String> test = new LinkedList<String>();
		
		assertEquals(test, textBuddy.findText("D"));
	}

}
