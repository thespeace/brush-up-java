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
    }
}