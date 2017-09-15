/**
 * ClassName  : Organisation
 * @author    : Vaishali Jain
 * Description: Type of entity
 * 				Containg details of entity of Organisation type
 * 				extends entity class
 */
public class Organisation extends Entity {
	private String domain;
	
	//parameterize constructor call super class constructor
	public Organisation(int entityId ,String entityName,String domain) {
		super(entityId,entityName);
		// TODO Auto-generated constructor stub
		this.domain=domain;
	}
	
	//getter to get domain of organisation
	public String getDomain() {
		return domain;
	}
	
}
