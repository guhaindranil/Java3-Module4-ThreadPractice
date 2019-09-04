/*
 * Word Counter Application - Controller Class 
 */
package wordcounterapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;


public class WordCounterController {
	
	private WordCounterView wcView;
	private WordCounterModel wcModel;
	
	/*
	 * Constructor 
	 */
	public WordCounterController(WordCounterView wcView, WordCounterModel wcModel) {
		this.wcView = wcView;
		this.wcModel = wcModel;
		this.wcView.buttonFileChooserListener(new buttonFCListener());
		
	}
    /*
     * Action event for FileChooser
     * On selection of files, for each file a new thread will be created and call the model class to return the word count, finally the counts will be formatted in the "Word Count:" Text area 
     */
	class buttonFCListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fc = new JFileChooser();
			fc.setMultiSelectionEnabled(true);
			
			int option = fc.showOpenDialog(wcView);
			
            if(option == JFileChooser.APPROVE_OPTION){
               File[] files = fc.getSelectedFiles();
               String fileNames = "File(s) Selected:                            ";
               for(File file: files){
            	  fileNames += file.getName() + " ";
            	  
            	  Thread t = new Thread () {
            		  
            	  @Override
            	  public void run() {
            	  System.out.println(file.getName());
                  wcView.setResult(String.format(file.getName() + ":" + wcModel.getWordCount(wcView.getWord(),file.getName()) + " "));
                  
            	  }
            	  };
            	  t.start();
            	}
               wcView.setFilesSelection(fileNames);
            } else {
            	wcView.setFilesSelection("Option Command Cancelled");
            	
            }
			
			
		}
		
	}
}
