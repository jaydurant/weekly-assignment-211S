package week6;

public class InvalidCharacterException extends Exception {

	public InvalidCharacterException(String s) {
		super(s);
	}
	
	@Override
	public String getMessage() {
		return "An invalid character was detected";
	}

}
