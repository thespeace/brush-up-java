package example.ch12;

/**
 *    - 표준 애너테이션.
 *      Java에서 제공하는 애너테이션
 *
 *      @Override               : 컴파일러에게 오버라이딩하는 메서드라는 것을 알린다.
 *      @Deprecated             : 앞으로 사용하지 않을 것을 권장하는 대상(필드나 메서드)에 붙인다.
 *      @SuppressWarnings       : 컴파일러의 특정 경고메시지가 나타나지 않게 해준다.
 *      @SafeVarargs            : 지네릭스 타입의 가변인자에 사용한다.(JDK1.7-)
 *      @FunctionalInterface    : 컴파일러에게 함수형 인터페이스라는 것을 알린다.(JDK1.8-)
 *                                함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크!(안붙여도 되지만, 실수를 방지할 수 있다.)
 *                                함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있다.
 *      @Native                 : native메서드에서 참조되는 상수 앞에 붙인다.(JDK1.8-)
 */

// @Override
class Parent{ void parentMethod(){ } }
class Child extends Parent{
    @Override
    void parentMethod(){ } // 오타와 같은 자주하기 쉬운 실수를 컴파일러가 막아준다.
}

// @Deprecated : 하위 호환성을 위해 제거를 하진 않고 사용 자제를 권장.
class Testable1 {
    @Deprecated
    void oldMethod(){ } // Deprecated가 붙은 대상이 사용된 코드를 컴파일하면 콘솔에 메시지를 띄워준다.
}

// @FunctionalInterface
@FunctionalInterface // 함수형 인터페이스는 하나의 추상 메서드만 가능(규칙).
interface Testable2{
    void test();    //추상메서드
    //void check();   //추상메서드
}

public class Annotation02 {
    /**
     *    - @SuppressWarnings()
     *      괄호()안에 억제하고자하는 경고의 종류를 문자열로 지정, 해당 예시에서는 Deprecated된 메서드의 권고를 억제.
     *      둘 이상의 경고를 동시에 억제하려면 @SuppressWarnings({"deprecation", "unchecked", "varargs"})
     *      '-Xlint'옵션으로 컴파일하면 경고메시지를 확인할 수 있는데 괄호[]안의 경고의 종류를 확인할 수 있다.
     *      경고가 계속쌓이면 새로운 경고를 확인 할 수 없기때문에, 프로그램에 크게 영향을 끼치지 않는 확인한 경고는 억제해주는 것이 좋다.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args){
        Testable1 e = new Testable1();
        e.oldMethod(); // deprecated된 메서드 사용시 자제 권고를 확인할 수 있다.
    }
}
