package sg.edu.nus.iss.club;

import java.util.*;

public class BookingRegister {
	
	private HashMap<Facility, ArrayList<Booking>> bookingMap;
	
	public BookingRegister(){
		bookingMap = new HashMap<Facility, ArrayList<Booking>>();
	}
	
	public void addBooking(Member member, Facility facility, 
							Date startDate, Date endDate) 
									throws BadBookingException{
		Booking booking = new Booking(member, facility, startDate, endDate);
		ArrayList<Booking> bookingList =  bookingMap.get(facility);
		if (bookingList == null){
			bookingList = new ArrayList<Booking>();
			bookingMap.put(facility, bookingList);
		}
		else {
			for (Booking other : bookingList) {
				if (booking.overlaps(other)){
					throw new BadBookingException("New Booking overlaps with existing booking");
				}
			}
		}
	}
}
