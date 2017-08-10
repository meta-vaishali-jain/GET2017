package assignment2;
/**
 * Class Name : LinearSearch
 * @author    : Vaishali Jain
 * Description: Search element in array using linear searching
 */

public class LinearSearch {
	/**
	 * method to check if two numbers are eqaul or not
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 */
	public int numberEqual(int numberOne,int numberTwo){
		return((numberOne==numberTwo)?1:0);
	}
	/**
	 * method for searching linearly
	 * @param array
	 * @param searchElement
	 * @return
	 */
	public int linearArraySearch(int[] array,int searchElement){
		//Here we are using method overriding for user convienience and to decrease chances of wrong input
		 return linearArraySearch(array,array.length,searchElement,0);	
		}
		public int linearArraySearch(int array[],int arrayLength,int searchElement,int startIndex){
			//throw exception if array is null
			if(arrayLength<=0)
				throw new NegativeArraySizeException();
			//if element not found in array will return -1;
			if(startIndex==arrayLength)
				return -1;
			//If element found then it will return index+1 of element
			return((numberEqual(array[startIndex],searchElement)==0))?(linearArraySearch(array,arrayLength,searchElement,startIndex+1))
					                                                 :startIndex+1;
			}
}
		
