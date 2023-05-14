package example.ch06;

public class OOP17 {
    public static void main(String[] args){
        /**
         *    - 생성자 this()
         *      생성자에서 다른 생성자 호출할 때 사용.
         *      같은 클래스안에 있는 생성자를 호출할 때 생성자이름말고 this를 사용할 수 있다.(규칙)
         *      다른 생성자 호출시 첫 줄에서만 사용가능.
         */
    }
}
class Car2{
    String color;       // 진짜이름 : this.color
    String gearType;    // 진짜이름 : this.gearType
    int door;           // 진짜이름 : this.door

    Car2(){ // 매개 변수를 받지 않으면 default 값으로 초기화.
        this("white","auto", 4); //this로 다른 생성자를 불러오면서 코드의 중복을 제거.
        //new Car2("white","auto",4); <- this를 사용.
    }

    Car2(String color){
        this(color,"auto", 4);
    }
    Car2(String color, String gearType, int door){
        this.color = color; // 참조변수 this 사용함으로써 이름이 같은 지역변수와 인스턴스 변수를 구별하고 this로 인스턴스 변수를 가리킨다.
        this.gearType = gearType;
        this.door = door;
    }
}
/**
 *    - 참조변수 this( <-> this() 생성자. )
 *      인스턴스 자신을 가리키는 참조변수
 *      인스턴스 메서드(생성자 포함)에서 사용가능
 *      지역변수와 인스턴스 변수를 구별할 때 사용.
 *      클래스 메서드(static 메서드)에서는 this 사용불가.
 *
 *
 *    - 참조변수 this와 생성자 this() 정리
 *      1. this : 인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다.
 *                모든 인스턴스메서드에 지역변수로 숨겨진 채로 존재한다. (선언 안해서 사용 가능)
 *      2. this(), this(매개변수) : 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.(클래스이름 대신 this())
 *
 *          + 참고, this와 this()는 비슷하게 생겼을 뿐 완전히 다른 것이다. this는 '참조 변수'이고, this()는 '생성자'이다.
 */