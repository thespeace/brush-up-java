package example.ch17.practice.p10_extends.super2;

public class ClassC extends ClassB{
    public ClassC( ) {
        super(10, 20); //생략 불가능, 부모의 기본생성자가 정의된 경우에는 정의해줘야 한다.
        System.out.println("ClassC 생성자");
    }
}
