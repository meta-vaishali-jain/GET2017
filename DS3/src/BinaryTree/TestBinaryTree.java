package BinaryTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestBinaryTree {
	BinaryTree<Integer> binaryTree1;
	BinaryTree<Integer> binaryTree2;
	Node<Integer> node;
	Node<Integer> node1;

	
	@Before
	public void setup(){
		binaryTree1=new BinaryTree<Integer>(10);
		binaryTree2=new BinaryTree<Integer>(10);
		node=binaryTree1.getRoot();
		node.setLeftPointer(new Node<Integer>(20));
		node.getLeftPointer().setLeftPointer(new Node<Integer>(40));
		node.setRightPointer(new Node<Integer>(30));
			
	}
	
	@Test
	public void testInorder(){
		String expected="40201030";
		binaryTree1.inorder();
		Assert.assertEquals(expected,binaryTree1.getInOrderedString());
	}
	
	@Test
	public void testPreOrder(){
		String expected="10204030";
		binaryTree1.preOrder();
		Assert.assertEquals(expected,binaryTree1.getPreOrderedString());
	}
	
	@Test
	public void testPostOrder(){
		String expected="40203010";
		binaryTree1.postOrder();
		Assert.assertEquals(expected,binaryTree1.getPostOrderedString());
	}
	
	@Test
	public void testIsMirror(){
		node1=binaryTree2.getRoot();
		node1.setLeftPointer(new Node<Integer>(30));
		node1.setRightPointer(new Node<Integer>(20));
		node1.getRightPointer().setRightPointer(new Node<Integer>(40));
		Assert.assertTrue(binaryTree1.isMirror(node,node1));
	}
	
	@Test
	public void testIsNotMirror(){
		node1=binaryTree2.getRoot();
		node1.setLeftPointer(new Node<Integer>(50));
		node1.setRightPointer(new Node<Integer>(20));
		node1.getRightPointer().setLeftPointer(new Node<Integer>(40));
		Assert.assertFalse(binaryTree1.isMirror(node,node1));
	}
	
}
