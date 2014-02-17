package geyerhamplkocsis;

import java.util.ArrayList;
import java.util.List;

/**
 * To encrypt a String the last digits of the standard alphabet will be moved.
 * Example: 
 * Default Alphabet: abcdefghijklmnopqrstuvwxyz 
 * Value: 6 Secret
 * Alphabet: uvwxyzabcdefghijklmnopqrst
 * 
 * @author Stefan Geyer
 * @version 1.0
 * @since 2014-02-17
 */
public class ShiftCipher extends MonoalphabeticCipher {

	/**
	 * @param value
	 *            How many digits the default alphabet will be moved.
	 */
	public ShiftCipher(int value) {
		// If the value is greater than 30 it will be set to modulo value
		value = value % 30;

		List<Character> tmp = new ArrayList<Character>();

		// Add everything from the end to the value
		for (int i = (this.getNormalAlphabet().length() - value); i < this
				.getNormalAlphabet().length(); i++) {
			tmp.add(this.getNormalAlphabet().toCharArray()[i]);
		}

		// Add everything from the beginning to the value
		for (int i = 0; i < (this.getNormalAlphabet().length() - value); i++) {
			tmp.add(this.getNormalAlphabet().toCharArray()[i]);
		}

		// Set the secret alphabet by using the method from the Superclass
		this.setSecretAlphabet(convert(tmp));
	}

	/**
	 * Convert the content of a {@link List} to a {@link String}
	 * 
	 * @param al
	 *            The List to convert
	 * @return The converted {@link String}
	 */
	private String convert(List<Character> al) {
		StringBuilder sb = new StringBuilder();

		// Append every Character of the List to the StringBuilder
		for (char c : al) {
			sb.append(c);
		}

		return sb.toString();
	}

	/**
	 * @param value
	 *            How many digits the default alphabet will be moved.
	 */
	public void setShiftAmount(int value) {
		// If the value is greater than 30 it will be set to modulo value
		value = value % 30;

		List<Character> tmp = new ArrayList<Character>();

		// Add everything from the end to the value
		for (int i = (this.getNormalAlphabet().length() - value); i < this
				.getNormalAlphabet().length(); i++) {
			tmp.add(this.getNormalAlphabet().toCharArray()[i]);
		}

		// Add everything from the beginning to the value
		for (int i = 0; i < (this.getNormalAlphabet().length() - value); i++) {
			tmp.add(this.getNormalAlphabet().toCharArray()[i]);
		}

		// Set the secret alphabet by using the method from the Superclass
		this.setSecretAlphabet(convert(tmp));
	}
}
