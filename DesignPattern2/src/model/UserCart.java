package model;
import java.util.HashMap;

/**
 * ClassName   : UserCart
 * @author     : Vaishali Jain
 * Description : store details of the usr all orders
 */
public class UserCart {
	private HashMap<ProductDetails,OrderedProductDetails> selectedProducts=new HashMap<ProductDetails,OrderedProductDetails>();

	public HashMap<ProductDetails, OrderedProductDetails> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(
			HashMap<ProductDetails, OrderedProductDetails> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}
}
