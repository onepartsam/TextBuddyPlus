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

}
