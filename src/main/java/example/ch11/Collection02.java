package example.ch11;

public class Collection02 {
    public static void main(String[] args){
        /**
         *    - Collection 인터페이스의 메서드.
         *
         *      1. 추가
         *          boolean add(Object o)
         *          boolean addAll(Collection c) : 지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.(합집합)
         *      2. 삭제
         *          boolean remove(Object o) : 지정된 객체를 삭제한다.
         *          boolean removeAll(Collection c) : 지정된 Collection에 포함된 객체들을 삭제한다.(차집합)
         *          boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.
         *                                            이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.(교집합)
         *          void clear() : Collection의 모든 객체를 삭제한다.(전체 삭제)
         *      3. 검색
         *          boolean contains(Object o)
         *          boolean containsAll(Collection c) : 지정된 객체(o)또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.(부분집합)
         *      4. 기타
         *          boolean equals(Object o) : 동일한 Collection인지 비교한다.
         *          int hashCode() : Collection의 hash code를 반환한다.
         *          boolean isEmpty() : Collection이 비어있는지 확인한다.
         *          Iterator iterator() : Collection의 Iterator를 얻어서 반환한다.
         *          int size() : Collection에 저장된 객체의 개수를 반환한다.
         *          Object[] toArray() : Collection에 저장된 객체를 객체배열(Object[])로 반환한다.
         *          Object[] toArray(Object[] a) : 지정된 배열에 Collection의 객체를 저장해서 반환한다.
         *
         *
         *
         *    - List인터페이스 : 순서(저장) O, 중복 O <-> Set인터페이스.
         *      List인터페이스를 구현한 클래스는 Vector(예전방식) <- Stack / ** ArrayList(Vector을 개선) / LinkedList ** 가 있다.
         *
         *    - List인터페이스의 메서드.
         *      List인터페이스는 Collection인터페이스 자손이기에 부모의 메서드들을 List인터페이스도 가지고 있고, 추가적으로 아래의 메서드들을 가지고 있는 것이다.
         *      많을 수의 객체들을 다루기 편리한 메서드들을 가지고 있다.
         *
         *      1. 추가
         *          void add(int index, Object element)
         *          boolean addAll(int index, Collection c) : 지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다.
         *      2. 삭제
         *          Object remove(int index) : 지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다.
         *      3. 검색
         *          int indexOf(Object o) : 지정된 객체의 위치(index)를 반환한다.(List의 첫 번째 요소부터 순방향으로 찾는다.)
         *          int lastIndexOf(Object o) : 지정된 객체의 위치(index)를 반환한다.(List의 마지막 요소부터 역방향으로 찾는다.)
         *      4. 읽기
         *          Object get(int index) : 지정된 위치(index)에 있는 객체를 반환한다.
         *      5. 변경
         *          Object set(int index, Object element) : 지정된 위치(index)에 객체(element)를 저장한다.
         *      6. 정렬
         *          void sort(Comparator c) : 지정된 비교자(comparator)로 List를 정렬한다.
         *      7. 기타
         *          ListIterator listIterator()
         *          ListIterator listIterator(int index) : List의 객체에 접근할 수 있는 ListIterator를 반환한다.
         *          List subList(int fromIndex, int toIndex) : 지정된 범위(fromIndex 부터 toIndex)에 있는 객체를 반환한다.
         *
         *
         *
         *    - Set인터페이스 : 순서 X, 중복 X <-> List인터페이스.
         *      Set인터페이스를 구현하고 있는 대표적인 Collection클래스는 핵심적으로 HashSet, TreeSet 이 두 개가 있고, 나머지 SortedSet가 있다.
         *      Set인터페이스의 메서드는 Collection인터페이스와 동일하다.
         *      합집합, 차집합, 교집합 등을 하여 어떠한 값을 찾기 위해서는 HashSet이나 TreeSet을 사용하면 편리하게 찾을 수 있다.
         *
         *
         *
         *    - Map인터페이스 : 순서 X, 중복( 키 X, 값 O )
         *      Map인터페이스를 구현 한 클래스로는 대표적으로 HashMap, TreeMap이 있고, 나머지 클래스는 다음과 같다. Hashtable은 HashMap의 옛날 버전, LinkedHashMap은 순서가 있다. 나머지로는 SortedMap이 있다.
         *
         *    - Map인터페이스의 메서드.
         *      1. 추가
         *          Object put(Object key, Object value) : Map에 value객체를 key객체에 연결(mapping)하여 저장한다.
         *          void putAll(Map t) : 지정된 Map의 모든 key-value쌍을 추가한다.
         *      2. 삭제
         *          Object remove(Object key) : 지정한 key객체와 일치하는 key-value객체를 삭제한다.
         *      3. 검색
         *          boolean containsKey(Object key) : 지정된 key객체와 일치하는 Map의 key 객체가 있는지 확인한다.
         *          boolean containsValue(Object value) : 지정된 value객체와 일치하는 Map의 value객체가 있는지 확인한다.
         *          Object get(Object key) : 지정한 key객체에 대응하는 value객체를 찾아서 반환한다.
         *      4. 읽기
         *          Set entrySet() : Map에 저장되어 있는 key-value쌍을 Map.Entry타입의 객체로 저장한 Set으로 반환한다.
         *          Set keySet() : Map에 저장된 모든 key 객체를 반환한다.
         *          Collection values() : Map에 저장된 모든 value 객체를 반환한다.
         *
         *          +키(key)값을 알고 싶다면 keySet()으로 값(value)은 values(), Entry(key + value)로 모두 불러오고 싶다면 entrySet()을 사용하면 된다.
         *           entrySet()과 keySet()은 반환타입이 Set이기 때문에 순서X, 중복X 이지만 반대로 values()는 Collector타입으로 반환할 수 있기때문에 List, Set 둘 중 어느걸 써도 상관없다.
         *      5. 기타
         *          void clear() : Map의 모든 객체를 삭제한다.
         *          boolean equals(Object o) : 동일한 Map인지 비교한다.
         *          int HashCode() : 해시코드를 반환한다.
         *          boolean isEmpty() : Map이 비어있는지 확인한다.
         *          int size() : Map에 저장된 key-value쌍의 개수를 반환한다.
         */
    }
}
