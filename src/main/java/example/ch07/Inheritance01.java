package example.ch07;

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

//예제(Point, Point3D, Point3D_extends)를 통해 상속과 비상속의 차이점을 알아보자.
class Point{ //2차원 좌표의 한점
    int x;
    int y;
}
class Point3D{//3차원 좌표의 한점, point class와는 관계없이 사용가능(독립적)
    int x, y, z;
}
class Point3D_extends extends Point{// point class를 상속받아 사용.
    //상속을 받아 int x , y; 가 숨겨져있다.
    int z;
}

//예제
class Tv{
    boolean power; //전원상태(on/off)
    int channel;   // 채널

    void power()       { power = !power; }
    void channelUp()   { ++channel; }
    void channelDown() { --channel; }
}

class SmartTv extends Tv{ //SmartTv는 Tv에 캡션(자막)을 보여주는 기능을 한다.
    boolean caption; // 캡션상태(on/off)
    void displayCaption(String text) {
        if(caption) // 캡션 상태가 on(true)일 때만 text를 보여 준다.
            System.out.println(text);
    }
}

public class Inheritance01 {
    public static void main(String[] args){
        SmartTv stv = new SmartTv();
        stv.channel = 10;       // 조상 클래스로부터 상속받은 멤버
        stv.channelUp();        // 조상 클래스로부터 상속받은 멤버
        System.out.println(stv.channel);
        stv.displayCaption("Hello, World!");
        stv.caption = true; // 캡션(자막) 기능을 켠다.
        stv.displayCaption("Hello, World");
    }
}