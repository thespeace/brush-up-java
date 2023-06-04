package example.ch07;

/**
 *    - 내부 클래스(inner class)
 *      클래스 안의 클래스
 *          ex) class A { // (B의)외부 클래스
 *                  ...
 *                  class B { // (A의)내부 클래스
 *                      ...
 *                  }
 *                  ...
 *              }
 *    - 내부 클래스의 장점
 *          - 내부 클래스에서 외부 클래스의 멤버들에 쉽게 접근할 수 있다. 즉 객체생성없이 사용 가능하다.
 *          - 코드의 복잡성을 줄일 수 있다.(캡슐화, 외부클래스 안에서만 내부클래스를 사용하면 다른클래스에서 내부클래스에 접근할 수 없다.)
 *
 *    - 내부 클래스의 종류와 특징
 *          내부 클래스의 종류와 유효범위(scope)는 변수와 동일
 *              ex) 변수 선언과 마찬가지로 클래스도 선언 가능하다.
 *                  class Outer { // 클래스 영역
 *                      class instanceIner {}
 *                      static class StaticIner {}
 *
 *                      void myMethod(){ // 메서드 영역
 *                          class LocalInner {}
 *                      }
 *                  }
 *
 *          * 내부 클래스의 종류와 특징
 *          1. 인스턴스 클래스 : 외부 클래스의 멤버변수 선언위치에 선언하며, 외부 클래스의 인스턴스멤버처럼 다루어진다.
 *                             주로 외부 클래스의 인스턴스멤버들과 관련된 작업에 사용 될 목적으로 선언된다.
 *          2. 스태틱 클래스  : 외부 클래스의 멤버변수 선언위치에 선언하며, 외부 클래스의 static멤버처럼 다루어진다.
 *                            주로 외부 클래스의 static멤버, 특히 static 메서드에서 사용될 목적으로 선언된다.
 *          3. 지역 클래스   : 외부 클래스의 메서드나 초기화블럭 안에 선언하며, 선언된 영역 내부에서만 사용 될 수 있다.
 *          4. 익명 클래스   : 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용). ex) 이벤트 처리시 사용. AWT, SWY, GUI..
 */

class AA {
    int i = 100;
    BB b = new BB();
}

class BB {
    void method(){
        AA a = new AA(); // 객체로 다른 클래스의 멤버를 불러와서 접근 가능.
        System.out.println(a.i);
    }
}

//내부 클래스의 예
class CC {
    int i = 200;
    class DD{ // 해당 내부클래스는 외부클래스의 멤버 객체로 볼 수 있다.
        void method(){
            System.out.println(i); // 객체 생성없이 외부 클래스의 멤버 접근 가능.
        }
    }
}

public class Inheritance22 {
    public static void main(String[] args){
        BB b = new BB();
        b.method();

        //외부 클래스의 객체 생성
        CC cc = new CC();
        //외부 클래스를 통해 내부 클래스를 불러와 내부 클래스의 객체 생성.
        CC.DD dd = cc.new DD();
        //내부 클래스의 메서드 호출
        dd.method();
    }
}
