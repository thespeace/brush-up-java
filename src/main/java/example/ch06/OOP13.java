package example.ch06;

public class OOP13 {
    public static void main(String[] args){
        /**
         *    - 기본형 매개 변수
         *      1. 기본형 매개변수 : 변수의 값을 읽기만 할 수 있다.(read only)
         *      2. 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.(read & write)
         *
         *      기본형 매개변수는 단순히 메인 메서드가 가진 값만 전달하기 때문에 읽기만 가능하다.
         *      <-> 참조형 매개변수는 메인 메서드가 참조변수(객체의 저장 주소)를 전달하기 때문에 읽고 쓰기가 가능해진다.
         */

        Data d = new Data(); //객체 생성
        d.x = 10; //
        System.out.println("main() : x = " + d.x);

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
        System.out.println("change메서드에서는 매개변수가 지역변수로서 읽히고 해당 메서드를 수행한 뒤 사라진다." +
                           "\n기본형 매개변수를 사용하면 이처럼 값을 바꿀 순 없고 읽고 지역변수로서 읽고 사용 할 수만 있다.");

        change(d);
        System.out.println("main() : x = " + d.x);


        System.out.println("===============================");


        Data2 d2 = new Data2();
        d2.y = 10;

        Data2 d3 = copy(d2); // 같은 클래스 안에 있기 때문에 참조변수( ex) e.copy() ) 없이 호출 가능.
        System.out.println("d2.y = " + d2.y);
        System.out.println("d3.y = " + d3.y);
    }
    static void change(int x){ // 기본형 매개변수
        x = 1000;
        System.out.println("기본형 매개변수 -> change() : x = " + x);
    }
    static void change(Data d){ // 참조형 매개변수
        d.x = 1000;
        System.out.println("참조현 매개변수 -> change() : x = " + d.x);
    }
    static Data2 copy(Data2 d2){ // 객체 생성 메서드, 객체 생성없이 호출 가능.
        Data2 tmp = new Data2(); // 새로운 객체 tmp 생성
        tmp.y = d2.y; // d2.y의 값을 tmp.y에 복사한다.
        return tmp; // 참조형 반환타입 메서드임으로 복사한 객체의 주소를 반환한다.
    }
}
class Data { int x; }
class Data2 { int y; }
