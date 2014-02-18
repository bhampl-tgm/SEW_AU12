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
	 * Generates a secret alphabet with the keyword in the beginning. Sets the
	 * secret alphabet in the {@link MonoalphabeticCipher} class.
	 * 
	 * @param keyword
	 *            Keyword that will be added to the alphabet
	 */
	public void setKeyword(String keyword) {
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

	public static void main(String[] args) {
		KeywordCipher kc = new KeywordCipher("hgfawjk\u00f6\u00e4");
		System.out.println(kc.encrypt("hallowelt"));
		System.out.println(kc.decrypt(kc.encrypt("hallowelt")));
	}
}
