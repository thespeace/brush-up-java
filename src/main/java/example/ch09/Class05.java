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

        /**
         *    - String 클래스의 생성자와 메서드(4/5)
         */

        //String[] split(String regex) : 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다.
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        System.out.println(arr[0]+","+arr[1]+","+arr[2]);

        //String[] split(String regex, int limit) : 문자열을 지정된 분리자(regex)로 나누어 문자열배열에 담아 반환한다. 단, 문자열 전체를 지정된 수(limit)로 자른다.
        String[] arr1 = animals.split(",",2);
        System.out.println(arr1.length); //bear가 빠짐.

        //boolean startsWith(String prefix) : 주어진 문자열(prefix)로 시작하는지 검사한다.
        String s4 = "java.lang.Object";
        boolean b1 = s4.startsWith("java");
        boolean b2 = s4.startsWith("lang");
        System.out.println(b1);
        System.out.println(b2);

        //String substring(int begin)
        //String substring(int begin, int end) : 주어진 시작위치(begin)부터 끝 위치(end) 범위에 포함된 문자열을 얻는다.
        //                                       이 때, 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다.(begin <= x < end)
        String s5 = "java.lang.Object";
        String c = s5.substring(10);
        String p = s5.substring(5,9);
        System.out.println(c);
        System.out.println(p);

    }
}
