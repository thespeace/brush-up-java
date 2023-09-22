package example.ch14;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.*;

public class Stream11 {
    public static void main(String[] args){

        /**
         *    - 스트림의 통계
         *      스트림의 통계정보 제공 : counting(), summingInt(), maxBy(), minBy(), ...
         */

        // Collectors.counting() : 요소 갯수 얻기.
        Stream<Integer> intStream = Stream.of(9,8,7,6,5,4,3,2,1);

//        long count = intStream.count(); // Stream의 count()는 항상 전체 카운팅만 가능.
        long count = intStream.collect(Collectors.counting()); // 그룹별로 나누어서 카운팅하는 것도 가능.
        System.out.println(count);



        // Collectors.summingInt() : 요소 합계 얻기.
        Stream<Integer> intStream1 = Stream.of(10,20,30,40,50,60,70,80,90,100);

//        long totalScore = somethingStream.mapToInt(somethingStream::getSomething).sum(); // IntStream의 sum() : 전체 합계.
        long totalScore = intStream1.collect(Collectors.summingInt(i->i)); // 전체 합계, 그룹별 합계가 가능하다.
        System.out.println(totalScore);



        // Collectors.maxBy() : 요소 중 최대값 얻기.
//        OptionalInt topScore = studentStream.mapToInt(Student::getTotalScore).max(); // 전체 요소 중의 최대값

        Stream<Student1> stuStream = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 310),
                new Student1("감자바", 3, 180)
        );

//        Optional<Student1> topStudent = stuStream.max(Comparator.comparingInt(Student1::getTotalScore));
        Optional<Student1> topStudent = stuStream
                .collect(Collectors.maxBy(Comparator.comparingInt(Student1::getTotalScore)));

        System.out.println(topStudent);



        /**
         *    - 스트림을 리듀싱 : reducing()
         *
         *      Collector reducing(BinaryOperator<T> op)
         *      Collector reducing(T identity, BinaryOperator<T> op) // accumulator(누적 작업)
         *      Collector reducing(U identity, Function<T,U> mapper, BinaryOperator<U> op) // map + reduce, 변환작업이 필요시 mapper있는걸 사용.
         */

        IntStream intStream2 = new Random().ints( 1, 46).distinct().limit(6);
        IntStream intStream3 = new Random().ints( 1, 46).distinct().limit(6);

        OptionalInt       max1 = intStream2.reduce(Integer::max); // 전체 요소 리듀싱.
        Optional<Integer> max2 = intStream3.boxed().collect(Collectors.reducing(Integer::max)); // 그룹별 리듀싱 가능.

        System.out.println(max1);
        System.out.println(max2);

        IntStream intStream4 = new Random().ints( 1, 46).distinct().limit(6);
        IntStream intStream5 = new Random().ints( 1, 46).distinct().limit(6);

        long sum1 = intStream4.reduce(0, (a,b) -> a + b); // 인자 첫번째 : 초기값, 두번째 누적작업.
        long sum2 = intStream5.boxed().collect(Collectors.reducing(0, (a,b) -> a + b)); // 전체 요소 작업 뿐아니라 그룹별로도 가능.

        System.out.println(sum1);
        System.out.println(sum2);

        Stream<Student1> stuStream1 = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 310),
                new Student1("감자바", 3, 180)
        );
        Stream<Student1> stuStream2 = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 310),
                new Student1("감자바", 3, 180)
        );
        int grandTotal1 = stuStream1.map(Student1::getTotalScore).reduce(0, Integer::sum);
        int grandTotal2 = stuStream2.collect(Collectors.reducing(0, Student1::getTotalScore, Integer::sum)); // 전체 요소 작업 뿐아니라 그룹별로도 가능.

        System.out.println(grandTotal1);
        System.out.println(grandTotal2);




        /**
         *    - 문자열 스트림의 요소를 모두 연결 : joining()
         */

        Stream<Student1> stuStream3 = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 310),
                new Student1("감자바", 3, 180)
        );
        Stream<Student1> stuStream4 = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 310),
                new Student1("감자바", 3, 180)
        );
        Stream<Student1> stuStream5 = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 310),
                new Student1("감자바", 3, 180)
        );

        String studentNames1 = stuStream3.map(Student1::getName).collect(Collectors.joining());
        String studentNames2 = stuStream4.map(Student1::getName).collect(Collectors.joining(","));
        String studentNames3 = stuStream5.map(Student1::getName).collect(Collectors.joining(",","[","]"));
//        String studentInfo = stuStream5.collect(Collectors.joining(",")); // Student의 toString()으로 결합

        System.out.println(studentNames1);
        System.out.println(studentNames2);
        System.out.println(studentNames3);
    }
}

class Student1 implements Comparable<Student1> {
    String name;
    int ban;
    int totalScore;
    Student1(String name, int ban, int totalScore) {
        this.name =name;
        this.ban =ban;
        this.totalScore =totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName()     { return name;}
    int getBan()         { return ban;}
    int getTotalScore()  { return totalScore;}

    public int compareTo(Student1 s) {
        return s.totalScore - this.totalScore;
    }
}