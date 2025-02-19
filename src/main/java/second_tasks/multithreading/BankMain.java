package second_tasks.multithreading;

public class BankMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(0);

        Thread thread1 = new Thread(new Client(bankAccount, "Клиент 1"));
        Thread thread2 = new Thread(new Client(bankAccount, "Клиент 2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Итоговая сумма: " + bankAccount.getBalance());

    }
}
