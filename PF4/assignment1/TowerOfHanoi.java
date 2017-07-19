package assignment1;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName : TowerOfHanoi
 * @author   : Vaishali Jain
 * Description: Solve the problem of tower of hanoi
 */
public class TowerOfHanoi {
    /**
     * Solve problem of tower of hanoi by taking three string to move particular number of disk from one string to another
     * @param sourcePeg     source peg- from where the disk to move
     * @param destinationPeg where  the disk has to move
     * @param temporaryPeg   temporary peg used for transfer
     * @param numberOfDisk number of disk provided for movement
     * @return
     */
 public	List<String> towerOfHanoi(String sourcePeg, String destinationPeg, String temporaryPeg, int numberOfDisk){
		List<String> movesString = new ArrayList<String>();
		if(numberOfDisk<=0){
		  throw new IllegalArgumentException();	
		}
		//base condition to exit loop
		 if( numberOfDisk == 1){
			movesString.add("Move Disk 1 from "+sourcePeg+" to "+destinationPeg);
			
			return movesString;
		}
		 //Recursive calling of method and then swaping it
		movesString.addAll(towerOfHanoi(sourcePeg, temporaryPeg, destinationPeg, numberOfDisk-1));
		movesString.add("Move Disk "+numberOfDisk+" from "+sourcePeg+" to "+destinationPeg);
		movesString.addAll(towerOfHanoi(temporaryPeg, destinationPeg, temporaryPeg, numberOfDisk-1));
		
		return movesString;
	}
}
