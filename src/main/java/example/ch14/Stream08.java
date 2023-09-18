package example.ch14;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream08 {
    public static void main(String[] args){
        /**
         *    - 스트림의 최종연산
         *
         *      forEach(),forEachOrdered() : 스트림의 모든 요소에 지정된 작업을 수행.
         *
         *      {@code
         *          void forEach(Consumer<? super T> action)        // 병렬스트림인 경우 순서가 보장되지 않음
         *          void forEachOrdered(Consumer<? super T> action) // 병렬스트림인 경우에도 순서가 보장됨
         *      }
         */

        System.out.println("forEach(), forEachOrdered()");
        // sequential() : 직렬 스트림.
        IntStream.range(1,10).sequential().forEach(System.out::print);        // 123456789
        System.out.println();
        IntStream.range(1,10).sequential().forEachOrdered(System.out::print); // 123456789
        System.out.println();

        // parallel() : 벙렬 스트림, 여러 쓰레드가 나눠서 작업(데이터가 많을 때 더 빠른 결과를 얻기위해서 사용).
        IntStream.range(1,10).parallel().forEach(System.out::print);        // 657231498, 여러 쓰레드로 인해 순서보장이 안된다.
        System.out.println();
        IntStream.range(1,10).parallel().forEachOrdered(System.out::print); // 123456789, forEachOrdered()를 사용해서 순서를 보장.



        /**
         *      allMatch(), anyMatch(), noneMatch() : 조건 검사.
         *
         *      {@code
         *          boolean allMatch  (Predicate<? super T> predicate) // 모든 요소가 조건을 만족시키면 true.
         *          boolean anyMatch  (Predicate<? super T> predicate) // 한 요소라도 조건을 만족시키면 true.
         *          boolean noneMatch (Predicate<? super T> predicate) // 모든 요소가 조건을 만족시키지 않으면 true.
         *      }
         *      {@code : 간단한 예시
         *          boolean hasFailedStu = stuStream.anyMatch(s -> s.getTotalScore() <= 100); // 낙제자가 있는지? 한명이라도 있으면 true.
         *      }
         */



        /**
         *
         *      findFirst(), findAny() : 조건에 일치하는 요소 찾기.
         *
         *      {@code : 결과가 NULL일수도 있기 때문에 Optional<T>을 사용.
         *          Optional<T> findFirst() // 첫 번째 요소를 반환. 순차 스트림에 사용.
         *          Optional<T> findAny()   // 아무거나 하나를 반환. 병렬 스트림에 사용.
         *      }
         *      {@code : 간단한 예시
         *          Optional<Student> result = stuStream.filter(s -> s.getTotalScore() <= 100).findFirst();
         *          Optional<Student> result = parallelStream.filter(s -> s.getTotalScore() <= 100).findAny();
         *      }
         */



        /**
         *      ** reduce() : 스트림의 요소를 하나씩 줄여가며 누적연산 수행(accumulate : 누적하다) **
         *
         *      {@code
         *          Optional<T> reduce(BinaryOperator<T> accumulator) // 초기값도 없고, 비어있는 스트림이라면 결과가 NULL일 수 있기때문에 Optional로 반환.
         *        **T           reduce(T identity, BinaryOperator<T> accumulator)**
         *          U           reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
         *
         *          * identity    : 초기값
         *          * accumulator : 이전 연산결과와 스트림의 요소에 수행할 연산
         *          * combiner    : 병렬처리된 결과를 합치는데 사용할 연산(병렬 스트림)
         *      }
         *      {@code : 간단한 예시(count(),sum(),max(),min(), collect()..은 reduce()를 사용해서 만들었다.)
         *          // int reduce(int identity, IntBinaryOperator op)
         *          int count = intStream.reduce(0(초기값), (a,b) -> a + 1(수행할 작업));
         *          int sum   = intStream.reduce(0, (a,b) -> a + b);
         *          int max   = intStream.reduce(Integer.MIN_VALUE, (a,b) -> a > b ? a : b);
         *          int min   = intStream.reduce(Integer.MAX_VALUE, (a,b) -> a < b ? a : b);
         *
         *          //reduce()의 내부 작업 구조를 간단하게 풀어보자
         *          int a = identity;
         *          for(int b : stream)
         *              a = a + b; //sum()
         *      }
         */
    }
}