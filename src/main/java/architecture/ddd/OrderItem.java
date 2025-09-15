package architecture.ddd;

// 订单项实体（有唯一标识 orderId + productId）
public class OrderItem {
    private final String productId;
    private final int quantity;
    private final Money price; // 单价

    public OrderItem(String productId, int quantity, Money price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotalPrice() {
        return new Money(price.getAmount() * quantity, price.getCurrency());
    }

    // getter 省略...
}
