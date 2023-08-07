package example.ch11;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static java.util.Collections.*;

public class Collection16 {
    public static void main(String[] args) {
        /**
         *    - 컬렉션 클래스 간단 정리.
         *
         *      1. ArrayList, Vector : Object배열 기반에 컬렉션 클래스.
         *          1-1. Stack : Vector기반의 LIFO 구조 클래스.
         *
         *
         *      2. LinkedList : 배열 기반의 단점인 추가, 삭제가 불리하다는 점을 개선하여 등장.
         *                      연결 기반의 클래스.
         *          2-1. Queue : LinkedList기반의 FIFO구조 클래스.
         *          2-2. TreeMap : 연결 기반의 각 노드마다 2개 이하의 노드를 연결할 수 있는 클래스.
         *                         이진 탐색 트리 구조를 이용해서 범위 검색과 정렬기능을 향상시켰다.
         *                              ex) 중위 순회 정렬 ...
         *              2-2-1. TreeSet : TreeMap의 내부 코드의 key만 가지고 만든 클래스.
         *
         *
         *      3. HashMap : 배열과 LinkedList의 장점을 결합, 검색기능 향상시킨 클래스.
         *                   entry(key, value)형태로 저장.
         *          3-1. HashSet : HashMap의 내부 코드의 key만 가지고 만든 클래스.
         *              3-1-1. LinkedHashSet : HashSet의 순서를 유지하지 않는 점을 개선시켜 순서유지 기능을 향상시킨 클래스.
         *          3-2. LinkedHashMap : HashMap의 순서를 유지하지 않는 점을 개선시켜 순서유지 기능을 향상시킨 클래스.
         *          3-3. Properties : HashMap의 (Object, Object)를 (String, String)으로 바꾸어서 파일을 읽고 쓰기에 용이하게 만든 클래스.
         */
    }
}
