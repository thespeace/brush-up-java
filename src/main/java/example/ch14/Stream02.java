package example.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

public class Stream02 {
    public static void main(String[] args){
        /**
         *    - 스트림(Stream)의 특징 (1/3)
         */
        //스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.(Read Only)
        List<Integer> list = Arrays.asList(3,1,5,4,2);
        List<Integer> sortedList = list.stream().sorted()   // list를 정렬해서
                .collect(Collectors.toList());              // 새로운 List에 저장
        System.out.println(list);
        System.out.println(sortedList);

        //스트림은 Iterator처럼 일회용이다.(필요하면 다시 스트림을 생성해야 한다)
        String[] strArr = { "a", "b","c","d","e"};
        Stream<String> strStream = Stream.of(strArr); // 문자열 배열이 소스인 스트림 생성.
        strStream.forEach(System.out::println); //모든 요소를 화면에 출력(최종연산)
//        int numOfStr = strStream.count();       //Error, 스트림은 최종연산 후 스트림의 요소를 소모한다. 더이상 사용할 요소가 없어서 스트림이 닫힌다.

        //최종 연산 전까지 중간연산이 수행되지 않는다 : 지연된 연산.
        IntStream intStream = new Random().ints(1,46); // 1~45범위의 무한 스트림.
        intStream.distinct().limit(6).sorted()      // 중간 연산(중복제거 + 자르기 + 정렬).
                .forEach(i->System.out.print(i+",")); // 최종 연산(출력).



        /**
         *    - 스트림(Stream)의 특징 (2/3)
         *      스트림은 작업을 내부 반복으로 처리한다.
         *      {@code
         *          for(String str : strList)       ->      stream.forEach(System.out::println);    // 성능은 비효율적이지만 코드가 간결해진다.
         *              System.out.println(str);
         *      }
         *      {@code : for문을 메서드안에 넣은 것.
         *          void forEach(Consumer<? super T> action) {
         *              Objects.requireNonNull(action); // 매개변수의 널 체크
         *              for(T t : src) //내부 반복(for문을 메서드 안으로 넣음)
         *                  action.accept(T);
         *          }
         *      }
         */


        /**
         *    - 스트림(Stream)의 특징 (3/3)
         */
        //스트림의 작업을 병렬로 처리 : 병렬스트림(멀티쓰레드)
        Stream<String> strStream2 = Stream.of("dd", "aaa","CC","cc","b");
        int sum = strStream2.parallel() // 병렬 스트림으로 전환(속성만 변경)
                .mapToInt(a->a.length()).sum(); // 모든 문자열의 길이의 합.
        System.out.println(sum);
/**
 *      기본형 스트림 : IntStream, LongStream, DoubleStream
 *
 *      오토박싱&언박싱의 비효율이 제거됨.(Stream<Integer> 대신 IntStream사용), 성능면에서 유리.
 *          오토박싱 : 기본형 -> 참조형.
 *          언박싱 : 참조형 -> 기본형.
 *
 *      숫자와 관련된 유용한 메서드를 Stream<T>보다 더 많이 제공한다.
 */


    }
}