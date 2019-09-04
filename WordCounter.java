/*
 * Driver for Word Counter Application Interface, run this to launch the application
 */

package wordcounterapp;

public class WordCounter {
	
	public static void main(String[] args) {
		
		WordCounterView wcView = new WordCounterView();
		wcView.setTitle("Word Counter Application Interface");
		wcView.setVisible(true);
		wcView.pack();
		
		WordCounterModel wcModel = new WordCounterModel();
		
		WordCounterController wcController = new WordCounterController(wcView,wcModel);
		
	}

}
