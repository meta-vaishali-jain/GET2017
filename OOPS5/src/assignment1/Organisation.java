package assignment1;
/**
 * ClassName : Organisation
 * @author   : Vaishali Jain
 * Description: describes details of the organisation
 */

public class Organisation extends Entity{
	private String domain;

	public Entity setValues(String userProfile) {
		String[] values = userProfile.trim().split(",");
		
		if(userProfile != null && values  != null && values.length > 0) {
			this.entityID			= Integer.parseInt(values[0].trim());
			this.entityType		= values[1].trim();
			this.entityName  = values[2];
			
			this.domain 	= values[3];
		}
		return this;
	}

	public String getDomain() {
		return domain;
	}


}
