package example.ch09;

public class Class05 {
    public static void main(String[] args){
        /**
         *    - String 클래스의 생성자와 메서드(3/5)
         */

        //int indexOf(int ch, int pos) : 주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.(index는 0부터 시작)
        String s = "Hello";
        int idx1 = s.indexOf('e',0);
        int idx2 = s.indexOf('e',2);
        System.out.println(idx1);
        System.out.println(idx2);

        //int indexOf(String str) : 주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려준다. 없으면 -1을 반환한다.(index는 0부터 시작)
        int idx3 = s.indexOf("lo");
        int idx4 = s.indexOf("ko");
        System.out.println(idx3);
        System.out.println(idx4);

        //int lastIndexOf(int ch) : 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.
        String s1 = "java.lang.Object";
        int idx5 = s1.lastIndexOf('.');
        int idx6 = s1.indexOf('.');
        System.out.println(idx5);
        System.out.println(idx6);

        //int lastIndexOf(String str) : 지정된 문자열을 인스턴스의 문자열 끝에서 부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.
        String s2 = "java.lang.java";
        int idx7 = s2.lastIndexOf("java");
        int idx8 = s2.indexOf("java");
        System.out.println(idx7);
        System.out.println(idx8);

        //int length() : 문자열의 길이를 알려준다.
        int length = s.length();
        System.out.println(length);

    }
}
