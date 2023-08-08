package example.ch12;

import java.util.ArrayList;
import java.util.Objects;

public class Generics01 {
    public static void main(String[] args){
        /**
         *    - 지네릭스(Generics)란?
         *      컴파일시 타입을 체크해 주는 기능(compile-time type check) - JDK1.5이상.
         *
         *      {@code -지네릭스 사용법 예시
         *          // Tv객체만 저장할 수 있는 ArrayList를 생성
         *          ArrayList<Tv> tvList = new ArrayList<Tv>();
         *
         *          tvList.add(new Tv());    // OK.
         *          tvList.add(new Audio()); // 컴파일 에러. Tv 외에 다른 타입은 저장 불가.
         *      }
         *      객체의 타입 안정성을 높여준다. 따라서 ClassCastException과 같은 형변환 에러를 차단할 수 있다.
         *      타입체크와 형변환의 번거로움을 줄여준다. 따라서 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.
         *
         *      {@code - Exception클래스와 RuntimeException클래스 중심의 상속 계층도
         *          Exception // 실행중 발생하는 에러.
         *              - IOException
         *              - ClassNotFoundException
         *              - ...
         *              - RuntimeException // 프로그래머 실수로 발생하는 에러.(실행시 발생)
         *                  - ArithmeticException
         *                  - ClassCastException        //형변환 에러.
         *                  - NullPointerException      //참조변수 Null.
         *                  - ...
         *                  - IndexOutOfBoundsException // 배열범위 벗어나는 에러
         *      }
         *      Runtime 에러보다는 compile time 에러가 낫다. 개발시 수정 가능하기 때문.
         *      그래서 어떻게하면 ** Runtime 에러를 compile 에러로 끌어올 수 있을까 고안하다 생겨난게 지네릭스(Generics)이다. **
         */

        //지네릭스를 사용하지 않았을때의 에러.
//        ArrayList list = new ArrayList(); // JDK 1.5이전, 지네릭스 도입이전에는 해당 선언문을 사용 했지만-
        ArrayList<Object> list = new ArrayList<Object>(); // JDK 1.5이후에는 지네릭스를 명시해주는 것이 좋은 코드이다.
        list.add(10);
        list.add(20);
        list.add("30"); // String을 추가
//        Integer i = (Integer)list.get(2); // 컴파일 OK, 실행시 ERROR(형변환에러 ...) : 컴파일러의 한계, 실행시 발생하는 에러를 컴파일과정에서 잡아내기 위해 등장한게 지네릭스!
        String i = (String)list.get(2); // Object 타입을 String 타입으로 형변환.
        System.out.println(i);

        //지네릭스 사용하여 컴파일 단계에서 에러 캐치하기.
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(20);
//        list1.add("30"); // 선언시 지네릭스 설정으로 컴파일시 타입 체크로 강화로 인해 String타입은 ERROR.
        list1.add(30);

        Integer i1 = list1.get(2); // 형변환 생략 가능.
        System.out.println(i1);
    }
}
