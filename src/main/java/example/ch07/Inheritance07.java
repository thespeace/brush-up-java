package example.ch07;

import java.util.Date;
//import java.lang.*; // import하지 않아도 자바 기본클래스이기 때문에 생략 가능하다.

//static import문 예시
import static java.lang.System.out;
import static java.lang.Math.*; // Math클래스의 모든 static 멤버를 클래스변수없이 사용할 수 있게 해준다.

/**
 *    - import문
 *      클래스를 사용할 때 패키지이름을 생략할 수 있다.
 *      컴파일러에게 클래스가 속한 패키지를 알려준다.
 *          * java.lang패키지의 클래스는 import하지 않고도 사용할 수 있다. 자바의 핵심클래스들을 모아놓은 기본 클래스이기 때문에 import하지 않고도 사용할 수 있다. import java.lang.*;
 *            ex) String, Object, System, Thread ...
 *
 *    - import문의 선언
 *      import문을 선언하는 방법은 다음과 같다.
 *          import 패키지명.클래스명;
 *              또는
 *          import 패키지명.*; <- * : 모든 것(모든 클래스).
 *      import문은 패키지문과 클래스선언의 사이에 선언한다.
 *          1) 패키지선언, 2) import문, 3) 클래스 정의
 *      ** import문은 컴파일 시에 처리되므로 프로그램의 성능에 영향이 없다. **
 *          ex) import java.util.Calendar;
 *              import java.util.Date;          ->   import java.util.*;  // 성능차이 거의 없다.
 *          하지만 이름이 같은 클래스가 속한 두 패키지를 import할 때는 클래스 앞에 패키지명을 붙여줘야 한다.
 *              ex) import java.sql.*;  // java.sql.Date
 *                  import java.util.*; // java.util.Date  <- 클래스명이 동일할시 java.util.Date today = new java.util.Date(); 이처럼 명시해줘야 한다.
 */

public class Inheritance07 {
    public static void main(String[] args){ // 이처럼 문자열 배열인 String[]도 import java.lang.*;을 하지 않고도 사용가능.
        System.out.println("Hello World!"); // System클래스도 기본 제공 패키지이기 때문에 import하지 않고 사용 가능.

        // System.out.println(Math.random());
        out.println(random());

        // System.out.println("Math.PI :" + Math.PI); // static 상수이름 생략 가능.
        out.println("Math.PI :" + PI);
    }
}
class ImportTest {
//    java.util.Date today = new java.util.Date(); //원래는 패키지이름을 적어줘야 하는데, Import문을 이용하면 패키지이름을 생략할 수 있습니다.
    Date today = new Date(); // 맨 위의 import java.util.Date;의 import문을 통해서 패키지명 기입을 생략할 수 있다.
}

/**
 *    - static import문
 *      static멤버를 사용할 때 클래스 이름을 생략할 수 있게 해준다.
 *          ex) import static java.lang.Integer.*;   // Integer 클래스의 모든 static 메서드.
 *              import static java.lang.Math.random; // 특정 메서드인 Math.random()만. 괄호 안 붙임.
 *              import static java.lang.System.out;  // System.out을 out만으로 참조가능.
 *
 *              System.out.println(Math.random());  ->  out.println(random()); // System, Math 생략 가능.
 *      많이 사용하진 않으나 꼭 필요할때 사용하면 유용하다. 코드가 길어지고 복잡해짐에 따라 여러 이점을 챙길 수 있다.
 */