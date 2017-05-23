import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class charPanel extends JPanel 
{	
	private JComboBox characterBox;
	private JTextField characterSelected;
	
	//Holds an array of character choices
	private String[] character = {"No Selection","Doctor", "Tax Collector",
								"Mathematician"};
	
	public charPanel()
	{
		// Create the combo box
		characterBox = new JComboBox(character);
		characterSelected = new JTextField(20);
		characterSelected.setEditable(false);
		characterSelected.setVisible(false);
		
	      // Register an action listener.
	      characterBox.addActionListener(new ComboBoxListener());
		
		//Add the combo box to the panel
		add(characterBox);
		add(characterSelected);
	}
	
	  private class ComboBoxListener implements ActionListener
	  {
	      public void actionPerformed(ActionEvent e)
	      {
	    		  String selection = (String) characterBox.getSelectedItem();
	    			  characterSelected.setText(selection);
	      }
	  }

	  public String getSelected()
	  {
		  try{
			  String selection = characterSelected.getText();
		  }
		  catch(NullPointerException e2)
		  {
			  return "";
		  }
		  return characterSelected.getText();
	  }
}

