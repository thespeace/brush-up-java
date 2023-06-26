package example.ch09;

public class Class08 {
    public static void main(String[] args){
        /**
         *    - StringBuffer클래스
         *      문자열을 저장하고 다루기 위한 클래스로 String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
         *
         *          public final class StringBuffer implements java.io.Serializable {
         *              private char[] value;
         *                  ...
         *          }
         *
         *      그러나, 내용을 변경할 수 없는 String과 달리 내용을 변경할 수 있다.(mutable : 변경가능)
         */
        StringBuffer sb = new StringBuffer("abc");
        sb.append("123");
        System.out.println("StringBuffer sb : "+sb); // 이처럼 생성된 sb 참조변수의 주소값에 문자열을 추가 할 수 있다.(내용 변경가능)

        /**
         *    - StringBuffer의 생성자
         *      배열은 길이 변경불가. 공간이 부족하면 새로운 배열 생성해야 한다.
         *      때문에 StringBuffer는 저장할 문자열의 길이를 고려하여 적절한 크기로 생성해서 공간이 부족하여 성능이 떨어지는 일이 없도록 해야 한다.
         *
         *          public StringBuffer(int length) {
         *              value = new char[length];
         *              shared = false;
         *          }
         *          public StringBuffer() {
         *              this(16); // 버퍼의 크기를 지정하지 않으면 버퍼의 크기는 16이 된다.
         *          }
         *          public StringBuffer(String str){
         *              this(str.length() + 16); // 지정한 문자열의 길이보다 16이 더 크게 버퍼를 생성한다.
         *              append(str);
         *          }
         *
         *    - StringBuffer의 변경
         *      StringBuffer는 String과 달리 내용 변경이 가능하다.
         *
         *          StringBuffer sb = new StringBuffer("abc");
         *          sb.append("123"); // sb의 내용 뒤에 "123"을 추가한다.
         *
         *      append()는 지정된 내용을 StringBuffer에 추가 후, StringBuffer의 참조를 반환
         */
        StringBuffer sb2 = sb.append("ZZ"); // sb의 내용뒤에 "ZZ"를 추가한다.
        System.out.println(sb);
        System.out.println(sb2);
        // sb.append("123").append("ZZ"); 반환타입이 StringBuffer이기 때문에 이처럼 붙여 사용할 수도 있다.

        /**
         *    - StringBuffer의 비교
         *      StringBuffer는 equals()가 오버라이딩되어있지 않다.(주소비교 : this == obj)
         */
        StringBuffer sb3 = new StringBuffer("abc");
        StringBuffer sb4 = new StringBuffer("abc"); // sb3와 sb4의 내용은 같다.

        System.out.println(sb3 == sb4);      // false, 주소비교이기 때문.
        System.out.println(sb3.equals(sb4)); // false, 주소비교이기 때문.

        // 해결책 : StringBuffer을 String으로 변환 후에 equals()로 비교해야 한다.
        String s = sb3.toString(); // sb3를 String으로 변환
        String s1 = sb4.toString();
        System.out.println(s.equals(s1)); // true


    }
}
