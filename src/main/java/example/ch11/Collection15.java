package example.ch11;

import java.util.*;
import static java.util.Collections.*; // 메서드를 사용할때, Collections를 생략가능하게 해준다.

public class Collection15 {
    public static void main(String[] args) {
        /**
         *    - Collections : 컬렉션을 다룰 때 필요한 유용한 메서드(static)를 제공해주는 클래스.
         *                    ex) Objects(객체를 다루기 위한), Arrays(배열을 다루기 위한), Collections(컬렉션).
         *
         *      1. 컬렉션 채우기, 복사, 정렬, 검색 - fill(), copy(), sort(), binarySearch() 등  ==  Arrays 클래스와 같다.
         *      2. 컬렉션의 동기화 - synchronizedXXX()
         *          {@code
         *              static Collection synchronizedCollection(Collection c)
         *              static List       synchronizedList(List list)
         *              static Set        synchronizedSet(Set s)
         *              static Map        synchronizedMap(Map m)
         *              static SortedSet  synchronizedSortedSet(SortedSet s)
         *              static SortedMap  synchronizedSortedMap(SortedMap m)
         *          }
         *          Vector, ArrayList 둘 다 배열기반 클래스인데, 예전 버전인 Vector은 동기화가 되어있고, 새로운 버전인 ArraysList는 동기화가 되어있지 않다.
         *          그 이유는 항상 동기화하기보다는 설계적으로도 좋은 코드를 작성하기 위해 필요할때만 동기화하도록 바뀐 것이다.
         *          위의 메서드들을 사용해서 동기화를 사용할 수 있다.
         *          {@code -사용법
         *              List syncList = Collections.synchronizedList(new ArrayList(...));
         *              // new ArrayList(...) : 동기화 되지 않은 리스트.
         *              // syncList           : 동기화된 리스트, Vector 클래스를 사용하는 것과 똑같은 결과를 얻을 수 있다.
         *          }
         *
         *      3. 변경불가(readOnly) 컬렉션 만들기 - unmodifiableXXX()
         *          {@code
         *              static Collection   unmodifiableCollection(Collection c)
         *              static List         unmodifiableList(List list)
         *              static Set          unmodifiableSet(Set s)
         *              static Map          unmodifiableMap(Map m)
         *              static NavigableSet unmodifiableNavigableSet(NavigableSet s)
         *              static SortedSet    unmodifiableSortedSet(SortedSet s)
         *              static NavigableMap unmodifiableNavigableMap(NavigableMap m)
         *              static SortedMap    unmodifiableSortedMap(SortedMap m)
         *          }
         *         해당 메서드를 사용하면 컬렉션을 수정 불가, 즉 읽기 전용 컬렉션으로 만들어 준다. == final 변수 -> 상수(변경불가)
         *         컬렉션이 변경되지 않고 보호해야 할 때 해당 메서드들을 사용하면 된다.
         *
         *      4. 싱글톤 컬렉션 만들기 - singletonXXX() : 객체 1개만 저장하는 컬렉션을 만드는 메서드.
         *          {@code
         *              static List singletonList(Object o)
         *              static Set  singleton(Object o)     // singletonSet이 아님에 주의.
         *              static Map  singletonMap(Object key, Object value)
         *          }
         *
         *      5. 한 종류(type)의 객체만 저장하는 컬렉션 만들기 - checkedXXX()
         *          {@code
         *              static Collection   checkedCollection(Collection c, Class type)
         *              static List         checkedList(List list, Class type)
         *              static Set          checkedSet(Set s, Class type)
         *              static Map          checkedMap(Map m, Class type)
         *              static Queue        checkedQueue(Queue queue, Class type)
         *              static NavigableSet checkedNavigableSet(NavigableSet s, Class type)
         *              static SortedSet    checkedSortedSet(SortedSet s, Class type)
         *              static NavigableMap checkedNavigableMap(NavigableMap m, Class keyType, Class valueType)
         *              static SortedMap    checkedSortedMap(SortedMap m, Class keyType, Class valueType)
         *          }
         *
         *          {@code -사용법
         *              List list = new ArrayList();
         *              List checkedList = checkedList(list, String.class); // String 타입의 객체만 저장 가능.
         *              checkedList.add("abc");             // OK.
         *              checkedList.add(new Integer(3));    // 에러, ClassCastException발생, String타입의 객체만 저장 가능.
         *          }
         *          JDK1.5 이후에는 지네릭스(Generics)의 등장으로 잘 쓰이지는 않지만, 이전에는 해당 메서드로 타입을 제한했다.
         */

        List list = new ArrayList();
        System.out.println(list);

        addAll(list, 1,2,3,4,5);
        System.out.println("list : " + list);

        rotate(list, 2);  // 반시계 방향으로 두 번 회전(오른쪽으로 두 칸씩 이동).
        System.out.println("rotate(list, 2) : " + list);

        swap(list, 0, 2); // 첫 번째 인덱스와 세 번째 인덱스를 교환(swap).
        System.out.println("swap(list, 0, 2) : " + list);

        shuffle(list);    // 저장된 요소의 위치를 임의로 변경.
        System.out.println("shuffle(list) : " + list);

        sort(list, reverseOrder()); // 역순 정렬 reverse(list);와 동일
        System.out.println("sort(list, reverseOrder()) : " + list);

        sort(list);       // 기본 정렬(오름차순)
        System.out.println("sort(list) : " + list);

        int idx = binarySearch(list, 3);  // 3이 저장된 위치(index)를 반환, binarySearch()메서드를 사용하기 위해서는 먼저 정렬을 해주어야 한다.
        System.out.println("index of 3 = " + idx);

        System.out.println("max="+max(list)); // 최댓값.
        System.out.println("min="+min(list)); // 최솟값.
        System.out.println("min="+max(list, reverseOrder())); // 반대 정렬 방식의 최대값 == min().

        fill(list, 9); // list를 9로 채운다.
        System.out.println("list="+list);

        // list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
        List newList = nCopies(list.size(), 2);
        System.out.println("newList="+newList);

        System.out.println(disjoint(list, newList)); // 공통요소가 없으면 true

        copy(list, newList); // 복사.
        System.out.println("newList="+newList);
        System.out.println("list="+list);

        replaceAll(list, 2, 1); // 대체, 2를 1로 바꾸기.
        System.out.println("list="+list);

        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);

        System.out.println("list2="+list2);
    }
}
