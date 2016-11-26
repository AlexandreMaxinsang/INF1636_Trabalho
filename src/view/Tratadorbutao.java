package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class Tratadorbutao implements ActionListener {

	
	Component c;
	public Tratadorbutao(Component x)
	{
		c=x;
	}
	public void actionPerformed(ActionEvent e)
	{
		c.setVisible(false);
	}

}
