package example.ch07;

/**
 *    - 내부 클래스의 제어자와 접근성
 *      내부 클래스의 제어자는 변수에 사용 가능한 제어자와 동일 <-> 일반 클래스는 (defalut), public 접근제어자만 사용 가능.
 *          ex) class Outer {
 *                  private class InstanceInner {}
 *                  protected static class StaticInner {}
 *                  void myMethod(){
 *                      class LocalInner {}
 *                  }
 *              }
 */

//예제 1) 내부 클래스의 static.
class Outer{
    class InstanceInner{
        int iv = 100;
        //static int cv = 100; //에러! static 변수를 선언할 수 없다.
        final static int CONST = 100; // fianl static은 상수이므로 허용
    }
    static class StaticInner{ // static멤버는 객체 생성없이 사용 가능한 것이니 class도 static이 꼭 붙어야 한다. 또한 static 내부 클래스에서는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        int iv = 200;
        static int cv = 200; // static 클래스만 static멤버를 정의할 수 있다.
    }
    void myMethod(){
        class LocalInner {
            int iv = 300;
            //static int cv = 300; // 에러! static 변수를 선언할 수 없다.
            final static int CONST = 300; // final static은 상수이므로 허용.
        }
    }
}


//예제 2) 내부 클래스의 static 멤버와 인스턴스 멤버.


public class Inheritance23 {
    public static void main(String[] args){
        System.out.println(Outer.InstanceInner.CONST);
        System.out.println(Outer.StaticInner.cv);
        //System.out.println(Outer.LocalInner.cv); // Error! 지역 내부 클래스의 static 상수는 메서드 내에서만 사용가능.
    }
}
