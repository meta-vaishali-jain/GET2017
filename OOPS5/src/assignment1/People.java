package assignment1;
/**
 * ClassName : People
 * @author   : Vaishali Jain
 * Description: describes details of the person
 */
public class People extends Entity{
	private int age;
	private String hobbies; 
	
	public Entity setValues(String userProfile) {
		String[] userProfileDetail = userProfile.trim().split(",");
		
		if(userProfile != null && userProfileDetail  != null && userProfileDetail.length > 0) {
			this.entityID			= Integer.parseInt(userProfileDetail[0].trim());
			this.entityType		= userProfileDetail[1].trim();
			this.entityName  = userProfileDetail[2].trim();
			
			this.age 		= Integer.parseInt(userProfileDetail[3].trim());
			this.hobbies 	= userProfileDetail[4].trim();
		}
		return this;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getHobbies() {
		return this.hobbies;
	}

}

