package example.ch17.practice.p10_extends.super2;

public class ClassB extends ClassA{
    public ClassB(int a) {
//        this(a,200); // this를 수행하더라도 한번은 super()을 호출 해야한다.
        super(); //매개변수가 없는 기본 생성자는 생략 가능
        System.out.println("ClassB 생성자 A : " + a);
    }

    public ClassB(int a, int b) {
        super(); //매개변수가 없는 기본 생성자는 생략 가능
        System.out.println("ClassB 생성자 a : " + a + " b : " + b);
    }
}
