package sg.edu.nus.iss.club;

public class BadBookingException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public BadBookingException(){
		
	}
	public BadBookingException(String error){
		super(error);
	}

}
