package geyerhamplkocsis;

import java.util.ArrayList;
import java.util.List;

/**
 * To encrypt a String, this class will add a keyword in the beginning of the
 * secret alphabet. If the Keyword contains Characters twice or illegal
 * Characters were used, an {@link IllegalArgumentException} will be thrown.
 * The case of the Characters will be ignored.
 * 
 * @author Stefan Geyer
 * @version 1.0
 * @since 2014-02-15
 */
public class KeywordCipher extends MonoalphabeticCipher {

	/**
	 * Generates a secret alphabet with the keyword in the beginning. Sets the
	 * secret alphabet in the {@link MonoalphabeticCipher} class.
	 * 
	 * @param keyword
	 *            Keyword that will be added to the alphabet
	 */
	public KeywordCipher(String keyword) {
		this.setKeyword(keyword);
	}

	/**
	 * Generates a secret alphabet with the keyword in the beginning. Sets the
	 * secret alphabet in the {@link MonoalphabeticCipher} class.
	 * 
	 * @param keyword
	 *            Keyword that will be added to the alphabet
	 */
	public void setKeyword(String keyword) {
		validateKeyword(keyword);
		// Ignoring Upper Case
		String kw = keyword.toLowerCase();

		List<Character> tmp = new ArrayList<Character>();

		// Adding every char of the keyword to the list
		for (int i = 0; i < kw.length(); i++) {
			tmp.add(kw.toCharArray()[i]);
		}

		for (char c : this.getNormalAlphabet().toCharArray()) {
			// If the String doesn't contain the char, it will be added to the
			// list
			if (convert(tmp).indexOf(c) == -1) {
				tmp.add(c);
			}
		}

		// Sets the secret alphabet by calling the method from the super class
		this.setSecretAlphabet(convert(tmp));
	}

	/**
	 * 
	 * @param al The List that contains the Characters that will be merged together
	 * @return The merged Characters
	 */
	private String convert(List<Character> al) {
		StringBuilder sb = new StringBuilder();

		//Append every Character of the List to the StringBuilder
		for (char c : al) {
			sb.append(c);
		}

		return sb.toString();
	}

	/**
	 * Checks if keyword is invalid and throws an {@link IllegalArgumentException} if needed
	 * 
	 * @param keyword Keyword that will be checked
	 * @throws IllegalArgumentException Will be thrown if Keyword is invalid
	 */
	public void validateKeyword(String keyword) throws IllegalArgumentException {
		// Keyword has to be shorter than 30 and longer than 0
		if (keyword.length() >= 30 || keyword.length() <= 0) throw new IllegalArgumentException("Invalid keyword length");
		// Keyword cant contain numeric Characters
		else if (keyword.matches("^[a-zA-Z]$")) throw new IllegalArgumentException("Invalid characters detected");
		// Keyword cant contain a Character twice
		else {
			for (int i = 0; i < keyword.length(); i++) {
				for (int j = 0; j < keyword.length(); j++) {
					if (keyword.charAt(i) == keyword.charAt(j) && i != j) throw new IllegalArgumentException("Character" + keyword.charAt(i) + " in keyword was used more than one time");
				}
			}
		}
	}
	
}
