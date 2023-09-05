package example.ch14;

/**
 *    - 컬렉션 프레임웍과 함수형 인터페이스
 *      JDK1.8- 부터 함수형 인터페이스가 추가되며 컬렉션 프레임웍에도 많은 변화가 있었고, 람다식을 이용해서 작업을 좀 더 쉽게 처리 할 수 있는 메서드가 생겼는데, 몇가지 살펴보자.
 *
 *      함수형 인터페이스를 사용하는 컬렉션 프레임웍의 메서드(와일드 카드 생략)
 *
 *          인터페이스   |                       메서드                       |      설명
 *          Collection | boolean removeIf(Predicate<E> filter)             | 조건에 맞는 요소를 삭제
 *          List       | void replaceAll(UnaryOperator<E> operator)        | 모든 요소를 변환하여 대체
 *          Iterable   | void forEach(Consumer<T> action)                  | 모든 요소에 작업 action을 수행
 *          Map        | V compute(K key, BiFunction<K,V,V> f)             | 지정된 키의 값에 작업 f를 수행
 *           "         | V computeIfAbsent(K key, Function<K,V> f)         | 키가 없으면, 작업 f 수행 후 추가
 *           "         | V computeIfPresent(K key, BiFunction<K,V,V> f)    | 지정된 키가 있을 때, 작업 f 수행
 *           "         | V merge(K key, V value, BiFunction<V,V,V> f)      | 모든 요소에 병합작업 f를 수행
 *           "         | void forEach(BiConsumer<K,V> action)              | 모든 요소에 작업 action을 수행
 *           "         | void replaceAll(BiConsumer<K,V,V> f)              | 모든 요소에 치환작업 f를 수행
 *
 *          {@code
 *              list.forEach(i->System.out.print(i+",")); // list의 모든 요소를 출력
 *              list.removeIf(x-> x%2==0 || x%3==0);      // 2 또는 3의 배수를 제거
 *              list.replaceAll(i->i*10);                 // 모든 요소에 10을 곱한다.
 *
 *              //map의 모든 요소를 {k,v}의 형식으로 출력
 *              map.forEach((k,v)->System.out.print("{"+k+","+v+"},"));
 *          }
 *
 *      JDK1.8의 람다식 도입 전에는 컬렉션 프레임웍을 사용하기에 불편한 점이 많이 있었지만, 람다식의 도입으로 사용하기 편리해 졌다.
 *      아인슈타인의 E = mc2제곱 은 프로그래밍에서는 Error = MoreCode 2제곱이라는 말장난이 있을만큼 간결한 코드를 선호하기 시작해졌다.
 */

import java.util.*;

public class Lambda06 {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add(i);

        // list의 모든 요소를 출력
        list.forEach(i->System.out.print(i+","));
        System.out.println();

        // list의 모든 요소를 출력(람다식 도입 이전 방식)
        /*Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+",");
        }*/

        // list에서 2 또는 3의 배수를 제거한다.
        list.removeIf(x-> x%2==0 || x%3==0);
        System.out.println(list);

        list.replaceAll(i->i*10); // list의 각 요소에 10을 곱한다.
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 모든 요소를 {k,v}의 형식으로 출력한다.
        map.forEach((k,v)-> System.out.print("{"+k+","+v+"},"));
        System.out.println();

        // map의 모든 요소를 출력(람다식 도입 이전 방식)
        /*Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }*/
    }
}
