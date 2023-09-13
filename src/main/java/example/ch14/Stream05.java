package example.ch14;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream05 {
    public static void main(String[] args){
        /*    - 스트림의 중간연산(1/7)
                스트림 자르기 - skip(), limit()     */
        System.out.println("==============스트림 자르기 - skip(), limit()=============");
        IntStream intStream = IntStream.rangeClosed(1, 10);

        // Stream<T> skip(long n) : 앞에서부터 n개 건너뛰기.
        // Stream<T> limit(long maxSize) : maxSize 이후의 요소는 잘라냄.
        intStream.skip(3).limit(5).forEach(System.out::println);



        /*    - 스트림의 중간연산(2/7)
                스트림의 요소 걸러내기 - filter(), distinct()     */

        // Stream<T> filter(Predicate<? super T> predicate) // 조건에 맞지 않는 요소 제거.
        // Stream<T> distinct()                             // 중복제거.

        System.out.println("==============스트림의 요소 걸러내기 - filter(), distinct()=============");

        IntStream intStream1 = IntStream.rangeClosed(1, 10);        // 12345678910
        intStream1.filter(i->i%2==0).forEach(System.out::print);    // 246810
        System.out.println();

        IntStream intStream2 = IntStream.rangeClosed(1, 10);
        intStream2.filter(i->i%2!=0 && i%3!=0).forEach(System.out::print);
        System.out.println();

        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::print);
        System.out.println();

        IntStream intStream4 = IntStream.of(1,2,2,3,3,3,4,5,5,6);
        intStream4.distinct().forEach(System.out::print);   //123456
        System.out.println();



        /**   - 스트림의 중간연산(3/7)
         *       스트림 정렬하기 - sorted()
         *
         *          Stream<T> sorted()                                 // 스트림 요소의 기본 정렬(Comparable)로 정렬.
         *          Stream<T> sorted(Comparator<? super T> comparator) // 지정된 comparator로 정렬.
         *
         *       strStream.sorted()                              // 기본 정렬.
         *       strStream.sorted(Comparator.naturalOrder())     // 기본 정렬.
         *       strStream.sorted((s1, s2) -> s1.compareTo(s2)); // 람다식도 가능.
         *       strStream.sorted(String::compareTo);            // 메서드 참조, 위의 문장과 동일.
         *          결과 : CCaabccdd
         *
         *       strStream.sorted(Comparator.reverseOrder())     // 기본 정렬의 역순.
         *       strStream.sorted(Comparator.<String>naturalOrder().reversed())
         *          결과 : ddccbaaCC
         *
         *       strStream.sorted(String.CASE_INSENSITIVE_ORDER) // 대소문자 구분안함
         *          결과 : aaabCCccdd
         *
         *       strStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
         *          결과 : ddCCccbaaa (오타아님)
         *
         *       strStream.sorted(Comparator.comparing(String::length))    // 길이 순 정렬
         *       strStream.sorted(Comparator.comparingInt(String::length)) // no오토박싱
         *          결과 : bddCCccaaa
         *
         *       strStream.sorted(Comparator.comparing(String::length).reversed())
         *          결과 : aaaddCCccb
         *
         *
         *
         *       - 스트림의 중간연산(4/7)
         *
         *       Comparator의 comparing()으로 정렬 기준을 제공.
         *
         *          comparing(Function<T, U> keyExtractor)
         *          comparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)
         */

        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        // 추가 정렬 기준을 제공할 때는 thenComparing()을 사용(정렬 기준 여러개).
        studentStream.sorted(Comparator.comparing(Student::getBan) // 1.반별 정렬 (람다식 qusgud : (Student s) -> s.getBan())
                        .thenComparing(Student::getTotalScore))    // 2.총점별로 정렬
                .forEach(System.out::println);

//        studentStream.sorted(Comparator.comparing(Student::getName) // 이름별로 정렬
//                        .thenComparing(Comparator.naturalOrder())) // 기본 정렬
//                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;
    Student(String name, int ban, int totalScore) {
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

    // 총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}