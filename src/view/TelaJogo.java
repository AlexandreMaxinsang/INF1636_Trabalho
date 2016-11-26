package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaJogo extends JPanel implements MouseListener {

	ArrayList<Entity> objs;
	
public TelaJogo(String name, Game game) {
		
        setBackground(Color.WHITE);
      
        objs.add(new Tabuleiro(game,15,15,450,200,20));
        
        objs.add(new Tabuleiro(game,15,15,150,200,20));

        JLabel l=new JLabel(name);
        l.setBounds(350,10,100,30);
        this.add(l);
        
        addMouseListener(this);
    }

public void update() {
	
	System.out.println("update");
    for(int i=0;i<objs.size();i++){
    	objs.get(i).update();
    }
   
   
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i=0;i<objs.size();i++){
    	objs.get(i).draw(g);
    }
}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
