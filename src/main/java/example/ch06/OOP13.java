package example.ch06;

public class OOP13 {
    public static void main(String[] args){
        /**
         *    - 기본형 매개 변수
         *      1. 기본형 매개변수 : 변수의 값을 읽기만 할 수 있다.(read only)
         *      2. 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.(read & write)
         */

        Data d = new Data(); //객체 생성
        d.x = 10; //
        System.out.println("main() : x = " + d.x);

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
        System.out.println("change메서드에서는 매개변수가 지역변수로서 읽히고 해당 메서드를 수행한 뒤 사라진다." +
                           "\n기본형 매개변수를 사용하면 이처럼 값을 바꿀 순 없고 읽고 지역변수로서 읽고 사용 할 수만 있다.");

    }
    static void change(int x){ // 기본형 매개변수
        x = 1000;
        System.out.println("change() : x = " + x);
    }
}
class Data { int x; }
