package example.ch11;

import java.util.*;

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
         */

        int[] copyArr  = new int[5];
        int[] copyArr1 = Arrays.copyOf(copyArr, copyArr.length);
        int[] copyArr2 = Arrays.copyOf(copyArr, 3);
        int[] copyArr3 = Arrays.copyOf(copyArr, 7);
        int[] copyArr4 = Arrays.copyOfRange(copyArr, 2, 4);
        int[] copyArr5 = Arrays.copyOfRange(copyArr, 0, 7);

        System.out.println("copyArr : " + copyArr);
        System.out.println("Arrays.copyOf(copyArr, copyArr.length) : "+Arrays.toString(copyArr1));
        System.out.println("Arrays.copyOf(copyArr, 3) : "+Arrays.toString(copyArr2));
        System.out.println("Arrays.copyOf(copyArr, 7) : "+Arrays.toString(copyArr3));
        System.out.println("Arrays.copyOfRange(copyArr, 2, 4) : "+Arrays.toString(copyArr4));
        System.out.println("Arrays.copyOfRange(copyArr, 0, 7) : "+Arrays.toString(copyArr5));


        /**
         *    - Arrays(2/4)
         *      + 순차 검색과 이진 검색.
         *        1. 순차 검색 : 정렬X, 앞에서부터 순차적으로 하나 하나 찾는다.
         *        2. 이진 검색 : 정렬O, 값을 비교해가며 둘로 나눠가면서 원하는 값을 찾는다.
         */

        // 3. 배열 채우기 : fill(배열, 모든 요소에 채울 값), setAll(배열, 람다식)
        int[] arr  = new int[5];
        Arrays.fill(arr, 9);    // arr=[9,9,9,9,9]  :  할당된 배열 요소를 설정한 값으로 모두 채우기.
        System.out.println("Arrays.fill() : " + Arrays.toString(arr));
        Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1); // arr=[1,5,2,1,1]     :  람다식을 이용해서 값을 채우는 것.
        System.out.println("Arrays.setAll() : " + Arrays.toString(arr));

        for(int i : arr) { // 향상된 for문
//        for(int x = 0; x<arr.length; x++) {
//            int i = arr[x];
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph)+i);
        }


        System.out.println("==============================");

        // 4. 배열의 정렬과 검색 : sort() : 배열 arr을 정렬, binarySearch(배열, 특정 값) : 특정 값의 위치를 찾을 수 있다. 단, 2진 탐색은 정렬된 배열에만 사용가능.
        char[] chArr = { 'A', 'D', 'C', 'B', 'E' };

        System.out.println("chArr="+Arrays.toString(chArr));
        System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B'));
        System.out.println("= After sorting =");
        Arrays.sort(chArr);
        System.out.println("chArr="+Arrays.toString(chArr));
        System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B')); // idx = 1 <- 올바른 결과.

        System.out.println("==============================");


        /**
         *    - Arrays(3/4)
         *      deepToString(2차원 또는 다차원 배열), deepEquals(다차원 배열1, 다차원 배열2)
         */

        // 5. 다차원 배열의 출력 - deepToString()

        int[]   arr2 = {0,1,2,3,4};
        int[][] arr2D = {{11,12,13}, {21,22,23}};

        System.out.println("Arrays.toString() : " + Arrays.toString(arr2)); // [0, 1, 2, 3, 4] : 1차원 배열 출력.
        System.out.println("Arrays.deepToString() : " + Arrays.deepToString(arr2D));  // [[11, 12] , [21, 22]] : 2차원 또는 다차원배열 출력.

        System.out.println("==============================");

        // 6. 다차원 배열의 비교 - deepEquals()
        String[][] str2D  = new String[][]{{"aaa", "bbb"},{"AAA", "BBB"}};
        String[][] str2D2 = new String[][]{{"aaa", "bbb"},{"AAA", "BBB"}};
        System.out.println("Arrays.equals() : " + Arrays.equals(str2D, str2D2));     // false.
        System.out.println("Arrays.deepEquals() : " + Arrays.deepEquals(str2D, str2D2)); // true.

        System.out.println("==============================");


        /**
         *    - Arrays(4/4)
         *      asList(Object... a)
         */

        // 7. 배열을 List로 변환 - asList(Object... a) / Object... : 가변 매개변수.
        List list = Arrays.asList(new Integer[]{1,2,3,4,5}); // list = [1, 2, 3, 4, 5], 배열을 리스트로 반환.
        System.out.println("Arrays.asList() : " + list);
        List list1 = Arrays.asList(1,2,3,4,5); // list1 = [1, 2, 3, 4, 5], 숫자 나열을 리스트로 반환.
        // list1.add(6); // List는 읽기 전용이기 때문에, UnsupportedOperationException 예외 발생.

        System.out.println("==============================");

        // 때문에 아래 코드처럼 리스트를 새로운 ArrayList를 만들어주면 변경 가능하다.
        List list2 = new ArrayList(Arrays.asList(1,2,3,4,5));
        list2.add(6);
        System.out.println("ArrayList(Arrays.asList(1,2,3,4,5)) + add(6) : " + list2);

        System.out.println("to be continue.. parallelXXX(), spliterator(), stream() -> ch14");
    }
}
