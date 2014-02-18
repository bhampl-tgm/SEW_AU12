package geyerhamplkocsis;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
/**
 * @author Patrick Kocsis
 */
public class Gui extends JFrame {
	
	JPanel input_panel_mono = new JPanel();
	JPanel buttons_panel = new JPanel();
	JPanel combobox_panel = new JPanel();
	JButton encrypt = new JButton("Encrypt MonoCipher");
	JButton decrypt = new JButton("Decrypt MonoCipher");
	JButton encrypt2 = new JButton("Encrypt KeywordCipher");
	JButton decrypt2 = new JButton("Decrypt KeywordCipher");
	JButton encrypt3 = new JButton("Encrypt SubstitutionCipher");
	JButton decrypt3 = new JButton("Decrypt SubstitutionCipher");
	JButton encrypt4 = new JButton("Encrypt ShiftCipher");
	JButton decrypt4 = new JButton("Decrypt ShiftCipher");
	JButton copy_to_clipboard1 = new JButton("Copy MonoCipher Output to Clipboard");
	JButton copy_to_clipboard2 = new JButton("Copy KeywordCipher Output to Clipboard");
	JButton copy_to_clipboard3 = new JButton("Copy SubstitutionCipher Output to Clipboard");
	JButton copy_to_clipboard4 = new JButton("Copy ShiftCipher Output to Clipboard");
	JComboBox<String> encryptmode = new JComboBox<String>();
	String label_shiftci = "ShiftCipher";
	String label_keywoci = "KeyWordCipher";
	String label_substci = "SubstituationCipher";
	String label_monoalci = "MonoAlphabeticCipher";
	JTextArea input = new JTextArea(1,1);
	JTextArea output = new JTextArea(1,1);
	JTextArea input2 = new JTextArea(1,1);
	JTextArea output2 = new JTextArea(1,1);
	JTextArea input3 = new JTextArea(1,1);
	JTextArea output3 = new JTextArea(1,1);
	JTextArea input4 = new JTextArea(1,1);
	JTextArea output4 = new JTextArea(1,1);
	JTextArea keyword = new JTextArea(1,1);
	JTextArea subst_word = new JTextArea(1,1);
	JTextArea shift_num = new JTextArea(1,1);
	String selected_item = "ShiftCipher";
	
