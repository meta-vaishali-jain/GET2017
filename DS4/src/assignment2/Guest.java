package assignment2;

/**
 * ClassName  : Guest
 * @author    : Vaishali Jain
 * Description: class describing the details of all the guest arrived i.e. name of guest and age
 */
public class Guest {
	private String nameOFGuest;
	private int age;
	
	//parameterize constructor
	public Guest(String nameOFGuest, int age) {
		this.nameOFGuest = nameOFGuest;
		this.age = age;
	}
	
	//getter to get name of the guest
	public String getNameOFGuest() {
		return nameOFGuest;
	}
	
	//setter to set name of guest
	public void setNameOFGuest(String nameOFGuest) {
		this.nameOFGuest = nameOFGuest;
	}
	
	//getter to get age of guest
	public int getAge() {
		return age;
	}
	
	//setter to set age of guest
	public void setAge(int age) {
		this.age = age;
	}
}
