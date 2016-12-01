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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaEscolha extends JPanel implements MouseListener {
	
	ArrayList<Entity> objs;
	JButton b1= new JButton("Finalizar");
	
	Game game = new Game(this);
	Tabuleiro board;
	public TelaEscolha(String name) {
		
        setBackground(Color.WHITE);
        objs = new ArrayList<Entity>();
      
        objs.add(new Submarine(game,10,10,20,20,Orientacao.Leste));
        objs.add(new Submarine(game,40,10,20,20,Orientacao.Leste));
        objs.add(new Submarine(game,70,10,20,20,Orientacao.Leste));
        objs.add(new Submarine(game,100,10,20,20,Orientacao.Leste));
        
        objs.add(new Destroyer(game,10,40,20,20,Orientacao.Leste));
        objs.add(new Destroyer(game,70,40,20,20,Orientacao.Leste));
        objs.add(new Destroyer(game,130,40,20,20,Orientacao.Leste));
        
        objs.add(new Cruzadores(game,10,70,20,20,Orientacao.Leste));
        objs.add(new Cruzadores(game,120,70,20,20,Orientacao.Leste));
        
        objs.add(new Battleships(game,10,100,20,20,Orientacao.Leste));
        
        
        objs.add(new Hidroaviao(game,10,160,20,20,Orientacao.Leste));
        objs.add(new Hidroaviao(game,90,160,20,20,Orientacao.Leste));
        objs.add(new Hidroaviao(game,170,160,20,20,Orientacao.Leste));
        objs.add(new Hidroaviao(game,250,160,20,20,Orientacao.Leste));
        objs.add(new Hidroaviao(game,330,160,20,20,Orientacao.Leste));
        board = new Tabuleiro(game,15,15,450,200,20);
        objs.add(board);
        
        setLayout(null);
        b1.setBounds(300,500,100,30);
        b1.setEnabled(false);
        b1.addActionListener(new Tratadorbutao(this));
        this.add(b1);

        JLabel l=new JLabel(name);
        l.setBounds(350,10,100,30);
        this.add(l);
        
        addMouseListener(this);
    }
	public Tabuleiro getBoard(){
		return board;
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(SwingUtilities.isRightMouseButton(e) && Ship.selecionado==true)
		{
			game.changeOrientation(game.getselected());
		}
		if(SwingUtilities.isLeftMouseButton(e))
		{
			 for(int i=0;i<objs.size();i++){
				 if (objs.get(i).onclick(e)){
						repaint();
					}
		     }
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    

    
}
