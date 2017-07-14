package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestAssignment {
	OctalConverter converter;
	@Before
	public void setup()
	{
		converter=new OctalConverter();
	}
	
	@Test
	public void tGeneral(){
		
		int octnum=converter.binaryToOctal(Integer.parseInt("000100"));
		Assert.assertEquals(04,octnum);
		}
	
	@Test
	public void tNull()
		{
			int octnum=converter.binaryToOctal(Integer.parseInt(""));
			Assert.assertEquals(null,octnum);
		}
	@Test
	public void tInvalid()
	{
		int octnum=converter.binaryToOctal(Integer.parseInt("1234"));
		Assert.assertEquals(0,octnum);
	}
	
}