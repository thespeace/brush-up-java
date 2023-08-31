package example.ch13;

import java.util.ArrayList;

/**
 *    - wait()과 notify()
 *      synchronized를 사용해 동기화를 하면 데이터는 보호가 되는데 비효율적이다.(한번에 한쓰레드만 임계영역에 들어갈수 있으니)
 *      때문에 동기화의 효율을 높이기 위해 wait(), notify()를 사용.
 *
 *      Object클래스에 정의되어 있으며, 동기화 블록 내에서만 사용할 수 있다.
 *          wait()      : 객체의 lock을 풀고 쓰레드를 해당 객체의 waiting pool에 넣는다.
 *          notify()    : waiting pool에서 대기중인 쓰레드 중의 하나를 깨운다.
 *          notifyAll() : waiting pool에서 대기중인 모든 쓰레드를 깨운다.
 */

//간단한 예시.
class Account2{
    int balance = 1000;

    public synchronized void withdraw(int money){
        while(balance < money){
            try {
                wait(); // 대기 - lock을 풀고 기다린다. 통지(notify())를 받으면 lock을 재획득(ReEntrance). 즉, lock을 반납 후 waiting pool로 이동.
            } catch (InterruptedException e) { }
        }
        balance -= money;
    } // withdraw

    public synchronized void deposit(int money){
        balance += money;
        notify(); // 중지 - 대기중인 쓰레드 중 하나에게 알림.
    }
}



//예시
class Customer implements Runnable {
    private Table  table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food  = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(10);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            if(eatFood())
                System.out.println(name + " ate a " + food);
            else
                System.out.println(name + " failed to eat. :(");
        } // while
    }

    boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {	this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(100);} catch(InterruptedException e) {}
        } // while
    }
}

class Table {
    String[] dishNames = { "donut","donut","burger" };
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();
    public synchronized void add(String dish) { // synchronized를 추가, 메서드를 임계영역으로 동기화 진행.
        if(dishes.size() >= MAX_FOOD)
            return;
        dishes.add(dish);
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean remove(String dishName) {
        synchronized(this) { // IndexOutOfBoundsException 발생, 자원을 공유하다 보니 임계영역이 필요. 동기화 블럭으로 동기화 진행!
            while(dishes.size()==0) {
                String name = Thread.currentThread().getName();
                System.out.println(name+" is waiting.");
                try { Thread.sleep(500);} catch(InterruptedException e) {}
            }

            for(int i=0; i<dishes.size();i++)
                if(dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
        } // synchronized

        return false;
    }

    public int dishNum() { return dishNames.length; }
}

public class Thread14 {
    public static void main(String[] args) throws Exception {
        Table table = new Table(); // 여러 쓰레드가 공유하는 객체

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"),  "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}


/**
 *    "동기화는 진행 됐지만 항상 작업이 잘 진행되지 않는다."
 *
 *    위 예제의 문제점 : 음식이 없을 때, 손님이 Table의 lock을 쥐고 안놓는다.
 *                     요리사가 lock을 얻지못해서 Table에 음식을 추가할 수 없다.
 *    해결책         : 음식이 없을 때, wait()으로 손님이 lock을 풀고 기다리게 하자.
 *                    요리사가 음식을 추가하면, notify()로 손님에게 알리자.(손님이 lock을 재획득)
 *
 *                    wait()와 notify()를 적용한 코드 보면서 비교 분석 꼭 하기! Thread15.java코드 보기!!
 */