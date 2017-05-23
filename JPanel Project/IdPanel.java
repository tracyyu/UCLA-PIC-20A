
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class IdPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField IdTextField;
	private JLabel IdLabel;
	
	
	// Constructor	
	public IdPanel()
	{		
		IdLabel = new JLabel("ID: ");
		
		// Create a text field a certain length
		IdTextField = new JTextField(6);
		
		// Add the label and text field to panel
		add(IdLabel);
		add(IdTextField);

	}
	
	public void allowEdit()
	{
		IdTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		IdTextField.setEditable(false);
	}
	
	// Check Id
	public void IdError() throws NotThreeDigit, NumberFormatException
	{
		//To hold text entered
		String idTemp = IdTextField.getText();
		
		//Checks if id is empty or not in between 001 to 999
		if(idTemp.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please insert an Id number");
		}
		else
		{
			int idValue;
			idValue = Integer.parseInt(idTemp);
			if(idTemp.length() < 3 || idValue > 999 || idValue < 100)
			{
				throw new NotThreeDigit();
			}

		}
	}
	
	public String getId()
	{
		return IdTextField.getText();
	}
	public void setId(String id)
	{
		IdTextField.setText(id);
	}
}

