import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private List<Double> money;

    public BankAccount() {
        this.money = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Wrong value!");
        }
        this.money.add(amount);
    }

    public double getBalance() {
        return this.money.stream().mapToDouble(m -> m).sum();
    }
}
