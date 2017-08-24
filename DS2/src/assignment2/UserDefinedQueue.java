package assignment2;

import arrayList.UserDefinedArrayList;

/**
 * ClassName  : USerDefinedQueue
 * @author    : Vaishali Jain
 * Description: class describe userDefined queue
 * @param <T>
 */
public class UserDefinedQueue<T> {
	UserDefinedArrayList<T> arrayList =new UserDefinedArrayList<T>();
		//enqueue element in queue
		public void enqueue(T data){
			arrayList.addItem(data);
		}
		
		//dequeue element from queue
		public Object dequeue(){
			return(arrayList.removeElementBasedOnPosition(1));
		}
		
		//clear the queue
		public void makeEmpty(){
			arrayList.clearList();
		}
		
		//get front element of the queue
		public Object getFront(){
			return arrayList.getElementBasedOnPosition(1);
		}
		
		//getter and setter
		public UserDefinedArrayList<T> getArrayList() {
			return arrayList;
		}

		public void setArrayList(UserDefinedArrayList<T> arrayList) {
			this.arrayList = arrayList;
		}
		public void queueSort(){
			arrayList.sort();
		}

}
