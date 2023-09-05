package example.ch14;

/**
 *    - Predicate의 결합.
 *      Predicate : 조건식.
 *      and()-&&, or()-||, negate()-!,not 으로 두 Predicate를 하나로 결합(default메서드).
 *
 *          {@code
 *              Predicate<Integer> p = i -> i < 100;
 *              Predicate<Integer> q = i -> i < 200;
 *              Predicate<Integer> r = i -> i%2 = 0;
 *
 *              Predicate<Integer> notP = p.negate();        // !(i<100)  즉, i >= 100
 *              Predicate<Integer> all = notP.and(q).or(r);  // 100 <= 1 && i < 200 || i % 2 == 0
 *              Predicate<Integer> all2 = notP.and(q.or(r)); // 100 <= 1 && (i < 200 || i % 2 == 0)
 *
 *              System.out.println(all.test(2));  // true.
 *              System.out.println(all2.test(2)); // false.
 *          }
 *
 *      등가비교를 위한 Predicate의 작성에는 isEqual()를 사용(static메서드)
 *          {@code
 *              Predicate<String> p = Predicate.isEqual(str1); // isEquals()는 static메서드.
 *              Boolean result = p.test(str2); // str1과 str2가 같은지 비교한 결과를 반환.
 *
 *              //위의 두 문장을 간단히 -
 *              boolean result = Predicate.isEqual(str1).test(str2); // str1.equals(st2)와 같은 문장.
 *          }
 */

import java.util.function.*;

public class Lambda05 {
    public static void main(String[] args){
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // 16진수로 해셕해서 숫자로 변경.
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);    // 2진수 문자열로 변환.

        //람다식을 하나로 연결할 수 있다.
        Function<String, String> h = f.andThen(g);      //andThen() : 함수 두 개를 하나로 연결하여 새로운 함수 생성. ex) 일.andThen(이) : "일"을 수행하고 "이"를 수행하여 반환값 출력.
        Function<Integer, Integer> h2 = f.compose(g);   //compose() : andThen()과 같은 기능을 하지만 연결되는 함수가 반대로 적용된다. ex) 일.compose(이) : "이"를 먼저 수행.

        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2)); // 2-> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등 함수(identity function)
        System.out.println(f2.apply("AAA")); // AAA가 그대로 출력됨.

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));       // true

        String str1 = new String("abc"); // 주소 비교 예시시 true가 나오면 등가 교환 연산식( == )이 아니라 .equals() 를 사용하는 것을 알 수 있다.
        String str2 = new String("abc");

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
//        boolean result = p2.test(str2);
        boolean result = Predicate.isEqual(str1).test(str2);
        System.out.println(result);
    }
}
