package example.ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Collection08 {
    public static void main(String[] args) {
        /**
         *    - Arrays(1/4) : 배열을 편리하게 다루기 위한 메서드(static) 제공. ex) Arrays, Math, Objects, Collections ...
         *
         *      1. 배열의 출력 : toString(배열)
         *      {@code
         *          static String toString(boolean[] a)
         *          static String toString(byte[] a)
         *          static String toString(char[] a)
         *          static String toString(short[] a)
         *          static String toString(int[] a)
         *          static String toString(long[] a)
         *          static String toString(float[] a)
         *          static String toString(double[] a)
         *          static String toString(Object[] a)
         *          // toString()은 오버로딩 되어 있어서 아무 배열타입에 사용해도 가능하다.
         *      }
         *
         *      2. 배열의 복사 : copyOf(배열, 복사할 갯수), copyOfRange(배열, from, to)
         *      {@code
         *          int[] arr  = {0,1,2,3,4};
         *          int[] arr2 = Arrays.copyOf(arr, arr.length); // arr2=[0,1,2,3,4]        : 배열의 길이 만큼.
         *          int[] arr3 = Arrays.copyOf(arr, 3);          // arr3=[0,1,2]            : 설정한 갯수 만큼.
         *          int[] arr4 = Arrays.copyOf(arr, 7);          // arr4=[0,1,2,3,4,0,0]    : 복사 후 나머지 요소는 0으로 채움.
         *          int[] arr5 = Arrays.copyOfRange(arr, 2, 4);  // arr5=[2,3] <- 4는 불포함  : from <= x < to
         *          int[] arr6 = Arrays.copyOfRange(arr, 0, 7);  // arr6=[0,1,2,3,4,0,0]    : 복사 후 나머지 요소는 0으로 채움.
         *      }
         *
         *      3. 배열 채우기 : fill(배열, 모든 요소에 채울 값), setAll(배열, 람다식)
         *      {@code
         *          int[] arr  = new int[5];
         *          Arrays.fill(arr, 9);    // arr=[9,9,9,9,9]  :  할당된 배열 요소를 설정한 값으로 모두 채우기.
         *          Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1); // arr=[1,5,2,1,1]     :  람다식을 이용해서 값을 채우는 것.
         *      }
         *
         *      4. 배열의 정렬과 검색 : sort() : 배열 arr을 정렬, binarySearch(배열, 특정 값) : 특정 값의 위치를 찾을 수 있다. 단, 2진 탐색은 정렬된 배열에만 사용가능.
         *      {@code
         *          int[] arr = { 3, 2, 0, 1, 4};
         *          int idx = Arrays.binarySearch(arr, 2);      // idx=-5 <- 잘못된 결과.
         *
         *          Arrays.sort(arr); // 배열 arr을 정렬한다.
         *          System.out.println(Arrays.toString(arr));   // [0, 1, 2, 3, 4]
         *          int idx = Arrays.binarySearch(arr, 2);      // idx=2 <- 올바른 결과.
         *      }
         *
         *      + 순차 검색과 이진 검색.
         *        1. 순차 검색 : 정렬X, 앞에서부터 순차적으로 하나 하나 찾는다.
         *        2. 이진 검색 : 정렬O, 값을 비교해가며 둘로 나눠가면서 원하는 값을 찾는다.
         *
         */
    }
}
