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
 */
