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
		
		Order order = new Order(); //TODO: setup the order, you can refer to SampleTest.java for example
		order.add(Products.GetProduct("blueDress"), 1);
		
		//exercise
		Order newOrder = dc.calculateDiscount(order);
		
		//verify
		double expectedValue = Products.GetProduct("blueDress").getPrice();//TODO: set the expected value;
		assertEquals(expectedValue, newOrder.getTotalPrice(),0.001);
        //TODO: add additional verification if necessary
	}

	@Test
	public void testBuy2DifferentItems() {
		Promotion promo = new Promotion();
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = new Order();
		order.add(Products.GetProduct("blueDress"), 1);
		order.add(Products.GetProduct("redDress"), 1);
		
		Order discountedOrder = dc.calculateDiscount(order);
		
		double expectedValue = Products.GetProduct("blueDress").getPrice() + Products.GetProduct("redDress").getPrice() * 0.7;
		assertEquals(expectedValue, discountedOrder.getTotalPrice(),0.001);
	}
	
	@Test
	public void testBuy2SameItems() {
		Promotion promo = new Promotion();
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = new Order();
		order.add(Products.GetProduct("blueDress"), 2);
		
		Order discountedOrder = dc.calculateDiscount(order);
		
		double expectedValue = Products.GetProduct("blueDress").getPrice() + Products.GetProduct("blueDress").getPrice() * 0.7;
		assertEquals(expectedValue, discountedOrder.getTotalPrice(),0.001);
	}
	
	@Test
	public void testBuy3SameItems() {
		Promotion promo = new Promotion();
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = new Order();
		order.add(Products.GetProduct("blueDress"), 3);
		
		Order discountedOrder = dc.calculateDiscount(order);
		
		double expectedValue = Products.GetProduct("blueDress").getPrice() * 2 + Products.GetProduct("blueDress").getPrice() * 0.7;
		assertEquals(expectedValue, discountedOrder.getTotalPrice(),0.001);
	}
	
	@Test
	public void testBuy4SameItems() {
		Promotion promo = new Promotion();
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = new Order();
		order.add(Products.GetProduct("blueDress"), 4);
		
		Order discountedOrder = dc.calculateDiscount(order);
		
		double expectedValue = Products.GetProduct("blueDress").getPrice() * 2 + (Products.GetProduct("blueDress").getPrice() * 0.7 * 2);
		assertEquals(expectedValue, discountedOrder.getTotalPrice(),0.001);
	}
	
	@Test
	public void testBuy2DifferentItemsSameStyle() {
		Promotion promo = new Promotion();
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = new Order();
		order.add(Products.GetProduct("redDress"), 1);
		order.add(Products.GetProduct("greenDress"), 1);
		
		Order discountedOrder = dc.calculateDiscount(order);
		double expectedValue = Products.GetProduct("redDress").getPrice() + (Products.GetProduct("greenDress").getPrice() * 0.7);
		assertEquals(expectedValue, discountedOrder.getTotalPrice(),0.001);
	}
	
//	@Test
//	public void testBuy2DifferentItemsSameStyleDifferentPrice() {
//		Promotion promo = new Promotion();
//		DiscountCalculator dc = new DiscountCalculator(promo);
//		
//		Order order = new Order();
//		order.add(Products.GetProduct("redDress"), 1);
//		order.add(Products.GetProduct("redSocks"), 1);
//		
//		Order discountedOrder = dc.calculateDiscount(order);
//		double expectedValue = Products.GetProduct("redDress").getPrice() + (Products.GetProduct("redSocks").getPrice() * 0.7);
//		assertEquals(expectedValue, discountedOrder.getTotalPrice(),0.001);
//	}

	
	@Test
	public void test3ABuy3ItemSameStyle() {
		
		//setup
		Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
		DiscountCalculator dc = new DiscountCalculator(promo);

		Order myTestOrder = new Order();
		myTestOrder.add(Products.GetProduct("whiteSocks"), 3);
		
		//exercise
		Order newOrder = dc.calculateDiscount(myTestOrder);
		
		//verify
		double expectedValue = 27.0;//TODO: set the expected value;
		assertEquals(expectedValue, newOrder.getTotalPrice(),0.001);
        //TODO: add additional verification if necessary
	}	
	
	@Test
	public void test4ABuy4ItemSameDiffStyle() {
		
		//setup
		Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
		DiscountCalculator dc = new DiscountCalculator(promo);

		Order myTestOrder = new Order();
		myTestOrder.add(Products.GetProduct("redSocks"), 1);
		myTestOrder.add(Products.GetProduct("whiteSocks"), 1);
		myTestOrder.add(Products.GetProduct("greenDress"), 1);
		myTestOrder.add(Products.GetProduct("redDress"), 1);
		
		//exercise
		Order newOrder = dc.calculateDiscount(myTestOrder);
		
		//verify
		double expectedValue = 187.0;//TODO: set the expected value;
		assertEquals(expectedValue, newOrder.getTotalPrice(),0.001);
        //TODO: add additional verification if necessary
	}

}
