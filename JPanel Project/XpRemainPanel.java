import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class XpRemainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField XpRemainTextField;
	private JLabel XpRemainLabel;
	int xpRemain;
	
	// Constructor	
	public XpRemainPanel()
	{		
		XpRemainLabel = new JLabel("XP REMAIN: ");
		
		// Create a text field a certain length
		XpRemainTextField = new JTextField(10);
		
		// Make text field editable
		XpRemainTextField.setEditable(false);
		
		// Add the label and text field to panel
		add(XpRemainLabel);
		add(XpRemainTextField);
		setVisible(false);

	}
	
	public void allowEdit()
	{
		XpRemainTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		XpRemainTextField.setEditable(false);
	}
	
	public int getXpRemainInt()
	{
		String xpTemp;
		xpTemp = XpRemainTextField.getText();
		xpRemain = Integer.parseInt(xpTemp);
		return xpRemain;
	}
	
	public String getXpRemainStr()
	{
		return XpRemainTextField.getText();
	}
	
	public void setXpRemain(String xpRemain)
	{
		XpRemainTextField.setText(xpRemain);

	}
	
	public void setXpRemain(int xpRemain)
	{
		XpRemainTextField.setText(Integer.toString(xpRemain));
	}
}
