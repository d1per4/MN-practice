package second_tasks.multithreading;

public class Client implements Runnable {

    private final String name;

    public String getName() {
        return name;
    }

    private final BankAccount bankAccount;

    public Client(BankAccount bankAccount, String name) {
        this.bankAccount = bankAccount;
        this.name = name;
    }

    @Override
    public void run() {
        int amount = (int) (Math.random() * 10) + 1;

        for (int i = 0; i < 10; i++) {
            int randomNum = (int) (Math.random() * 2) + 1;

            if (randomNum == 1) {
                bankAccount.replenishBalance(amount, getName());
            } else {
                bankAccount.withdrawBalance(amount, getName());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
