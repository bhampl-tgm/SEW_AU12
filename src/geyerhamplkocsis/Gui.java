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
	JButton copy_output_to_input1 = new JButton("Copy MonoCipher Output to Input");
	JButton copy_output_to_input2 = new JButton("Copy KeywordCipher Output to Input");
	JButton copy_output_to_input3 = new JButton("Copy SubstitutionCipher Output to Input");
	JButton copy_output_to_input4 = new JButton("Copy ShiftCipher Output to Input");
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
		this.setSize(700, 300);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
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
		
		copy_output_to_input1.addActionListener(new ButtonListener());
		copy_output_to_input2.addActionListener(new ButtonListener());
		copy_output_to_input3.addActionListener(new ButtonListener());
		copy_output_to_input4.addActionListener(new ButtonListener());
		
		output.setEditable(false);
		output2.setEditable(false);
		output3.setEditable(false);
		output4.setEditable(false);		
		/*
		 * 
		 */
		
		GridLayout input_layout = new GridLayout(2,2);
		input_layout.setVgap(10);
		input_layout.setHgap(0);
		input_panel_mono.setLayout(input_layout);
		input_panel_mono.add(new JLabel("Input"));
		input_panel_mono.add(input);
		input_panel_mono.add(new JLabel("Output"));
		input_panel_mono.add(output);
		
		JPanel buttons_mono = new JPanel();
		buttons_mono.add(encrypt);
		buttons_mono.add(decrypt);
		buttons_mono.add(copy_to_clipboard1);
		buttons_mono.add(copy_output_to_input1);
		
		JPanel panel_mono = new JPanel(new BorderLayout());
		panel_mono.add(input_panel_mono,BorderLayout.NORTH);
		panel_mono.add(buttons_mono,BorderLayout.CENTER);
		/*
		 * 
		 */
		GridLayout input_layout2 = new GridLayout(3,2);
		input_layout2.setVgap(10);
		input_layout2.setHgap(0);
		input_panel_keyword_cipher.setLayout(input_layout2);
		input_panel_keyword_cipher.add(new JLabel("Input"));
		input_panel_keyword_cipher.add(input2);
		input_panel_keyword_cipher.add(new JLabel("Output"));
		input_panel_keyword_cipher.add(output2);
		input_panel_keyword_cipher.add(new JLabel("KeyWord"));
		input_panel_keyword_cipher.add(keyword);
		
		JPanel buttons_keyword = new JPanel();
		buttons_keyword.add(encrypt2);
		buttons_keyword.add(decrypt2);
		buttons_keyword.add(copy_to_clipboard2);
		buttons_keyword.add(copy_output_to_input2);
		
		JPanel panel_keyword = new JPanel(new BorderLayout());
		panel_keyword.add(input_panel_keyword_cipher,BorderLayout.NORTH);
		panel_keyword.add(buttons_keyword,BorderLayout.CENTER);
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
		input_panel_subst_cipher.add(new JLabel("Alternative Alphabet(30 Letters)"));
		input_panel_subst_cipher.add(subst_word);

		
		JPanel buttons_subst = new JPanel();
		buttons_subst.add(encrypt3);
		buttons_subst.add(decrypt3);
		buttons_subst.add(copy_to_clipboard3);
		buttons_subst.add(copy_output_to_input3);
		
		JPanel panel_subst = new JPanel(new BorderLayout());
		panel_subst.add(input_panel_subst_cipher,BorderLayout.NORTH);
		panel_subst.add(buttons_subst,BorderLayout.CENTER);
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
		
		JPanel buttons_shift = new JPanel();
		buttons_shift.add(encrypt4);
		buttons_shift.add(decrypt4);
		buttons_shift.add(copy_to_clipboard4);
		buttons_shift.add(copy_output_to_input4);
		
		JPanel panel_shift = new JPanel(new BorderLayout());
		panel_shift.add(input_panel_shift_cipher,BorderLayout.NORTH);
		panel_shift.add(buttons_shift,BorderLayout.CENTER);
		/*
		 * 
		 */
		tabbedPane.addTab("Monoalphabetic Cipher", panel_mono);
        tabbedPane.addTab("KeywordCipher", panel_keyword);
        tabbedPane.addTab("SubstitutionCipher", panel_subst);
        tabbedPane.addTab("ShiftCipher", panel_shift);
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
					String alpha = "";
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
			
			/*
			 * Das sind die 
			 */
			
			if(event.getText().equals("Copy MonoCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (output.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			if(event.getText().equals("Copy KeywordCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (output2.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			if(event.getText().equals("Copy SubstitutionCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (output3.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			if(event.getText().equals("Copy ShiftCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (output4.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
			/*
			 *Das sind die Output to Input buttons
			 */
			if(event.getText().equals("Copy MonoCipher Output to Input")){
				input.setText(output.getText());
			}
			if(event.getText().equals("Copy KeywordCipher Output to Input")){
				input2.setText(output2.getText());
			}
			if(event.getText().equals("Copy SubstitutionCipher Output to Input")){
				input3.setText(output3.getText());
			}
			if(event.getText().equals("Copy ShiftCipher Output to Input")){
				input4.setText(output4.getText());
			}
			
			
			/*
			 * Wenn der Button Decrypt gedr��ckt wird, wird mit dem gerade ausgew��hltem 
			 * modus(String Wert in der JCombobox(=encryptmode)) 
			 * der Text  (in der JTexArea(=input) angegeben) Entschl��sselt(decrypted) 
			 */
			
			if(event.getText().equals("Decrypt MonoCipher")){
				String text_to_decrypt=input.getText();
	        	  MonoalphabeticCipher a = new MonoalphabeticCipher();
	        	  String decrypted=a.decrypt(text_to_decrypt);
	        	  output.setText(decrypted);
			}
			if(event.getText().equals("Decrypt KeywordCipher")){
				String text_to_decrypt=input2.getText();
	        	  KeywordCipher a = new KeywordCipher(keyword.getText());
	        	  String decrypted=a.decrypt(text_to_decrypt);
	        	  output2.setText(decrypted);
			}
			if(event.getText().equals("Decrypt SubstitutionCipher")){
				String text_to_decrypt=input3.getText();
	        	  SubstitutionCipher a = new SubstitutionCipher(subst_word.getText());
	        	  String decrypted=a.decrypt(text_to_decrypt);
	        	  output3.setText(decrypted);
			}
			if(event.getText().equals("Decrypt ShiftCipher")){
		        	  String text_to_decrypt=input4.getText();
		        	  ShiftCipher a = new ShiftCipher(Integer.parseInt(shift_num.getText()));
		        	  String decrypted=a.decrypt(text_to_decrypt);
		        	  output4.setText(decrypted);
			}
			
			
		}
	}
}
