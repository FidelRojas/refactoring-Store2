package store;

public class AccessoriesDiscount implements DiscountCalculator {

	@Override
	public float calculateDiscount(OrderItem orderItem) {
		float discount = 0;
		if (orderItem.calculateAmount() >= 100) {
			discount = orderItem.calculateAmount() * 10 / 100;
		}
		// TODO Auto-generated method stub
		return discount;
	}

}
