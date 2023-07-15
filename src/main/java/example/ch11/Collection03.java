package example.ch11;

import java.util.ArrayList;
import java.util.Collections;

public class Collection03 {
    public static void main(String[] args){
        /**
         *    - ArrayList.
         *      예전 Vector클래스를 새로 개편하여 만든 것이 ArrayList이다.
         *      Vector와 ArrayList의 차이점 -> Vector은 자체적으로 동기화처리가 되어있지만 ArrayList는 동기화가 되어있지 않다.
         *      List인터페이스를 구현하므로, 저장순서가 유지되고 중복을 허용한다.
         *      데이터의 저장공간으로 배열을 사용한다.(배열기반)
         *
         *      {@code  Vector 클래스 예시
         *          public class Vector extends AbstractList implements List, RandomAccess, Cloneable, java.io.Serializable {
         *              ...
         *              protected Object[] elementData; // 객체를 담기 위한 배열, 다형성으로 인해 모든 종류의 객체 저장 가능.
         *              ...
         *          }
         *      }
         *
         *    - ArrayList의 메서드.
         *      1. 생성자
         *          ArrayList() : 기본 생성자
         *          ArrayList(Collection c) : 매개변수로 어떠한 Collection을 주면 ArrayList로 생성. (Collection끼리 변환할때 많이 사용한다.)
         *          ArrayList(int initialCapacity) : 매개변수로 배열의 길이를 지정, 나중에 변경하기 어려우니 신중히 설정.
         *      2. 추가
         *          boolean add(Object o) : 매개변수로 저장할 객체를 전달. 성공하면 true, 실패하면 false를 반환.
         *          void add(int index, Object element) : 매개변수로 저장위치를 설정할 수 있다.
         *          boolean addAll(Collection c) : Collection을 매개변수로 받으면 그대로 저장한다.
         *          boolean addAll(int index, Collection c) : 저장 취리를 설정할 수 있다.
         *      3. 삭제
         *          boolean remove(Object o) : 저장한 걸 삭제.
         *          Object remove(int index) : 특정 위치의 객체를 삭제.
         *          boolean removeAll(Collecton c) : Collection의 객체를 삭제.
         *          void clear() : ArrayList에 있는 모든 객체를 삭제.
         *      4. 검색
         *          int indexOf(Object o) : 객체가 몇 번째 저장되어 있는지 반환, 실패 시 -1을 반환.
         *          int lastIndexOf(Object o) : indexOf()의 반대로 오른쪽 끝에서 부터 왼쪽으로 거꾸로 찾아 반환.
         *          boolean contains(Object o) : 지정된 객체가 존재하는지 찾는다. 존재시 true, 없을 시 false.
         *          Object get(int index) : 객체 읽기.
         *          Object set(int index, Object element) : 특정 위치에 있는 객체를 변경.
         *      5. 기타
         *          List subList(int fromIndex, int toIndex) : from ~ to 사이에 있는 객체들을 뽑아서 새로운 리스트를 생성.
         *          Object[] toArray() : ArrayList가 가지고있는 객체 배열을 반환.
         *          Object[] toArray(Object[] a) :
         *          boolean isEmpty() : ArrayList가 비어있는지 확인.
         *          void trimToSize() : 빈공간 제거.
         *          int size() : ArrayList의 저장된 객체의 갯수를 반환.
         */


         System.out.println("=================Example1=================");

         // 기본 길이(용량, capacity)가 10인 ArrayList를 생성.
         ArrayList list1 = new ArrayList(10);
         //list1.add(5); // ArrayList는 객체배열을 뜻하니 원래는 객체만 저장 가능하다.
                         // 하지만 컴파일러에 의해 autoboxing이 이루어서 기본형이 참조형으로 자동 변환되어 기본형을 편리하게 작성 가능해졌다.
         list1.add(new Integer(5));
         list1.add(new Integer(4));
         list1.add(new Integer(2));
         list1.add(new Integer(0));
         list1.add(new Integer(1));
         list1.add(new Integer(3));

        /**
         *  subList() : ArrayList의 일부만 뽑아서 새로운 리스트로 만들 수 있다. 하지만 읽기 전용으로 리스트를 생성.
         *  ArrayList(Collection c) : sublist는 읽기 전용이기 때문에 내용을 변경하기 위해 ArrayList(Collection c)를 사용해 새로운 ArrayList를 만듦.
         *      {@code
         *          List        sub = list1.subList(1,4); // sub는 읽기만 가능 [4, 2, 0].
         *          ArrayList list2 = new ArrayList(sub); // sub와 같은 내용의 ArrayList생성.
         *      }
         */
         ArrayList list2 = new ArrayList(list1.subList(1,4)); // 1 <= x < 4.
         print(list1, list2);


         //Collection은 인터페이스, Collections는 유틸 클래스.
         Collections.sort(list1); // Collections.sort() : 오름차순을 default로 정렬한다.
         Collections.sort(list2);
         print(list1, list2);

         System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2)); // list1에 list2를 모두 포함하는지를 확인. 반환 값 : true, false.

         list2.add("B");
         list2.add("C");
         list2.add(3,"A"); // add(index, 값) : 추가할 위치 지정하여 값 추가, 하지만 중간에 무언가를 끼워넣는 것은 다른 요소들을 옮겨야 할 수 있기 때문에 부담이 가는 작업이다.
         print(list1, list2);

         list2.set(3, "AA"); // set() : 변경, 3번째 자리에 A를 AA로 치환하는 작업.
         print(list1, list2);

         list1.add(0,"1");
         print(list1, list2);

         //indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
         System.out.println("문자열 1의 index = " + list1.indexOf("1"));
         System.out.println("정수형 1의 index = " + list1.indexOf(1));

         list1.remove(0); // index로 해당 순서 요소 제거.
         //list1.remove(new Integer(1)); // 요소(정수 1)로 해당 요소 제거.
         print(list1, list2);

         //list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.(교집합 제거)
         System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
         print(list1, list2);

         //list2에서 list1에 포함된 객체들을 삭제한다.
         for(int i = list2.size() -1; i >= 0; i--) {
             if(list1.contains(list2.get(i)))
                 list2.remove(i);
         }
         /**
         *   1. get(i)으로 list2에서 하나씩 꺼낸다.
         *   2. contains()로 꺼낸 객체가 list1에 있는지 확인.
         *   3. remove(i)로 해당 객체를 list2에서 삭제.
         */
         print(list1, list2);
    }

    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }

     /**
      *   - ArrayList에 저장된 객체의 삭제 과정 시 주의점.
      *     1. 첫번째부터 삭제 (배열복사 발생)
      *     2. 마지막부터 삭제 (배열복사 안해서 빠르다.)
      *
      *     따라서, ArrayList에 저장된 객체를 삭제할 때, list.size()-1 로 삭제해야 배열복사가 안 생기고 더 빠르고 안전하게 요소를 제거할 수 있다.
      */
}
