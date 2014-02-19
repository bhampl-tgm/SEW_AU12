/**
 * 
 */
package geyerhamplkocsis.test;

import static org.junit.Assert.*;
import geyerhamplkocsis.KeywordCipher;

import org.junit.Test;

/**
 * Klassen Autor Stafan Geyer
 * 
 * @author Burkhard Hampl
 * 
 */
public class TestKeywordCipher {

	/**
	 * A Constructor test
	 */
	@Test
	public void test_Constructor() {
		KeywordCipher kc = new KeywordCipher("qwertz");
		assertEquals("das ist ein junit test",
				kc.decrypt(kc.encrypt("Das ist ein JUnit Test")));
	}

	/**
	 * A false Constructor test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_FalseConstructor() {
		@SuppressWarnings("unused")
		KeywordCipher kc = new KeywordCipher("listig");
		fail("A Exception was expected!");
	}

	/**
	 * A setKeyword test
	 */
	@Test
	public void test_SetKeyword() {
		KeywordCipher kc = new KeywordCipher("donau");
		kc.setKeyword("heyop");
		assertEquals("das ist ein junit test",
				kc.decrypt(kc.encrypt("Das ist ein JUnit Test")));
	}

	/**
	 * A false setKeyword test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_falseSetKeyword() {
		KeywordCipher kc = new KeywordCipher("donau");
		kc.setKeyword("nochlistiger");
		fail("A Exception was expected!");
	}

	/**
	 * A valifKeyword test
	 */
	@Test
	public void test_ValidKeyword() {
		KeywordCipher kc = new KeywordCipher("lustig");
		try {
			kc.validateKeyword("lustig");
		} catch (IllegalArgumentException e) {
			fail("No Exception was expected!");
		}
	}
	
	/**
	 * A false valifKeyword test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_falseValidKeyword() {
		KeywordCipher kc = new KeywordCipher("dasisteinTest");
		kc.validateKeyword("dasisteinTest");
		fail("A Exception was expected!");
	}
	
	/**
	 * A false valifKeyword empty
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_falseValidKeywordEmpty() {
		KeywordCipher kc = new KeywordCipher("dasisteinTest");
		kc.validateKeyword("");
		fail("A Exception was expected!");
	}
	
	/**
	 * A false valifKeyword test to long
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_falseValidKeywordToLong() {
		KeywordCipher kc = new KeywordCipher("dasisteinTest");
		kc.validateKeyword("aslkölsköadfjalöksdjfölaskdjföasldkfjaösldfkjasöldfkjaösldfkjas");
		fail("A Exception was expected!");
	}
	
	/**
	 * A false valifKeyword test false chars
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_falseValidKeywordChars() {
		KeywordCipher kc = new KeywordCipher("kein");
		kc.validateKeyword("sert+#-");
		fail("A Exception was expected!");
	}

}
