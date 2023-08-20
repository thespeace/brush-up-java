package example.ch12;
import java.lang.annotation.*;

/**
 *    - 애너테이션 타입 정의하기.
 *
 *      애너테이션을 직접 만들어 쓸 수 있다.
 *      {@code
 *          @interface 애너테이션이름 {
 *              타입 요소이름(); // 애너테이션의 요소를 선언한다.
 *                  ...
 *          }
 *
 *          //예시
 *          @interface DateTime {
 *              String yymmdd();
 *              String hhmmss();
 *          }
 *      }
 *
 *      애너테이션의 메서드는 "추상 메서드"이며, 애너테이션을 적용할 때 지정(순서 X)
 *      {@code
 *          @interface TestInfo {
 *              int      count();
 *              String   testedBy();
 *              String[] testTools();
 *              TestType testType();    // enum TestType { FIRST, FINAL }
 *              DateTime testDate();    // 자신이 아닌 다른 애너테이션(@DateTime)을 포함할 수 있다.
 *          }
 *
 *          // @TestInfo 사용 예시
 *          @interface TestInfo { // 추상메서드를 구현할 필요는 없고, 요소의 값을 다 적어주어서 호출하여 사용한다.
 *              count=3, testedBy="Kim",
 *              testTools={"JUnit","AutoTester"},
 *              testType=TestType.FIRST,
 *              testDate=@DateTime(yymmdd="160101",hhmmss="235959")
 *          }
 *          public class NewClass { ... }
 *      }
 *
 *
 *    - 애너테이션의 요소.
 *
 *      적용시 값을 지정하지 않으면, 사용될 수 있는 기본값 지정 가능(null제외).
 *      {@code
 *          @interface TestInfo {
 *              int count() default 1; // 기본값을 1로 지정
 *          }
 *
 *          @TestInfo // @TestInfo(count=1)과 동일, 요소의 값을 필수로 적어주는 과정을 생략할 수 있다.
 *          public class NewClass { ... }
 *      }
 *
 *      요소가 하나이고 이름이 value일 때는 요소의 이름 생략 가능.
 *      {@code
 *          @interface TestInfo {
 *              String value();
 *          }
 *
 *          @TestInfo("passed") // @TestInfo(value="passed")와 동일.
 *          class NewClass { ... }
 *      }
 *
 *      요소의 타입이 배열인 경우, 괄호{}를 사용해야 한다.
 *      {@code
 *          @interface TestInfo {
 *              String[] testTools();
 *          }
 *
 *          @TestInfo(testTools={"JUnit","AutoTester"})
 *          @TestInfo(testTools="JUnit")
 *          @TestInfo(testTools={}) // 값이 없을 때는 빈 괄호{}가 반드시 필요.
 *      }
 *
 *
 *    - 모든 애너테이션의 조상 : java.lang.annotation.Annotation
 *
 *      Annotation은 모든 애너테이션의 조상이지만 상속은 불가.
 *      {@code
 *          @interface TestInfo extends Annotation { // ERROR, 허용되지 않는 표현(extends Annotation). 단순한 문법.
 *              int    count();
 *              String testedBy();
 *                  ...
 *          }
 *      }
 *
 *      사실 Annotation은 인터페이스이다.
 *      {@code
 *          package java.lang.annotation;
 *
 *          public interface Annotation { // Annotation자신은 인터페이스이다.
 *              boolean equals(Object obj);
 *              int hashCode();
 *              String toString(); // 조상 Annotation이 가지고있는 추상메서드는 모든 자식이 물려받고, 이 추상메서드를 구현하지 않고도 사용 가능하다.(컴파일러가 자동으로 구현)
 *
 *              Class<? extends Annotation> annotationType(); // 애너테이션의 타입을 반환.
 *          }
 *      }
 *
 *
 *    - 마커 애너테이션 : Marker Annotation.
 *      요소가 하나도 정의되지 않은 애너테이션.
 *      {@code
 *          @Target(ElementType.METHOD)
 *          @Retention(RetentionPolicy.SOURCE)
 *          public @interface Override{ } // 마커 애너테이션, 정의된 요소가 하나도 없다.
 *
 *          @Target(ElementType.METHOD)
 *          @Retention(RetentionPolicy.SOURCE)
 *          public @interface Test{ } // 마커 애너테이션, 정의된 요소가 하나도 없다.
 *          // 단지 사용자에게 해당 메서드가 테스트 대상임을 테스트 프로그램에게 알린다.
 *      }
 *
 *
 *    - 애너테이션 요소의 규칙
 *      애너테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야 한다.
 *          * 요소의 타입은 기본형, String, enum, 애너테이션, Class만 허용된다.
 *          * 괄호()안에 매개변수를 선언할 수 없다.
 *          * 예외를 선언할 수 없다.
 *          * 요소를 타입 매개변수로 정의할 수 없다.
 *
 *      {@code - 아래의 코드에서 잘못된 부분은 무엇인지 생각해보자.
 *          @interface AnnoTest {
 *              int id = 100;                    // static final 생략, 상수 OK.
 *              String major(int i, int j);      // ERROR, 매개변수 X.
 *              String minor() throws Exception; // ERROR, 예외 선언 불가.
 *              ArrayList<T> list();             // ERROR, 타입 매개변수 정의 불가.
 *          }
 *          // 간단하게 추상메서드 선언 방식만 기억하면 된다. 상수 OK, int count();
 *      }
 *
 *      + 앞으로 Servlet, Spring FrameWork 등등을 사용하면서 애너테이션을 많이 사용하게 될텐데,
 *        직접 애터네이션을 만들일은 별로 없겠지만, 내가 적용하는 애터네이션으로부터 어떠한 정보를 넣는지 기본적인 구조를 익히기 위해 애너테이션에 대해 알아보았다.
 */


@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101",hhmmss="235959")/*, testTools = {"JUnit", "JUnit5"}*/)  //default값이 있는 요소는 생략가능하다.
public class Annotation04 {
    public static void main(String[] args){
        // Ex12_8의 Class객체를 얻는다.
        Class<Annotation04> cls = Annotation04.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy()="+anno.testedBy());
        System.out.println("anno.testDate().yymmdd()=" +anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss()=" +anno.testDate().hhmmss());

        for(String str : anno.testTools())
            System.out.println("testTools="+str);

        System.out.println();

        // Annotation04에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for(Annotation a : annoArr)
            System.out.println(a);
    }
}

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정
@interface TestInfo {
    int       count()	  	default 1;
    String    testedBy();
    String[]  testTools() 	default "JUnit";
    TestType  testType()    default TestType.FIRST;
    DateTime  testDate();
}

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType { FIRST, FINAL }