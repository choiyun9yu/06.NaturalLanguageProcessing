package access06;

public class BanckAccountMain {
    public static void main(String[] args) {
        BanckAccount account = new BanckAccount();
        account.deposit(10000);
        account.withdraw(3000);
        System.out.println("balance = " + account.getBalance());
    }
}
