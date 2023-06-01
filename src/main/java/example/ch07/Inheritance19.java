package example.ch07;
/**
 *    - 인터페이스를 이용한 다형성
 *      인터페이스도 구현 클래스의 부모일까? 그렇다.
 *      인터페이스 타입 매개변수는 인터페이스를 구현한 클래스의 객체만 가능.
 *      인터페이스를 메서드의 리턴타입으로 지정할 수 있다.
 *
 *      아래의 예시를 통해 자세히 살펴보자.
 */

abstract class Unit2{
    int x, y;
    abstract void move(int x, int y);
    void stop() { System.out.println("멈춥니다."); }
}

interface Fightable1 {
    void move(int x, int y); // public abstract가 생략됨, 인터페이스의 모든 메서드는 예외없이 public abstract가 붙는다.
    void attack(Fightable1 f); // Fightable 인터페이스를 구현한 클래스의 인스턴스만 가능.
}

//인터페이스를 통해서 다중상속의 문제를 해결하면서 다중상속과 같은 효과를 낼 수 있다.(다형성)
class Fighter extends Unit2 implements Fightable1 { // Fighter 클래스는 Unit 클래스로부터 상속, Fightable 인터페이스를 구현.
    // 오버라이딩 규칙 : 조상(public)보다 접근제어자의 범위가 좁으면 안된다.
    public void move(int x, int y)  { System.out.println("["+x+","+y+"] 로 이동"); }
    public void attack(Fightable1 f) { System.out.println(f+"를 공격"); }

    // 싸울 수 있는 상대를 불러온다.
    Fightable1 getFightable1(){ // Fightable1 인터페이스를 구현한 클래스의 인스턴스를 반환.(리턴타입, 인터페이스.)
        //Fighter f = new Fighter();
        //return f;   이 두 문장을 한 문장으로 바꾸면 아래의 코드와 같다.
        return new Fighter(); // 인터페이스를 구현한 객체를 반환.(조상으로 자동형변환)
    } // <- 인터페이스를 반환하는 것은 다형성 이면서도 추상화를 사용할 수 있다.
}

public class Inheritance19 {
    public static void main(String[] args){
        //Fighter f    = new Fighter();
        Unit2      u = new Fighter(); // 조상 클래스.
        Fightable1 f = new Fighter(); // 인터 페이스 : 인터페이스 타입의 참조변수로 그 인터페이스를 구현한 객체를 가리키는게 가능, stop()이 없어서 호출불가.
        Fighter   f2 = new Fighter();
        u.move(100,200);
//      u.attack(f2); // attack()메서드는 자손클래스에만 있고 조상클래스에는 없어서 호출 불가.
        u.stop();

        f.move(100, 200);
        f.attack(f2);
//      f.stop(); // Fightable1에는 stop()이 없어서 호출불가.

        Fightable1 f3 = f2.getFightable1(); // 인터페이스의 참조변수로 자손 객체 가리키기.(다형성)
    }
}
