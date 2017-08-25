package assignment2;

import java.util.HashMap;

/**
 * ClassName :RoomAllotment
 * @author userr
 * Description:Class assigning rooms to the guest
 */
public class RoomAllotment {
	//containing details of all the rooms
	private HashMap<Integer,Guest> detailsOfRoomAllotment =new HashMap<Integer,Guest>();
	private static final int NUMBER_OF_ROOMS=5;
	
	//getter and setter for that
	public HashMap<Integer, Guest> getDetailsOfRoomAllotment() {
		return detailsOfRoomAllotment;
	}
	
	public void setDetailsOfRoomAllotment(
			HashMap<Integer, Guest> detailsOfRoomAllotment) {
		this.detailsOfRoomAllotment = detailsOfRoomAllotment;
	}
	
	//getter to get total number of rooms in guest house
	public static int getNumberOfRooms() {
		return NUMBER_OF_ROOMS;
	}
	
	//hash function to compute room number from the age of the guest
	public int hashFunction(int age,int NUMBER_OF_ROOMS){
		return age % NUMBER_OF_ROOMS+1;
	}
	
	/**
	 * methpod to book the room
	 * @param guestName
	 * @param age
	 * @return
	 */
	public int bookRoom(String guestName,int age){
		int roomNumber=0;
		Guest guest=new Guest(guestName,age);
	    roomNumber=hashFunction(age,NUMBER_OF_ROOMS);
		while(detailsOfRoomAllotment.containsKey(roomNumber)){
			roomNumber=hashFunction(roomNumber+1,NUMBER_OF_ROOMS);
		}
		if(roomNumber!=0){
			detailsOfRoomAllotment.put(roomNumber,guest);
		}
		return roomNumber;
	}
	
}
