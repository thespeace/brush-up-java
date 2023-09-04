package example.ch14;

import java.util.function.*;
import java.util.*;

/**
 *    - java.util.function 패키지.(1/3)
 *      자주 사용되는 다양한 함수형 인터페이스를 제공.
 *      표준화 된다는 장점이 있다 : 개개인마다 함수형 인터페이스를 만드는 것보다 이미 만들어진 것들을 공통으로 사용하면 이해하기도 쉽고 편리하다.
 *
 *             함수형 인터페이스     |          메서드         |       설 명
 *             java.lang.Runnable | void run()             | 매개변수도 없고, 반환값도 없다.
 *             Supplier<T>        | T get()                | 매개변수는 없고, 반환값만 있음.(공급자)
 *             Consumer<T>        | void accept(T t)       | Supplier와 반대로 매개변수만 있고, 반환값이 없음.(소비자)
 *             Function<T,R>      | R apply(T t)           | 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환.(일반적인 함수)
 *             Predicate<T>       | boolean test(T t)      | 조건식을 표현하는데 사용됨. 매개변수는 하나, 반환 타입은 boolean.(조건식)
 *
 *             {@code
 *                 Predicate<String> isEmptyStr = s -> s.length() == 0; // 반환 타입은 항상 boolean이어야 한다.
 *                 String s = "";
 *
 *                 if(isEmptyStr.test(s))                               // if(s.length() == 0)와 같은 코드.
 *                     System.out.println("This is an empty String.");
 *             }
 *
 *      Quiz!
 *          [   1   ] f = () -> (int)(Math.random()*100)+1;
 *          [   2   ] f = i -> System.out.print(i+", ");
 *          [   3   ] f = i -> i % 2 == 0;
 *          [   4   ] f = i -> i / 10 * 100;
 *
 *          1.Supplier<Integer> / 2.Consumer<Integer>  / 3.Predicate<Integer>   <- 원래는 Function<T,R>처럼 Predicate<Integer, Boolean)이라고 써야 하지만
 *          4.Function<Integer, Integer>                                           반환타입이 항상 Boolean이기 때문에 Boolean은 쓰지 않는다.
 *
 *
 *
 *    - java.util.function 패키지.(2/3)
 *      매개변수가 2개인 함수형 인터페이스
 *             함수형 인터페이스     |          메서드         |       설 명
 *             BiConsumer<T,U>    | void accept(T t, U u)  | 두 개의 매개변수만 있고, 반환값이 없음.
 *             BiPredicate<T,U>   | boolean test(T t, U u) | 조건식을 표현하는데 사용된다. 매개변수는 둘, 반환값은 boolean.
 *             BiFunction<T,U,R>  | R apply(T t,U u)       | 두 개의 매개변수(T,U)를 받아서 하나의 결과를 반환(R).
 *
 *             {@code : 그 이상의 매개변수를 받기를 원한다면, 사용자 정의 함수형 인터페이스를 만들면 된다.
 *                 @FunctionalInterface
 *                 interface TriFunction<T,U,V,R> {
 *                     R apply(T t,U u,V v);
 *                 }
 *             }
 *
 *
 *
 *    - java.util.function 패키지.(3/3)
 *      매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스.
 *             함수형 인터페이스     |          메서드         |       설 명
 *             UnaryOperator<T>   | T apply(T t)           | Function의 자손, Function과 달리 매개변수와 결과의 타입이 같다.(단항 연산자)
 *             BinaryOperator<T>  | T apply(T t, T t)      | BiFunction의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같다.(이항 연산자)
 *
 *             {@code : 항수형 Funtion<T,R> 인터페이스
 *                 @FunctionalInterface
 *                 public interface Function<T, R> {
 *                     R apply(T t);
 *                     ...
 *                 }
 *             }
 *             {@code : Funtion<T,R> 인터페이스를 상속받아 만든 항수형 UnaryOperator<T> 인터페이스
 *                 @FunctionalInterface
 *                 public interface UnaryOperator<T> extends Function<T,T> {
 *                     static <T> UnaryOperator<T> identity() { // 항등함수. t를 넣으면 t가 나오는 것.
 *                      return t -> t;
 *                     }
 *                 }
 *             }
 */

public class Lambda04 {
    public static void main(String[] args){
        Supplier<Integer>  s = ()-> (int)(Math.random()*100)+1; // 1~100 난수 반환 Supplier.
        Consumer<Integer>  c = i -> System.out.print(i+", ");   // 콘솔에 출력하는 Consumer.
        Predicate<Integer> p = i -> i%2==0;                     // 짝수인지 검사하는 Predicate.
        Function<Integer, Integer> f = i -> i/10*10;            // i의 일의 자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);  // list를 랜덤값으로 채운다.
        System.out.println(list);
        printEvenNum(p, c, list); // 짝수를 출력.
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for(int i=0;i<10;i++) {
            list.add(s.get()); //Supplier로부터 1~100의 난수를 받아서 list에 추가.
        }
    }
    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for(T i : list) {
            if(p.test(i))   //조건식 Predicate(짝수인지 검사)를 받아서-
                c.accept(i); // Consumer를 실행, 화면에 i 출력.
        }
        System.out.println("]");
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());
        for(T i : list) {
            newList.add(f.apply(i)); // 일의 자리를 없애서 새로운 list에 저장.
        }
        return newList;
    }
}