	public Gui(){
		JTabbedPane tabbedPane = new JTabbedPane();
		this.setTitle("EncryptDecrypt");
		this.setSize(700, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel input_panel_keyword_cipher= new JPanel();
		JPanel input_panel_subst_cipher = new JPanel();
		JPanel input_panel_shift_cipher = new JPanel();
		
		
		encrypt.addActionListener(new ButtonListener());
		decrypt.addActionListener(new ButtonListener());
		
		encrypt2.addActionListener(new ButtonListener());
		decrypt2.addActionListener(new ButtonListener());
		
		encrypt3.addActionListener(new ButtonListener());
		decrypt3.addActionListener(new ButtonListener());
		
		encrypt4.addActionListener(new ButtonListener());
		decrypt4.addActionListener(new ButtonListener());
		
		copy_to_clipboard1.addActionListener(new ButtonListener());
		copy_to_clipboard2.addActionListener(new ButtonListener());
		copy_to_clipboard3.addActionListener(new ButtonListener());
		copy_to_clipboard4.addActionListener(new ButtonListener());
		
		output.setEditable(false);
		output2.setEditable(false);
		output3.setEditable(false);
		output4.setEditable(false);

		/*
		 * 
		 */
		GridLayout input_layout = new GridLayout(4,2);
		input_layout.setVgap(10);
		input_layout.setHgap(0);
		input_panel_mono.setLayout(input_layout);
		input_panel_mono.add(new JLabel("Input"));
		input_panel_mono.add(input);
		input_panel_mono.add(new JLabel("Output"));
		input_panel_mono.add(output);
		input_panel_mono.add(encrypt);
		input_panel_mono.add(decrypt);
		input_panel_mono.add(copy_to_clipboard1);
		/*
		 * 
		 */
		GridLayout input_layout2 = new GridLayout(5,2);
		input_layout2.setVgap(10);
		input_layout2.setHgap(0);
		input_panel_keyword_cipher.setLayout(input_layout2);
		input_panel_keyword_cipher.add(new JLabel("Input"));
		input_panel_keyword_cipher.add(input2);
		input_panel_keyword_cipher.add(new JLabel("Output"));
		input_panel_keyword_cipher.add(output2);
		input_panel_keyword_cipher.add(new JLabel("KeyWord"));
		input_panel_keyword_cipher.add(keyword);
		input_panel_keyword_cipher.add(encrypt2);
		input_panel_keyword_cipher.add(decrypt2);
		input_panel_keyword_cipher.add(copy_to_clipboard2);
		
		/*
		 * 
		 */
		GridLayout input_layout3 = new GridLayout(5,2);
		input_layout3.setVgap(10);
		input_layout3.setHgap(0);
		input_panel_subst_cipher.setLayout(input_layout3);
		input_panel_subst_cipher.add(new JLabel("Input"));
		input_panel_subst_cipher.add(input3);
		input_panel_subst_cipher.add(new JLabel("Output"));
		input_panel_subst_cipher.add(output3);
		input_panel_subst_cipher.add(new JLabel("Substitute Word"));
		input_panel_subst_cipher.add(subst_word);
		input_panel_subst_cipher.add(encrypt3);
		input_panel_subst_cipher.add(decrypt3);
		input_panel_subst_cipher.add(copy_to_clipboard3);
		/*
		 * 
		 */
		
		GridLayout input_layout4 = new GridLayout(5,2);
		input_layout4.setVgap(10);
		input_layout4.setHgap(0);
		input_panel_shift_cipher.setLayout(input_layout4);
		input_panel_shift_cipher.add(new JLabel("Input"));
		input_panel_shift_cipher.add(input4);
		input_panel_shift_cipher.add(new JLabel("Output"));
		input_panel_shift_cipher.add(output4);
		input_panel_shift_cipher.add(new JLabel("Shift by Amount(only numbers)"));
		input_panel_shift_cipher.add(shift_num);
		input_panel_shift_cipher.add(encrypt4);
		input_panel_shift_cipher.add(decrypt4);
		input_panel_shift_cipher.add(copy_to_clipboard4);
		/*
		 * 
		 */
		tabbedPane.addTab("Monoalphabetic Cipher", input_panel_mono);
        tabbedPane.addTab("KeywordCipher", input_panel_keyword_cipher);
        tabbedPane.addTab("SubstitutionCipher", input_panel_subst_cipher);
        tabbedPane.addTab("ShiftCipher", input_panel_shift_cipher);
		this.add(tabbedPane,BorderLayout.CENTER);
		//this.add(buttons_panel,BorderLayout.SOUTH);
		//this.add(combobox_panel,BorderLayout.NORTH);
		this.setVisible(true);
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
			 * Wenn der Button Encrypt gedr��ckt wird, wird mit dem gerade ausgew��hltem 
			 * modus(String Wert in der JCombobox(=encryptmode)) 
			 * der Text  (in der JTexArea(=input) angegeben) Verschl��sselt(encrypted) 
			 */
			if(event.getText().equals("Encrypt MonoCipher")){
				String text_to_encrypt=input.getText();
	        	  MonoalphabeticCipher a = new MonoalphabeticCipher();
	        	  String encrypted=a.encrypt(text_to_encrypt);
	        	  output.setText(encrypted);
			}
			if(event.getText().equals("Encrypt KeywordCipher")){
				String text_to_encrypt=input2.getText();
	        	  KeywordCipher a = new KeywordCipher(keyword.getText());
	        	  String encrypted=a.encrypt(text_to_encrypt);
	        	  output2.setText(encrypted);
			}
			if(event.getText().equals("Encrypt SubstitutionCipher")){
				String text_to_encrypt=input3.getText();
	        	  SubstitutionCipher a = new SubstitutionCipher(subst_word.getText());
	        	  String encrypted=a.encrypt(text_to_encrypt);
	        	  output3.setText(encrypted);
			}
			if(event.getText().equals("Encrypt ShiftCipher")){
		        	  String text_to_encrypt=input4.getText();
		        	  ShiftCipher a = new ShiftCipher(Integer.parseInt(shift_num.getText()));
		        	  String encrypted=a.encrypt(text_to_encrypt);
		        	  output4.setText(encrypted);
			}
			
			
			
			if(event.getText().equals("Copy MonoCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (copy_to_clipboard1.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			if(event.getText().equals("Copy KeywordCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (copy_to_clipboard2.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			if(event.getText().equals("Copy SubstitutionCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (copy_to_clipboard3.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			if(event.getText().equals("Copy ShiftCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (copy_to_clipboard4.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			
			/*
			 * Wenn der Button Decrypt gedr��ckt wird, wird mit dem gerade ausgew��hltem 
			 * modus(String Wert in der JCombobox(=encryptmode)) 
			 * der Text  (in der JTexArea(=input) angegeben) Entschl��sselt(decrypted) 
			 */
			if(event.getText().equals("Decrypt")){
				if(selected_item.equals("ShiftCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  ShiftCipher a = new ShiftCipher(2);
		        	  String decrypted = a.decrypt(text_to_decrypt);
		        	  output.setText(decrypted);
		          }
		          if(selected_item.equals("KeyWordCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  KeywordCipher a = new KeywordCipher("test");
		        	  String decrypted = a.decrypt(text_to_decrypt);
		        	  output.setText(decrypted);
		          }
		          if(selected_item.equals("SubstituationCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  SubstitutionCipher a = new SubstitutionCipher("test");
		        	  String decrypted = a.decrypt(text_to_decrypt);
		        	  output.setText(decrypted);
		          }
		          if(selected_item.equals("MonoAlphabeticCipher")){
		        	  String text_to_decrypt=input.getText();
		        	  MonoalphabeticCipher a = new MonoalphabeticCipher();
		        	  String decrypted = a.decrypt(text_to_decrypt);
		        	  output.setText(decrypted);
		          }
			}
			
		}
	}
}
