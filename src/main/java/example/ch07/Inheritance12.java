package example.ch07;

public class Inheritance12 {
    public static void main(String[] args){
        /**
         *    - 참조변수의 형변환
         *      사용할 수 있는 멤버의 갯수를 조절하는 것( 주소값, 객체는 전혀 바뀌지않고 오직 멤버의 갯수만 바뀐다)
         *          <-> 기본형 : 값이 바뀐다.
         *      ** 조장, 자손 관계의 참조변수는 서로 형변환 가능.( 형제관계 X ) **
         */
        FireEngine f = new FireEngine();
        Car c = (Car) f;                //OK, 조상인 Car타입으로 형변환( UpCasting, 사용할 수 있는 멤버변수가 줄어들기 때문에 안전하다고 판단, 생략 가능 )
        c.drive();
        c.stop();
        // c.water(); // 형변환을 했더라도 자손타입의 멤버변수는 사용 불가. 컴파일 에러, Car타입의 참조변수로는 water()를 호출할 수 없다.

        FireEngine f2 = (FireEngine) c; //OK, 자손인 FireEngine타입으로 형변환( DownCasting, 사용할 수 있는 멤버변수가 늘어나기 대문에 불안전하다고 판단, 생략 불가 )
        f2.water(); // 타입 일치로, 자손타입의 모든 멤버변수를 사용 가능.
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
