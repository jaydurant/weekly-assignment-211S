package week1;

public enum SeatType {
	Leather("leather"),
	Suede("suede"),
	Nylon("nylon");
	
	private String seatType;
	private SeatType(String seatType) {
		this.seatType = seatType;
	}
	
	public String getSeatType() {
		return this.seatType;
	}
}
