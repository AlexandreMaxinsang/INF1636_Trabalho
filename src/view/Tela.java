package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JPanel implements MouseListener {
	ArrayList<Entity> objs;
	public Tela() {
        setBackground(Color.WHITE);
        objs = new ArrayList<Entity>();
        Game game = new Game(this);
        objs.add(new Submarine(game,10,10,20,20));
        objs.add(new Submarine(game,40,10,20,20));
        objs.add(new Submarine(game,70,10,20,20));
        objs.add(new Submarine(game,100,10,20,20));
        objs.add(new Destroyer(game,10,40,20,20));

        objs.add(new Tabuleiro(game,15,15,50,200,20));

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
		
		 for(int i=0;i<objs.size();i++){
			 if (objs.get(i).onclick(arg0)){
					repaint();
				};
	     }
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    

    
}
