package example.ch11;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;

public class Collection13 {
    public static void main(String[] args) {
        /**
         *    - HashMap과 Hashtable : 순서 X, 중복(키 X, 값 O)
         *      Map인터페이스를 구현, 데이터를 키와 값의 쌍으로 저장. (key, value)
         *          + TreeMap : 이진탐색트리로 구성, TreeSet과 같은 특성을 가지고 있다.
         *      HashMap(동기화 X)는 Hashtable(동기화 O)의 신버전.
         *
         *    - HashMap
         *      Map인터페이스를 구현한 대표적인 컬렉션 클래스
         *      순서를 유지하려면, LinkedHashMap클래스를 사용하면 된다.
         *
         *    - TreeMap
         *      사실은 TreeSet이 TreeMap을 가지고 만든 것, 같은 특성을 갖는다.
         *      범위 검색과 정렬에 유리한 컬렉션 클래스.
         *      HashMap보다 데이터 추가, 삭제에 시간이 더 걸린다.(비교저장때문에)
         *
         *    - HashMap의 키(key)와 값(value)
         *      해싱(hashing)기법으로 데이터를 저장, 데이터가 많아도 검색이 빠르다.
         *      Map인터페이스를 구현, 데이터를 키와 값의 쌍으로 저장.
         *          1. 키(key)   : 컬렉션 내의 키(key) 중에서 유일해야 한다.
         *          2. 값(value) : 키(key)와 달리 데이터의 중복을 허용한다.
         *
         *          {@code HashMap Class
         *              public class HashMap extends AbstractMap implements Map, Cloneable, Serializable {
         *                  transient Entry[] table;
         *                  ...
         *                  static class Entry implements Map.Entry {
         *                      final Object key;
         *                      Object value;
         *                      ...
         *                  }
         *              }
         *          }
         *
         *              + Entry : key-value, 한 쌍을 엔트리라 부른다.
         *              {@code 객체 지향적인 코드.
         *                  Entry[] table; // 묶음의 배열 선언.
         *                  class Entry { // 키와 값을 묶음.
         *                      Object key;
         *                      Object value;
         *                  } // 현재는 코드가 바뀌었지만, 예전 코드가 이해하기 쉬워서 작성.
         *              }
         *
         *              {@code 비객체지향적인 코드
         *                  Object[] key; // 객체 배열.
         *                  Object[] value;
         *              }
         */


        /**
         *    - 해싱(hashing)
         *      해시함수(hash function)를 이용해서 해시테이블(hash table)에 데이터를 저장하고, 읽어오는 것(즉 검색)을 하는 기법.
         *      함수에 key값을 넣으면 해쉬코드(저장위치, 배열의 index)를 알려준다.
         *      해시테이블은 배열과 링크드 리스트가 조합된 형태로 가변적이긴 하지만 2차원 배열처럼 생겨서 테이블이라고 한다. 간단히 말하자면, 링크드리스트를 배열로 묶어 놓은 것.
         *          " 배열의 장점(접근성) + 링크드리스트의 장점(변경에 유리)를 합친 것이 해시테이블이다. "
         *      이렇게 분류해서 저장한 링크드리스트를 배열에 담으면, 데이터가 많아도 검색 속도가 상당히 빠르다.
         *      해싱은 해시함수를 이용한 것이기 때문에 함수의 성능이 가장 중요한데, Object.hash()메서드를 이용해서 작성하면된다.
         *      해싱을 사용하는 클래스 : HashTable, HashMap, HashSet ...
         *      전부 hashCode()라는 메서드를 사용하는 데, 이 메서드를 Object.hash()라는 메서드를 이용해서 오버라이딩하여 해쉬함수를 작성하면 된다.
         *
         *    - 해시테이블에 저장된 데이터를 가져오는 과정.
         *      1. 키(key)로 해시함수를 호출해서 해시코드(hash code, 배열의 index(저장위치))를 얻는다.
         *      2. 해시코드(해시함수의 반환값)에 대응하는 링크드리스트를 배열에서 찾는다.
         *      3. 링크드리스트에서 키와 일치하는 데이터를 찾는다.
         *          * 해시함수는 같은 키에 대해 항상 같은 해시코드를 반환해야 한다. 그래야 저장하고 읽어올때 모두 같은 해시코드가 나와야하기 때문.
         *            서로 다른 키일지라도 같은 값의 해시코드를 반환할 수도 있다.
         */
    }
}
