package example.ch13;

/**
 *    - 쓰레드의 동기화(synchronization).
 *      멀티 쓰레드 프로세스에서는 다른 쓰레드의 작업에 영향을 미칠 수 있다.(여러 쓰레드가 같은 자원(메모리 등등)을 공유하기 때문)
 *      진행중인 작업이 다른 쓰레드에게 간섭받지 않게 하려면 '동기화'가 필요하다.
 *
 *          쓰레드의 동기화 : 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하게 막는 것.
 *
 *      동기화하려면 간섭받지 않아야 하는 문장들을 '임계 영역'으로 설정.
 *      임계영역은 락(lock)을 얻은 단 하나의 쓰레드만 출입가능(객체 1개에 락 1개)
 *
 *
 *    - synchronized를 이용한 동기화
 *      synchronized로 임계영역(lock이 걸리는 영역)을 설정하는 방법 2가지.
 *
 *          1. 메서드 전체를 임계 영역으로 지정
 *             {@code
 *                  public synchronized void calcSum() { // 임계 영역(critical section), 반환타입 앞에다가 synchronized 기입.
 *                      // ...
 *                  }
 *             }
 *             + 임계 영역은 한번에 한 쓰레드만 사용할 수 있기때문에 영역을 최소화해야 한다. 많을수록 성능 저하 야기. 때문에 메서드 전체를 설정하지 않고 특정 영역만 지정하는게 좋다.
 *
 *          2. 특정한 영역을 임계 영역으로 지정
 *             {@code
 *                  synchronized(객체의 참조변수) {        // 임계 영역(critical section)
 *                      // ...
 *                  }
 *             }
 */

public class Thread13 {
    public static void main(String[] args){
        Runnable r = new RunnableEx12();
        new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
        new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아니다.
    }
}

class Account {
    private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

    public synchronized int getBalance() { // 읽을 때도 동기화를 해주어야한다.
        return balance;
    }

    public synchronized void withdraw(int money){ // synchronized로 메서드를 동기화, 임계영역에 한번에 하나의 쓰레드만 접근가능.
        if(balance >= money) {
            try { Thread.sleep(1000);} catch(InterruptedException e) {} // sleep()은 결과를 보기 쉽게 하기 위해 삽입.
            balance -= money;
        }
    } // withdraw
}

class RunnableEx12 implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0) {
            // 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    } // run()
}