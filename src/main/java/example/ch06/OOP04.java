package example.ch06;

public class OOP04 {
    public static void main(String[] args){
        /**
         *    - 객체의 생성과 사용
         *      1) 객체의 생성
         *         클래스명 변수명;          // 클래스의 객체를 참조하기 위한 참조변수를 선언
         *         변수명 = new 클래스명();  // 클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장
         *
         *         ex) Tv t;         // Tv클래스 타입의 * 참조변수 t를 선언 *
         *             t = new Tv(); // Tv인스턴스(객체)를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장
         *
         *      2) 객체의 사용( = 객체가 가지고 있는 변수, 메서드 사용)
         *         t.channel = 7;   // Tv인스턴스의 멤버변수 channel의 값을 7로 한다.(변수 사용)
         *         t.channelDown(); // Tv인스턴스의 메서드 channelDown()을 호출한다.(메서드 사용)
         *         System.out.println("현재 채널은 " + t.channel + " 입니다.");
         *
         *      * 전체 적인 흐름 : (1) 클래스 작성(설계도) -> (2) 객체 생성(제품 생성) -> (3) 객체 사용(제품 사용) *
         */

        Tv t;
        t = new Tv();
        Tv t1 = new Tv();
        t1 = t; // GC(garbage collector)가 알아서 사용하지 않는 t1의 메모리를 삭제해준다. 그리고 두 개의 참조변수에 하나의 객체를 저장하는 것이 가능하다. <-> 하나의 참조변수로 두 개의 객체를 가리키는 것은 불가능하다.
        t.channel = 7;
        System.out.println("현재 채널은 : " + t.channel + " 입니다.");
        t.channelDown();
        System.out.println("현재 채널은 : " + t.channel + " 입니다.");
        System.out.println("다른 Tv 채널은 : " + t1.channel + " 입니다.");



    }
}
class Tv { // Tv클래스( 6개의 멤버 : 변수 3개 + 메서드 3개 )
    String color;  // 색깔
    boolean power; // 전원 상태
    int channel;   // 채널

    void power() { power = !power; }
    void channelUp() { channel++; }
    void channelDown() { channel--; }
}