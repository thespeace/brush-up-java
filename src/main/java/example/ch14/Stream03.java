package example.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream03 {
    public static void main(String[] args){
        /**
         *    - 스트림 만들기 - 컬렉션
         *
         *      {@code : Collection 인터페이스의 stream()으로 컬렉션을 스트름으로 변환
         *          Stream<E> stream() // Collection인터페이스의 메서드
         *      }
         *
         */
        System.out.println("==============컬렉션 스트림 만들기=============");
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); //list를 스트림으로 변환

        //스트림의 모든 요소를 출력
        intStream.forEach(System.out::print);

        //Stream은 일회용, stream에 대해 최종연산을 수행하면 stream이 닫힌다.
        intStream = list.stream(); //list로부터 stream을 생성.
        intStream.forEach(System.out::print);
//        intStream.forEach(System.out::print); // 에러, 스트림이 이미 닫혔다.



        /**
         *    - 스트림 만들기 - 배열
         *
         *      {@code : 객체 배열로부터 스트림 생성하기.
         *          Stream<T> Stream.of(T... values) // 가변인자
         *          Stream<T> Stream.of(T[])
         *          Stream<T> Arrays.stream(T[])
         *          Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive) // 배열의 일부로만 Stream을 만드는 것, ( from(<=) ~ to(>))
         *      }
         */
        System.out.println("==============배열 스트림 만들기=============");
        Stream<String> strStream1 = Stream.of("a","b","c"); //가변인자
//        String[] strArr = {"a","b","c"};
//        Stream<String> strStream2 = Stream.of(strArr); // 이 두개의 코드를 합친 코드가 아래의 코드.
        Stream<String> strStream2 = Stream.of(new String[]{"a","b","c"});
        Stream<String> strStream3 = Arrays.stream(new String[]{"a","b","c"});
        Stream<String> strStream4 = Arrays.stream(new String[]{"a","b","c"}, 0, 3); // 0 <= i < 3

        System.out.println();
        strStream1.forEach(System.out::println);

        /**
         *      기본형 배열로부터 스트림 생성하기.
         *      {@code : 객체 배열로부터 스트림 생성하기.
         *          IntStream IntStream.of(int... values) // Stream이 아니라 IntStream, 가변 인자.
         *          IntStream IntStream.of(int[])
         *          IntStream Arrays.Stream(int[])
         *          IntStream Arrays.Stream(int[] array, int startInclusive, int endExclusive)
         *      }
         */

        int[] intArr1 = {1,2,3,4,5}; //기본형 배열인 경우 IntStream 사용하는 것이 이점이 많다. 숫자 스트림을 다룰때에는 IntStream을 사용하면 속도도 향상되고 추가적으로 편리한 메소드들도 따라온다.
        IntStream intStream1 = Arrays.stream(intArr1);     //기본형 스트림.
//        intStream1.forEach(System.out::println);
//        System.out.println("count=" + intStream1.count());
//        System.out.println("sum=" + intStream1.sum());
        System.out.println("average=" + intStream1.average());

        Integer[] intArr2 = {1,2,3,4,5};
        Stream<Integer> streamInteger = Arrays.stream(intArr2); //Integer 객체 스트림.
//        intStream1.forEach(System.out::println);
        System.out.println("count=" + streamInteger.count()); // Stream<T>는 숫자외에도 여러 타입의 스트림이 가능해야하므로 숫자 스트림에만 사용할 수 있는 sum(),average()를 넣지 않은 것.



        /**
         *    - 스트림 만들기 - 임의의 수
         *
         *      {@code : 난수를 요소로 갖는 스트림 생성하기
         *          IntStream intStream = new Random().ints();       // 무한 스트림
         *          intStream.limit(5).forEach(System.out::println); // 5개의 요소만 출력한다.
         *
         *          IntStream intStream = new Random().ints(5); // 크기가 5인 난수 스트림을 반환.
         *      }
         *      {@code : 랜덤클래스의 메서드(Random.class)
         *          Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
         *             Long.MIN_VALUE <= longs() <= Long.MAX_VALUE
         *                       0.0 <= doubles() < 1.0
         *      }
         *      {@code : 지정된 범위의 난수를 요소로 갖는 스트림을 생성하는 메서드(Random클래스)
         *          IntStream    ints(int begin, int end)
         *          LongStream   longs(long begin, long end)                    // 무한 스트림
         *          DoubleStream doubles(double begin, double end)
         *
         *          IntStream    ints(long streamSize, int begin, int end)
         *          LongStream   longs(long streamSize, long begin, long end)   // 유한 스트림
         *          DoubleStream doubles(long streamSize, double begin, double end)
         *      }
         */
        System.out.println("==============임의의 수 스트림 만들기=============");
//        IntStream randomStream = new Random().ints(); // 무한 스트림
//        IntStream randomStream = new Random().ints(5); // 유한 스트림, 갯수 지정.
//        IntStream randomStream = new Random().ints(5, 10); // 무한 스트림, 갯수 지정( 5 <= 난수 < 10)
        IntStream randomStream = new Random().ints(10,5, 10); // 유한 스트림, ( 갯수 지정,  5 <= 난수 < 10 )
        randomStream
//                .limit(5)
                .forEach(System.out::println);



        /**
         *    - 스트림 만들기 - 특정 범위의 정수
         *
         *      {@code : 특정 범위의 정수를 요소로 갖는 스트림 생성하기(IntStream, LongStream)
         *          IntStream Instream.range(int begin, int end)       // begin <= stream < end
         *          IntStream Instream.rangeClosed(int begin, int end) // begin <= stream <= end
         *      }
         */
        System.out.println("==============특정 범위의 정수 스트림 만들기=============");
        IntStream rangeStream1 = IntStream.range(11, 15);
        IntStream rangeStream2 = IntStream.rangeClosed(11, 15);
        rangeStream1.forEach(System.out::print);
        System.out.println();
        rangeStream2.forEach(System.out::print);

    }
}