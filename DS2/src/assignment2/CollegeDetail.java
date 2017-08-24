package assignment2;

/**
 * ClassName  : CollegeDetail
 * @author    : Vaishali Jain
 * Description: class decribing the complete college details with number of seats available
 *
 */
public class CollegeDetail {
	private String collegeName;
	private int totalSeats;
	private int seatsAvailable;
	private int rankOfCollege;
	//parameterize constructor
	public CollegeDetail(String collegeName, int totalSeats, int seatsAvailable,int rankOfo0llege) {
		
		this.collegeName = collegeName;
		this.totalSeats = totalSeats;
		this.seatsAvailable = seatsAvailable;
		this.rankOfCollege=rankOfCollege;
	}
	
	/**
	 * getters and setters
	 * @return
	 */
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	
	
}
