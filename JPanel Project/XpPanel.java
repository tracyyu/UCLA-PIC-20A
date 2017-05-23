
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class XpPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField XpTextField;
	private JLabel XpLabel;
	int xp;
	
	// Constructor	
	public XpPanel()
	{		
		XpLabel = new JLabel("XP: ");
		
		// Create a text field a certain length
		XpTextField = new JTextField(10);
		
		// Make text field editable
		XpTextField.setEditable(false);
		
		// Add the label and text field to panel
		add(XpLabel);
		add(XpTextField);
		setVisible(false);

	}
	
	public void allowEdit()
	{
		XpTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		XpTextField.setEditable(false);
	}
	
	public int getXpInt()
	{
		String xpTemp;
		xpTemp = XpTextField.getText();
		xp = Integer.parseInt(xpTemp);
		return xp;
	}
	
	public String getXpStr()
	{
		return XpTextField.getText();
	}
	
	public void setXp(String xp)
	{
		XpTextField.setText(xp);

	}
	
	public void setXp(int xp)
	{
		XpTextField.setText(Integer.toString(xp));
	}
}
