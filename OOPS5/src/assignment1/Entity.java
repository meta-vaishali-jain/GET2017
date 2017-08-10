package assignment1;

/**
 * @Class	Entity
 * @author  Vaishali Jain
 * Description: Base class that defines the different types of users
 *              in the networking site
 *              Type can be people or organisation
 **/

public class Entity {
	protected int entityID;
	protected String entityType;
	protected String entityName;
	
	/** default getters to access private data items*/
	public int getId() {
		return entityID;
	}

	public String getType() {
		return entityType;
	}

	public String getUserName() {
		return entityName;
	}

	public Entity() {
		
	}
	
	/**@Method	setValues(String user_profile)
	 * downcast to appropriate user class
	 * @return	type = Entity, initialized entity type objects
	 * **/
	public Entity setValues(String userProfile) {
		if(userProfile.trim().contains("user")){
			return new People().setValues(userProfile);
		}else if(userProfile.trim().contains("organisation")) {
			return new Organisation().setValues(userProfile);
		}
		return null;
	}	
}	 