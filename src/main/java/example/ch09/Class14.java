package example.ch09;

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

    }
}
