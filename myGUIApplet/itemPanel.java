import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class itemPanel extends JPanel
{
	private JList itemList;
	private JTextField itemSelected;
	
	//holds the array of items
	private String[] items = {"Jacket","Tshirt", "Sneakers", "Pants", "Hat", "Necklace"}; 
	
	public itemPanel()
	{
		// create the list
		itemList = new JList(items);
		itemSelected = new JTextField(16);
		itemSelected.setEditable(false);
		itemSelected.setVisible(false);
		
		//Set the selection mode to single selection
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		itemList.addListSelectionListener(new ListListener());
		
		//Set the number of visible rows to 4
		itemList.setVisibleRowCount(4);
		
		//add the list to a scroll pane
		JScrollPane scrollPane = new JScrollPane(itemList);		
		add(scrollPane);	
	}
	

	  //********************************************************
	  // Private inner class that handles the event when      *
	  // the user selects an item from the list.              *
	  //********************************************************

	  private class ListListener implements ListSelectionListener
	  {
	      public void valueChanged(ListSelectionEvent e)
	      {
	    	  // Get the selected string from the list.
	    	  String selection = (String) itemList.getSelectedValue();
	        
	    	  // Store the selected string in the text field.
	    	  itemSelected.setText(selection);
	      }
	  }

	  public String getSelected()
	  {
		 return itemSelected.getText();
	  }
	 
}
