package example.ch06;

public class OOP14 {
    public static void main(String[] args){
        /**
         *    - static 메서드와 인스턴스 메서드
         *      static : "정적인, 움직이지 않는다."는 뜻으로, 메모리에서 고정되기 때문에 붙은 이름이지만, 실제 소스에서 static을 사용한다는 의미는 모든 객체가 '공유'한다는 의미이다.
         *
         *      1. 인스턴스 메서드
         *         - 인스턴스 생성 후, '참조변수.메서드이름()'으로 호출
         *         - 인스턴스 멤버(인스턴스 변수, 인스턴스 메서드)와 관련된 작업을 하는 메서드
         *         - 메서드 내에서 인스턴스 변수 사용 가능
         *
         *      2. static 메서드(클래스메서드)  ex) Math.random(), 객체생성 X
         *         - 객체 생성없이 '클래스이름.메서드이름()'으로 호출
         *         - 인스턴스 멤버와 관련없는 작업을 하는 메서드
         *         - 메서드 내에서 인스턴스 변수 사용불가
         *
         *      간단히 말해, 이 두 메서드의 차이점은 인스턴스 변수의 사용여부에 따라 다르다.
         *
         *          Q1.인스턴스 vs 클래스 메서드, 이 둘의 차이점은? 인스턴스 변수의 사용 유무!
         *          Q2.static을 언제 붙여야 하는가? ** 인스턴스 변수를 사용하지 않을 때! **
         */

        System.out.println(MyMath2.add(200L,100L)); // 클래스 메서드 호출( 클래스이름.클래스 메서드 ), 객체의 생성 없이 호출 가능(참조변수 X).
        MyMath2 mm = new MyMath2(); // 인스턴스 생성
        mm.a = 200L;
        mm.b = 100L;
        System.out.println(mm.add()); // 인스턴스 메서드 호출(참조변수.인스턴스 메서드)

        TestClass.staticMethod();
        TestClass cc = new TestClass();
        cc.instanceMethod();

    }
}
class MyMath2 {
    long a, b;
    
    long add(){ // 인스턴스 메서드, 매개변수를 받지 않기 때문에 인스턴스 변수를 사용하는 것이기도 하다.
        return a + b; //인스턴스 변수
    }
    static long add(long a, long b){ // 클래스 메서드(static 메서드)
        return a + b; //지역변수
    }

}

/**
 *    - 메서드 간의 호출과 참조
 *      static 메서드는 인스턴스 변수(iv)를 사용할 수 없다.
 */
class TestClass{
    int iv = 1;        // 인스턴스 변수 , 객체생성 후 사용가능.
    static int cv = 2; // 클래스 변수   , 언제나 사용가능.

    void instanceMethod(){      // 인스턴스 메서드, 객체 생성 후 호출 가능.
        System.out.println("인스턴스 변수 : " + iv); // 인스턴스 변수를 사용할 수 있다.
        System.out.println("클래스 변수 : " + cv); // 클래스 변수를 사용할 수 있다.
    }

    static void staticMethod(){ // static 메서드, 객체 생성 없이 호출 가능.
      //System.out.println(iv); // 에러! 인스턴스 변수를 사용할 수 없다.
        System.out.println("클래스 변수 : " + cv); // 클래스 변수는 사용할 수 있다.
    }
}

/**
 *      static 메서드는 인스턴스 메서드(im)를 호출할 수 없다.
 *
 *      Q. static 메서드는 static 메서드 호출 가능?
 *         A. 네
 *      Q. static 메서드는 인스턴스 변수 사용 가능?
 *         A. 아니요, 객체를 생성해야 사용 가능. 그럼 객체란? 인스턴스 변수의 묶음.
 *      Q. static 메서드는 인스턴스 메서드 호출 가능?
 *         A. 아니요, 위의 인스턴스 변수를 사용하지 못하는 이유와 같다.
 *      Q. 왜? static 메서드는 인스턴스 멤버를 쓸 수 없나요?
 *         A. static메서드 호출시 객체(인스턴스 변수 묶음)가 없을 수도 있어서.
 */

class TestClass2 {
    void instanceMethod() {}
    static void staticMethod() {}
    void instanceMethod2() { // 인스턴스 메서드
        instanceMethod();    // 다른 인스턴스 메서드를 호출한다.
        staticMethod();      // static 메서드를 호출한다.
    }
    static void staticMethod2(){ // static 메서드
      //instanceMethod();        // 에러!!! 인스턴스 메서드를 호출할 수 없다. 인스턴스 변수를 사용하는 객체가 필요한 메서드임으로 호출할 수 없다.
        staticMethod();          // static메서드는 호출 할 수 있다.
    }
}
