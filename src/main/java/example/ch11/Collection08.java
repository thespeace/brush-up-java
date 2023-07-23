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
         *      1. 배열의 출력 : toString()
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
         *      2. 배열의 복사 : copyOf(), copyOfRange()
         *      {@code
         *          int[] arr  = {0,1,2,3,4};
         *          int[] arr2 = Arrays.copyOf(arr, arr.length); // arr2=[0,1,2,3,4]        : 배열의 길이 만큼.
         *          int[] arr3 = Arrays.copyOf(arr, 3);          // arr3=[0,1,2]            : 설정한 갯수 만큼.
         *          int[] arr4 = Arrays.copyOf(arr, 7);          // arr4=[0,1,2,3,4,0,0]    : 복사 후 나머지 요소는 0으로 채움.
         *          int[] arr5 = Arrays.copyOfRange(arr, 2, 4);  // arr5=[2,3] <- 4는 불포함  : from <= x < to
         *          int[] arr6 = Arrays.copyOfRange(arr, 0, 7);  // arr6=[0,1,2,3,4,0,0]    : 복사 후 나머지 요소는 0으로 채움.
         *      }
         */
    }
}
