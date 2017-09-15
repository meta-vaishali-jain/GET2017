import java.util.Objects;

/**
 * ClassName  : Entity
 * @author    : Vaishali Jain
 * Description: Entity class describing details of each entity.
 * 				Entity can be of two types 1) User 2) Organisation
 */
public abstract class Entity {
	//describing id of entity
	private int entityId;
	//describing name of entity
	private String entityName;
	
	//getter to get entity ID
	public int getEntityId() {
		return entityId;
	}
	
	//getter to get entity name
	public String getEntityName() {
		return entityName;
	}
	
	//parameterize constructor
	public Entity(int entityId, String entityName) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
	}
	
	//overriding hashcode
	@Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.entityName);
        hash = 41 * hash + Objects.hashCode(this.entityId);
        return hash;
    }
	
	//overriding equals method
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Entity other = (Entity) obj;
	        if (!Objects.equals(this.entityName, other.entityName)) {
	            return false;
	        }
	        if (!Objects.equals(this.entityId, other.entityId)) {
	            return false;
	        }
	        return true;
	    }
}
