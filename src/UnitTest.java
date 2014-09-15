import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testSort() {
		
		TextBuddy textBuddy = new TextBuddy(new String[0]);
		
		textBuddy.addText("B");
		textBuddy.addText("A");
		
		textBuddy.sortTexts();
		
		LinkedList<String> test = new LinkedList<String>();
		test.add("A");
		test.add("B");
		
		assertEquals(test, textBuddy.getTexts());
	}

}
