package example.ch12;

/**
 *    - 메타 애너테이션.
 *      "애너테이션을 위한 애너테이션", "애너테이션을 만들때 사용하는 애너테이션".
 *      메타 애너테이션은 java.lang.annotation패키지에 포함.
 *
 *      @Target*                : 애너테이션이 적용가능한 대상을 지정하는데 사용한다.
 *
 *      @Documented*            : 애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
 *      @Inherited*             : 애너테이션이 자손 클래스에 상속되도록 한다.
 *      @Retention*             : 애너테이션이 유지되는 범위를 지정하는데 사용한다.
 *      @Repeatable*            : 애너테이션을 반복해서 적용할 수 있게 한다.(JDK1.8)
 */

// @Target
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
