package example.ch14;

public class Stream14 {
    public static void main(String[] args){
        /**
         *    - 스트림의 변환(1/2)
         *
         *                  from            |           to              |               변환 메서드
         *
         *      1. 스트림 -> 기본형 스트림
         *      Stream<T>                   |        IntStream          |       mapToInt(ToIntFunction<T> mapper)
         *      Stream<T>                   |        LongStream         |       mapToLong(ToLongFunction<T> mapper)
         *      Stream<T>                   |        DoubleStream       |       mapToDouble(ToDoubleFunction<T> mapper)
         *
         *      2. 기본형 스트림 -> 스트림
         *      IntStream                   |       Stream<Integer>     |       boxed()
         *      LongStream                  |       Stream<Long>        |       boxed()
         *      DoubleStream                |       Stream<Double>      |       boxed()
         *          *                       |       Stream<U>           |       mapToObj(DoubleFunction<U> mapper)
         *
         *      3. 기본형 스트림 -> 기본형 스트림
         *      IntStream                   |       LongStream          |       asLongStream()
         *      LongStream                  |       DoubleStream        |       asDoubleStream()
         *      DoubleStream                |
         *
         *      4. 스트림 -> 부분 스트림
         *      Stream<T>                   |       Stream<T>           |       skip(long n)
         *      IntStream                   |       IntStream           |       limit(long maxSize)
         *
         *      5. 두 개의 스트림 -> 스트림
         *      Stream<T>, Stream<T>        |       Stream<T>           |       concat(Stream<T> a, Stream<T> b)
         *      IntStream, IntStream        |       IntStream           |       concat(IntStream a, IntStream b)
         *      LongStream, LongStream      |       LongStream          |       concat(LongStream a, LongStream b)
         *      DoubleStream, DoubleStream  |       DoubleStream        |       concat(DoubleStream a, DoubleStream b)
         *
         *      6. 스트림의 스트림 -> 스트림
         *      Stream<Stream<T>>           |       Stream<T>           |       flatMap(Function mapper)
         *      Stream<IntStream>           |       IntStream           |       flatMapToInt(Function mapper)
         *      Stream<LongStream>          |       LongStream          |       flatMapToLong(Function mapper)
         *      Stream<DoubleStream>        |       DoubleStream        |       flatMapToDouble(Function mapper)
         */
    }
}