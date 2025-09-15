package architecture.ddd;

// 领域服务：协调多个领域对象的复杂逻辑
// 例如：检查库存、计算折扣等（此处简化）
public class OrderService {

    // 例如：检查订单是否满足优惠条件
    public boolean isEligibleForDiscount(Order order) {
        return order.getTotalAmount().getAmount() > 100.0;
    }
}