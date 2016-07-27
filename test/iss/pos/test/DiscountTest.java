package iss.pos.test;

import static org.junit.Assert.*;

import org.junit.Test;
import iss.pos.*;
import iss.pos.promotion.*;

public class DiscountTest {

	@Test
	public void test1ABuy1Item() {
		
		//setup
		Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
		
		//exercise
		Order newOrder = dc.calculateDiscount(order);
		
		//verify
		double expectedValue = 0;//TODO: set the expected value;
		assertEquals(expectedValue, newOrder.getTotalPrice(),0.001);
        //TODO: add additional verification if necessary
	}

}
