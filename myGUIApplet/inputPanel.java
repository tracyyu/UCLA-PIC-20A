import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class inputPanel extends JPanel
{
	userPanel id;
	namePanel name;
	charPanel character;
	itemPanel item;
		
	JButton okButton;
	JButton cancelButton;
	
	
	public inputPanel() throws NullPointerException
	{
		 //Create the custom panels
	      id = new userPanel();
	      name = new namePanel();
	      character = new charPanel();
	      item = new itemPanel();
	      		
	      // Add the components to the content pane.
	      add(name);
	      add(id);
	      add(character);
	      add(item);
	      repaint();
	}
	
	public String getID()
	{
		return id.getSelected();
	}
	
	public String getName()
	{
		return name.getSelected();
	}
	
	public String getChar()
	{
		return character.getSelected();
	}
	
	public String getItem()
	{
		return item.getSelected();
	}
}
