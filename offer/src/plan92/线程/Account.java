package plan92.线程;

import org.junit.Test;

class Account {
    private String actno;
    private double balance; //实例变量。

    //对象
    Object o= new Object(); // 实例变量。（Account对象是多线程共享的，Account对象中的实例变量obj也是共享的。）

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款的方法
    public void withdraw(double money){
        /**
         * 以下可以共享,金额不会出错
         * 以下这几行代码必须是线程排队的，不能并发。
         * 一个线程把这里的代码全部执行结束之后，另一个线程才能进来。
         */
        synchronized(this) {
            //synchronized(actno) {
            //synchronized(o) {

            /**
             * 以下不共享，金额会出错
             */
		  /*Object obj = new Object();
	        synchronized(obj) { // 这样编写就不安全了。因为obj2不是共享对象。
	        synchronized(null) {//编译不通过
	        String s = null;
	        synchronized(s) {//java.lang.NullPointerException*/
            double before = this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
            //}
        }
    }

    static class AccountThread extends Thread {
        // 两个线程必须共享同一个账户对象。
        private Account act;

        // 通过构造方法传递过来账户对象
        public AccountThread(Account act) {
            this.act = act;
        }
        @Override
        public void run(){
            double money = 5000;
            act.withdraw(money);
            System.out.println(Thread.currentThread().getName() + "对"+act.getActno()+"取款"+money+"成功，余额" + act.getBalance());
        }
    }
}



