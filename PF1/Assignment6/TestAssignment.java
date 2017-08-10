package assignment6;
import org.junit.Assert;


import org.junit.Test;

public class TestAssignment {
	//Test case if both array are in ascending order
	@Test
	public void mtest1()
	{
		JoinSortedArray sort_array =new JoinSortedArray();
		int a[]={5,7,9,10};
		int b[]={4,6,8,11};
		int c[]=new int[a.length+b.length];
		int result_array[]={4,5,6,7,8,9,10,11};
		c =sort_array.join(a, a.length, b, b.length, c);
		Assert.assertArrayEquals(result_array,c);
	}
	//test case if all elements of one array is same
	 @Test
	 public void mtest2()
		{
			JoinSortedArray sort_array =new JoinSortedArray();
			int a[]={7,7,7,7};
			int b[]={8,9,10,11};
			int c[]=new int[a.length+b.length];
			int result_array[]={7,7,7,7,8,9,10,11};
			c =sort_array.join(a, a.length, b, b.length, c);
			Assert.assertArrayEquals(result_array,c);
		}
	 //test case if all elements of both array are same
	 @Test
	 public void mtest3()
		{
			JoinSortedArray sort_array =new JoinSortedArray();
			int a[]={7,7,7,7};
			int b[]={8,8,8,8};
			int c[]=new int[a.length+b.length];
			int result_array[]={7,7,7,7,8,8,8,8};
			c =sort_array.join(a, a.length, b, b.length, c);
			Assert.assertArrayEquals(result_array,c);
		}
	 //test case if both array are in decreasing order
	 @Test
	 public void mtest4()
		{
			JoinSortedArray sort_array =new JoinSortedArray();
			int a[]={8,6,3,1};
			int b[]={11,11,10,9};
			int c[]=new int[a.length+b.length];
			int result_array[]={11,11,10,9,8,6,3,1};
			c =sort_array.join(a, a.length, b, b.length, c);
			Assert.assertArrayEquals(result_array,c);
		}
	 //negative case case
	 @Test
	 public void mtest5()
		{
			JoinSortedArray sort_array =new JoinSortedArray();
			int a[]={8,6,3,1};
			int b[]={11,11,10,9};
			int c[]=new int[a.length+b.length];
			int result_array[]={10,9,11,11,8,6,3,1};
			c =sort_array.join(a, a.length, b, b.length, c);
			Assert.assertArrayEquals(result_array,c);
		}
	 

}
