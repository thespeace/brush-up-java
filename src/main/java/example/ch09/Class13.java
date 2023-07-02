package example.ch09;

public class Class13 {
    public static void main(String[] args){
        /**
         *    - 래퍼(wrapper) 클래스
         *      기본형 값을 감싸는 클래스.
         *      8개의 기본형(참조형 X)을 객체로 다뤄야 할 때 사용하는 클래스.
         *      객체지향언어에서는 모든것이 객체여야 한다. 하지만 객체가 아닌 기본형으로 인해 90%정도 객체지향 언어라고도 한다.
         *      그렇다면 왜 기본형이라는 예외를 두었냐면, 성능 때문에 그렇다.
         *      기본형은 int i = 10; 라는 사용법으로 직접 접근하여 변수지정이 가능하지만, 참조형으로 만들면 Integer i = new Integer("10"); 참조변수를 통해 값에 접근해야하기 때문에 성능 문제 때문에 기본형이 생긴것이다.
         *
         *
         *      {@code
         *          public final class Integer extends Number implements Comparable {
         *              ...
         *              private int value; // 기본형인 int값을 감싸고 있다.
         *              ...
         *          }
         *      }
         */

        //래퍼 클래스 예제.
        Integer i = new Integer(100);
        Integer i2 = new Integer(100);
        System.out.println("i==i2 ? " + (i == i2));
        System.out.println("i.equals(i2) ? " + i.equals(i2));
        System.out.println("i.compareTo(i2) ? " + i.compareTo(i2));
        System.out.println("i.toString() ? " + i.toString());

    }
}
