package example.ch13;

import java.util.ArrayList;

/**
 *    " Thread14.java 코드를 wait()과 notify()를 사용하여 리팩토링 "
 *    Thread14.java와 달리 한 쓰레드가 lock을 오래 쥐는 일이 없어짐. 효율적이 된다.
 *
 *    wait(), notify()의 단점 : 호출의 대상이 불분명함. -> 단점을 해소한 것이 "lock&condition"
 */

class Customer2 implements Runnable {
    private Table2  table;
    private String food;

    Customer2(Table2 table, String food) {
        this.table = table;
        this.food  = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(100);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        } // while
    }
}

class Cook2 implements Runnable {
    private Table2 table;

    Cook2(Table2 table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(10);} catch(InterruptedException e) {}
        } // while
    }
}

class Table2 {
    String[] dishNames = { "donut","donut","burger" }; // donut의 확률을 높인다.
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait(); // COOK쓰레드를 기다리게 한다.(음식이 테이블에 꽉 찼을때 요리사를 대기 시키는 것.)
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }
        dishes.add(dish);
        notify();  // 기다리고 있는 CUST를 깨우기 위함. (음식 추가시 손님께 통보)
        System.out.println("Dishes:" + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized(this) {
            String name = Thread.currentThread().getName();

            while(dishes.size()==0) { // 음식이 없다면-
                System.out.println(name+" is waiting.");
                try {
                    wait(); // CUST쓰레드를 기다리게 한다.(손님을 대기)
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }

            while(true) {
                for(int i=0; i<dishes.size();i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i); // 음식을 먹고나면 -
                        notify(); // 잠자고 있는 COOK을 깨우기 위함(요리사를 깨우기, 통보)
                        return;
                    }
                } // for문의 끝

                try {
                    System.out.println(name+" is waiting.");
                    wait(); // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.(원하는 음식이 없을 때 손님을 대기)
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            } // while(true)
        } // synchronized
    }
    public int dishNum() { return dishNames.length; }
}

public class Thread15 {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();

        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"),  "CUST1").start(); // 손님1은 도넛만 먹는 손님.
        new Thread(new Customer2(table, "burger"), "CUST2").start(); // 손님2는 버거만 먹는 손님.
        Thread.sleep(2000);
        System.exit(0);
    }
}
