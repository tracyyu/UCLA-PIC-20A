import java.awt.*;
import javax.swing.*;

public class namePanel extends JPanel 
{
	private JTextField nameText;
	private JLabel nameLabel;
	
	public namePanel()
	{
		nameLabel = new JLabel("Name: ");
		
		//Create a textfield to store name
		nameText = new JTextField(15);
		
		nameText.setEditable(true);
		
		add(nameLabel);
		add(nameText);
		setVisible(true);
	}
	
	public String getSelected()
	{
		return nameText.getText();
	}
}
