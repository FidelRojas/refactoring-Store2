package store;

public class BikesDiscount implements DiscountCalculator {

	@Override
	public float calculateDiscount(OrderItem orderItem) {
		return orderItem.calculateAmount() * 20 / 100;
		
	}

}
