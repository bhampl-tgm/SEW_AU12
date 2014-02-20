package geyerhamplkocsis;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Patrick Kocsis
 */
public class Gui extends JFrame {

	protected JButton encrypt_keyword = new JButton("Encrypt KeywordCipher");
	protected JButton decrypt_keyword = new JButton("Decrypt KeywordCipher");
	protected JButton encrypt_subst = new JButton("Encrypt SubstitutionCipher");
	protected JButton decrypt_subst = new JButton("Decrypt SubstitutionCipher");
	protected JButton encrypt_shift = new JButton("Encrypt ShiftCipher");
	protected JButton decrypt_shift = new JButton("Decrypt ShiftCipher");
	protected JButton copy_to_clipboard_keyword = new JButton("Copy KeywordCipher Output to Clipboard");
	protected JButton copy_to_clipboard_subst = new JButton("Copy SubstitutionCipher Output to Clipboard");
	protected JButton copy_to_clipboard_shift = new JButton("Copy ShiftCipher Output to Clipboard");
	protected JButton copy_output_to_input_keyword = new JButton("Copy KeywordCipher Output to Input");
	protected JButton copy_output_to_input_subst = new JButton("Copy SubstitutionCipher Output to Input");
	protected JButton copy_output_to_input_shift = new JButton("Copy ShiftCipher Output to Input");
	protected JTextArea input_keyword = new JTextArea(1, 1);
	protected JTextArea output_keyword = new JTextArea(1, 1);
	protected JTextArea input_subst = new JTextArea(1, 1);
	protected JTextArea output_subst = new JTextArea(1, 1);
	protected JTextArea input_shift = new JTextArea(1, 1);
	protected JTextArea output_shift = new JTextArea(1, 1);
	protected JTextArea keyword = new JTextArea(1, 1);
	protected JTextArea subst_alpha = new JTextArea(1, 1);
	protected JTextArea shift_num = new JTextArea(1, 1);
	protected String zwischensp = ""; //Für eingabecheck bei ShiftCipher

