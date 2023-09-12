package example.ch14;

import java.util.stream.Stream;

/**
 *    - 스트림(Stream)의 연산?
 *      스트림이 제공하는 기능 : 중간 연산과 최종 연산
 *
 *          중간 연산 : 연산결과가 스트림인 연산. 반복적으로 적용 가능
 *          최종 연산 : 연산결과가 스트림이 아닌 연산. 단 한번만 적용 가능(스트림의 요소를 소모)
 *
 *      " stream.distinct().limit(5).sorted().forEach(System.out::println)
 *                중간연산    중간연산  중간연산           최종연산
 */

public class Stream04 {
    public static void main(String[] args){
        String[] strArr = {"dd","aaa","CC","cc","b","b"};
        Stream<String> stream = Stream.of(strArr); // 문자열 배열이 소스인 스트림.
        Stream<String> filteredStream = stream.filter(i -> i.equals("aaa")); // 걸러내기(중간 연산)
        Stream<String> distinctedStream = filteredStream.distinct();         // 중복제거(중간 연산)
        Stream<String> sortedStream = distinctedStream.sorted();             // 정렬(중간 연산)
        Stream<String> limitedStream = sortedStream.limit(3);        // 스트림 자르기(중간 연산)
        int total = (int) limitedStream.count();                             // 요소 개수 세기(최종 연산) : 스트림이 닫힌다(closed)
        System.out.println(total);

        /**
         *    - 스트림의 연산 : 중간 연산
         *      {@code
         *          Stream<T> distinct() : 중복을 제거
         *          Stream<T> filter(Predicate<T> predicate(조건식)) : 조건에 안 맞는 요소 제외
         *          Stream<T> limit(long maxSize) : 스트림의 일부를 잘라낸다.
         *          Stream<T> skip(long n) : 스트림의 일부를 건너뛴다.
         *          Stream<T> peek(Consumer<T> action) : 스트림의 요소에 작업수행 == ForEach와 비슷하다.
         *
         *          Stream<T> sorted()
         *          Stream<T> sorted(Comparator<T> comparator(정렬기준)) : 스트림의 요소를 정렬한다.
         *
         *          * Stream<R>        map(Function<T,R> mapper)
         *                DoubleStream mapToDouble(ToDoubleFunction<T> mapper)
         *                IntStream    mapToInt(ToIntFunction<T> mapper)
         *                LongStream   mapToLong(ToLongFunction<T> mapper)
         *
         *          * Stream<R>        flatMap(Function<T,Stream<R>> mapper)
         *                DoubleStream flatMapToDouble(Function<T,DoubleStream> m)
         *                IntStream    flatMapToInt(Function<T,IntStream> m)
         *                LongStream   flatMapToLong(Function<T,LongStream> m)       : 스트림의 요소를 변환한다.
         *      }
         *    - 스트림의 연산 : 최종 연산
         *      {@code
         *          void forEach(Consumer<? super T> action)        : 각 요소에 지정된 작업 수행.
         *          void forEachOrdered(Consumer<? super T> action) : 각 요소에 지정된 작업 수행(순서 유지, 병렬 스트림).
         *
         *          long count() : 스트림의 요소의 개수 반환
         *
         *          Optional<T> max(Comparator<? super T> comparator(정렬 기준))
         *          Optional<T> min(Comparator<? super T> comparator(정렬 기준)) : 스트림의 최대값/최소값을 반환.
         *
         *          Optional<T> findAny()   : filter()와 같이 쓰이고, 스트림의 요소 하나를 반환(아무거나 하나, 병렬).
         *          Optional<T> findFirst() : filter()와 같이 쓰이고, 스트림의 요소 하나를 반환(첫 번째 요소, 직렬).
         *
         *          boolean allMatch(Predicate<T> p)  : 주어진 조건을 모든 요소가 만족시키는지. 만족시키지 않는지 확인(모두 만족하는지).
         *          boolean anyMatch(Predicate<T> p)  : 주어진 조건을 모든 요소가 만족시키는지. 만족시키지 않는지 확인(하나라도 만족하는지).
         *          boolean noneMatch(Predicate<T> p) : 주어진 조건을 모든 요소가 만족시키는지. 만족시키지 않는지 확인(모두 만족하지 않는지).
         *
         *          Object[] toArray()
         *          A[]      toArray(IntFunction<A[]> generator) : 스트림의 모든 요소를 배열로 반환.
         *
         *          // ** reduce() & collect()이 최종연산의 핵심이다. **
         *          Optional<T> reduce(BinaryOperator<T> accumulator)
         *          T reduce(T identity, BinaryOperator<T> accumulator)
         *          U reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner) : 스트림의 요소를 하나식 줄여가면서(리듀싱) 계산한다.
         *
         *          R collect(Collector<T,A,R> collector)
         *          R collect(Supplier<R> supplier, BiConsumer<R,T> accumulator, BiConsumer<R,R> combiner) : 스트림의 요소를 수집한다.
         *                                                                                                   주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 반환하는데 사용된다.
         *      }
         */
    }
}