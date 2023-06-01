package example.ch07;
/**
 *    - 인터페이스를 이용한 다형성
 *      인터페이스도 구현 클래스의 부모일까? 그렇다.
 *      인터페이스 타입 매개변수는 인터페이스를 구현한 클래스의 객체만 가능.
 *      인터페이스를 메서드의 리턴타입으로 지정할 수 있다.
 *
 *      아래의 예시를 통해 자세히 살펴보자.
 */

//인터페이스를 통해서 다중상속의 문제를 해결하면서 다중상속과 같은 효과를 낼 수 있다.(다형성)
class Fighter extends Unit implements Fightable1 { // Fighter 클래스는 Unit 클래스로부터 상속, Fightable 인터페이스를 구현.
    public void move(int x, int y)  { /* 내용 생략 */ }
    public void attack(Fightable1 f) { /* 내용 생략 */ }
    Fightable1 method(){ // Fightable1 인터페이스를 구현한 클래스의 인스턴스를 반환.(리턴타입, 인터페이스.)
        //Fighter f = new Fighter();
        //return f;   이 두 문장을 한 문장으로 바꾸면 아래의 코드와 같다.
        return new Fighter(); // 인터페이스를 구현한 객체를 반환.(조상으로 자동형변환)
    }
}

interface Fightable1 {
    void move(int x, int y);
    void attack(Fightable1 f); // Fightable 인터페이스를 구현한 클래스의 인스턴스만 가능.

}

public class Inheritance19 {
    public static void main(String[] args){
        Unit       u = new Fighter(); // 조상 클래스
        Fightable1 f = new Fighter(); // 인터 페이스 : 인터페이스 타입의 참조변수로 그 인터페이스를 구현한 객체를 가리키는게 가능.
//        Fightable1 f1 = method(); // 인터페이스의 참조변수로 자손 객체 가리키기.(다형성)

    }
}

/**
 *    - 인터페이스를 이용한 다형성
 *      인터
 */


