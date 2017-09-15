/**
 * ClassName  : User
 * @author    : Vaishali Jain
 * Description: Type of entity
 * 				Containing details of entity of User type
 * 				extends entity class
 */
public class User extends Entity {
	//describing age of user
	private int userAge;
	//describing hobby of user
	private String userHobbies;
	
	//getter to get user age
	public int getUserAge() {
		return userAge;
	}
	
	//setter to set user age
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	//getter to get user Hobbies
	public String getUserHobbies() {
		return userHobbies;
	}
	
	//setter to set user hobbies
	public void setUserHobbies(String userHobbies) {
		this.userHobbies = userHobbies;
	}
	
	//parameterize constructor
	public User(int entityId, String entityName,int age,String hobby) {
		//calling super class constructor
		super(entityId, entityName);
		// TODO Auto-generated constructor stub
		this .userAge=age;
		this.userHobbies=hobby;
		
	}
	
	
	
}
