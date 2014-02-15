package geyerhamplkocsis;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui extends JFrame {
	JPanel input_panel = new JPanel();
	JPanel buttons_panel = new JPanel();
	JPanel combobox_panel = new JPanel();
	JButton encrypt = new JButton("Encrypt");
	JButton decrypt = new JButton("Decrypt");
	JComboBox<String> encryptmode = new JComboBox<String>();
	String label_shiftci = "ShiftCipher";
	String label_keywoci = "KeyWordCipher";
	String label_substci = "SubstituationCipher";
	String label_monoalci = "MonoAlphabeticCipher";
	JTextArea input = new JTextArea("Input");
	public Gui(){
		this.setTitle("EncryptDecrypt");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buttons_panel.setLayout(new GridLayout(2,1));
		
		
		
		encryptmode.addItem(label_shiftci);
		encryptmode.addItem(label_keywoci);
		encryptmode.addItem(label_substci);
		encryptmode.addItem(label_monoalci);
		combobox_panel.add(encryptmode);
		buttons_panel.add(encrypt);
		buttons_panel.add(decrypt);
		input_panel.add(input);
		
		
		this.add(input_panel,BorderLayout.CENTER);
		this.add(buttons_panel,BorderLayout.SOUTH);
		this.add(combobox_panel,BorderLayout.NORTH);
	}
}
