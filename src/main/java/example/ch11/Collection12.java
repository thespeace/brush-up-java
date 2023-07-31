package example.ch11;

import java.util.*;

public class Collection12 {
    public static void main(String[] args) {
        /**
         *    - TreeSet : 범위 탐색, 정렬.
         *      TreeSet은 이진 탐색 트리(binary search tree)로 구현. 범위 탐색(from~to)과 정렬에 유리.
         *      이진 트리는 모든 노드가 최대 2개(0~2)의 하위 노드를 갖는다.
         *      각 요소(node)가 나무(tree)형태로 연결(LinkedList의 변형)
         *
         *      이진 트리(binary tree)의 구조.
         *
         *          루트(root) - 1. 부모(A) - 1. A의 자식(B)
         *                                   2. A의 자식(C)
         *                      2. 부모(D) - 1. D의 자식(E)
         *      {@code
         *          class TreeNode {
         *              TreeNode left;    // 왼쪽 자식노드
         *              Object   element; // 저장할 객체
         *              TreeNode right;   // 오른쪽 자식노드
         *          }
         *      }
         *
         *    - 이진 탐색 트리(binary search tree) : 한 노드에 최대 2개의 하위 노드를 연결할 수 있는 것, 이진 트리의 많은 종류들 중 하나.
         *      부모보다 작은 값은 왼쪽, 큰 값은 오른쪽에 저장.
         *      단점 : 데이터가 많아질 수록 추가,삭제에 시간이 더 걸림(비교 횟수 증가)
         *
         *    - TreeSet의 데이터 저장 과정 : boolean add(Object o)
         *
         *      예시) TreeSet에 7, 4, 9, 1, 5의 순서로 데이터를 저장하면, 아래의 과정을 거친다.
         *           (루트부터 트리를 따라 내려가며 값을 비교, 작으면 왼쪽, 크면 오른쪽에 저장)
         *           1. 7 저장.
         *           2. 4 저장, 저장되어 있는 7과 비교. (비교 횟수 1)
         *           3. 7보다 작은 숫자 4를 왼쪽에 저장.
         *           4. 9 저장, 7과 비교. (비교 횟수 1)
         *           5. 7보다 큰 수인 9를 오른쪽에 저장.
         *           6. 1 저장, root부터 비교, 7보다 작으니 왼쪽으로, 이미 저장되어 있는 4와 비교.  (비교 횟수 2)
         *           7. 4보다 작으니까 4의 왼쪽에 저장.
         *           8. 5 저장, 위와 마찬가지로 root 7과 비교 후, 이미 저장되어 있는 4와 비교.  (비교 횟수 2)
         *           9. 4보다 크니 4의 오른쪽에 저장.
         *              * 요소(node)를 저장해가면서 비교횟수는 점점 늘어나서 저장에 더 시간이 많이 걸린다. == 이진트리의 단점.
         */

        /**
         *    - TreeSet의 주요 생성자와 메서드.(Collection 인터페이스의 주요 메서드 제외)
         */

        // TreeSet() : 기본 생성자.
        TreeSet ts = new TreeSet();

        // TreeSet() : 주어진 컬렉션을 저장하는 TreeSet을 생성
        TreeSet ts1 = new TreeSet(Arrays.asList(60, 30, 45, 35));
        System.out.println("ts1 : " + ts1);

        // TreeSet(Comparator comp) : 주어진 정렬기준(비교 기준)으로 정렬하는 TreeSet을 생성. <-> 비교기준이 없을 경우, 기본 비교기준 적용.
        TreeSet ts2 = new TreeSet(new TestComparator());

        // Object first() : 정렬(오름차순)된 순서에서 첫 번째 객체를 반환한다.
        ts1.first();
        System.out.println("ts1.first() : " + ts1.first());

        // Object last() : 정렬(오름차순)된 순서에서 마지막 객체를 반환한다.
        ts1.last();
        System.out.println("ts1.last() : " + ts1.last());

        // Object ceiling(Object o) : 지정된 객체와 같은 객체를 반환, 없으면 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 Null.
        ts1.ceiling(42);
        System.out.println("ts1.ceiling(42) : " + ts1.ceiling(42));

        // Object floor(Object o) : 지정된 객체와 같은 객체를 반환. 없으면 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 Null.
        ts1.floor(42);
        System.out.println("ts1.floor(42) : " + ts1.floor(42));

        // Object higher(Object o) : 지정된 객체보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 Null.
        ts1.higher(45);
        System.out.println("ts1.higher(45) : " + ts1.higher(45));

        // Object lower(Object o) : 지정된 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 Null.
        ts1.lower(45);
        System.out.println("ts1.lower(45) : " + ts1.lower(45));

        // SortedSet subSet(Object fromElement, Object toElement) : 범위 검색(fromElement와 toElement사이)의 결과를 반환한다.(끝 범위인 toElement는 범위에 포함되지 않음)
        ts1.subSet(20,50);
        System.out.println("ts1.subSet(20,50) : " + ts1.subSet(20,50));

        // SortedSet headSet(Object toElement) : 지정된 객체보다 작은 값의 객체들을 반환한다.
        ts1.headSet(45);
        System.out.println("ts1.headSet(45) : " + ts1.headSet(45));

        // SortedSet tailSet(Object fromElement) : 지정된 객체보다 큰 값의 객체들을 반환한다.
        ts1.tailSet(35);
        System.out.println("ts1.tailSet(35) : " + ts1.tailSet(35));


        System.out.println("\n==============예제 1(1~45사이의 정수를 난수로 골라서 set에 저장해서 출력)=============");

        Set set = new TreeSet(); // 범위 검색, 정렬에 유리. 따로 정렬 필요없음.

        for(int i = 0; set.size() < 6; i++){
            int num = (int)(Math.random()*45) + 1;
            set.add(num); // set.add(new Integer(num));
        }

        System.out.println(set);

        System.out.println("==============예제 2(정렬 비교 기준이 필수인 TreeSet의 정렬 기준 두 가지(Comparable VS Comparator))=============");

        Set setTest = new TreeSet();
        setTest.add(new Test()); // 1. 저장하는 객체가 비교 기준을 가지고 있다.
        System.out.println(setTest);

        Set setTestComp = new TreeSet(new TestComparator()); // 2. TreeSet이 정렬기준을 갖게 한다.
        setTestComp.add(new Test());
        setTestComp.add(new Test());
        setTestComp.add(new Test());
        setTestComp.add(new Test());
        System.out.println(setTestComp);

    }
}
class Test implements Comparable { // Comparable을 갖고있는 객체.(주어진 객체(o)를 자신(this)과 비교)
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}

class TestComparator implements Comparator { //

    @Override
    public int compare(Object o, Object t1) {
        return 1;
    }
}
