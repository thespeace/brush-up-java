package example.ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Collection09 {
    public static void main(String[] args) {
        /**
         *    - Comparator와 Comparable
         *      객체 정렬에 필요한 메서드(**정렬기준 제공**)를 정의한 인터페이스
         *          1. Comparable : 기본 정렬기준을 구현하는데 사용.
         *          2. Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용.
         *
         *      {@code
         *          public interface Comparator{
         *              int compare(Object o1, Object o2); // o1, o2 두 객체를 비교, 결과가 0이면 같다/양수면 왼쪽이 크다/음수면 오른쪽이 크다.
         *              boolean equals(Object obj); // equals를 오버라이딩하라는 뜻.
         *          }
         *
         *          public interface Comparable {
         *              int compareTo(Object o); // 주어진 객체(o)를 자신(this)과 비교.
         *          }
         *      }
         *
         *          + 정렬을 해주는 sort()와 같은 점 : 프로세스(1.두 대상을 비교 2.자리 바꿈 3.반복)
         *
         *      compare()와 compareTo()는 두 객체의 비교결과를 반환하도록 작성.
         *
         *      {@code
         *          public final class Integer extends Number implements Comparable {
         *              ...
         *              public int compareTo(Integer anotherInteger) {
         *                  int v1 = this.value;
         *                  int v2 = anotherInteger.value;
         *                  // 같으면 0, 오른쪽 값이 크면 -1, 작으면 1을 반환.
         *                  return (v1 < v2 ? -1 : (v1 == v2 ? 0 : 1));
         *              }
         *          }
         *      }
         */

        // 예제1.
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr); // String 클래스의 Comparable 메서드 구현에 의한 정렬, 1.대문자 > 소문자 2.사전순
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // String.CASE_INSENSITIVE_ORDER : static 상수, 대소문자 구분하지 않도록 정렬 기준.
        /**
         * static void sort(정렬 대상) : 객체 배열에 저장된 객체가 구현한(가지고 있는) Comparable(정렬 기준)에 의한 정렬.
         * static void sort(정렬 대상, 정렬 기준) : 지정한 Comparator(정렬 기준)에 의한 정렬.
         */
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); // 역순 정렬을 만들어서 기준을 둠.
        System.out.println("strArr=" + Arrays.toString(strArr));
    }
}

class Descending implements Comparator { // Comparator 인터페이스 구현.
    public int compare(Object o1, Object o2){ // 메서드 완성.
        if( o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1 ; // String 클래스가 가지고 있는 기본 정렬 기준을 이용해서 -1을 곱해서 기본 정렬방식의 역으로 변경한다.(양수->음수, 음수->양수)
            //return c2.compareTo(c1); // 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
        }
        return -1;
    }
}
