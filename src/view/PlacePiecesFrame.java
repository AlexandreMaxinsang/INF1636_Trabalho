package view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PlacePiecesFrame extends JFrame {
	
	public PlacePiecesFrame(String s)
	{
		super(s);
		setSize(900,600);
		this.setLayout(null);
		
		
		int weight =this.getWidth();
		int height=this.getHeight();
		

		Grid gamegrid =new Grid();
		gamegrid.setBounds(weight-400,100,300,300);
		JButton iniciar = new JButton("Tubuleiro Pronto");
		iniciar.setBounds(300,500,200,30);
		

		this.add(gamegrid);
		this.add(iniciar);
		
		setVisible(true);
	}
}
