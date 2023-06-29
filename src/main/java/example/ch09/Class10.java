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
    }
}
