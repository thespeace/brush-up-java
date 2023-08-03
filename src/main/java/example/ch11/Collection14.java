package example.ch11;

import java.util.HashMap;
import java.util.Map;

public class Collection14 {
    public static void main(String[] args) {
        /**
         *    - HashMap의 주요 메서드.
         */

        // HashMap() : 생성자
        Map hm1 = new HashMap();

        // HashMap(int initialCapacity) : 배열초기용량 지정 가능.
        HashMap hm2 = new HashMap(16); // Default값인 16.
        hm2.put("myKey","myValue");

        // HashMap(int initialCapacity, float loadFactor) : 배열초기용량, 수용 가능한 크기가 어느 정도까지만 유지될 수 있는지에 대한 threshold 값을 지정 가능.
        HashMap hm3 = new HashMap(16,0.75f); // load Factor의 기본값 0.75.

        // HashMap(Map m) : Map타입을 HashMap으로 변경 가능.
        HashMap hm4 = new HashMap(hm1);

        // Object put(Object key, Object value) : key와 value형태로 추가.
        hm4.put("myid",1234);
        hm4.put("asdf",1234);

        // void putAll(Map m) : Map 객체를 통채로 추가.
        hm4.putAll(hm2);

        // Object remove(Object key) : 해당 키 삭제.
        hm4.remove("asdf");

        // Object replace(Object key, Object value) : 기존에 저장된 키에 새로운 값을 저장하는 것.
        hm4.replace("myid","user");

        // boolean replace(Object key, Object oldValue, Object newValue) : 변경
        hm4.replace("myKey","myValue","5w98faew56f");

        // Set entrySet() : key-value 쌍의 값을 Set으로 얻을 수 있다.
        System.out.println("hm4.entrySet() : " + hm4.entrySet());

        // Set keySet() : key 값만 얻기.
        System.out.println("hm4.keySet() : " + hm4.keySet());

        // Collection values() : value 값 얻기.
        System.out.println("hm4.values() : " + hm4.values());

    }
}
