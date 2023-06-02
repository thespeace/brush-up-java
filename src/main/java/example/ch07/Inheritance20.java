package example.ch07;

/**
 *    - 인터페이스의 개념과 장점
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
 *          ex) A가 B를 사용(A가 B에 의존) : A(User) -> B(Provider)
 *              B를 감싸고 있는 인터페이스로 인해 알갱이인 B가 바뀌어도 인터페이스가 바뀌지 않는 한 A는 코드를 변경하지 않아도 그대로 사용 가능해진다.
 *
 */

// 위 장점 3번의 예시.( 직접적인 관계의 두 클래스[A-B] <-> 간접적인 관계의 두 클래스(C-I-D) )

    // 직접적인 관계의 두 클래스[A-B]
    class A {
        public void methodA(B b){ b.methodB();}
    }
    class B {
        public void methodB(){ System.out.println("methodB()"); }
    }

    // 간접적인 관계의 두 클래스(C-I-D)
    interface I { void methodD();}
    class C{
        public void methodC(I i){ i.methodD();} // C는 D와 관계 없어졌다, 인터페이스와만 소통한다.
    }
    class D implements I{
        public void methodD(){ System.out.println("methodD()"); }
    }

public class Inheritance20 {
    public static void main(String[] args){
        A a = new A();
        a.methodA(new B());

        C c = new C();
        c.methodC(new D());
    }
}
