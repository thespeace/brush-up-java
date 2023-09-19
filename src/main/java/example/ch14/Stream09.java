package example.ch14;

import java.util.*;
import java.util.stream.*;

public class Stream09 {
    public static void main(String[] args){
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr).forEach(System.out::println); // 배열 순서대로 출력.
        Stream.of(strArr)
                .parallel()
//                .forEach(System.out::println); // 병렬로 출력, 여러 쓰레드가 나눠 출력하기 때문에 순서가 달라진다.
                .forEachOrdered(System.out::println); // forEachOrdered() 메서드로 병렬처리 및 순서까지 유지.

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0); // 문자열 길이가 0인 배열 요소 찾아서 하나라도 있으면 false반환.
        Optional<String> sWord = Stream.of(strArr)
                .filter(s->s.charAt(0)=='s').findFirst(); // findFist()~findAny()는 filter()랑 같이 쓰이면서, 조건에 맞는 요소 하나를 반환.

        System.out.println("noEmptyStr="+noEmptyStr);
        System.out.println("sWord="+ sWord.get());

        // Stream<String>을 Stream<Integer>으로 변환 : map().
//      Stream<Integer> intStream1 = Stream.of(strArr).map(String::length); // (s) -> s.length()

        // Stream<String>을 IntStream 기본형 스트림으로 변환 : mapToInt()
        // 성능이 더 좋기때문에 IntStream사용이 좋다.
        // IntStream(각 요소를 기본형으로 다룸) vs Stream<Integer>(각 요소를 객체로 다룸)
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum   = intStream2.reduce(0, (a,b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max); // 값이 없을 수도 있기때문에 OptionalInt 결과로 받는다.

        // 1. 빈 스트림으로 바꾼다면?
//        OptionalInt max = IntStream.empty().reduce(Integer::max);

        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("count="+count);
        System.out.println("sum="+sum);
        System.out.println("max="+ max.getAsInt());

        // 2. 결과가 없으면 예외 발생. 따라서 orElse()를 사용해서 결과가 없다면 반환 받을 수 있는 값을 지정 할 수 있다.
//        System.out.println("max="+ max.orElse(0));

        // 3. orElse()도 있는데 굳이 orElseGet(supplier)를 사용한다면, 람다식을 사용하기때문에 활용 범위가 넓어질 수 있다.
//        System.out.println("max="+ max.orElseGet(()->0));

        System.out.println("min="+ min.getAsInt());
    }
}