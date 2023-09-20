package example.ch14;

import java.util.stream.Stream;

/**
 *    - collect()와 Collectors
 *
 *      "collect()"는 Collector를 매개변수로 하는 "스트림의 최종연산".
 *      {@code
 *          Object collect(Collector collector) // 인터페이스인 Collector를 구현한 클래스의 객체를 매개변수로-
 *          Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner) // 잘 안쓰인다.
 *      }
 *
 *      reduce() vs collect() : reduce()는 전체에 대한 reducing, collect()는 그룹별로 나누어서 reducing이 가능하다.
 *
 *      "Collector"는 수집(collect)에 필요한 메서드를 정의해 놓은 "인터페이스".
 *      {@code
 *          public interface Collector<T, A, R> {   // T(요소)를 A에 누적한 다음, 결과를 R로 변환해서 반환.
 *              Supplier<A>          supplier();        // StringBuilder:new             누적할 곳
 *              BiConsumer<A, T>     accumulator();     // (sb, s) -> sb.append(s)       누적방법
 *              BinaryOperator<A>    combiner();        // (sb1, sb2) -> sb1.append(sb2) 결합방법(병렬)
 *              Function<A, R>       finisher();        // sb -> sb.toString()           최종변환
 *              Set<Characteristics> characteristics(); // 컬렉터의 특성이 담긴 Set을 반환
 *          }
 *      }
 *
 *      "Collectors클래스"는 다양한 기능의 컬렉터("Collector를 구현한 클래스")를 제공, 원래는 위의 Collector인터페이스를 직접 구현 해야했다..
 *      {@code
 *          변환 : mapping(), toList(), toSet(), toMap(), toCollection(), ...
 *          통계 : counting(), summingInt(), averagingInt(), maxBy(), minBy(), summarizingInt(), ...
 *          문자열 결합 : joining()
 *          리듀싱 : reducing()
 *          그룹화와 분할 : groupingBy(), partitioningBy(), collectingAndThen()
 *      }
 *
 *
 */

public class Stream10 {
    public static void main(String[] args){
    }
}