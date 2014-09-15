import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
	
	// These are the possible command types
	private static String OPERATION_ADD = "add";
	private static String OPERATION_DELETE = "delete";
	private static String OPERATION_CLEAR = "clear";
	private static String OPERATION_DISPLAY = "display";
	private static String OPERATION_SORT = "sort";
	private static String OPERATION_FIND = "find";
	private static String OPERATION_EXIT = "exit";
	
	/*
	 * This variable is declared for the whole class (instead of declaring it
	 * inside the readUserCommand() method to facilitate automated testing using
	 * the I/O redirection technique. If not, only the first line of the input
	 * text file will be processed.
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] file)
			throws FileNotFoundException, UnsupportedEncodingException {

		TextBuddy textBuddy = new TextBuddy(file);

		while(true) {

			String operation = scanner.next();
			operation = operation.toLowerCase(); // For insensitive casing search

			if(operation.equals(OPERATION_ADD)) { // Add text
				textBuddy.addText(scanner.nextLine());
			}
			else if(operation.equals(OPERATION_DELETE)) { // Delete text
				textBuddy.deleteText(scanner.nextInt());
			}
			else if(operation.equals(OPERATION_CLEAR)) { // Clear all texts
				textBuddy.clearAllText();
			}
			else if(operation.equals(OPERATION_DISPLAY)) { // Display all texts
				textBuddy.displayTexts();
			}
			else if(operation.equals(OPERATION_SORT)) { // Display all texts
				textBuddy.sortTexts();
			}
			else if(operation.equals(OPERATION_FIND)) {
				textBuddy.findText(scanner.nextLine());
			}
			else if(operation.equals(OPERATION_EXIT)) { // Save texts to file and exit
				textBuddy.saveAndExit();
				break;
			}
		}
	}

}
