package practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractise {

	public void sample()
	{
		System.out.println("step 1");
		System.out.println("step 2");

		System.out.println("step 3");
		Assert.assertEquals(0, 1);
		System.out.println("step 4");
		System.out.println("step 5");
		
		//sa.assertAll();
	}
		@Test
		 public void sample1()
		 {
			SoftAssert sa=new SoftAssert();
			System.out.println("step 1");
			System.out.println("step 2");
			System.out.println("step 3");
			sa.assertEquals(0,1);
			System.out.println("step 4");
			sa.assertTrue(false);
			System.out.println("step 5");
			sa.assertAll();

			
			
		 }
	

	}


