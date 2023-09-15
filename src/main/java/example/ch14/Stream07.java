package example.ch14;

import java.util.Optional;

/**
 *    - Optional<T>
 *
 *          {@code : T 타입 객체의 래퍼클래스 - Optional<T>
 *              public final class Optional<T> {
 *                  private final T value; // T타입의 참조변수, 모든 종류의 객체 저장 가능(NULL도 가능).
 *                      ...
 *              }
 *          }
 *
 *      Optional<T>을 사용하는 이유 ? 1. NULL을 직접 다루는 것은 NullPointException처럼 예외가 발생할 수 있기때문에 위험하다.
 *                                    때문에 간접적으로 객체안에 담아서 NULL을 다루기 위함이다.
 *                                  2. 일반적으로 NULL체크를 하려면 if문이 필수이기 때문에 코드가 지저분해지는데 깔끔하게 코드 작성이 가능해진다.
 */

public class Stream07 {
    public static void main(String[] args){

        // Optional<T> 객체 생성하기 : Optional<T> 객체 생성하는 다양한 방법!
        String str = "abc";
        Optional<String> optVal1 = Optional.of(str);
        Optional<String> optVal2 = Optional.of("abc");
//        Optional<String> optVal3 = Optional.of(null);      // NullPointerException 발생.
        Optional<String> optVal4 = Optional.ofNullable(str); // OK.
        System.out.println(optVal1);
        System.out.println(optVal2);
        System.out.println(optVal4);

        // null대신 빈 Optional<T>객체를 사용하자.
        Optional<String> optVal5 = null; // NULL로 초기화, 가능은 하지만 바람직하지 않다.
        Optional<String> optVal6 = Optional.<String>empty(); // 빈 객체로 초기화.

                //위의 코드는 아래의 코드와 같은 것.(NULL을 직접적으로 다루기를 피하기 위한 것.)
                String a = null; // NULL보다는 -
                String b = "";   // 빈 문자열로!!

                Object[] objArr1 = null;          // NULL로 초기화 하기 보다는 -
                Object[] objArr2 = new Object[0]; // 크기가 0인 배열로 초기화!!

    }
}