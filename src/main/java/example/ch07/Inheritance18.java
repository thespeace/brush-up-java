package example.ch07;

public class Inheritance18 {
    public static void main(String[] args){
        /**
         *    - 인터페이스(interface)
         *      "추상 메서드의 집합" ( 프로그래밍 관점 ).
         *      구현된 것이 전혀 없는 설계도, 즉 껍데기(모든 멤버가 public).
         *      인스턴스 변수를 가질 수 없다.
         *
         *      Q.추상클래스와 인터페이스의 차이점은?
         *      A.추상클래스는 일반 클래스인데 추상 메서드를 가지고 있어서 추상클래스가 되지만, 인터페이스는 추상 메서드만 가지고 있는 것.
         *
         *          ex) interface 인터페이스이름 {
         *                  public static final 타입 상수이름 = 값;  // 상수는 선언 가능 <-> 변수(클래스, 인스턴스)는 선언 불가. 인스페이스의 모든 멤버는 public이어야 한다.
         *                  public abstract 메서드이름(매개변수목록); // 추상 메서드만 가능.
         *              }
         */
    }
}
interface PlayingCard{
    public static final int SPADE = 4; // 상수.
    final int DIAMOND = 3;  // public static final int DIAMOND = 3;
    static int HEART = 2;   // public static final int HEART = 2;
    int CLOVER = 1;         // public static final int CLOVER = 1;  <- 상수도 예외없이 항상 public이고, static이고 final이기 때문에 일부 또는 전부를 생략 가능.

    public abstract String getCardNumber(); // 캡슐화 추상메서드.
    String getCardKind(); // 추상 메서드, 인터페이스의 모든 메서드는 예외없이 항상 public이고 abstract이니까 생략 가능.
}

/**
 *    - 인터페이스의 상속
 *      인터페이스의 조상은 인터페이스만 가능.(Object가 최고 조상이 아니다)
 *      다중 상속이 가능.(추상메서드는 충돌해도 문제 없음) : 선언부만 있고 구현부는 없기 때문에 충돌문제가 없다. <-> 충돌문제로 인해 단일 상속을 한다.
 */
interface Fightable extends Movable, Attackable{ }
interface Movable { // <- 기본 최고 조상인 extends Object X, 인터페이스의 조상은 인터페이스만 가능.
    /** 지정된 위치(x,y)로 이동하는 기능의 메서드*/
    void move(int x, int y);
}
interface Attackable{
    /** 지정된 대상(u)을 공격하는 기능의 메서드 */
    void attack(Unit u);
}

/**
 *    - 인터페이스의 구현
 *      인터페이스에 정의된 추상 메서드를 완성하는 것.
 *
 *          class 클래스이름 implements 인터페이스이름 { // implements(구현 : 인터페이스) <-> extends(상속 : 추상클래스)
 *              // 인터페이스에 정의된 추상메서드를 모두 구현해야 한다.
 *          }
 *
 *      일부만 구현하는 경우, 클래스 앞에 abstract를 붙여야 한다.
 *          abstract class Fighter implements Fightable {
 *              public void move(int x, int y) { ... }  // 추상메서드의 멤버객체를 두개 중 하나만 구현했기 때문에 추상 클래스임으로 abstract를 붙여야 한다.
 *          }
 *
 *
 *    Q. 인터페이스란?
 *    A. ** 추상 메서드의 집합 ** - 핵심!  +  jdk1.8부터는 기능적으로 보완하기 위해서 상수, static메서드, 디폴트메서드가 추가되었다.
 *
 *    Q. 인터페이스의 구현(implements)이란?
 *    A. 인터페이스의 추상메서드 몸통{} 만들기(미완성 설계도 완성하기)
 *
 *    Q. 추상클래스와 인터페이스의 공통점은?
 *    A. 추상 메서드를 가지고 있다.(미완성 설계도)
 *
 *    Q. 추상클래스와 인터페이스의 차이점은?
 *    A. 인터페이스는 인스턴스변수, 생성자, 인스턴스메서드 작성 불가, 오직 추상메서드만 작성 가능.
 */