package example.ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
 */

public class Stream10 {
    public static void main(String[] args){

        /**
         *    - 스트림을 컬렉션, 배열로 변환.
         */

        // 스트림을 컬렉션으로 변환(Collectors 제공) : toList(), toSet(), toMap(), toCollection()
        Stream<Staff> staffStream = Stream.of(
                new Staff("john",10000),
                new Staff("kim",12000),
                new Staff("lee",13000),
                new Staff("park",15000)
        );

        //직원 이름이 담긴 리스트로 변환- toList()
        List<String> names = staffStream.map(Staff::getName) // Stream<Staff> -> Stream<String>
                .collect(Collectors.toList());               // Stream<String> -> List<String>
        System.out.println(names);


        //리스트를 구현한 특정 클래스를 지정하고 싶다면- toCollection(반환 결과 지정)
        ArrayList<String> list = names.stream()
                .collect(Collectors.toCollection(ArrayList::new)); // Stream<String> -> ArrayList<String>
        System.out.println(list);


        //map에 담을 수 있다- toMap(key, value)
        Stream<Staff> personStream = Stream.of(
                new Staff("john",10000),
                new Staff("kim",12000),
                new Staff("lee",13000),
                new Staff("park",15000)
        );

        Map<String,Staff> map = personStream
                .collect(Collectors.toMap(s->s.getName(), s->s));

        System.out.println(map.get("john"));



        // 스트림을 배열로 변환 : toArray()
        Stream<Staff> staffStream2 = Stream.of(
                new Staff("john",10000),
                new Staff("kim",12000),
                new Staff("lee",13000),
                new Staff("park",15000)
        );
        Staff[] arrayStream1 = staffStream2.toArray(Staff[]::new); // OK.
//        Staff[] arrayStream2 = staffStream2.toArray();           // Error, toArray()의 반환타입이 Object[]타입이여서 형변환을 해주어야 한다. 자동형변환 X.
//        Staff[] arrayStream2 = (Staff[]) staffStream2.toArray(); // OK, 형변환시 가능.
//        Object[] arrayStream3 = staffStream2.toArray();          // OK.

        System.out.println(arrayStream1);

    }
}

class Staff implements Comparable<Staff> {
    String name;
    int pay;
    Staff(String name, int pay) {
        this.name =name;
        this.pay =pay;
    }
    public String toString() {
        return String.format("[%s, %d]", name,  pay);
    }
    String getName() { return name;}
    public int compareTo(Staff s) {
        return s.pay - this.pay;
    }
}