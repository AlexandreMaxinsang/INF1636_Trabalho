package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaEscolha extends JPanel implements MouseListener {
	
	ArrayList<Entity> objs;
	
	JButton b1= new JButton("Finalizar");
	Game game = new Game(this);
	public TelaEscolha() {
        setBackground(Color.WHITE);
        objs = new ArrayList<Entity>();
      
        
        objs.add(new Submarine(game,10,10,20,20));
        objs.add(new Submarine(game,40,10,20,20));
        objs.add(new Submarine(game,70,10,20,20));
        objs.add(new Submarine(game,100,10,20,20));
        
        objs.add(new Destroyer(game,10,40,20,20));
        objs.add(new Destroyer(game,70,40,20,20));
        objs.add(new Destroyer(game,130,40,20,20));
        
        objs.add(new Cruzadores(game,10,70,20,20));
        objs.add(new Cruzadores(game,120,70,20,20));
        
        objs.add(new Battleships(game,10,100,20,20));
        
        
        objs.add(new Hidroaviao(game,30,130,20,20));
        objs.add(new Hidroaviao(game,110,130,20,20));
        objs.add(new Hidroaviao(game,190,130,20,20));
        objs.add(new Hidroaviao(game,270,130,20,20));
        objs.add(new Hidroaviao(game,350,130,20,20));
        
        objs.add(new Tabuleiro(game,15,15,450,200,20));
        
        setLayout(null);
        b1.setBounds(300,500,100,30);
        this.add(b1);
        b1.setEnabled(false);
        
        addMouseListener(this);
    }
	public void update() {
		
		System.out.println("update");
        for(int i=0;i<objs.size();i++){
        	objs.get(i).update();
        }
        
        if(game.getnumeroShip()==15){
        	  b1.setEnabled(true);
        	
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
