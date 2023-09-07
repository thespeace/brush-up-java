package example.ch14;

import java.util.stream.Stream;

/**
 *    - 스트림(Stream)이란?
 *
 *      "데이터의 연속적인 흐름."
 *      다양한 데이터 소스(컬렉션, 배열)를 표준화된 방법으로 다루기 위한 것.
 *          CF(컬렉션프레임워크)로 표준화된 방법으로 다루길 원했지만 List,Set,Map의 성격이 달라서 사용방법이 달라서 실패했다.
 *          반쪽짜리 표준화를 사용하고 있었지만, JDK 1.8부터는 스트림이 나와서 다양한 데이터소스를 표준화 할 수 있었다.
 *
 *      컬렉션의 List,Set,Map / 배열 등의 다양한 데이터소스로 부터 스트림(Stream)을 만들 수 있다.
 *      스트림을 만들고 나서는 똑같은 방식으로 작업을 처리하게 된다.
 *          1.스트림생성 -> 2.중간 연산(0~n번)-> 3.최종연산(0~1번) -> 4.원하는 결과 도출 " : 중간 연산, 최종 연산을 통일 할 수 있다.
 *
 *      {@code : 스트림으로 변환하는 방법, 즉 스트림을 생성.
 *          List<Integer> list = Array.asList(1,2,3,4,5);
 *          Stream<Integer>   intStream = list.stream();                        //컬렉션, Stream<T> Collection stream() 컬렉션 stream()메서드 사용.
 *          Stream<String>    strStream = Stream.of(new String[]{"a","b","c"}); //배열
 *          Stream<Integer>  evenStream = Stream.iterate(0, n->n+2);            // 0,2,4,6 ...
 *          Stream<Double> randomStream = Stream.generate(Math::random);        // 람다식
 *          IntStream         intStream = new Random().ints(5);                 // 난수 스트림(크기가 5)
 *      }
 *
 *
 *    - 스트림이 제공하는 기능 : 중간 연산과 최종 연산.
 *
 *      중간 연산 : 연산결과가 스트림인 연산. 반복적으로 적용가능
 *      최종 연산 : 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능(스트림의 요소를 소모)
 *
 *      {@code : 예시.
 *          stream.distinct().limit(5).sorted().forEach(System.out::println)
 *                  중간연산    중간연산  중간연산          최종 연산(forEach)
 *      }
 */

public class Stream01 {
    public static void main(String[] args){
        String[] strArr = { "dd", "aaa","aaa","cc","b"};
        Stream<String> stream = Stream.of(strArr); // 문자열 배열이 소스인 스트림 생성.

        Stream<String> filteredStream = stream.filter("aaa"::equals);     // 걸러 내기(중간 연산)
        Stream<String> distinctedStream = filteredStream.distinct();      // 중복 제거(중간 연산)
        Stream<String> sortedStream = distinctedStream.sorted();          // 정렬(중간 연산)
        Stream<String> limitedStream = sortedStream.limit(5);          // 스트림 자르기(중간 연산)

        int total = (int) limitedStream.count(); // 요소 개수 세기(최종 연산)
        System.out.println(total);
    }
}