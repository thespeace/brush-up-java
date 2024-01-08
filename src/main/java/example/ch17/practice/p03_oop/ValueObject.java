package example.ch17.practice.p03_oop;

public class ValueObject {
    int value;

    void add() {
        value++;
        System.out.println("숫자 증가 value=" + value);
    }
}
