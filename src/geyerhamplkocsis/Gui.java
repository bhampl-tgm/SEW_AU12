package geyerhamplkocsis;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * @author Patrick Kocsis
 */
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
	JTextArea input = new JTextArea(1,1);
	String selected_item = "ShiftCipher";
	
	public Gui(){
		this.setTitle("EncryptDecrypt");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		encrypt.addActionListener(new ButtonListener());
		decrypt.addActionListener(new ButtonListener());
		encryptmode.addItemListener(new ItemChangeListener());
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
	/**
	 * 
	 * @author Patrick Kocsis
	 *
	 */
	class ItemChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	          String selected_encryption =(String) event.getItem();
	          if(selected_encryption.equals("ShiftCipher")){
	        	  selected_item = "ShiftCipher";
	          }
	          if(selected_encryption.equals("KeyWordCipher")){
	        	  selected_item = "KeyWordCipher";
	          }
	          if(selected_encryption.equals("SubstituationCipher")){
	        	  selected_item = "SubstituationCipher";
	          }
	          if(selected_encryption.equals("MonoAlphabeticCipher")){
	        	  selected_item = "MonoAlphabeticCipher";
	          }
	       }
	    }       
	}
	/**
	 * 
	 * @author Patrick Kocsis
	 *
	 */
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton event =(JButton) e.getSource();
			/*
			 * Wenn der Button Encrypt gedrückt wird, wird mit dem gerade ausgewähltem 
			 * modus(String Wert in der JCombobox(=encryptmode)) 
			 * der Text  (in der JTexArea(=input) angegeben) Verschlüsselt(encrypted) 
			 */
			if(event.getText().equals("Encrypt")){
				if(selected_item.equals("ShiftCipher")){
		        	  String text_to_encrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "ShiftCipher");
		        	  ShiftCipher a = new ShiftCipher(2);
		        	  a.encrypt(text_to_encrypt);
		          }
		          if(selected_item.equals("KeyWordCipher")){
		        	  String text_to_encrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "KeyWordCipher");
		        	  KeywordCipher a = new KeywordCipher("test");
		        	  a.encrypt(text_to_encrypt);
		          }
		          if(selected_item.equals("SubstituationCipher")){
		        	  String text_to_encrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "SubstituationCipher");
		        	  SubstitutionCipher a = new SubstitutionCipher("test");
		        	  a.encrypt(text_to_encrypt);
		          }
		          if(selected_item.equals("MonoAlphabeticCipher")){
		        	  String text_to_encrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "MonoAlphabeticCipher");
		        	  MonoalphabeticCipher a = new MonoalphabeticCipher();
		        	  a.encrypt(text_to_encrypt);
		          }
			}
			/*
			 * Wenn der Button Decrypt gedrückt wird, wird mit dem gerade ausgewähltem 
			 * modus(String Wert in der JCombobox(=encryptmode)) 
			 * der Text  (in der JTexArea(=input) angegeben) Entschlüsselt(decrypted) 
			 */
			if(event.getText().equals("Decrypt")){
				if(selected_item.equals("ShiftCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "ShiftCipher");
		        	  ShiftCipher a = new ShiftCipher(2);
		        	  a.decrypt(text_to_decrypt);
		          }
		          if(selected_item.equals("KeyWordCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "KeyWordCipher");
		        	  KeywordCipher a = new KeywordCipher("test");
		        	  a.decrypt(text_to_decrypt);
		          }
		          if(selected_item.equals("SubstituationCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "SubstituationCipher");
		        	  SubstitutionCipher a = new SubstitutionCipher("test");
		        	  a.decrypt(text_to_decrypt);
		          }
		          if(selected_item.equals("MonoAlphabeticCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  JOptionPane.showMessageDialog(null, "MonoAlphabeticCipher");
		        	  MonoalphabeticCipher a = new MonoalphabeticCipher();
		        	  a.decrypt(text_to_decrypt);
		          }
			}
			
		}
	}
}
