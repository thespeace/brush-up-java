package example.ch07;

/**
 *    - 인터페이스의 개념과 장점 1.
 *
 *      interface == inter(~사이) + face(얼굴, 대상).
 *      1.두 대상(객체) 간의 '연결, 대화, 소통'을 돕는 '중간 역할'을 한다.
 *          혹은 '껍데기, 기계의 껍데기'로 복잡한 기계를 인간이 다루기 쉽게 가이드라인을 제공하는 역할을 하는 것을 인터페이스라 한다. ex) 자판기의 외형, 컴퓨터의 GUI.
 *
 *      2.선언(설계)와 구현을 분리시킬 수 있게 해준다.
 *
 *          ex) 인터페이슬 사용해서, 선언부와 구현부를 분리하는 예.
 *              interface I { public void method(); } // 선언부만 떼어내기.
 *              class C implements I{
 *                  public void method(){ System.out.println("mehotdInB"); }
 *              }
 *          코드를 보다 변경에 유리하고 유연한 코드가 된다.
 *
 *      3.인터페이스 덕분에 B가 변경되어도 A는 안바꿀 수 있게 된다.(느슨한 결합)
 *          변경을 최소화할 수 있고, 변경에 유연하게 대처할 수 있게 된다.
 *          ex) A가 B를 사용(A가 B에 의존) : A(User) -> B(Provider)
 *              B를 감싸고 있는 인터페이스로 인해 알갱이인 B가 바뀌어도 인터페이스가 바뀌지 않는 한 A는 코드를 변경하지 않아도 그대로 사용 가능해진다.
 *
 */

// 위 장점 3번의 예시.( 직접적인 관계의 두 클래스[A-B] <-> 간접적인 관계의 두 클래스(C-I-D) )

    // 직접적인 관계의 두 클래스[A-B]
    class A {
        public void methodA(B b){ b.methodB();} // method()의 선언 (선언-구현 분리)
    }
    class B {
        public void methodB(){ System.out.println("methodB()"); } // method()의 구현 (선언-구현 분리)
    }

    // 간접적인 관계의 두 클래스(C-I-D)
    interface I { void methodD();}
    class C{
        public void methodC(I i){ i.methodD();} // C는 D와 관계 없어졌다, 인터페이스와 소통하며 인터페이스를 구현한 객체들만 매개변수로 사용 가능해졌다. 때문에 인터페이스의 알맹이의 변경 및 교체가 자유로워 졌다.
    }
    class D implements I{ // D클래스가 인터페이스 I를 구현해야 method()의 매개변수로 사용 가능.
        public void methodD(){ System.out.println("methodD()"); }
    }

public class Inheritance20 {
    public static void main(String[] args){
        A a = new A();
        a.methodA(new B()); // A가 B를 사용(의존)

        C c = new C();
        c.methodC(new D());
    }
}


/**
 *    - 인터페이스의 개념과 장점 2.
 *      1.개발 시간을 단축할 수 있다.
 *          ex) A.class(User) - B.class(Provider) 가 있을때 B클래스를 호출해서 A클래스의 코드를 작성하려면 B클래스의 코드가 작성 완료될 때까지 A클래스의 코드는 진행을 못하는 상황이 발생할 수 있다.
 *              하지만 그 사이에 인터페이스를 넣는다면, A클래스는 인터페이스의 추상메서드를 호출 가능하기때문에 코드 작성을 진행 할 수 있고, B클래스는 인터페이스의 내용을 구현할 수 있게 된다.
 *              더불어 인스턴스 객체 캡슐화(private)를 통해 직접 접근은 불가하고 메서드를 통해 호출하기 때문에 인스턴스 객체에 접근도 가능하다.
 *
 *      2.변경에 유리한 유연한 설계가 가능하다. ( 인터페이스의 장점 1에서 확인 가능.)
 *
 *      3.표준화가 가능하다.(규칙)
 *          ex) JDBC : JavaApplication와 DB를 연결해주는 인터페이스의 집합, JDBC가 바뀌지 않는한 JavaApplication을 바꾸지 않아도 DB의 종류(회사) 변경이 수월하다.
 *
 *      4.서로 관계없는 클래스들을 관계를 맺어줄 수 있다.
 *          관계가 없는 클래스 혹은 어떤 상속 계층도에 있는 클래스여도 다중 상속이 가능하다는 장점을 가진 인터페이스이기 묶어준 인터페이스를 구현하도록 만들어 관계를 맺어 묶어줄 수 있다.
 */