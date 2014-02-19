package geyerhamplkocsis;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * @author Patrick Kocsis
 */
public class Gui extends JFrame {

	protected JButton encrypt2 = new JButton("Encrypt KeywordCipher");
    protected JButton decrypt2 = new JButton("Decrypt KeywordCipher");
    protected JButton encrypt3 = new JButton("Encrypt SubstitutionCipher");
    protected JButton decrypt3 = new JButton("Decrypt SubstitutionCipher");
    protected JButton encrypt4 = new JButton("Encrypt ShiftCipher");
    protected JButton decrypt4 = new JButton("Decrypt ShiftCipher");
    protected JButton copy_to_clipboard2 = new JButton("Copy KeywordCipher Output to Clipboard");
    protected JButton copy_to_clipboard3 = new JButton("Copy SubstitutionCipher Output to Clipboard");
    protected JButton copy_to_clipboard4 = new JButton("Copy ShiftCipher Output to Clipboard");
    protected JButton copy_output_to_input2 = new JButton("Copy KeywordCipher Output to Input");
    protected JButton copy_output_to_input3 = new JButton("Copy SubstitutionCipher Output to Input");
    protected JButton copy_output_to_input4 = new JButton("Copy ShiftCipher Output to Input");
    protected JTextArea input = new JTextArea(1,1);
    protected JTextArea output = new JTextArea(1,1);
    protected JTextArea input2 = new JTextArea(1,1);
    protected JTextArea output2 = new JTextArea(1,1);
    protected JTextArea input3 = new JTextArea(1,1);
    protected JTextArea output3 = new JTextArea(1,1);
    protected JTextArea input4 = new JTextArea(1,1);
    protected JTextArea output4 = new JTextArea(1,1);
    protected JTextArea keyword = new JTextArea(1,1);
    protected JTextArea subst_word = new JTextArea(1,1);
    protected JTextArea shift_num = new JTextArea(1,1);
    protected String zwischensp="q";
	
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

		encrypt2.addActionListener(new ButtonListener());
		decrypt2.addActionListener(new ButtonListener());
		
		encrypt3.addActionListener(new ButtonListener());
		decrypt3.addActionListener(new ButtonListener());
		
		encrypt4.addActionListener(new ButtonListener());
		decrypt4.addActionListener(new ButtonListener());

