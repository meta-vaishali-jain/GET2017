import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName  : TestSocialNetwork
 * @author    : Vaishali Jain
 * Description: Test cases to test social networking
 */
public class TestSocialNetwork {
	SocialNetwork socialNetwork;
	
	@Before
	public void setup(){
		socialNetwork=new SocialNetwork();
	}
	
	//Test case to test print user summary
	@Test
	public void testPrintUsersSummary(){
		ArrayList<User> userList=new ArrayList<User>();
		userList=socialNetwork.printUsersSummary();
		Assert.assertEquals(5, userList.size());
	}
	
	//test case to test print organisation summary
	@Test
	public void testPrintOrganisationSummary(){
		ArrayList<Organisation> organisationList=new ArrayList<Organisation>();
		organisationList=socialNetwork.printOrganisationsummary();
		Assert.assertEquals(4,organisationList.size());
	}
	
	//test case to test if id exist or not
	@Test
	public void testToCheckIfIDExist(){
		Assert.assertTrue(socialNetwork.ifIDExist(1001));
	}
	
	//test test check if id not exist
	@Test
	public void testToCheckIfIDNotExist(){
		Assert.assertFalse(socialNetwork.ifIDExist(1111));
	}
	
	//test case to test add connection if connection already npot exist
	@Test
	public void testAddConnection(){
		Assert.assertTrue(socialNetwork.addConnection(1001,1003));
	}
	
	//test case to test add connection if connection already  exist
	@Test
	public void testAddConnectionIfConnectionAlreadyExist(){
		Assert.assertFalse(socialNetwork.addConnection(1001,1009));
	}
	
	//test case to test display social network
	@Test
	public void testDisplaySocialNetwork(){
		int[][] connectionMatrix=socialNetwork.displaySocialNetwork();
		Assert.assertEquals(1,connectionMatrix[2][1]);
	}
	
	//test case to display social network
	@Test
	public void testDisplaySocialNetworkIfNoConnection(){
		int[][] connectionMatrix=socialNetwork.displaySocialNetwork();
		Assert.assertEquals(0,connectionMatrix[2][2]);
	}
	
	//Test case to test getEntityByName if entity exist
	@Test
	public void testGetEntityByName(){
		ArrayList<Node> nameBasedEntityList=socialNetwork.getEntityByName("Vaishali Jain");
		Assert.assertEquals(1,nameBasedEntityList.size());
		User user=(User)nameBasedEntityList.get(0).getEntity();
		Assert.assertEquals("Vaishali Jain",user.getEntityName());
	}
	
	//test case to test getEntityByName if entity not exist
	@Test
	public void testGetEntityByNameIfEntityNotExist(){
		ArrayList<Node> nameBasedEntityList=socialNetwork.getEntityByName("XYZ");
		Assert.assertEquals(0,nameBasedEntityList.size());
	}
	
	
	
}
