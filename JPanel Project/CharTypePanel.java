
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class CharTypePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField CharTextField;
	private JLabel CharLabel;
	String charType;
	
	public CharTypePanel()
	{
		CharLabel = new JLabel("CHARACTER TYPE: ");
		
		// Create a text field a certain length
		CharTextField = new JTextField(6);
		
		// Make text field editable
		CharTextField.setEditable(false);
		
		// Add the label and text field to panel
		add(CharLabel);
		add(CharTextField);
		setVisible(false);
	}

	public void allowEdit()
	{
		CharTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		CharTextField.setEditable(false);
	}
	
	public String getCharStr()
	{
		charType = CharTextField.getText();
		return charType;
	}
	
	public char getCharChar()
	{
		charType = CharTextField.getText();
		return charType.charAt(0);
	}
	
	public void setChar(String charType)
	{
		CharTextField.setText(charType);
	}
	
	public void setChar(char type)
	{
		charType = Character.toString(type);
		CharTextField.setText(charType);
	}
}
