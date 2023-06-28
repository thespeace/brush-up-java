package example.ch09;

public class Class09 {
    public static void main(String[] args){
        /**
         *    - StringBuffer의 생성자와 메서드(1/4)
         */

        //StringBuffer() : 16문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.
        StringBuffer sb = new StringBuffer(); // 길이 16.

        //StringBuffer(int length) : 지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.
        StringBuffer sb1 = new StringBuffer(10); // 길이 10.

        //StringBuffer(String str) : 지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성한다.
        StringBuffer sb2 = new StringBuffer("Hi"); // 길이 18(2+16).
        System.out.println(sb2);

        //StringBuffer append( boolean || char || char[] || double || float || int || long || Object || String)
        //매개변수로 입력된 값을 문자열로 변환하여 StringBuffer인스턴스가 저장하고 있는 문자열의 뒤에 덧붙인다.
        StringBuffer sb3 = new StringBuffer("abc");
        StringBuffer sb4 = sb3.append(true);
        sb3.append('d').append(10.0f);

        StringBuffer sb5 = sb3.append("ABC").append(123);
        System.out.println(sb3);
        System.out.println(sb4);
        System.out.println(sb5);


        /**
         *    - StringBuffer의 생성자와 메서드(2/4)
         */

        //int capacity() : StringBuffer인스턴스의 버퍼크기를 알려준다. length()는 버퍼에 담긴 문자열의 길이를 알려준다.
        StringBuffer sb6 = new StringBuffer(100);
        sb6.append("abcd");
        int bufferSize = sb6.capacity();
        int stringSize = sb6.length();
        System.out.println("bufferSize : " + bufferSize);
        System.out.println("stringSize : " + stringSize);

        //char charAt(int index) : 지정된 위치(index)에 있는 문자를 반환한다.
        StringBuffer sb7 = new StringBuffer("abc");
        char c = sb7.charAt(2);
        System.out.println("charAt() : " + c);

        //StringBuffer delete(int start, int end) : 시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거한다. 단, 끝 위치의 문자는 제외.
        StringBuffer sb8 = new StringBuffer("0123456");
        StringBuffer sb9 = sb8.delete(3, 6);
        System.out.println(sb8);
        System.out.println(sb9);

        //StringBuffer deletecharAt(int index) : 지정된 위치(index)의 문자를 제거한다.
        StringBuffer sb10 = new StringBuffer("0123456");
        sb10.deleteCharAt(3);
        System.out.println(sb10);
    }
}
