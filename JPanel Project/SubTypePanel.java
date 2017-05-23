import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SubTypePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField SubTypeTextField;
	private JLabel SubTypeLabel;
	String subType;
	
	public SubTypePanel()
	{
		SubTypeLabel = new JLabel("SUBCHARACTER TYPE: ");
		
		// Create a text field a certain length
		SubTypeTextField = new JTextField(6);
		
		// Make text field editable
		SubTypeTextField.setEditable(false);
		
		// Add the label and text field to panel
		add(SubTypeLabel);
		add(SubTypeTextField);
		setVisible(false);
	}

	public void allowEdit()
	{
		SubTypeTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		SubTypeTextField.setEditable(false);
	}
	
	public String getSubTypeStr()				// return a string
	{
		subType = SubTypeTextField.getText();
		return subType;
	}
	
	public char getSubTypeChar()						// return a char
	{
		String charTemp = SubTypeTextField.getText();
		char sub = charTemp.charAt(0);
		return sub;
	}
	
	public void setSubType(String charType)				// if user enter a string
	{
		SubTypeTextField.setText(charType);

	}
	
	public void setItem(char itemName)		// if user enter a char
	{
		String subType = Character.toString(itemName);
		SubTypeTextField.setText(subType);
	}
	
}
