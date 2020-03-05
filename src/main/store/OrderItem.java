package store;

public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float calculateTotalFor() {
		float totalItem=0;
		float discount=0;
		DiscountCalculator discountController = createDiscountCalculator();
		discount= discountController.calculateDiscount(this);
		totalItem = calculateTotalAmount() - discount;
		return totalItem;
	}

	private float calculateTotalAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}

	private DiscountCalculator createDiscountCalculator() {
		DiscountCalculator discountCalculator = null;
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			discountCalculator = new AccessoriesDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			discountCalculator = new BikesDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			discountCalculator = new CloathingDiscount();
		}
		return discountCalculator;
	}

	public float calculateAmount() {
		return calculateTotalAmount();
	}
}
