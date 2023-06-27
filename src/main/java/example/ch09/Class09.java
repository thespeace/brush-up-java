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

    }
}
