import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AllUser extends JFrame{
	
	static Vector<String> charList;
	int numberOfCharacters;
	
	private JPanel buttonPanel;
	private JButton done;
	
	Vector<IdPanel> [] id;
	Vector<XpPanel> [] xp;
	Vector<NamePanel> [] name;
	Vector<CharTypePanel> [] character;
	Vector<SubTypePanel> [] subChar;
	Vector<ItemPanel> [] xpRemain;
	
	
	//Constructor
	public AllUser() throws IOException		// Will download the file
	{
		super("All Stats");		
		//Download File
		
		String fileName = "charList.txt";
		String input;
		//Holds a vector of id
		 charList = new Vector<String>();
		
		//Download file 
		 FileReader freader = openFile(fileName);
		 BufferedReader ipf = new BufferedReader(freader);
		 
			 // Read a line from the file
			 input = ipf.readLine();
			 
			 //As long as a line was read, process it
			 while(input != null)
			 {
				 String [] temp;	// Hold temporary string when split
				temp = input.split("\t");
				for( int i = 0; i < temp.length; i++)
				{
					charList.add(temp[i]);
				}
				 
				input = ipf.readLine();
			 }
			 
			 ipf.close();
		
				//Close Button
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Create a BorderLayout manger for the content pane
				
				setLayout(new BorderLayout());
				setSize(500, 500);	
				
				buildButtonPanel();
				
				add(buttonPanel, BorderLayout.SOUTH);
				
				setVisible(true);
				
				System.getProperty("line.separator");
				int nextLine = 0;
				String stats = "";
				for( int i = 0; i < charList.size(); i++)
				{
					stats += charList.elementAt(i);
					if( nextLine == 6)
					{
						stats += "\n";
						nextLine = 0;
					}
					else
					stats += "\t";
					nextLine++;
				}
				
				JTextArea area = new JTextArea();
				area.setText(stats);
				setLayout(new FlowLayout());
				
				add(area, BorderLayout.NORTH);
				area.setVisible(true);
				area.setEditable(false);
						
		
	}
	
	private void buildButtonPanel()
	{
		//Create a panel for the button
		buttonPanel = new JPanel();
		
		//add button
		done = new JButton("Done");
		
		//add an action listener to the button
		done.addActionListener(new doneButtonListener());
		
		
		//add the button to the panel
		buttonPanel.add(done);
		buttonPanel.setVisible(true);
	}
	
	private class doneButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//exits the program
			System.exit(0);
		}
	}
	
	public static FileReader openFile(String fileName)
	 {
		 FileReader fr = null;
		 
	      // Create a Scanner object for keyboard input.
	      Scanner keyboard = new Scanner(System.in);

		 
		 while(fr == null)
		 {
			 try
			 {
				 // Attempt to open file
				 fr = new FileReader(fileName);
			 }
			 catch(FileNotFoundException e)
			 {
				 // If the file is not found, end program
				 System.out.println("ERROR: " + fileName +  "does not exist. " +
				 		"Please type in file you are looking for");
				fileName = keyboard.nextLine();
				 
			 }
		 }
		 		 
		 // Return a reference to the FileReader object
		 return fr;
	 }
	
	 public int ReturnCharacter()			// Return the number of characters
	 {
		 return (charList.size()/7);
	 }
	 

		

}
