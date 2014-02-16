package geyerhamplkocsis;

/**
 * @author Burkhard Hampl
 * 
 */
public class SubstitutionCipher extends MonoalphabeticCipher {

	private String secretAlphabet;

	/**
	 * The constructor of the MonoalphabeticCipher class
	 * 
	 * @param secretAlphabet
	 *            the secretAlphabet
	 */
	public SubstitutionCipher(String secretAlphabet) {
		this.setSecretAlphabet(secretAlphabet);
	}

	/**
	 * The setter method to set secretAlphabet
	 * 
	 * @param secretAlphabet
	 *            the secretAlphabet to set
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		if (secretAlphabet.length() != 30) {
			throw new IllegalArgumentException();
		}
		this.secretAlphabet = secretAlphabet;
	}

}
