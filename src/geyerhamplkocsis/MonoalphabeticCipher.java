package geyerhamplkocsis;

/**
 * The MonoalphabeticCipher class to decrypt and encrypt a text
 * @author Burkhard Hampl
 *
 */
public class MonoalphabeticCipher implements Cipher {
 
	private String secretAlphabet;

	private final String normalAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	 
	/**
	 * The default constructor of the MonoalphabeticCipher class
	 */
	public MonoalphabeticCipher() {
		this.secretAlphabet = this.normalAlphabet;
	}
	 
	/**
	 * The getter method to get secretAlphabet
	 * @return the secretAlphabet
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	
	/**
	 * The setter method to set get secretAlphabet
	 * @param secretAlphabet the secretAlphabet to set
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}
	 
	/**
	 * To encrypt a text
	 * @return the encrypted text
	 * @see geyerhamplkocsis.Cipher#encrypt(java.lang.String)
	 */
	public String encrypt(String text) {
		String encryptedText = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			int charPos = this.normalAlphabet.indexOf(text.charAt(i));
			if (charPos < 0) {
				encryptedText += text.charAt(i);
			} else {
				encryptedText += this.secretAlphabet.charAt(charPos);
			}
		}
		
		return encryptedText;
	}
	 
	/**
	 * To decrypt a text
	 * @return the decrypted text
	 * @see geyerhamplkocsis.Cipher#decrypt(java.lang.String)
	 */
	public String decrypt(String text) {
		String decryptedText = "";
		for (int i = 0; i < text.length(); i++) {
			int charPos = this.secretAlphabet.indexOf(text.charAt(i));
			if (charPos < 0) {
				decryptedText += text.charAt(i);
			} else {
				decryptedText += this.normalAlphabet.charAt(charPos);
			}
		}
		
		return decryptedText;
	}
	 
}
 
