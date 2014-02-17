package geyerhamplkocsis;

/**
 * The SubstitutionCipher to set the secretalphabet
 * @author Burkhard Hampl
 * 
 */
public class SubstitutionCipher extends MonoalphabeticCipher {

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
	 * @see geyerhamplkocsis.MonoalphabeticCipher#setSecretAlphabet(java.lang.String)
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}

}
