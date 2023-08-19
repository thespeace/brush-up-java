package example.ch12;

/**
 *    - 메타 애너테이션.
 *      "애너테이션을 위한 애너테이션", "애너테이션을 만들때 사용하는 애너테이션".
 *      메타 애너테이션은 java.lang.annotation패키지에 포함.
 *
 *      @Target                 : 애너테이션이 적용가능한 대상을 지정하는데 사용한다.
 *
 *                                대상 타입         | 의미
 *                                ANNOTATION_TYPE | 애너테이션
 *                                CONSTRUCTOR     | 생성자
 *                                FIELD           | 필드(멤버변수,enum상수)
 *                                LOCAL_VARIABLE  | 지역변수
 *                                METHOD          | 메서드
 *                                PACKAGE         | 패키지
 *                                PARAMETER       | 매개변수
 *                                TYPE            | 타입(클래스, 인터페이스, enum)
 *                                TYPE_PARAMETER  | 타입 매개변수(JDK1.8-)
 *                                TYPE_USE        | 타입이 사용되는 모든 곳(JDK1.8-)
 *
 *      @Documented             : 애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
 *                                javaDoc으로 작성한 문서에 포함시키려면 @Documented를 붙인다.
 *      @Inherited              : 애너테이션이 자손 클래스에 상속되도록 한다.
 *                                {@code
 *                                   @Inherited // @SuperAnno가 자손까지 영향 미치게.
 *                                   @Interface SuperAnno { }
 *
 *                                   @SuperAnno
 *                                   class Parent { }
 *
 *                                   // @SuperAnno 가 붙은것과 같다. 조상의 애너테이션이 상속.
 *                                   class Child extends Parent { } // Child에 애너테이션이 붙은 것으로 인식.
 *                                }
 *      @Retention              : 애너테이션이 유지되는 범위(기간)를 지정하는데 사용한다.
 *
 *                                유지 정책 | 의미
 *                                SOURCE   | 소스 파일에만 존재, 클래스파일에는 존재하지 않음.
 *                                CLASS    | 클래스 파일에 존재, 실행시에 사용불가, "기본값"이지만 잘사용하지 않는다.
 *                                RUNTIME  | 클래스 파일에 존재, 실행시에 사용가능.
 *
 *                                컴파일러에 의해 사용되는 애너테이션의 유지 정책은 SOURCE이다.
 *                                {@code - @override
 *                                   @Target(ElementType.METHOD)
 *                                   @Retention(RetemtionPolicy.SOURCE)  //컴파일러가 오버라이딩을 제대로 했는지 체크, 실행시에는 필요가 없기때문에 유지정책은 SOURCE이다.
 *                                   public @interface Override { }
 *                                }
 *
 *                                실행시에 사용 가능한 애너테이션의 정책은 RUNTIME이다.
 *                                {@code - @FunctionalInterface
 *                                   @Documented
 *                                   @Retention(RetemtionPolicy.RUNTIME) //컴파일러가 FunctionalInterface를 제대로 작성했는지 체크해주고, 런타임까지 살아서 가기때문에 RUNTIME.
 *                                   @Target(ElementType.TYPE)
 *                                   public @interface FunctionalInterface { }
 *                                }
 *
 *      @Repeatable             : 애너테이션을 반복해서 적용할 수 있게 한다.(JDK1.8)
 *                                반복해서 붙일 수 있는 애너테이션을 정의할 때 사용.
 *                                {@code
 *                                   @Documented(ToDos.class) // Todo애너테이션을 여러 번 반복해서 쓸 수 있게 한다.
 *                                   @interface Todo {
 *                                       String value();
 *                                   }
 *
 *                                   @ToDo("delete test codes.") // @Repeatable이 붙은 애너테이션은 반복해서 붙일 수 있다.
 *                                   @ToDo("override inherited methods")
 *                                   class MyClass{
 *                                      ...
 *                                   }
 *
 *
 *                                   // @Repeatable인 @ToDo를 하나로 묶을 컨테이너 애너테이션도 정의해야 함.
 *                                   @interface ToDos{ // 여러 개의 ToDo애너테이션을 담을 컨테이너 애너테이션 ToDos
 *                                      ToDo[] value(); // ToDo애너테이션 배열타입의 요소를 선언, 이름이 반드시 value이어야 함.
 *                                   }
 *                                }
 *
 */

@MyAnnotation       // 적용 대상이 TYPE인 경우, 즉 클래스, 인터페이스인 경우.
class MyClass {
    @MyAnnotation   // 적용 대상이 FIELD인 경우, 즉 멤버변수인 경우.
    int i;

    @MyAnnotation   // 적용 대상이 TYPE_USE인 경우, 즉 참조변수인 경우.
    MyClass mc;
}

public class Annotation03 {
    public static void main(String[] args){
    }
}
