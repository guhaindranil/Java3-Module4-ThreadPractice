/*
 * Word Counter Application - Model Class 
 * Responsible to read the file sequentially, 
 * split the data into tokens and match the word with tokens to find the total count of the word occurrences in the file and return the count to controller 
 */
package wordcounterapp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordCounterModel {
	
	
	private int wordCount;
	public synchronized int getWordCount(String word, String fileName) {
	
		String line = "";
		try(Scanner input = new Scanner(Paths.get(fileName))) {
			wordCount=0;
			while(input.hasNext()) {
				line = line + input.next() + " ";
				//input.next();
			}
			input.close();
			String [] tokens = line.split("[^a-zA-Z]+");
			for (int i=0;i<tokens.length;i++) {
				System.out.println(tokens[i]);
				if (word.equalsIgnoreCase(tokens[i])) {wordCount++;}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(fileName + ":" + wordCount);
		return wordCount;
		
	}
	
	
}
