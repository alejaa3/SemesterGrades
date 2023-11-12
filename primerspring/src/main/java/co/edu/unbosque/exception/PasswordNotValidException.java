package co.edu.unbosque.exception;

public class PasswordNotValidException extends Exception{

	public PasswordNotValidException() {
		super("The password does not meet the standard. It should have at least: 8 characters, a number, an uppercase character, a lowercase character and an especial character");
	}
	
}
