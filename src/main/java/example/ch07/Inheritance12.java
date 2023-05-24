package example.ch07;

public class Inheritance12 {
    public static void main(String[] args){
        /**
         *    - 참조변수의 형변환
         *      사용할 수 있는 멤버의 갯수를 조절하는 것( 주소값, 객체는 전혀 바뀌지않고 오직 멤버의 갯수만 바뀐다)
         *          <-> 기본형 : 값이 바뀐다.
         *      조장, 자손 관계의 참조변수는 서로 형변환 가능.( 형제관계 X )
         */
        FireEngine f = new FireEngine();
        Car c = (Car) f;                //OK, 조상인 Car타입으로 형변환( UpCasting, 생략 가능 )
        FireEngine f2 = (FireEngine) c; //OK, 자손인 FireEngine타입으로 형변환( DownCasting, 생략 불가 )
        // Ambulance a = (Ambulance) f; //Error, 상속관계가 아닌 클래스 간의 형변환 불가.

    }
}
class Car{
    String Color;
    int door;
    void drive(){
        System.out.println("drive, Brrrr~");
    }
    void stop(){
        System.out.println("stop!!!");
    }
}
class FireEngine extends Car {
    void water(){
        System.out.println("water!!!");
    }
}
class Ambulance extends Car {
    void siren(){
        System.out.println("woo-woo!!!");
    }
}