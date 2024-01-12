package example.ch17.practice.p06_access;

public class CounterMain {
    public static void main(String[] args) {
        MaxCounter counter = new MaxCounter(3);
        counter.increament();
        counter.increament();
        counter.increament();
        counter.increament();
        int count = counter.getCount();
        System.out.println(count);
    }
}
