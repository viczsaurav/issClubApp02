package sg.edu.nus.iss.club;

import java.util.*;

public class BookingRegister {

	private HashMap<Facility, ArrayList<Booking>> bookingMap;

	public BookingRegister() {
		bookingMap = new HashMap<Facility, ArrayList<Booking>>();
	}

	public void addBooking(Member member, Facility facility, Date startDate,
			Date endDate) throws BadBookingException {
		Booking booking = new Booking(member, facility, startDate, endDate);
		ArrayList<Booking> bookingList = bookingMap.get(facility);
		if (bookingList == null) {
			bookingList = new ArrayList<Booking>();
			bookingMap.put(facility, bookingList);
		} else {
			for (Booking other : bookingList) {
				if (booking.overlaps(other)) {
					throw new BadBookingException(
							"New Booking overlaps with existing booking");
				}
			}
		}
		bookingList.add(booking);
	}

	public ArrayList<Booking> getBookings(Facility f, Date sDate, Date edate) {
		ArrayList<Booking> bookingList = bookingMap.get(f);
		ArrayList <Booking> selected = new ArrayList<Booking>();
		if (bookingList != null) {
			for (Booking b : bookingList) {
				if (!((sDate.after(b.getEndDate())) || 
						(edate.before(b.getStartDate()))
						)
					) {
					selected.add(b);
				}
			}
		}
		return selected;
	}
	
	public void removeBooking(Booking rBook){
		ArrayList<Booking> bookList;
		Facility f = rBook.getFacility();
		bookList = bookingMap.get(f);
		if (bookList != null){
			bookList.remove(rBook);
		}
	}
}
