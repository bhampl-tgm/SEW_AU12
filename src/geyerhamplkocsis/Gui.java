package geyerhamplkocsis;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui extends JFrame {
	JPanel eingabe = new JPanel();
	JPanel buttons = new JPanel();
	JPanel combobox = new JPanel();
	JButton encrypt = new JButton();
	JButton decrypt = new JButton();
	JComboBox encryptmethode = new JComboBox();
	
	public Gui(){
		this.setTitle("EncryptDecrypt");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		eingabe.setLayout(new BorderLayout());
		buttons.setLayout(new BorderLayout());
		combobox.setLayout(new BorderLayout());
		
		
		this.add(eingabe,BorderLayout.CENTER);
		this.add(buttons,BorderLayout.SOUTH);
		this.add(combobox,BorderLayout.WEST);
		
	}
}