	public Gui() {

		JTabbedPane tabbedPane = new JTabbedPane();
		this.setTitle("EncryptDecrypt");
		this.setSize(700, 220);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel input_panel_keyword_cipher = new JPanel();
		JPanel input_panel_subst_cipher = new JPanel();
		JPanel input_panel_shift_cipher = new JPanel();

		encrypt_keyword.addActionListener(new ButtonListener());
		decrypt_keyword.addActionListener(new ButtonListener());

		encrypt_subst.addActionListener(new ButtonListener());
		decrypt_subst.addActionListener(new ButtonListener());

		encrypt_shift.addActionListener(new ButtonListener());
		decrypt_shift.addActionListener(new ButtonListener());

		copy_to_clipboard_keyword.addActionListener(new ButtonListener());
		copy_to_clipboard_subst.addActionListener(new ButtonListener());
		copy_to_clipboard_shift.addActionListener(new ButtonListener());

		copy_output_to_input_keyword.addActionListener(new ButtonListener());
		copy_output_to_input_subst.addActionListener(new ButtonListener());
		copy_output_to_input_shift.addActionListener(new ButtonListener());

		output_keyword.setEditable(false);
		output_subst.setEditable(false);
		output_shift.setEditable(false);

		/*
		 * Das ist der KeywordCipher Tab
		 */
		//Hier habe ich das Layout für das Buttons Panel eingestellt(Layout für Input,JLabel)
		GridLayout input_layout2 = new GridLayout(3, 2);
		input_layout2.setVgap(10);
		input_layout2.setHgap(0);
		//Das sind die JTextArea und die JLabels welche in diesem Tab verwendet wurden(in das input_panel_keyword_cipher JPanel geaddet)(Input,JLabel JPanel)
		input_panel_keyword_cipher.setLayout(input_layout2);
		input_panel_keyword_cipher.add(new JLabel("Input"));
		input_panel_keyword_cipher.add(input_keyword);
		input_panel_keyword_cipher.add(new JLabel("KeyWord"));
		input_panel_keyword_cipher.add(keyword);
		input_panel_keyword_cipher.add(new JLabel("Output"));
		input_panel_keyword_cipher.add(output_keyword);
		//Das sind die Buttons welche in diesem Tab verwendet wurden(in das buttons_keyword JPanel geaddet)(Buttons JPanel)
		JPanel buttons_keyword = new JPanel();
		buttons_keyword.add(encrypt_keyword);
		buttons_keyword.add(decrypt_keyword);
		buttons_keyword.add(copy_to_clipboard_keyword);
		buttons_keyword.add(copy_output_to_input_keyword);
		//Das ist von diesem Tab das Main Panel, welches in das tabbedPane geaddet wird.Es beinhaltet die 2 JPanels (Main JPanel)
		JPanel panel_keyword = new JPanel(new BorderLayout());
		panel_keyword.add(input_panel_keyword_cipher, BorderLayout.NORTH);
		panel_keyword.add(buttons_keyword, BorderLayout.CENTER);
		/*
		 * Das ist der SubstitutionCipher Tab
		 */
		//Layout für Input,JLabel
		GridLayout input_layout3 = new GridLayout(3, 2);
		input_layout3.setVgap(10);
		input_layout3.setHgap(0);
		//Input,JLabel JPanel
		input_panel_subst_cipher.setLayout(input_layout3);
		input_panel_subst_cipher.add(new JLabel("Input"));
		input_panel_subst_cipher.add(input_subst);
		input_panel_subst_cipher.add(new JLabel("Alternative Alphabet(30 Letters)"));
		input_panel_subst_cipher.add(subst_alpha);
		input_panel_subst_cipher.add(new JLabel("Output"));
		input_panel_subst_cipher.add(output_subst);
		//Buttons JPanel
		JPanel buttons_subst = new JPanel();
		buttons_subst.add(encrypt_subst);
		buttons_subst.add(decrypt_subst);
		buttons_subst.add(copy_to_clipboard_subst);
		buttons_subst.add(copy_output_to_input_subst);
		//Main JPanel
		JPanel panel_subst = new JPanel(new BorderLayout());
		panel_subst.add(input_panel_subst_cipher, BorderLayout.NORTH);
		panel_subst.add(buttons_subst, BorderLayout.CENTER);
		/*
		 * Das ist der ShiftCipher Tab
		 */
		//Layout für Input,JLabel
		GridLayout input_layout4 = new GridLayout(3, 2);
		input_layout4.setVgap(10);
		input_layout4.setHgap(0);
		// Input,JLabel JPanel
		input_panel_shift_cipher.setLayout(input_layout4);
		input_panel_shift_cipher.add(new JLabel("Input"));
		input_panel_shift_cipher.add(input_shift);
		input_panel_shift_cipher.add(new JLabel("Shift by Amount(only numbers)"));
		input_panel_shift_cipher.add(shift_num);
		input_panel_shift_cipher.add(new JLabel("Output"));
		input_panel_shift_cipher.add(output_shift);
		// Buttons JPanel
		JPanel buttons_shift = new JPanel();
		buttons_shift.add(encrypt_shift);
		buttons_shift.add(decrypt_shift);
		buttons_shift.add(copy_to_clipboard_shift);
		buttons_shift.add(copy_output_to_input_shift);
		//Main JPanel
		JPanel panel_shift = new JPanel(new BorderLayout());
		panel_shift.add(input_panel_shift_cipher, BorderLayout.NORTH);
		panel_shift.add(buttons_shift, BorderLayout.CENTER);
		/*
		 * Hier werden die Tabs(Main JPanels) zum TabbedPane geaddet
		 */
		tabbedPane.addTab("KeywordCipher", panel_keyword);
		tabbedPane.addTab("SubstitutionCipher", panel_subst);
		tabbedPane.addTab("ShiftCipher", panel_shift);
		/*
		 * Hier wird das TabbedPane zum JFrame geaddet
		 */
		this.add(tabbedPane, BorderLayout.CENTER);
		this.setVisible(true);
	}

