package architecture.ddd;

// 值对象：金额，没有ID，只通过值决定相等性
public class Money {
    private final double amount;
    private final String currency;

    public Money(double amount, String currency) {
        if (amount < 0) throw new IllegalArgumentException("金额不能为负");
        this.amount = amount;
        this.currency = currency != null ? currency : "CNY";
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("货币类型不一致，无法相加");
        }
        return new Money(this.amount + other.amount, this.currency);
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(amount) * 31 + currency.hashCode();
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}