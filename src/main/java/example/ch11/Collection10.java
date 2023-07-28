package example.ch11;

import java.util.*;

public class Collection10 {
    public static void main(String[] args) {
        /**
         *    - HashSet : 순서 X, 중복 X
         *          <-> List : 순서 O, 중복 O
         *      Set인터페이스를 구현한 대표적인 컬렉션 클래스로, 다른 하나로는 TreeSet이 있다.
         *      순서를 유지하려면, LinkedHashSet클래스를 사용하면 된다.
         *
         *    - TreeSet
         *      범위 검색(from ~ to)과 정렬에 유리한 컬렉션 클래스.
         *      HashSet보다 데이터 추가, 삭제에 시간이 더 걸림.
         */

        /**
         *    - HashSet의 주요 메서드.
         */

        System.out.println("==============HashSet의 주요 메서드(1/2)=============");


        // HashSet() : 생성자.
        HashSet hs = new HashSet();

        // HashSet(Collection c) : 지정된 컬렉션에 모든 객체를 저장하여 생성.
        HashSet hs1 = new HashSet(Arrays.asList("apple", "grape", "banana", "kiwi"));
        System.out.println(hs1);

        // HashSet(int initialCapacity) : 초기용량을 가진 해쉬셋을 생성.
        HashSet hs2 = new HashSet(10);

        // HashSet(int initialCapacity, float loadFactor) : 초기용량 설정, 언제 늘릴것인지 설정하여 생성.
        HashSet hs3 = new HashSet(10, 0.8f); //loadFactor가 0.8이면 용량이 80%가 찼을 때 용량을 늘림.(보통 2배로 늘리는 것이 좋다.)

        // boolean add(Object o) : 추가.
        hs.add(1);
        System.out.println("add(1) : " + hs);

        // boolean addAll(Collection c) : 컬렉션 추가(합집합).
        hs1.addAll(Arrays.asList("orange"));
        System.out.println("addAll(Arrays.asList(\"orange\")) : " + hs1);

        // boolean remove(Object o) : 삭제.
        hs1.remove("orange");
        System.out.println("romove(\"orange\") : " + hs1);

        // boolean removeAll(Collection c) : 컬렉션 삭제(교집합).
        hs1.removeAll(Arrays.asList("grape", "kiwi"));
        System.out.println("removeAll(Arrays.asList(\"grape\", \"kiwi\") : " + hs1);

        // boolean retainAll(Collection c) : 컬렉션에 있는 요소만 남기고 삭제(차집합).
        hs1.retainAll(Arrays.asList("apple"));
        System.out.println("retainAll(Arrays.asList(\"apple\")) : " + hs1);

        // void clear() : 모두 삭제.
        hs1.clear();
        System.out.println("clear() : " + hs1);


        System.out.println("==============HashSet의 주요 메서드(2/2)=============");


        hs.add(2);
        hs.add(3);
        // boolean contains(Object o) : Object 포함 여부을 알려준다. 참이면 true, 거짓이면 false.
        System.out.println("hs : " + hs);
        System.out.println("hs.contains(2) : " + hs.contains(2));
        System.out.println("hs.contains(4) : " + hs.contains(4));

        // boolean containsAll(Collection c) : 컬렉션의 담긴 여러 객체가 모두 포함되고 있는지를 알려준다. true / false.
        System.out.println("hs.containsAll(Arrays.asList(2,3)) : " + hs.containsAll(Arrays.asList(2,3)));
        System.out.println("hs.containsAll(Arrays.asList(3,4)) : " + hs.containsAll(Arrays.asList(3,4)));

        // Iterator iterator() : 컬렉션 요소를 읽어올 수 있다.
        System.out.println("hs.iterator() : " + hs.iterator());

        // boolean isEmpty() : 객체가 비었는지 확인.
        System.out.println("hs.isEmpty() : " + hs.isEmpty());

        // int size() : 저장된 객체의 수를 반환.
        System.out.println("hs.size() : " + hs.size());

        // Object[] toArray() : 저장된 객체를 객체배열로 반환.
        System.out.println("hs.toArray() : " + hs.toArray());


        System.out.println("==============예제 1=============");


        Object[] objArr = {"1",new Integer(1),"2","2","3","3","4","4","4"};
        Set set = new HashSet();

        for(int i=0; i < objArr.length; i++) {
            System.out.println(objArr[i] + " = " + set.add(objArr[i])); // HashSet에 objArr의 요소들을 저장한다.(중복은 제거)
        }
        // HashSet에 저장된 요소들을 출력한다.
        System.out.println(set);

        // HashSet에 저장된 요소들을 출력한다.(Iterator이용)
        Iterator it = set.iterator();

        while(it.hasNext()) { // 읽어올 요소가 있는지 확인.
            System.out.println(it.next()); // 요소 하나씩 꺼내오기.
        }


        System.out.println("==============예제 2=============");


        Set set1 = new HashSet();

        // set1의 크기가 6보다 작은 동안 1~45사이의 난수를 저장.
        for (int i = 0; set1.size() < 6 ; i++) {
            int num = (int)(Math.random()*45) + 1;
//          set1.add(new Integer(num));
            set1.add(num);
        }

//        System.out.println(set1); // set은 정렬 불가
        List list = new LinkedList(set1); // LinkedList(Collection c), set의 모든 요소를 list에 저장.
        Collections.sort(list);          // Collections.sort(List list), 매개변수로 올 수 있는건 list만 가능.
        System.out.println(list);
    }
}
