package view;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
	public GameFrame(String s)
	{
		super(s);
		
		this.setLayout(null);
		
		Grid gamegrid1 =new Grid();
		Grid gamegrid2 =new Grid();
		gamegrid1.setBounds(50, 50,300,300);
		gamegrid2.setBounds(500, 50,300,300);
		
		JButton iniciar = new JButton("Iniciar");
		iniciar.setBounds(400, 400, 80,30);

		this.add(gamegrid1);
		this.add(gamegrid2);
		this.add(iniciar);
		
		setSize(900,600);
		setVisible(true);
	}
}