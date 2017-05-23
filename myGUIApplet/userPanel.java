import java.awt.*;
import javax.swing.*;

public class userPanel extends JPanel 
{
	//Constant Id choices
	public final String ID1 = "123";
	public final String ID2 = "456";
	public final String ID3 = "789";
	
	//Create Check box for each
	private JRadioButton id1; //123
	private JRadioButton id2; //456
	private JRadioButton id3; //789	
	

	public userPanel()
	{
		// Create a GridLayout manager with 
	      // four rows and one column.
	      setLayout(new GridLayout(3, 1));

	      // Create the check boxes.
	      id1 = new JRadioButton("123");
	      id2 = new JRadioButton("456");
	      id3 = new JRadioButton("789");
	      
	      // Add a border around the panel.
	      setBorder(BorderFactory.createTitledBorder("ID"));
	      
	      // add the check boxes to panel
	      add(id1);
	      add(id2);
	      add(id3);
	}
	
	public String getSelected()
	{
		if( id1.isSelected())
			return "123";
		else if (id2.isSelected())
			return "456";
		else if(id3.isSelected())
			return "789";
		else
			return "";
	}
	
}