		copy_to_clipboard2.addActionListener(new ButtonListener());
		copy_to_clipboard3.addActionListener(new ButtonListener());
		copy_to_clipboard4.addActionListener(new ButtonListener());

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
		GridLayout input_layout2 = new GridLayout(3,2);
		input_layout2.setVgap(10);
		input_layout2.setHgap(0);
		input_panel_keyword_cipher.setLayout(input_layout2);
		input_panel_keyword_cipher.add(new JLabel("Input"));
		input_panel_keyword_cipher.add(input2);
		input_panel_keyword_cipher.add(new JLabel("KeyWord"));
		input_panel_keyword_cipher.add(keyword);
		input_panel_keyword_cipher.add(new JLabel("Output"));
		input_panel_keyword_cipher.add(output2);
		
		
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
		input_panel_subst_cipher.add(new JLabel("Alternative Alphabet(30 Letters)"));
		input_panel_subst_cipher.add(subst_word);
		input_panel_subst_cipher.add(new JLabel("Output"));
		input_panel_subst_cipher.add(output3);

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
		input_panel_shift_cipher.add(new JLabel("Shift by Amount(only numbers)"));
		input_panel_shift_cipher.add(shift_num);
		input_panel_shift_cipher.add(new JLabel("Output"));
		input_panel_shift_cipher.add(output4);
		JPanel buttons_shift = new JPanel();
		buttons_shift.add(encrypt4);
		buttons_shift.add(decrypt4);
		buttons_shift.add(copy_to_clipboard4);
		buttons_shift.add(copy_output_to_input4);
        /*
         *
         */
		JPanel panel_shift = new JPanel(new BorderLayout());
		panel_shift.add(input_panel_shift_cipher,BorderLayout.NORTH);
		panel_shift.add(buttons_shift,BorderLayout.CENTER);
		/*
		 * 
		 */
        tabbedPane.addTab("KeywordCipher", panel_keyword);
        tabbedPane.addTab("SubstitutionCipher", panel_subst);
        tabbedPane.addTab("ShiftCipher", panel_shift);
		this.add(tabbedPane,BorderLayout.CENTER);
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
			 * Wenn der Button Encrypt gedrückt wird, wird je nach dem gerade ausgewähltem 
			 * Tab der Text  (in der JTexArea(=input angegeben) und Verschlüsselt(encrypted) 
			 */
			if(event.getText().equals("Encrypt KeywordCipher")){
                String keyword1=keyword.getText();
				String text_to_encrypt=input2.getText();
                boolean good =false;
                while(good == false){
				  try{
	        	    KeywordCipher a = new KeywordCipher(keyword1);
                    String encrypted=a.encrypt(text_to_encrypt);
                    output2.setText(encrypted);
                    good=true;
                  }catch(IllegalArgumentException e1){
                    good=false;
                    keyword1=JOptionPane.showInputDialog("Wrong Keyword!\n(1)Keyword has to be shorter than 30 and longer than 0\n(2)Keyword cant contain numeric Characters\n(3)Keyword cant contain a Character twice");
                   }
                }
			}
			if(event.getText().equals("Encrypt SubstitutionCipher")){
				String text_to_encrypt=input3.getText();
                String substword=subst_word.getText();
                boolean good=false;
                while(good == false)
				try{
	        	  SubstitutionCipher a = new SubstitutionCipher(substword);
                    good=true;
                    String encrypted=a.encrypt(text_to_encrypt);
                    output3.setText(encrypted);
                }catch (IllegalArgumentException e1){
                    substword=JOptionPane.showInputDialog("Wrong Input:\n Input Alphabet like (abcdefghijklmnopqrstuvwxyzäöüß)");
                    good = false;
                }

			}
			if(event.getText().equals("Encrypt ShiftCipher")){
		        	  String text_to_encrypt=input4.getText();
		        	  ShiftCipher a = new ShiftCipher(Integer.parseInt(shift_num.getText()));
		        	  String encrypted=a.encrypt(text_to_encrypt);
		        	  output4.setText(encrypted);
			}
			/*
			 * Das sind die buttons mit dem man den Output zum Clipboard geben kann(für jedes Tab )
			 */
			if(event.getText().equals("Copy KeywordCipher Output to Clipboard")){
				StringSelection stringSelection = new StringSelection (output2.getText());//Hier wird der text in ein StringSelection(welcher ins Clipboard gepeichert werden soll) gespeichert
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();    //Hier wird das Clipboard aufgerufen
				clpbrd.setContents (stringSelection, null);                               //Hier wird der oben gepeicherte Text ins Clipboard gespeichert
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
			 *Das sind die Output to Input buttons pro Tab
			 */

			if(event.getText().equals("Copy KeywordCipher Output to Input")){
				input2.setText(output2.getText()); //Der output Text wird in das input feld kopiert
                output2.setText("");    //Die Outbut JTextArea wird geleert
			}
			if(event.getText().equals("Copy SubstitutionCipher Output to Input")){
				input3.setText(output3.getText());
                output3.setText("");
			}
			if(event.getText().equals("Copy ShiftCipher Output to Input")){
				input4.setText(output4.getText());
                output4.setText("");
			}
			/*
			 * Wenn der Button Decrypt gedückt wird, wird mit dem gerade ausgewähltem Tab
			 * der Text  (in der JTexArea(=input) angegeben) Entschlüsselt(decrypted) 
			 */
			if(event.getText().equals("Decrypt KeywordCipher")){
                String keyword1=keyword.getText();
                String text_to_decrypt=input2.getText();
                boolean good =false;
                while(good == false){
                    try{
                        KeywordCipher a = new KeywordCipher(keyword1);
                        String decrypted=a.decrypt(text_to_decrypt);
                        output2.setText(decrypted);
                        good=true;
                    }catch(IllegalArgumentException e1){
                        good=false;
                        keyword1=JOptionPane.showInputDialog("Wrong Keyword!\n(1)Keyword has to be shorter than 30 and longer than 0\n(2)Keyword cant contain numeric Characters\n(3)Keyword cant contain a Character twice");
                    }
                }
            }
			if(event.getText().equals("Decrypt SubstitutionCipher")){
                String text_to_decrypt=input3.getText();
                String substword=subst_word.getText();
                boolean good=false;
                while(good == false)
                    try{
                        SubstitutionCipher a = new SubstitutionCipher(substword);
                        good=true;
                        String decrypted=a.decrypt(text_to_decrypt);
                        output3.setText(decrypted);
                    }catch (IllegalArgumentException e1){
                        substword=JOptionPane.showInputDialog("Wrong Input:\n Input Alphabet like (abcdefghijklmnopqrstuvwxyzäöüß)");
                        good = false;
                    }
            }
			if(event.getText().equals("Decrypt ShiftCipher")){
		        String text_to_decrypt=input4.getText();
                int shift_amount=0;
                boolean fail=false;
                boolean good= false;
                while(good == false){
                    try{
                        if(fail == false){
                           shift_amount=Integer.parseInt(shift_num.getText());
                       }
                      shift_amount=Integer.parseInt(zwischensp);
                        good=true;
                 }catch(NumberFormatException e1){
                            zwischensp=JOptionPane.showInputDialog("Wrong input!\nJust numbers please!");
                       fail=true;
                        good=false;
                }
                  }
		        ShiftCipher a = new ShiftCipher(shift_amount);
		        String decrypted=a.decrypt(text_to_decrypt);
		        output4.setText(decrypted);
			}
		}
	}
}
