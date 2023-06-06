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


class Outer{

    //예제 1) 내부 클래스의 static.
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



    //예제 2) 내부 클래스의 static 멤버와 인스턴스 멤버.
    class InstanceInner1 {} // 인스턴스 멤버.
    static class StaticInner1 {} // static 멤버.

    InstanceInner1 iv = new InstanceInner1();     // 인스턴스멤버끼리는 직접 접근 가능
    static StaticInner1 cv = new StaticInner1();  // static 멤버끼리는 직접 접근 가능

    static void staticMethod() { // static멤버는 인스턴스 멤버에 직접 접근 불가.
        //InstanceInner1 obj1 = new InstanceInner1(); // static 멤버가 인스턴스 멤버에 접근 할 수 없기때문에 생성 불가.
        StaticInner1 obj2 = new StaticInner1();

        Outer ot = new Outer(); // 인스턴스 클래스는 외부 클래스를 먼저 생성해야 생성가능, 하지만 이렇게 쓸 일이 없어야 한다.
        InstanceInner1 obj1 = ot.new InstanceInner1();
    }

    void instanceMethod() { // 인스턴스 메서드에서는 인스턴스 멤버와 static 멤버 모두 접근 가능.
        InstanceInner1 obj1 = new InstanceInner1();
        StaticInner1 obj2 = new StaticInner1(); // 인스턴스 멤버가 static 멤버 사용 가능.
        // LocalInner Iv = new LocalInner(); // 지역 내부 클래스는 외부에서 접근할 수 없다.
    }
    void myMethod1(){
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }



    //예제 3) 내부클래스는 외부 클래스의 private멤버에 접근 가능하고,지역클래스에서는 상수만 접근가능.
    private int outerIv = 0;
    static  int outerCv = 0;

    class InstanceInner2 {
        int iiv = outerIv;  // 외부 클래스의 private멤버도 접근가능하다.
        int iiv2 = outerCv;
    }

    static class StaticInner2 {
        //int siv = outerIv; // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        static int scv = outerCv;
    }

    void Mymethod2(){
        int lv = 0; // JDK1.8부터는 final이 생략되었기 때문에 변수가 아니라 상수로 간주.
        final int LV = 0; // JDK1.8부터 final 생략 가능.

        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv; // Error, 하지만 JDK1.8이후부터 사용 가능하게 되었다. 이전에는 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능했다.
            int liv4 = LV; // OK
        }
    }



    // 예제 5) 외부, 내부, 지역 클래스의 변수 구별하기.
    int value = 10; // 외부 클래스의 인스턴스 변수.
    class Inner {
        int value = 20; // 내부 클래스의 인스턴스 변수.

        void method() {
            int value = 30; // 내부 클래스의 로컬 변수.
            System.out.println("           value : " + value); // 가장 가까운 지역 변수 호출.
            System.out.println("      this.value : " + this.value); // this로 속해있는 클래스의 value 호출.
            System.out.println("Outer.this.value : " + Outer.this.value); // 외부 클래스의 value 호출.
        }
    }
}





public class Inheritance23 {
    public static void main(String[] args){
        System.out.println(Outer.InstanceInner.CONST);
        System.out.println(Outer.StaticInner.cv);
        //System.out.println(Outer.LocalInner.cv); // Error! 지역 내부 클래스의 static 상수는 메서드 내에서만 사용가능.

        //내부클래스 사용 예.
        Outer oc = new Outer(); // 외부 클래스의 인스턴스를 먼저 생성해야 인스턴스 클래스의 ~
        Outer.InstanceInner ii = oc.new InstanceInner(); // 인스턴스(내부클래스 객체)를 생성 가능.

        System.out.println( "ii.iv : " + ii.iv);
        System.out.println( "Outer.StaticInner.cv : " + Outer.StaticInner.cv); // 외부 클래스의 객체 생성없이 사용 가능.

        //스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println("si.iv : " + si.iv);

        Outer.Inner inner = oc.new Inner();
        inner.method();
    }
}
