package example.ch11;

public class Collection02 {
    public static void main(String[] args){
        /**
         *    - Collection 인터페이스의 메서드
         *
         *      1. 추가
         *          boolean add(Object o), boolean addAll(Collection c) : 지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.(추가)
         *      2. 삭제
         *          boolean remove(Object o) : 지정된 객체를 삭제한다.(삭제)
         *          boolean removeAll(Collection c) : 지정된 Collection에 포함된 객체들을 삭제한다.(삭제)
         *          boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.
         *                                            이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.(삭제)
         *          void clear() : Collection의 모든 객체를 삭제한다.(전체 삭제)
         *      3. 검색
         *          boolean contains(Object o), boolean containsAll(Collection c) : 지정된 객체(o)또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.(검색)
         *      4. 기타
         *          boolean equals(Object o) : 동일한 Collection인지 비교한다.
         *          int hashCode() : Collection의 hash code를 반환한다.
         *          boolean isEmpty() : Collection이 비어있는지 확인한다.
         *          Iterator iterator() : Collection의 Iterator를 얻어서 반환한다.
         *          int size() : Collection에 저장된 객체의 개수를 반환한다.
         *          Object[] toArray() : Collection에 저장된 객체를 객체배열(Object[])로 반환한다.
         *          Object[] toArray(Object[] a) : 지정된 배열에 Collection의 객체를 저장해서 반환한다.
         */
    }
}
