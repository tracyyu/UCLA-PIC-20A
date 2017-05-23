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


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class HW4 extends JFrame{
		
	 private int WINDOW_WIDTH = 300;  // Window width
	 private int WINDOW_HEIGHT = 300; // Window height
	
	private IdPanel id; // Id panel
	private int idPos;	// id position
	
	private XpPanel xp; // Xp panel
	private int totalXp = 0; // total Xp
	
	private NamePanel name; // Name panel
	private CharTypePanel charType;// Character Panel
	private SubTypePanel subType; // Sub Character Panel
	private ItemPanel item; // item Panel
	private String oldItem;
	
	private AllUser all; // List of stats for all user
	
	private XpRemainPanel xpRemain; // Xp Remain Panel
	
	boolean noError = true; //Checks to see if there is an error
	 
	private JButton enterButton;
	private JButton changeButton;
	private JButton noChangeButton;
	private JButton updateButton;
	private JButton quitButton;
	private JButton doneButton;
	private JPanel buttonPanel;
	
	private JLabel wantChangesLabel;
	
	protected static Vector<String> charList;
	
	
	/* Constructor */
	
	public HW4() throws IOException
	{
		//Display a title
		super("Character List");
		
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
		
		setLayout(new GridLayout(5,0));
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);	
		
		wantChangesLabel = new JLabel("Do you want to make changes?");
		wantChangesLabel.setVisible(false);
		
		id = new IdPanel(); 
		xp = new XpPanel();
		name = new NamePanel();
		charType = new CharTypePanel();
		subType = new SubTypePanel();
		item = new ItemPanel();
		xpRemain = new XpRemainPanel();
				
		buildButtonPanel();	
		
		// Add the panels to the content panel
		add(id);
		add(xp);
		add(name);
		add(charType);
		add(subType);
		add(item);
		add(xpRemain);
		
		//add label for changes
		add(wantChangesLabel, BorderLayout.CENTER);
		//Add the Enter an Quit buttons
		add(buttonPanel, BorderLayout.SOUTH);
		
		//Pack and display the window
		setVisible(true);
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
	
	public static void writeFile() throws IOException
	{
		System.getProperty("line.separator");
		int nextLine = 0;
		FileWriter fw = new FileWriter("charList.txt", false);
		for( int i = 0; i < charList.size(); i++)
		{
			fw.write(charList.elementAt(i));
			if( nextLine == 6)
			{
				fw.write("\r\n");
				nextLine = 0;
			}
			else
				fw.write("\t");
			nextLine++;
		}
		fw.close();
	}
	
	// Check id if exist in the vector & tells us the position of the id in the list
	public boolean checkId(String idNumber)
	{
		boolean answer = false;
		for( int i = 0; i < charList.size(); i+=7)
		{
			if( (charList.elementAt(i)).equals(idNumber))
			{
				answer = true;
				idPos = i;
			}
		}
		return answer;
	}
	
	//Get total number of xp 
	public int totalXp()
	{
		totalXp = 0;
		for( int i = 1; i < charList.size(); i+=7)
		{
				String xpValue = charList.elementAt(i);		// get the string of Xp
				int charXP = Integer.parseInt(xpValue);		// convert the string into integer
				totalXp += charXP;
		}
		return totalXp;
	}
	
	public void displayAll()
	{
		xp.setVisible(true);
		name.setVisible(true);
		charType.setVisible(true);
		subType.setVisible(true);
		item.setVisible(true);
		xpRemain.setVisible(true);
		
	}

	
	private void buildButtonPanel()
	{
		//Create a panel for the button
		buttonPanel = new JPanel();
		
		//add button
		enterButton = new JButton("Enter");
		changeButton = new JButton("Yes");
		noChangeButton = new JButton("No");
		updateButton = new JButton("Update");
		quitButton = new JButton("Quit");
		doneButton = new JButton("Done");
		
		//add an action listener to the button
		enterButton.addActionListener(new enterButtonListener());
		quitButton.addActionListener(new quitButtonListener());
		
		
		//add the button to the panel
		buttonPanel.add(enterButton);
		buttonPanel.add(changeButton);
		buttonPanel.add(noChangeButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(quitButton);
		buttonPanel.add(doneButton);
		
		changeButton.setVisible(false);
		noChangeButton.setVisible(false);
		updateButton.setVisible(false);
		quitButton.setVisible(false);
	}
	
	private class enterButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				id.IdError();
			} catch (NumberFormatException e1 ) {
				// TODO Auto-generated catch block
				noError = false;
				JOptionPane.showMessageDialog(null, "Must be a valid Id");
			} catch (NotThreeDigit e1){
				noError = false;
				JOptionPane.showMessageDialog(null, "Must be a three digit Id");
			}
			if(noError == true && checkId(id.getId()) == true)
			{
				enterButton.setVisible(false);
				quitButton.setVisible(false);
				updateButton.setVisible(false);
				doneButton.setVisible(false);
				changeButton.setVisible(true);
				changeButton.addActionListener(new changeButtonListener());
				noChangeButton.setVisible(true);
				noChangeButton.addActionListener(new noChangeButtonListener());
				
				
				// Set the stats value to the corresponding id
				
				wantChangesLabel.setVisible(true);
				id.noEdit();
				xp.setXp(charList.elementAt(idPos + 1));
				name.setName(charList.elementAt(idPos + 2));
				charType.setChar(charList.elementAt(idPos + 3));
				subType.setSubType(charList.elementAt(idPos + 4));
				item.setItem(charList.elementAt(idPos + 5));
				xpRemain.setXpRemain(charList.elementAt(idPos + 6));
				
				setSize(500, 700);	
	
				displayAll();

			}
			else
				JOptionPane.showMessageDialog(null, "Id does not exist");
			
			// Display a message dialog showing the id
			//JOptionPane.showMessageDialog(null, "Your id: " + idValue);
			
		}
	}
	
	private class changeButtonListener implements ActionListener			// ask if want to change data
	{
		public void actionPerformed(ActionEvent e)
		{
			wantChangesLabel.setVisible(false);
			enterButton.setVisible(false);
			quitButton.setVisible(false);
			noChangeButton.setVisible(false);
			changeButton.setVisible(false);

			updateButton.setVisible(true);
			updateButton.addActionListener(new updateButtonListener());
			
			doneButton.setVisible(true);
			doneButton.addActionListener(new doneButtonListener());
			
			// Allow all data to be changed except for ID and XP
			name.allowEdit();
			
			charType.allowEdit();

			subType.allowEdit();

			oldItem = item.getItemStr();
			
			item.allowEdit();
			
		}
	}
	
	
	private class noChangeButtonListener implements ActionListener			// if do not want to make changes
	{
		public void actionPerformed(ActionEvent e)
		{
			
			wantChangesLabel.setVisible(false);
			id.allowEdit();
			enterButton.setVisible(true);
			enterButton.addActionListener(new enterButtonListener());
			quitButton.setVisible(true);
			quitButton.addActionListener(new quitButtonListener());
			updateButton.setVisible(false);
			changeButton.setVisible(false);
			noChangeButton.setVisible(false);
			
		}
	}
	
	
	private class updateButtonListener implements ActionListener			// make updates to data
	{
		public void actionPerformed(ActionEvent e)
		{
			displayAll();
			
			//Update the changes made to the vector 
			charList.setElementAt(name.getName(), idPos + 2);
			
			charList.setElementAt(charType.getCharStr(), idPos + 3);
			
			charList.setElementAt(subType.getSubTypeStr(), idPos + 4);			
						
			int totalXp = xp.getXpInt();
			int newXpRemain = 0;
			//Checks if id person has enough xp for new item
			if(item.BuyGoods(totalXp, item.getItemStr()))
			{
				newXpRemain =item.CalculateXP(totalXp, item.getItemStr());
				xpRemain.setXpRemain(newXpRemain);
			}
			else
			{	
				JOptionPane.showMessageDialog(null, "Choose a different item. You do not have enough XP.");
				item.setItem(oldItem);
			}
			
			charList.setElementAt(item.getItemStr(), idPos + 5);
			

			updateButton.setVisible(true);
			updateButton.addActionListener(new updateButtonListener());
			doneButton.setVisible(true);
			doneButton.addActionListener(new doneButtonListener());
			quitButton.setVisible(false);
			noChangeButton.setVisible(false);
			changeButton.setVisible(false);
			
			try {
				writeFile();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null,"File could not be created");
			}
				
		}
	}
	
	private class quitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//exits the program
			System.exit(0);
		}
	}
	
	private class doneButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			id.allowEdit();
			
			charType.noEdit();
			subType.noEdit();
			item.noEdit();
			name.noEdit();
			
			enterButton.setVisible(true);
			enterButton.addActionListener(new enterButtonListener());
			quitButton.setVisible(true);
			quitButton.addActionListener(new quitButtonListener());
			
			updateButton.setVisible(false);
			doneButton.setVisible(false);
			noChangeButton.setVisible(false);
			changeButton.setVisible(false);
					
			wantChangesLabel.setVisible(false);
			try {
				all = new AllUser();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "NO List Exist");
			}
			
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);	
			xp.setVisible(false);
			name.setVisible(false);
			charType.setVisible(false);
			subType.setVisible(false);
			item.setVisible(false);
			xpRemain.setVisible(false);
			
		}
	}
	
	
	public static void main(String [] args) throws IOException{
		HW4 list = new HW4();
	}
}
