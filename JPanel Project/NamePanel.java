
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField NameTextField;
	private JLabel NameLabel;
	String name;
	
	// Constructor	
	public NamePanel()
	{		
		NameLabel = new JLabel("NAME: ");
		
		// Create a text field a certain length
		NameTextField = new JTextField(20);
		
		// Make text field editable
		NameTextField.setEditable(false);
		
		// Add the label and text field to panel
		add(NameLabel);
		add(NameTextField);
		setVisible(false);

	}
	
	public void allowEdit()
	{
		NameTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		NameTextField.setEditable(false);
	}
	
	public String getName()
	{
		return NameTextField.getText();
	}
	
	public void setName(String name)
	{
		NameTextField.setText(name);
	}
	
}
