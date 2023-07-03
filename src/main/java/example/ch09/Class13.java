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

        //기본형 boolean
        Boolean b = new Boolean(true); // Boolean(boolean value)
        Boolean b2 = new Boolean("true"); // Boolean(String s)

        //기본형 char
        Character c = new Character('a'); // Charactor(char value)

        //기본형 byte
        //Byte b3 = new Byte(10); // Byte(byte value)
        Byte b4 = new Byte("10"); // Byte(String s)

        //기본형 short
        //Short s = new Short(10); // Short(short value)
        Short s2 = new Short("10"); // Short(String s)

        //기본형 int
        Integer i = new Integer(100); // Integer(int value)
        Integer i2 = new Integer("100"); // Integer(String s)

        //기본형 long
        Long l = new Long(100); // Long(long value)
        Long l2 = new Long("100"); // Long(STring s)

        //기본형 float
        Float f = new Float(1.0); // Float(double value)
        Float f2 = new Float(1.0f); // Float(folat value)
        Float f3 = new Float("1.0f"); // Float(String s)

        //기본형 double
        Double d = new Double(1.0); // Double(double value)
        Double d2 = new Double("1.0"); // Double(String s)


        //래퍼 클래스 예제.
        Integer i3 = new Integer(100);
        Integer i4 = new Integer(100);
        System.out.println("i==i2 ? " + (i3 == i4)); // 주소 비교.
        System.out.println("i.equals(i2) ? " + i3.equals(i4)); // 값 비교.
        System.out.println("i.compareTo(i2) ? " + i3.compareTo(i4)); //같으면 0, 작으면 양수, 크면 음수 반환.
        System.out.println("i.toString() ? " + i3.toString()); // 문자열 반환.

        System.out.println("MAX_VALUE="+Integer.MAX_VALUE); // 최댓값.
        System.out.println("MIN_VALUE="+Integer.MIN_VALUE); // 최소값.
        System.out.println("SIZE="+Integer.SIZE+" bits"); // bits 반환.
        System.out.println("BYTES="+Integer.BYTES+" bytes"); // byte 반환.
        System.out.println("TYPE="+Integer.TYPE); // 타입 반환.

        /**
         *    - Number클래스
         *      모든 숫자 래퍼 클래스의 조상.
         *          자식 래퍼 클래스 -> Byte, Short, Integer, Long, Float, Double, BigInteger(아주 큰 정수), BigDecimal(아주 큰 실수)
         *      추상 클래스로, 래퍼 클래스와 반대로 래퍼 객체의 값을 기본형으로 바꿀때쓰는 메서드들을 가지고 있다. ex) intValue(), longValue() ...
         */
    }
}
