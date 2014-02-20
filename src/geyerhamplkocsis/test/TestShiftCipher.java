/**
 * 
 */
package geyerhamplkocsis.test;

import static org.junit.Assert.*;
import geyerhamplkocsis.KeywordCipher;
import geyerhamplkocsis.ShiftCipher;

import org.junit.Test;

/**
 * Klassen Autor Stafan Geyer
 * 
 * @author Burkhard Hampl
 * 
 */
public class TestShiftCipher {

	/**
	 * A Constructor test
	 */
	@Test
	public void test_Constructor() {
		ShiftCipher sf = new ShiftCipher(3);
		assertEquals("das ist ein junit test",
				sf.decrypt(sf.encrypt("Das ist ein JUnit Test")));
	}
	
	/**
	 * A setShiftAmount test
	 */
	@Test
	public void test_setShiftAmount() {
		ShiftCipher sf = new ShiftCipher(3);
		sf.setShiftAmount(5);
		assertEquals("das ist ein junit test",
				sf.decrypt(sf.encrypt("Das ist ein JUnit Test")));
	}
}
