package example.ch11;

public class Collection02 {
    public static void main(String[] args){
        /**
         *    - Collection 인터페이스의 메서드.
         *
         *      1. 추가
         *          boolean add(Object o)
         *          boolean addAll(Collection c) : 지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.(추가)
         *      2. 삭제
         *          boolean remove(Object o) : 지정된 객체를 삭제한다.(삭제)
         *          boolean removeAll(Collection c) : 지정된 Collection에 포함된 객체들을 삭제한다.(삭제)
         *          boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.
         *                                            이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.(삭제)
         *          void clear() : Collection의 모든 객체를 삭제한다.(전체 삭제)
         *      3. 검색
         *          boolean contains(Object o)
         *          boolean containsAll(Collection c) : 지정된 객체(o)또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.(검색)
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
         *    - List인터페이스 : 순서(저장) O, 중복 O
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
         */
    }
}
