package geyerhamplkocsis.test;

import geyerhamplkocsis.Gui;
import geyerhamplkocsis.KeywordCipher;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("serial")
public class GUITest extends Gui {

	@Test
	public void testKeywordCipherButtonDecrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.decrypt2, ActionEvent.ACTION_FIRST, ""));
		this.input2 = new JTextArea("test");
		this.keyword = new JTextArea("qwertz");
		assertEquals(new KeywordCipher("qwertz").decrypt("test"), this.output2.getText());
	}

	@Test
	public void testKeywordCipherButtonEncrypt() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.encrypt2, ActionEvent.ACTION_FIRST, ""));
		this.input2 = new JTextArea("test");
		this.keyword = new JTextArea("qwertz");
		assertEquals(new KeywordCipher("qwertz").encrypt("test"), this.output2.getText());
	}
	
	@Test
	public void testKeywordCipherCopyClipboard() {
		ButtonListener b = new ButtonListener();
		b.actionPerformed(new ActionEvent(this.copy_to_clipboard2, ActionEvent.ACTION_FIRST, ""));
		this.output2 = new JTextArea("bla");
		assertEquals("bla", Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null));
	}
}
