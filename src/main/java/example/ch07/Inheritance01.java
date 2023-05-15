package example.ch07;

public class Inheritance01 {
    public static void main(String[] args){
        /**
         *    - 상속(Inheritance)
         *      기존의 클래스로 새로운 클래스를 작성하는 것.(코드의 재사용)
         *      두 클래스를 부모와 자식으로 관계를 맺어주는 것.
         *
         *      자손은 조상(부모, 부모의 부모, ...)의 모든 멤버를 무조건 모두 다! 상속받는다.(생성자, 초기화 블럭 제외)
         *      자손의 멤버 개수는 조상보다 적을 수 없다.(같거나 많다)
         *
         *      자손의 변경은 조상에 영향을 미치지 않는다.
         *
         *    - 기본문법
         *
         *      class 자식클래스 extends 부모클래스 {
         *          // ...
         *      }
         *
         */

    }
}
//예시
class Parent{ // 부모 클래스
    int age;
}
class Child extends Parent{ // 자식 클래스, extends(확장)로 부모와 자식클래스를 상속 시켜준다.
    // ... 보이지 않지만 부모클래스로 부터 상속받은 멤버변수인 age가 있다.
    void play(){
        System.out.println("Let's play!");
    } // 새로운 멤버 추가, 부모의 멤버에는 영향이 없다.
}

