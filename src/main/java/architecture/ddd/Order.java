package architecture.ddd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 聚合根：Order，整个订单聚合的入口
// 外部只能通过 Order 来操作其内部对象（OrderItem）
public class Order {
    private final String orderId;
    private final List<OrderItem> items = new ArrayList<>();
    private Money totalAmount = new Money(0, "CNY");
    private boolean paid = false;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    // 业务方法：添加订单项
    public void addItem(OrderItem item) {
        if (paid) {
            throw new IllegalStateException("订单已支付，无法修改");
        }
        items.add(item);
        totalAmount = totalAmount.add(item.getTotalPrice());
    }

    // 领域事件：支付成功（简化为状态变更）
    public void pay() {
        if (items.isEmpty()) {
            throw new IllegalStateException("订单不能为空");
        }
        this.paid = true;
        // 实际项目中可发布 Domain Event，如 OrderPaidEvent
        System.out.println("订单 " + orderId + " 支付成功，总金额：" + totalAmount);
    }

    // 只读访问
    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }
}