	/**
	 * @author Patrick Kocsis
	 */
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton event = (JButton) e.getSource();
			/*
			 * Wenn der Button Encrypt gedrückt wird, wird je nach dem gerade ausgewähltem 
			 * Tab der Text  (in der JTexArea(=input angegeben) und Verschlüsselt(encrypted) 
			 */
			if (event.getText().equals("Encrypt KeywordCipher")) {
				//In diese Variable wird das Keyword gepeichert
				String keyword1 = keyword.getText();
				//Input welcher Verschlüsselt werden soll
				String text_to_encrypt = input_keyword.getText();
				boolean good = false;
				//Hier wird gecheckt ob ein richtiger Keyword eingegeben wurde
				while (good == false) {
					try {
						//Wenn das KeyWord nicht stimmt wirft diese Zeile eine Exception
						KeywordCipher a = new KeywordCipher(keyword1);
						//text wird verschlüsselt
						String encrypted = a.encrypt(text_to_encrypt);
						output_keyword.setText(encrypted);
						keyword.setText(keyword1);
						good = true;
					} catch (IllegalArgumentException e1) {
						//Die Check varibale wird auf false gesetzt sodass die Methode nochmal versucht den Text zu verschlüsseln,
						// wenn wieder eine falsche eingabe kommt wird diese Exception nocheinnmal aufgerufen
						good = false;
						keyword1 = JOptionPane.showInputDialog("Wrong Keyword!\n(1)Keyword has to be shorter than 30 and longer than 0\n(2)Keyword cant contain numeric Characters\n(3)Keyword cant contain a Character twice");
					}
				}
			}
			if (event.getText().equals("Encrypt SubstitutionCipher")) {
				//Alles gleich wie bei KeywordCipher nur mit subst
				String text_to_encrypt = input_subst.getText();
				String substword = subst_alpha.getText();
				boolean good = false;
				while (good == false)
					try {
						SubstitutionCipher a = new SubstitutionCipher(substword);
						good = true;
						subst_alpha.setText(substword);
						String encrypted = a.encrypt(text_to_encrypt);
						output_subst.setText(encrypted);
					} catch (IllegalArgumentException e1) {
						substword = JOptionPane.showInputDialog("Wrong Input:\n Input Alphabet like (abcdefghijklmnopqrstuvwxyzäöüß)");
						good = false;
					}

			}
			if (event.getText().equals("Encrypt ShiftCipher")) {
				String text_to_encrypt = input_shift.getText();
				int shift_amount = 0;
				boolean fail = false;
				boolean good = false;
				while (good == false) {
					try {
						if (fail == false) {
							shift_amount = Integer.parseInt(shift_num.getText());
						}
						shift_amount = Integer.parseInt(zwischensp);
						shift_num.setText("" + shift_amount);
						good = true;
					} catch (NumberFormatException e1) {
						zwischensp = JOptionPane.showInputDialog("Wrong input!\nJust numbers please!");
						fail = true;
						good = false;
					}
				}


				ShiftCipher a = new ShiftCipher(Integer.parseInt(shift_num.getText()));
				String encrypted = a.encrypt(text_to_encrypt);
				output_shift.setText(encrypted);
			}
			/*
			 * Das sind die buttons mit dem man den Output zum Clipboard geben kann(für jedes Tab )
			 */
			if (event.getText().equals("Copy KeywordCipher Output to Clipboard")) {
				StringSelection stringSelection = new StringSelection(output_keyword.getText()); //Hier wird der text in ein StringSelection(welcher ins Clipboard gepeichert werden soll) gespeichert
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();             //Hier wird das Clipboard aufgerufen
				clpbrd.setContents(stringSelection, null);                                       //Hier wird der oben gepeicherte Text ins Clipboard gespeichert
			}
			if (event.getText().equals("Copy SubstitutionCipher Output to Clipboard")) {
				StringSelection stringSelection = new StringSelection(output_subst.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
			if (event.getText().equals("Copy ShiftCipher Output to Clipboard")) {
				StringSelection stringSelection = new StringSelection(output_shift.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
			/*
			 *Das sind die Output to Input buttons pro Tab
			 */

			if (event.getText().equals("Copy KeywordCipher Output to Input")) {
				input_keyword.setText(output_keyword.getText()); //Der output Text wird in das input feld kopiert
				output_keyword.setText("");    //Die Outbut JTextArea wird geleert
			}
			if (event.getText().equals("Copy SubstitutionCipher Output to Input")) {
				input_subst.setText(output_subst.getText());
				output_subst.setText("");
			}
			if (event.getText().equals("Copy ShiftCipher Output to Input")) {
				input_shift.setText(output_shift.getText());
				output_shift.setText("");
			}
			/*
			 * Wenn der Button Decrypt gedückt wird, wird mit dem gerade ausgewähltem Tab
			 * der Text  (in der JTexArea(=input) angegeben) Entschlüsselt(decrypted) 
			 */
			if (event.getText().equals("Decrypt KeywordCipher")) {
				//In diese Variable wird das Keyword gepeichert
				String keyword1 = keyword.getText();
				//Input welcher Verschlüsselt werden soll
				String text_to_decrypt = input_keyword.getText();
				boolean good = false;
				//Hier wird gecheckt ob ein richtiger Keyword eingegeben wurde
				while (good == false) {
					try {
						//Wenn das KeyWord nicht stimmt wirft diese Zeile eine Exception
						KeywordCipher a = new KeywordCipher(keyword1);
						//text wird entschlüsselt
						String decrypted = a.decrypt(text_to_decrypt);
						output_keyword.setText(decrypted);
						keyword.setText(keyword1);
						good = true;
					} catch (IllegalArgumentException e1) {
						//Die Check varibale wird auf false gesetzt sodass die Methode nochmal versucht den Text zu entschlüsseln,
						// wenn wieder eine falsche eingabe kommt wird diese Exception nocheinmal aufgerufen
						good = false;
						keyword1 = JOptionPane.showInputDialog("Wrong Keyword!\n(1)Keyword has to be shorter than 30 and longer than 0\n(2)Keyword cant contain numeric Characters\n(3)Keyword cant contain a Character twice");
					}
				}
			}
			if (event.getText().equals("Decrypt SubstitutionCipher")) {
				//Alles gleich wie bei KeywordCipher nur mit subst
				String text_to_decrypt = input_subst.getText();
				String substword = subst_alpha.getText();
				boolean good = false;
				while (good == false)
					try {
						SubstitutionCipher a = new SubstitutionCipher(substword);
						good = true;
						subst_alpha.setText(substword);
						String decrypted = a.decrypt(text_to_decrypt);
						output_subst.setText(decrypted);
					} catch (IllegalArgumentException e1) {
						substword = JOptionPane.showInputDialog("Wrong Input:\n Input Alphabet like (abcdefghijklmnopqrstuvwxyzäöüß)");
						good = false;
					}
			}
			if (event.getText().equals("Decrypt ShiftCipher")) {
				String text_to_decrypt = input_shift.getText();
				int shift_amount = 0;
				boolean fail = false;
				boolean good = false;
				while (good == false) {
					try {
						if (fail == false) {
							shift_amount = Integer.parseInt(shift_num.getText());
						}
						shift_amount = Integer.parseInt(zwischensp);
						shift_num.setText("" + shift_amount);
						good = true;
					} catch (NumberFormatException e1) {
						zwischensp = JOptionPane.showInputDialog("Wrong input!\nJust numbers please!");
						fail = true;
						good = false;
					}
				}
				ShiftCipher a = new ShiftCipher(shift_amount);
				String decrypted = a.decrypt(text_to_decrypt);
				output_shift.setText(decrypted);
			}
		}
	}
}
