package iss.pos.promotion;

import java.util.HashMap;
import java.util.Map;

import iss.pos.Order;
import iss.pos.OrderItem;

public class DiscountCalculator {

	public DiscountCalculator(Promotion promo) {

	}

	public Order calculateDiscount(Order order) {
		double totalDiscountedAmount = 0.0;

		Map<String, Integer> styleCodeMap = new HashMap<String, Integer>();

		for (OrderItem orderItem : order.getItems()) {

			String[] styleCode = orderItem.getProduct().getSku().split("\\.");
			if (styleCodeMap.containsKey(styleCode[0])) {
				styleCodeMap.put(styleCode[0], styleCodeMap.get(styleCode[0]) + 1);
			} else {
				styleCodeMap.put(styleCode[0], 1);
			}

			if (orderItem.getQuantity() % 2 == 0) {
				int numOfDiscount = (orderItem.getQuantity() / 2);
				totalDiscountedAmount += numOfDiscount * orderItem.getProduct().getPrice() * 0.3;
			} else if (orderItem.getQuantity() % 2 == 1) {
				// odd number of items
				int numOfDiscount = (orderItem.getQuantity() / 2);
				totalDiscountedAmount += numOfDiscount * orderItem.getProduct().getPrice() * 0.3;
			}
		}

		for (Map.Entry<String, Integer> entry : styleCodeMap.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				int numOfDiscount = (entry.getValue() / 2);
				if(entry.getKey().contains("1001")) {
					totalDiscountedAmount += numOfDiscount * 100.0 * 0.3;
				} else {
					// 2001
					totalDiscountedAmount += numOfDiscount * 10.0 * 0.3;
				}
			} else {
				int numOfDiscount = (entry.getValue() / 2);
				if(entry.getKey().contains("1001")) {
					totalDiscountedAmount += numOfDiscount * 100.0 * 0.3;
				} else {
					// 2001
					totalDiscountedAmount += numOfDiscount * 10.0 * 0.3;
				}
			}
		}

		order.setDiscountedAmount(totalDiscountedAmount);

		return order;
	}
}
