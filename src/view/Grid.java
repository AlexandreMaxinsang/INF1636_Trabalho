package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


public class Grid extends JComponent{

	public int width;
    public int height;
    public int cellWidth;
    
 

    @Override
        public void paintComponent(Graphics g)
        {
    		
            width = this.getWidth() ; 
            height = this.getHeight();		
            cellWidth = height/15;
     
            Graphics2D g2d = (Graphics2D) g;
            Color ocean = new Color(0,119,190);

            //Make the background white
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0,0,this.getWidth(),this.getHeight());
            
           

            //Paint GameGrid lines
            g2d.setColor(Color.GRAY);
            for(int i=1; i<15; i++)
                g2d.drawLine(i*cellWidth,0,i*cellWidth,height);	
            for(int i=1; i<15; i++)
                g2d.drawLine(0,i*cellWidth,width,i*cellWidth);	
           
            
        }


}


