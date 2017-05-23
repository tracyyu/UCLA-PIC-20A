import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ItemPanel extends JPanel{
	
	//Keep tracks of the cost of item
	private final int N = 0;
	private final int T = 10;
	private final int C = 50;
	private final int F = 100;
	
	private static final long serialVersionUID = 1L;
	private JTextField ItemTextField;
	private JLabel ItemLabel;
	String item;
	
	public ItemPanel()
	{
		ItemLabel = new JLabel("ITEM: \n" +
				"		in ascending order (N, T, C, F)");
		
		// Create a text field a certain length
		ItemTextField = new JTextField(6);
		
		// Make text field editable
		ItemTextField.setEditable(false);
		
		// Add the label and text field to panel
		add(ItemLabel);
		add(ItemTextField);
		setVisible(false);
	}
	
	public void allowEdit()
	{
		ItemTextField.setEditable(true);
	}
	
	public void noEdit()
	{
		ItemTextField.setEditable(false);
	}
	
	public String getItemStr()		// returns to string
	{
		return ItemTextField.getText();
	}
	
	public char getItemChar()			// returns a char
	{
		String charTemp = ItemTextField.getText();
		char item = charTemp.charAt(0);
		return item;
	}
										// if user enter a string
	public void setItem(String itemName)
	{
		ItemTextField.setText(itemName);
	}
	
	public void setItem(char itemName)		// if user enter a char
	{
		String itemType = Character.toString(itemName);
		ItemTextField.setText(itemType);
	}
	
	public int getItemCost(String item)			// Determines cost depending on item
	{
		int cost = 0;
		if( item != "N" || item != "T" || item != "C" || item != "F")
		{
			cost = 0;
			JOptionPane.showMessageDialog(null, "This item does not exist!!");
		}
		else{
			if( item.equals("N"))
				cost = N;
			else if (item.equals("T"))
				cost = T;
			else if (item.equals("C"))
				cost = C;
			else if(item.equals("F"))
				cost = F;
			else;
		}
		
		return cost;
		
	}
	
	public boolean BuyGoods(int xp, String item)		// Can person afford item
	{
		if( xp >= getItemCost(item))
			return true;
		else
			return false;
	}
	
	public int CalculateXP(int xp, String item)			// What is remaining xp
	{
		if( BuyGoods(xp,item))
			return (xp-getItemCost(item));
		else
			return xp;
	}
}
