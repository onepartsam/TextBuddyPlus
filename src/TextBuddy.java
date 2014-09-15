/*
 * ============================ASSUMPTIONS=============================
 *  i) The text file will be saved only when user exits the program
 *   - This is to reduce processing time
 * ii) If the text file exists, contents will be overwritten.
 * ====================================================================
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Scanner;

public class TextBuddy {

	// These are the feedback messages
	private String MESSAGE_FILE_NOT_SPECIFY = "Parameter not found. Using \"default.txt\" instead.\n";
	private String MESSAGE_WELCOME = "Welcome to TextBuddy. %s is ready for use!\n";
	private String MESSAGE_ADD_SUCCESSFUL = "Added \"%s\"\n";
	private String MESSAGE_DELETE_SUCCESSFUL = "Deleted \"%s\"\n";
	private String MESSAGE_DELETE_UNSUCCESSFUL = "Text cannot be found. Delete unsuccessful.\n";
	private String MESSAGE_CLEAR_SUCCESSFUL = "Cleared successfully.\n";
	private String MESSAGE_SORT_SUCCESSFUL = "Sorted successfully.\n";
	private String MESSAGE_DISPLAY_UNSUCCESSFUL = "Nothing to display...\n";
	private String MESSAGE_SAVE_SUCCESSFUL = "%s has been updated.\n";
	private String MESSAGE_SAVE_LINE_FORMAT = "%d. %s\n";
	private String MESSAGE_ERROR = "Error: %s\n";
	
	// This is the default file that will use if non is indicated
	private String DEFAULT_FILE = "default.txt";

	// This is the file name that the program will save its date to
	private String fileName;

	// This will be used as a buffer to store the data before saving into the text file
	private LinkedList<String> tempLines = new LinkedList<String>();

	
	
	public TextBuddy(String[] file) {
		
		getFile(file);
		showWelcomeMessage();
	}

	/**
	 * This operation attempt to get the file the user specify while running this program.
	 * If there is no specified file, this program will use "default.txt" to store the data.
	 */
	private void getFile(String[] file) {

		if(file.length != 0) { // File name is provided
			fileName = file[0];
		}
		else { // File name is not provided
			fileName = DEFAULT_FILE; // "default.txt" will be used
			informUsingDefaultFile();
		}
	}

	/**
	 * This operation will feedback to the user that "default.txt" is being used.
	 */
	private void informUsingDefaultFile() {

		System.out.printf(MESSAGE_FILE_NOT_SPECIFY);
	}

	/**
	 * This operation will feedback to the user a welcome message.
	 */
	private void showWelcomeMessage() {

		System.out.printf(MESSAGE_WELCOME, fileName);
	}

	/**
	 * This operation will add the input text to the buffer list
	 * and feedback to the user that the operation is successful.
	 */
	public void addText(String text) {

		text = text.trim(); // Remove unnecessary heading and tailing spaces 
		tempLines.add(text);
		System.out.printf(MESSAGE_ADD_SUCCESSFUL, text);
	}

	/**
	 * This operation will delete the input text from the buffer list
	 * and feedback to the user whether if the operation is successful.
	 */
	public void deleteText(int deleteId) {

		if(deleteId==0 || deleteId > tempLines.size()) {
			System.out.printf(MESSAGE_DELETE_UNSUCCESSFUL);
		}
		else {
			System.out.printf(MESSAGE_DELETE_SUCCESSFUL, tempLines.get(deleteId-1));
			tempLines.remove(deleteId-1);
		}
	}

	/**
	 * This operation will remove all input texts from the buffer list
	 * and feedback to the user that the operation is successful.
	 */
	public void clearAllText() {

		tempLines.clear();
		System.out.printf(MESSAGE_CLEAR_SUCCESSFUL);
	}

	/**
	 * This operation will display all input texts from the buffer list
	 * and feedback to the user that the operation is successful.
	 */
	public void displayTexts() {

		displayTexts(tempLines);
	}

	private void displayTexts(LinkedList<String> listTexts) {

		if(listTexts.size()==0) {
			System.out.printf(MESSAGE_DISPLAY_UNSUCCESSFUL);
		}
		else {
			for(int i=0; i<listTexts.size(); i++) {
				int textIndex = i+1;
				String text = listTexts.get(i);
				System.out.printf(MESSAGE_SAVE_LINE_FORMAT, textIndex, text);
			}
		}
	}

	/**
	 * This operation will sort all input texts from the buffer list
	 * and feedback to the user that the operation is successful.
	 */
	public void sortTexts() {

		TreeSet<String> sortedTexts = new TreeSet<String>(tempLines); // TreeSet will sort the data
		tempLines = new LinkedList<String>(sortedTexts); // Transfer sorted data back to tempLines

		System.out.printf(MESSAGE_SORT_SUCCESSFUL);
		displayTexts();
	}



	public void findText(String keyword) {
		
		keyword = keyword.trim();

		for(int i=0; i<tempLines.size(); i++) {
			String text = tempLines.get(i);
			if(text.contains(keyword)) {
				int textIndex = i+1;
				System.out.printf(MESSAGE_SAVE_LINE_FORMAT, textIndex, text);
			}
		}
	}

	/**
	 * This operation will save all input texts from the buffer list to the specified file
	 * and feedback to the user whether the operation is successful.
	 */
	public void saveAndExit() {

		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");

			for(String textLine: tempLines) {
				writer.println(textLine);
			}

			System.out.printf(MESSAGE_SAVE_SUCCESSFUL, fileName);

			writer.close();
		} catch (FileNotFoundException e) {
			System.out.printf(MESSAGE_ERROR, e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.printf(MESSAGE_ERROR, e.getMessage());
		}
	}
	
	public LinkedList<String> getTexts() {
		
		return tempLines;
	}
}
