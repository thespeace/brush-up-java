package example.ch14;

import java.util.Optional;
import java.util.OptionalInt;

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

        /**
         *    - Optional<T> 객체 생성하기 : Optional<T> 객체 생성하는 다양한 방법!
         */
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



        /**
         *    - Optional<T> 객체의 값 가져오기
         *      Optional객체의 값 가져오기 - get(), orElse(), orElseGet(), orElseThrow()
         */
        Optional<String> optVal = Optional.of("abc");
        String str1 = optVal.get();                                  // optVal에 저장된 값을 반환. null이면 예외발생.
        String str2 = optVal.orElse("");                       // optVal에 저장된 값이 null일 때는, ""(대체값)를 반환.
        String str3 = optVal.orElseGet(String::new);                 // 람다식 사용가능 ()->new String().               //T orElseGet(Supplier<? extends T> other)
        String str4 = optVal.orElseThrow(NullPointerException::new); // 널이면 예외발생.                                //T orElseThrow(Supplier<? extends T> exceptionSupplier)

        System.out.println("==============isPresent() : Optional객체의 값이 null이면 false, 아니면 true를 반환.=============");
        if(Optional.ofNullable(str1).isPresent()){ // if(str1 != null)
            System.out.println(str1);
        }

        System.out.println("==============ifPresent() : NULL이 아닐때만 작업 수행, NULL이면 아무 일도 안 함.=============");
        Optional.ofNullable(str1).ifPresent(System.out::println); // (v)->(System.out.prinln(v))



        /**
         *    - 기본형 값을 감싸는 래퍼클래스.
         *      OptionalInt, OptionalLong, OptionalDouble.
         *      Optinal<T>는 람다와 스트림이 모든 걸 감싸서 객체로 다루기 때문에 성능이 조금 떨어진다. 때문에 주로 성능을 위해 사용한다.
         *
         *          {@code
         *              public final class OptionalInt {
         *                  ...
         *                  private final boolean isPresent; // 값이 저장되어 있으면 true.
         *                  private final int value; // int타입의 변수. <-> Optinal<T>는 final T value : 참조형 타입의 변수를 사용.
         *          }
         *
         *      OptionalInt의 값 가져오기 - int getAsInt()
         *          Optional<T>   ->  T      get()
         *          OptionalInt   ->  int    getAsInt()
         *          OptionalLong  ->  long   getAsLong()
         *          OptionalDouble->  double getAsDouble()
         */

        System.out.println("==============빈 Optional객체와의 비교(진짜 0을 저장한건지 아무것도 저장하지 않은건지 비교)=============");
        OptionalInt opt = OptionalInt.of(0); // OptionalInt에 0을 저장
        OptionalInt opt2 = OptionalInt.empty();    // OptionalInt에 0을 저장
        System.out.println("OptionalInt.of(0) :   " + opt.isPresent());  // true.
        System.out.println("OptionalInt.empty() : " + opt2.isPresent()); // false.
        System.out.println("OptionalInt.of(0).equlas(OptionalInt.empty()) : " + opt.equals(opt2)); // false.



        System.out.println("==============실습=============");
        Optional<String>  optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length); // 람다식 : s -> s.length()
        System.out.println("optStr="+optStr.get());
        System.out.println("optInt="+optInt.get());

        int result1 = Optional.of("123")
                .filter(x->x.length() >0)
                .map(Integer::parseInt).get();

        int result2 = Optional.of("")
                .filter(x->x.length() >0)
                .map(Integer::parseInt).orElse(-1); // NULL인 경우 -1 반환.

        System.out.println("result1="+result1);
        System.out.println("result2="+result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x->System.out.printf("result3=%d%n",x)); // NULL이 아닐때만 실행.

        OptionalInt optInt1  = OptionalInt.of(0);   // 0을 저장. isPresent:true.
        OptionalInt optInt2  = OptionalInt.empty(); // 빈 객체를 생성. isPresent:false.

        System.out.println(optInt1.isPresent());   // true
        System.out.println(optInt2.isPresent());   // false

        System.out.println(optInt1.getAsInt());  // 0
//		System.out.println(optInt2.getAsInt());  // NoSuchElementException
        System.out.println("optInt1="+optInt1);
        System.out.println("optInt2="+optInt2);
        System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));

    }
}