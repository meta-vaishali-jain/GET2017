package assignment1;
/**
 * ClassName:OrderDetails
 * @author :Vaishali Jain
 * Description:stores the user order id and quantity
 */

public class OrderDetails {
	private int orderProductId;
	private int orderProductQuantity;
	//method to set values 
	public void setValues(int orderProductID,int orderProductQuantity){
		orderProductID=this.orderProductId;
		orderProductQuantity=this.orderProductQuantity;
	}
	public int getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}
	public int getOrderProductQuantity() {
		return orderProductQuantity;
	}
	public void setOrderProductQuantity(int orderProductQuantity) {
		this.orderProductQuantity = orderProductQuantity;
	}

}
