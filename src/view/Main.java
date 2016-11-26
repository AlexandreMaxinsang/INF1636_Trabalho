package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Main extends JFrame{

	
	
	Main(){
		//addWindowListener(this);
        Tela tela = new Tela();
        this.add(tela);
        
	}
	
	public static void main(String[] args) {
		
        Main jFrame = new Main();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setVisible(true);
		jFrame.setLayout(null);

    }

	
	
	
}
