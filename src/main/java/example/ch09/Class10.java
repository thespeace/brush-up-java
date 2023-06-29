package example.ch09;

public class Class10 {
    public static void main(String[] args){
        /**
         *    - StringBuffer의 생성자와 메서드(3/4)
         */

        //StringBuffer insert(int pos, boolean b || char c || char[] str || double d || float f || int i || long l || Object obj || String str)
        //두 번째 매개변수로 받은 값을 문자열로 변환하여 지정된 위치(pos)에 추가한다. pos는 0부터 시작.
        StringBuffer sb = new StringBuffer("0123456");
        sb.insert(4,".");
        System.out.println("insert(int pos, boolean b || char c || char[] str || double d || float f || int i || long l || Object obj || String str) : "+sb);

        //int length() : StringBuffer 인스턴스에 저장되어 있는 문자열의 길이를 반환한다.
        int length = sb.length();
        System.out.println("length() : "+length);

        //StringBuffer replace(int start, int end, String str) : 지정된 범위(start ~ end)의 문자들을 주어진 문자열로 바꾼다(치환). end위치의 문자는 범위에 포함 되지 않는다.(start <= x < end)
        sb.replace(3, 6, "AB");
        System.out.println("replace(int start, int end, String str) : "+sb);

        //StringBuffer reverse() : StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.
        sb.reverse();
        System.out.println("reverse() : "+sb);

        System.out.println("=======================================================================");


        /**
         *    - StringBuffer의 생성자와 메서드(4/4)
         */

        //void setCharAt(int index, char ch) : 지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.
        StringBuffer sb1 = new StringBuffer("0123456");
        sb1.setCharAt(5,'o');
        System.out.println("setCharAt(int index, char ch) : "+sb1);

        //void setLength(int newLength) : 지정된 길이로 문자열의 길이를 변경한다. 길이를 늘리는 경우에 나머지 빈 공간을 Null문자 '\u0000'로 채운다.
        StringBuffer sb2 = new StringBuffer("0123456");
        sb2.setLength(5);
        System.out.println(sb2);

        StringBuffer sb3 = new StringBuffer("0123456");
        sb3.setLength(10);
        String str = sb3.toString().trim();
        System.out.println("setLength(5) : " + sb2);
        System.out.println("setLength(10) : " + sb3);
        System.out.println("toString().trim() : "+ str);

        //String toString() : StringBuffer인스턴스의 문자열을 String으로 반환
        StringBuffer sb4 = new StringBuffer("0123456");
        String str1 = sb4.toString();
        System.out.println("toString() : " + str1);

        //String substring(int start) , String substring(int start, int end) : 지정된 범위 내의 문자열을 String으로 뽑아서 반환한다. 시작위치(start)만 지정하면 시작위치부터 문자열 끝까지 뽑아서 반환한다.
        String str2 = sb4.substring(3);
        String str3 = sb4.substring(3, 5);
        System.out.println("substring(int start) : " + str2);
        System.out.println("substring(int start, int end) : " + str3);

    }
}
