package example.ch11;

import java.util.*;

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
         */
    }
}
