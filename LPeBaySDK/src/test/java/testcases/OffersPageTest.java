package testcases;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import pages.OffersPage;

public class OffersPageTest {
	
	
	OffersPage obj_offerpage;
	public OffersPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		obj_offerpage= new OffersPage();
	}
	
	@Test(priority=1)
	public void VerifyOfferScreenElements()
	{
		boolean offersElements=obj_offerpage.offerPageElements();
		Assert.assertEquals(true, offersElements);
	}
	@Test(priority=2)
	public void verifyOfferSelection() throws InterruptedException
	{
		
		boolean ele = obj_offerpage.selectOffer();
		Assert.assertEquals(true, ele);
	}

}
