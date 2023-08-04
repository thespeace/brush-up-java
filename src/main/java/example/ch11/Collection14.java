package example.ch11;

import java.util.*;

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

        // Object get(Object key) : key값을 매개변수로 주면 해당하는 value를 반환한다.
        System.out.println("hm4.get(\"myid\") : " + hm4.get("myid"));

        // Object getOrDefault(Object key, Object defaultValue) : 매개변수에 전달한 key가 없을때, 지정한 defaultValue를 반환하는 메서드.
        System.out.println("hm4.getOrDefault(\"myName\", \"seo\") : " + hm4.getOrDefault("myName","seo"));

        // boolean containsKey(Object key) : 지정된 키가 존재하는지를 boolean타입으로 반환.
        System.out.println("hm4.containsKey(\"myName\") : " + hm4.containsKey("myName"));

        // boolean containsValue(Object value) : 지정된 값이 존재하는지를 boolean타입으로 반환.
        System.out.println("hm4.containsValue(\"user\") : " + hm4.containsValue("user"));

        // int size() : 크기.
        System.out.println("hm4.size() : " + hm4.size());

        // boolean isEmpty() : 비었는지 확인.
        System.out.println("hm4.isEmpty() : " + hm4.isEmpty());

        // Object clone() : 복제.
        HashMap hm5 = new HashMap((HashMap)hm4.clone());
        System.out.println("HashMap hm5 = new HashMap((HashMap)hm4.clone()); : " + hm5);

        // void clear() : 전부 비우기.
        hm4.clear();
        System.out.println("hm4.clear(); : " + hm4);



        System.out.println("\n==============예제 1(아이디 비밀번호 체크하기)=============");

        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);	// 화면으로부터 라인단위로 입력받는다.

        while(true) {
            System.out.println("id와 password를 입력해주세요.");
            System.out.print("id :");
            String id = s.nextLine().trim(); // trim() : 앞 뒤 공백제거.

            System.out.print("password :");
            String password = s.nextLine().trim();
            System.out.println();

            if(!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                continue;
            }

            if(!(map.get(id)).equals(password)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            } else {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
        }



        System.out.println("\n==============예제 2(점수 집계 내기)=============");

        HashMap map1 = new HashMap();
        map1.put("김자바", 90);
        map1.put("김자바", 100); // key값이 일치하기 때문에 value값이 덧씌워진다.
        map1.put("이자바", 100);
        map1.put("강자바", 80);
        map1.put("안자바", 90);

        Set set = map1.entrySet(); // entrySet을 이용해서 map에 저장된 내용을 읽어오는 코드.
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next(); // map 인터페이스 안에 Entry 인터페이스를 구현.
            System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map1.keySet(); // keySet() : key값만 가져올 수 있다.
        System.out.println("참가자 명단 : " + set);

        Collection values = map1.values(); // values() : value만 가져올 수 있다.
        it = values.iterator();

        int total = 0;

        while(it.hasNext()) {
            int i = (int)it.next();
            total += i;
        }

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float)total/set.size());
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));



        System.out.println("\n==============예제 3(단어 카운팅(빈도수 체크))=============");

        String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

        HashMap map2 = new HashMap();

        for(int i=0; i < data.length; i++) {
            if(map2.containsKey(data[i])) { // key 존재여부 체크.
                int value = (int)map2.get(data[i]);
                map2.put(data[i], value+1);  // 기존에 존재하는 키면 기존 값을 1증가
            } else {
                map2.put(data[i], 1);	    // 긱존에 존재하지 않는 키는 값을 1로 저장
            }
        }

        Iterator it2 = map2.entrySet().iterator();

        while(it2.hasNext()) {
            Map.Entry entry = (Map.Entry)it2.next();
            int value = (int)entry.getValue();
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value );
        }

    }

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];

        for(int i=0; i < bar.length; i++)
            bar[i] = ch;

        return new String(bar); // String(char[] chArr)
    }

}
