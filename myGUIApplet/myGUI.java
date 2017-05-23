import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class myGUI extends JFrame
{
	JPanel buttonPanel;
	inputPanel start;
	outputPanel end;
	
	JButton okButton;
	JButton doneButton;
	
	String id;
	String name;
	String character;
	String item;
	
	public myGUI() throws NullPointerException
	{
		super("Character List");
		
		//Close Button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		 //Create the custom panels
		start = new inputPanel();
		end = new outputPanel();
		buildButtonPanel();
		
		setSize(500,200);
		setLayout(new FlowLayout());
		add(start, FlowLayout.LEFT);
		add(end, FlowLayout.LEFT);
		add(buttonPanel, FlowLayout.RIGHT);
		end.setVisible(false);
		
		
	      // Pack the contents of the window and display it.
	      pack();
		setVisible(true);
	}
	
	private void buildButtonPanel()
	{
		//Create panel
		buttonPanel = new JPanel();
		
		//add button
		okButton = new JButton("Ok");
		doneButton = new JButton("Done");
		
		buttonPanel.add(okButton);
		buttonPanel.add(doneButton);
		
		//add Action Listener to the button
		okButton.addActionListener(new okButtonListener());
		doneButton.addActionListener(new doneButtonListener());
	}
		
	private class okButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			id = start.getID();
			name = start.getName();
			character = start.getChar();
			item = start.getItem();
			end.setName(name);
			end.setID(id);
			end.setChar(character);
			end.setItem(item);
			//end.displayImg();
			
			end.setVisible(true);
			start.setVisible(false);
			setSize(1200,600);
			okButton.setVisible(false);
			doneButton.setVisible(true);
			
			setVisible(true);
		}
	}
	
	private class doneButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			end.setVisible(false);
			start.setVisible(true);
			setSize(500,200);
			okButton.setVisible(true);
			doneButton.setVisible(false);
		}
	}
	
	public static void main(String [] args)
	{
		myGUI project = new myGUI();
	}
}
