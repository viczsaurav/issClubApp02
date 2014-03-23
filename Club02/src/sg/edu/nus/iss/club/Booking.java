package sg.edu.nus.iss.club;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
	
	public static final String DATE_FORMAT = "dd-MMM-yyyy";
    public static final String TIME_FORMAT = "dd-MMM-yyyy H:mm";
    
    SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
    SimpleDateFormat tf = new SimpleDateFormat(TIME_FORMAT);
	
	private Member member;
	private Facility facility;
	private Date startDate;
	private Date endDate;
	
	public Booking(Member member, Facility facility,
					Date startDate, Date endDate)
								throws BadBookingException {
		String error = null;
		//System.out.println("Diff : "+ (startDate.getTime() - endDate.getTime()));
		if		(member == null) 	{ 
			error = "Member empty";		
			}
		else if	(facility == null) 	{ 
			error = "Facility empty";		
			}
		else if	(startDate == null)	{ 
			error = "Start Date empty";	
			}
		else if	(endDate == null)	{ 
			error = "End Date Empty";		
			}
		else if (startDate.getTime() > endDate.getTime()) {
			error = "Start time greator than End time";
			}
		
		if(error != null)			{ 
			new BadBookingException(error);	
			}
		
		this.member =  member;
		this.facility = facility;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}

	public Member getMember() {
		return member;
	}

	public Facility getFacility() {
		return facility;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public boolean overlaps(Booking otherBooking){
		boolean status = true;
		if 		(this.facility != otherBooking.facility) 						{ status = false;}
		else if (this.startDate.getTime() >= otherBooking.endDate.getTime()) 	{ status = false;}
		else if (otherBooking.startDate.getTime() >= this.endDate.getTime()) 	{ status = false;}
		return status;
	}
	
	public String toString(){
		return ("\nBooking Details :\n"+ facility + 
				"\nby "+ member + 
				"\nfrom "+ tf.format(startDate) +
				"\nto "+ tf.format(endDate));
	}
	
	public void show(){
		System.out.println(this.toString());
	}
}
