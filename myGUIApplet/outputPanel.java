import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class outputPanel extends JPanel{

	
	// for the selection frame
	JPanel label;
	JPanel nameSelected;
	JPanel idSelected;
	JPanel charSelected;
	JPanel itemSelected;
	JTextField nameSelectedText;
	JTextField idSelectedText;
	JTextField charSelectedText;
	JTextField itemSelectedText;
	
	 JLabel img1;
	 JLabel img2;
	 JLabel img3;
	 JLabel img4;
	JLabel img5;
	JLabel img6;
	
	String id;
	String name;
	String character;
	String item;
	
	public outputPanel() throws NullPointerException
	{
		// Create a new window frame to store selection
	
		// Create a BorderLayout
		setLayout(new BorderLayout());
		
		buildLabelPanel();
		add(label, BorderLayout.NORTH);
		buildNameSelectedPanel();
		add(nameSelected, BorderLayout.WEST);
		buildIdSelectedPanel();
		add(idSelected, BorderLayout.CENTER);
		buildcharSelectedPanel();
		add(charSelected, BorderLayout.EAST);
		buildItemSelectedPanel();
		add(itemSelected, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void buildLabelPanel()
	{
		label = new JPanel();
		JLabel selection = new JLabel("You selected: ");
		label.add(selection);
		setVisible(true);
	}
	
	public void buildNameSelectedPanel()
	{
		nameSelected = new JPanel();
		JLabel nameSelectedLabel = new JLabel("Name: ");
		nameSelectedText = new JTextField(7);
		nameSelectedText.setText(name);
		nameSelectedText.setEditable(false);
		
		nameSelected.add(nameSelectedLabel);
		nameSelected.add(nameSelectedText);
		setVisible(true);
	}
	
	public void buildIdSelectedPanel()
	{
		idSelected = new JPanel();
		JLabel idSelectedLabel = new JLabel("ID: ");
		idSelectedText = new JTextField(20);
		idSelectedText.setText(id);
		idSelectedText.setEditable(false);
		
		idSelected.add(idSelectedLabel);
		idSelected.add(idSelectedText);
		setVisible(true);
	}
	
	public void buildcharSelectedPanel()
	{
		charSelected = new JPanel();
		JLabel charSelectedLabel = new JLabel("Character: ");
		charSelectedText = new JTextField(20);
		charSelectedText.setText(character);
		charSelectedText.setEditable(false);
		
		charSelected.add(charSelectedLabel);
		charSelected.add(charSelectedText);
		setVisible(true);
	}
	
	public void buildItemSelectedPanel()
	{
		itemSelected = new JPanel();
		itemSelected.setLayout(new FlowLayout());
		JLabel itemSelectedLabel = new JLabel("Item: ");
		itemSelectedText = new JTextField(15);
		itemSelectedText.setText(item);
		itemSelectedText.setEditable(false);
		
		itemSelected.add(itemSelectedLabel);
		itemSelected.add(itemSelectedText);
		
		// import all the images
		 img1 = new JLabel(new ImageIcon("img1.jpg"));
		 img2 = new JLabel(new ImageIcon("img2.jpg"));
		 img3 = new JLabel(new ImageIcon("img3.jpg"));
		 img4 = new JLabel(new ImageIcon("img4.jpg"));
		 img5 = new JLabel(new ImageIcon("img5.jpg"));
		 img6 = new JLabel(new ImageIcon("img6.jpg"));
		 
		 //add image to item panel
		 itemSelected.add(img1);
		 itemSelected.add(img2);
		 itemSelected.add(img3);
		 itemSelected.add(img4);
		 itemSelected.add(img5);
		 itemSelected.add(img6);
		 
		 // set them invisble
		 img1.setVisible(false);
		 img2.setVisible(false);
		 img3.setVisible(false);
		 img4.setVisible(false);
		 img5.setVisible(false);
		 img6.setVisible(false);
		 
		setVisible(true);	
	}
	
	//if item is chosen, it will be set visible
	public void displayImg()
	{	
		if( item.equals("Hat"))
		{
			img1.setVisible(true);
			img2.setVisible(false);
			img3.setVisible(false);
			img4.setVisible(false);
			img5.setVisible(false);
			img6.setVisible(false);
			
		}
		else if (item.equals("Jacket"))
		{			
			img2.setVisible(true);
			 img1.setVisible(false);
			 img3.setVisible(false);
			 img4.setVisible(false);
			 img5.setVisible(false);
			 img6.setVisible(false);
		}
		else if (item.equals("Tshirt"))
		{
			img5.setVisible(true);
			 img1.setVisible(false);
			 img2.setVisible(false);
			 img3.setVisible(false);
			 img4.setVisible(false);
			 img6.setVisible(false);
		}
		else if	(item.equals("Sneakers"))
		{
			img4.setVisible(true);
			 img1.setVisible(false);
			 img2.setVisible(false);
			 img3.setVisible(false);
			img5.setVisible(false);
			img6.setVisible(false);
		}
		else if (item.equals("Pants"))
		{
			img3.setVisible(true);
			 img1.setVisible(false);
			 img2.setVisible(false);
			 img4.setVisible(false);
			 img5.setVisible(false);
			 img6.setVisible(false);
		}
		else if(item.equals("Necklace"))
		{
		 img6.setVisible(true);
		 img1.setVisible(false);
		 img2.setVisible(false);
		 img3.setVisible(false);
		 img4.setVisible(false);
		 img5.setVisible(false);
		}	
		else
			;
	}
	
	//Set the selected items to a string
	
	//for id
	public void setID(String value)
	{
		StringBuilder temp = new StringBuilder();
		temp.replace(0, temp.length(), value);
		id = temp.toString();
		idSelectedText.setText(id);
	}
	
	//for name
	public void setName(String value)
	{
		StringBuilder temp = new StringBuilder();
		temp.replace(0, temp.length(), value);
		name = temp.toString();
		nameSelectedText.setText(name);
	}
	
	//for char
	public void setChar(String value)
	{
		StringBuilder temp = new StringBuilder();
		temp.replace(0, temp.length(), value);
		character = temp.toString();
		charSelectedText.setText(character);
	}
	
	//for item
	public void setItem(String value)
	{
		StringBuilder temp = new StringBuilder();
		temp.replace(0, temp.length(), value);
		item = temp.toString();
		itemSelectedText.setText(item);
	}
}
