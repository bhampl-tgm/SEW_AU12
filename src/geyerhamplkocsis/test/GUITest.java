package geyerhamplkocsis.test;

import geyerhamplkocsis.Gui;
import geyerhamplkocsis.KeywordCipher;
import geyerhamplkocsis.ShiftCipher;
import geyerhamplkocsis.SubstitutionCipher;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("serial")
public class GUITest extends Gui {

	// Tests KeywordCipher
	@Test
	public void testKeywordCipherButtonDecrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.decrypt_keyword, ActionEvent.ACTION_FIRST, ""));
		this.input_keyword = new JTextArea("test");
		this.keyword = new JTextArea("qwertz");
		assertEquals(new KeywordCipher("qwertz").decrypt("test"), this.output_keyword.getText());
	}

	@Test
	public void testKeywordCipherButtonEncrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.encrypt_keyword, ActionEvent.ACTION_FIRST, ""));
		this.input_keyword = new JTextArea("test");
		this.keyword = new JTextArea("qwertz");
		assertEquals(new KeywordCipher("qwertz").encrypt("test"), this.output_keyword.getText());
	}
	
	@Test
	public void testKeywordCipherCopyClipboard() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_to_clipboard_keyword, ActionEvent.ACTION_FIRST, ""));
		this.output_keyword = new JTextArea("bla");
		assertEquals("bla", Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null));
	}
	
	@Test
	public void testKeywordCipherCopyToInput() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_output_to_input_keyword, ActionEvent.ACTION_FIRST, ""));
		this.output_keyword = new JTextArea("bla");
		assertEquals("bla", this.input_keyword.getText());
	}
	
	// Test SubstitutionCipher
	@Test
	public void testSubstCipherButtonDecrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.decrypt_subst, ActionEvent.ACTION_FIRST, ""));
		this.input_subst = new JTextArea("test");
		assertEquals(new SubstitutionCipher("qwertzuiop�asdfghjkl��yyxcvbnm�").decrypt("test"), this.output_subst.getText());
	}
	
	@Test
	public void testSubstCipherButtonEncrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.encrypt_subst, ActionEvent.ACTION_FIRST, ""));
		this.input_subst = new JTextArea("test");
		assertEquals(new SubstitutionCipher("qwertzuiop�asdfghjkl��yyxcvbnm�").encrypt("test"), this.output_subst.getText());
	}
	
	@Test
	public void testSubstCipherCopyClipboard() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_to_clipboard_subst, ActionEvent.ACTION_FIRST, ""));
		this.output_subst = new JTextArea("bla");
		assertEquals("bla", Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null));
	}
	
	@Test
	public void testSubstCipherCopyToInput() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_output_to_input_subst, ActionEvent.ACTION_FIRST, ""));
		this.output_subst = new JTextArea("bla");
		assertEquals("bla", this.input_subst.getText());
	}
	
	// Test ShiftChiper
	
	@Test
	public void testShiftCipherButtonDecrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.decrypt_shift, ActionEvent.ACTION_FIRST, ""));
		this.input_shift = new JTextArea("test");
		this.shift_num = new JTextArea("3");
		assertEquals(new ShiftCipher(3).decrypt("test"), this.output_shift.getText());
	}
	
	@Test
	public void testShiftCipherButtonEncrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.encrypt_shift, ActionEvent.ACTION_FIRST, ""));
		this.input_shift = new JTextArea("test");
		this.shift_num = new JTextArea("3");
		assertEquals(new ShiftCipher(3).encrypt("test"), this.output_shift.getText());
	}
	
	@Test
	public void testShiftCipherCopyClipboard() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_to_clipboard_shift, ActionEvent.ACTION_FIRST, ""));
		this.output_shift = new JTextArea("bla");
		assertEquals("bla", Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null));
	}
	
	@Test
	public void testShiftCipherCopyToInput() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_output_to_input_shift, ActionEvent.ACTION_FIRST, ""));
		this.output_shift = new JTextArea("bla");
		assertEquals("bla", this.input_shift.getText());
	}
}
