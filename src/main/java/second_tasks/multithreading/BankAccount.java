package second_tasks.multithreading;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void replenishBalance(int amount, String client){
        System.out.println(client + " выполняет операцию...");
        System.out.println("Пополнение средств: +" + amount);
        setBalance(getBalance() + amount);
        System.out.println("Текущий баланс: " + getBalance() + '\n');
    }

    public synchronized void withdrawBalance(int amount, String client){
        System.out.println(client + " выполняет операцию...");
        System.out.println("Снятие средств: -" + amount);
        if(getBalance() >= amount) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Недостаточно средства");
        }
        System.out.println("Текущий баланс: " + getBalance() + '\n');
    }
}
