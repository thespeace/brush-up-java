package example.ch14;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream05 {
    public static void main(String[] args){
        /**
         *    - 스트림의 중간연산(1/7)
         *      스트림 자르기 - skip(), limit()
         */
        IntStream intStream = IntStream.rangeClosed(1, 10);

        // Stream<T> skip(long n) : 앞에서부터 n개 건너뛰기.
        // Stream<T> limit(long maxSize) : maxSize 이후의 요소는 잘라냄.
        intStream.skip(3).limit(5).forEach(System.out::println);
    }
}