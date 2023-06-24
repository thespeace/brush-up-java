package example.ch09;

public class Class06 {
    public static void main(String[] args){
        /**
         *    - String 클래스의 생성자와 메서드(5/5)
         */

        //String toLowerCase() : String 인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.
        String s = "HELLO";
        String s1 = s.toLowerCase();
        System.out.println(s1);

        //String toUpperCase() : String 인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.
        String s2 = "hello";
        String s3 = s2.toUpperCase();
        System.out.println(s3);

        //String trim() : 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다. 이 때 문자열 중간에 있는 공백은 제거되지 않는다.
        String s4 = "    Hello World    ";
        String s5 = s4.trim();
        System.out.println(s5);

        /**
         *  static String valueOf(boolean b)
         *  static String valueOf(char c)
         *  static String valueOf(int i)
         *  static String valueOf(long l)
         *  static String valueOf(float f)
         *  static String valueOf(double d)
         *  static String valueOf(object o) : 지정된 값을 문자열로 변환하여 반환한다. 참조변수의 경우, toString()을 호출한 결과를 반환한다.
         */
        String b = String.valueOf(true);
        String c = String.valueOf('a');
        String i = String.valueOf(100);
        String l = String.valueOf(100L);
        String f = String.valueOf(10f);
        String d = String.valueOf(10.0);
        java.util.Date dd = new java.util.Date();
        String date = String.valueOf(dd);
        System.out.println(b);
        System.out.println(c);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(date);

    }
}
