package plan92.线程;

public class Test {
    public static void main(String[] args) {
        // 创建账户对象（只创建1个）
        Account act = new Account("act-001", 10000);
        // 创建两个线程，共享同一个对象
        Thread t1 = new Account.AccountThread(act);
        Thread t2 = new Account.AccountThread(act);

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

}
