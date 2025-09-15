package architecture.ddd;

// 应用服务（不属于领域层，但协调领域对象）
public class OrderApplication {
    private final OrderService orderService = new OrderService();

    public void createAndPayOrder() {
        Order order = new Order("ORD-1001");

        Money price1 = new Money(50.0, "CNY");
        Money price2 = new Money(30.0, "CNY");

        order.addItem(new OrderItem("P001", 2, price1)); // 2 * 50 = 100
        order.addItem(new OrderItem("P002", 1, price2)); // 1 * 30 = 30

        System.out.println("订单总金额：" + order.getTotalAmount());

        // 检查是否满足折扣
        if (orderService.isEligibleForDiscount(order)) {
            System.out.println("该订单满足折扣条件！");
        }

        // 支付
        order.pay();
    }
}