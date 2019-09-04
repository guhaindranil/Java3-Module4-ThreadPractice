/*
 * Word Counter Application - View Class 
 * This Class is responsible to create the view of GUI
 */
package wordcounterapp;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WordCounterView extends JFrame{
	
	/**
	 * Create Swing GUI, User need to enter the word and select the files from file chooser.
	 * Once the files are selected, Text area for "Files Selected" will display the file names and 
	 * Text area for "Word Counts" will display the counts of the occurrence of the entered word in each file.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelWord = new JLabel("Enter Word");
	private JTextField textFieldWord = new JTextField(30);
	private JButton buttonFileChooser= new JButton("Choose Files");
	private JLabel labelFileSelection = new JLabel("Files Selected :");
	private JTextArea textAreaFileSelection = new JTextArea (10,20);
	private JLabel labelSearchResult = new JLabel("Word Counts :");
	private JTextArea textAreaSearchResult = new JTextArea(10,20);
	
	WordCounterView() {
		
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		
		JPanel panel1 = new JPanel();
		
		panel1.add(labelWord);
		panel1.add(textFieldWord);
		panel1.add(buttonFileChooser);
		
		this.getContentPane().add(panel1,"North");
		
		
		JPanel panel2 = new JPanel();
		
		panel2.add(labelFileSelection);
		
		textAreaFileSelection.setEditable(false);
		textAreaFileSelection.setLineWrap(true);
		textAreaFileSelection.setWrapStyleWord(true);
		panel2.add(textAreaFileSelection);
		
		panel2.add(labelSearchResult);
		textAreaSearchResult.setEditable(false);
		textAreaSearchResult.setLineWrap(true);
		textAreaSearchResult.setWrapStyleWord(true);
		panel2.add(textAreaSearchResult);
		
		this.getContentPane().add(panel2,"South");
		
	}
	/*
	 * Get the word from GUI Text field
	 */
    public String getWord() {
		return this.textFieldWord.getText();
		
	}
	/*
	 * Action Listener for Button FileChooser 
	 */
	void buttonFileChooserListener(ActionListener listenForFCButton) {
		this.buttonFileChooser.addActionListener(listenForFCButton);
	}
	/*
	 * Set the selected file names in the Text area
	 */
	public void setFilesSelection(String fileNames) {
		this.textAreaFileSelection.setText(fileNames); 
		
	}
	/*
	 * Set the "Word Counts: " Text Area in the GUI 
	 */
	public void setResult(String result) {
		textAreaSearchResult.append(result);
	}

	
}
