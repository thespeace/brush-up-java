package example.ch09;

import java.util.ArrayList;

public class Class14 {
    public static void main(String[] args){
        /**
         *    - 문자열을 숫자로 변환하기
         *      문자열을 숫자로 변환하는 다양한 방법
         *      {@code
         *         int i = new Integer("100").intValue(); //1. floatValue(), longValue(), ...
         *         int i2 = Integer.parseInt("100"); //2. 주로 많이 사용하는 방법.
         *         Integer i3 = Integer.valueOf("100");
         *      }
         */

        //문자열 -> 기본형
        byte b = Byte.parseByte("100");
        short s = Short.parseShort("100");
        int i = Integer.parseInt("100");
        long l = Long.parseLong("100");
        float f = Float.parseFloat("3.14");
        double d = Double.parseDouble("3.14");

        //문자열 -> 래퍼 클래스
        Byte b1 = Byte.valueOf("100");
        Short s1 = Short.valueOf("100");
        Integer i1 = Integer.valueOf("100");
        Long l1 = Long.valueOf("100");
        Float f1 = Float.valueOf("3.14");
        Double d1 = Double.valueOf("3.14");

        //n진법의 문자열을 숫자로 변환하는 방법.
        //기본적으로 parseInt()는 10진수로 변환 한다.
        int i4 = Integer.parseInt("100", 2); //100(2) -> 4
        int i5 = Integer.parseInt("100", 8); //100(8) -> 64
        int i6 = Integer.parseInt("100", 16); //100(16) -> 256
        int i7 = Integer.parseInt("FF", 16); //FF(16) -> 255
        // int i8 = Integer.parseInt("FF"); // NumberFormatException 발생.
        System.out.println(i4);
        System.out.println(i5);
        System.out.println(i6);
        System.out.println(i7);


        /**
         *    - 오토박싱(Auto boxing) & 언박싱(unboxing)
         *      기본형의 값을 객체로 자동변환하는 것을 오토박싱, 그 반대는 언박싱.
         *      1. 오토박싱 : 기본형 int를 래퍼클래스 Integer로 자동변환 해주는 것을 오토박싱이라 한다.
         *      2. 언박싱  : 오토박싱과 반대로 래퍼클래스 Integer를 기본형 int로 바꿔주는 것을 언박싱이라 한다.
         *
         *      jdk1.5 이전에는 기본형과 참조형간의 연산이 불가능했다.
         *      {@code
         *          int i = 5;
         *          Integer iObj = new Integer(7);
         *          int sum = i + iObj; // Error, 기본형과 참조형 간의 덧셈 불가(JDK1.5 이전)
         *
         *          --> 컴파일 후의 코드
         *          int i = 5;
         *          Integer iObj = new Integer(7);
         *          int sum = i = iObj.intValue(); // 컴파일러에 의해 래퍼클래스를 기본형으로 자동 변환(언박싱).
         *      }
         */
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10); // list에는 객체만 추가가능, 따라서 오토박싱이 필요하다. 10 -> new Integer(10);
        // list.add(new Integer(10)); 컴파일러에 의해 해당 코드로 자동변환되어 정상작동.

        int value = list.get(0); // 언박싱. new Integer(10) -> 10.

        //list.get(0).intValue(); 오토박싱과 마찬가지로 컴파일러에 의해 언박싱.
        System.out.println(value);


        //예제
        int ii = 10;

        //기본형을 참조형으로 형변환(형변환 생략가능)
        Integer intg = (Integer) ii; // Integer intg = Integer.valueOf(ii);
        Object obj = (Object) ii; // Object obj = (Object)Integer.valueOf(ii);

        Long lng = 100L; // 래퍼클래스 타입에 기본형 바로 저장 가능, Long lng = new Long(100L);

        int ii2 = intg + 10; // 참조형과 기본형간의 연산 가능.
        long ll = intg + lng; // 참조형 간의 덧셈도 가능.

        Integer intg2 = new Integer(20);
        int ii3 = (int)intg2; // 참조형을 기본형으로 형변환도 가능(형변환 생략가능).
        System.out.println(ii3);
    }
}
