package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRoomAllotement {
	RoomAllotment roomAllotment;
	
	@Before
	public void setup(){
		roomAllotment=new RoomAllotment();
	}
	
	//test case to check if room is available or not
	@Test
	public void testIsRoomAvailable(){
		Assert.assertTrue(new Main().isRoomAvailable(4));
	}
	
	//test case to check if room not available
	@Test
	public void testIsRoomNotAvailable(){
		Assert.assertFalse(new Main().isRoomAvailable(5));
	}
	
	//test case to check hash function
	@Test
	public void testHashFunction(){
		Assert.assertEquals(1,roomAllotment.hashFunction(25,5));
	}
	
	//test case to check book room
	@Test 
	public void testBookRoom(){
		Assert.assertEquals(1,roomAllotment.bookRoom("naina",25));
	}
	
	//test case to check book room if two usrs have same age
	@Test 
	public void testBookRoomIfGuestAlreadyThere(){
		Assert.assertEquals(1,roomAllotment.bookRoom("naina",25));
		Assert.assertEquals(3,roomAllotment.bookRoom("shreya",25));
	}
}
