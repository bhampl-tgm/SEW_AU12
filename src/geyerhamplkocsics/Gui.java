package geyerhamplkocsics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui extends JFrame {
	JPanel eingabe = new JPanel();
	JPanel buttons = new JPanel();
	
	public Gui(){
		this.setTitle("EncryptDecrypt");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
