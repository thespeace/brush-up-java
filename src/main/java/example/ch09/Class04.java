package example.ch09;

public class Class04 {
    public static void main(String[] args){
        /**
         *    - String 클래스의 생성자와 메서드(1/5)
         *      String 클래스는 정말 자주 쓰이는 중요한 클래스이기 때문에 어떤 메서드들이 존재하는지 볼 필요가 있다.
         */

        //String(String s) : 주어진 문자열(s)를 갖는 String 인스턴스를 생성한다.
        String s1 = new String("Hello");

        //String(char[] value) : 주어진 문자열(value)을 갖는 String인스턴스를 생성한다.(char[] -> String) <-> toCharArray() (String -> char[])
        char[] c = {'H','e','l','l','o'};
        String s2 = new String(c);

        //String(StringBuffer buf) : StringBuffer 인스턴스가 갖고 있는 문자열과 같은 내용의 String 인스턴스를 생성한다.
        StringBuffer sb = new StringBuffer("Hello");
        String s3 = new String(sb);

        //char charAt(int index) : 지정된 위치(index)에 있는 문자를 알려준다.(index는 0부터 시작)
        String s4 = "Hello";
        String n4 = "0123456";
        char c4 = s4.charAt(1);
        char c5 = n4.charAt(1);
        System.out.println(c4);
        System.out.println(c5);

        //int compareTo(String str) :  문자열(str)과 사전순서로 비교한다. 같으면 0을. 사전순으로 이전이면 음수를. 이후면 양수를 반환한다. 보통 정렬할 때 사용한다.
        int i1 = "aaa".compareTo("aaa");
        int i2 = "aaa".compareTo("bbb");
        int i3 = "bbb".compareTo("aaa");
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        /**
         *    - String 클래스의 생성자와 메서드(2/5)
         */

        //String concat(String str) : 문자열(str)을 뒤에 덧붙인다.
        String s5 = "Hello";
        String s6 = s5.concat(" World");
        System.out.println(s6);

        //boolean contains(CharSequence s) : 지정된 문자열(s)이 포함되었는지 검사한다. CharSequence는 인터페이스이다.
        String s7 = "abcdefg";
        boolean b = s7.contains("bc");
        System.out.println(b);

        //boolean endsWith(String suffix) : 지정된 문자열(suffix)로 끝나는지 검사한다.
        String file = "Hello.txt";
        boolean b2 = file.endsWith("txt");
        System.out.println(b2);

        //boolean equals(Object obj) : 매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교한다. obj가 String이 아니거나 문자열이 다르면 false를 반환한다.
        String s8 = "Hello";
        boolean b3 = s8.equals("Hello");
        boolean b4 = s8.equals("Hello");
        System.out.println(b3);
        System.out.println(b4);

        //boolean equalsIgnoreCase(String str) : 문자열과 String인스턴스의 문자열을 대소문자 구분없이 비교한다.
        String s9 = "Hello";
        boolean b5 = s9.equalsIgnoreCase("HELLO");
        boolean b6 = s9.equalsIgnoreCase("HeLLo");
        System.out.println(b5);
        System.out.println(b6);

        //int indexOf(int ch) : 주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.(index는 0부터 시작)
        String s10 = "Hello";
        int idx1 = s10.indexOf('o');
        int idx2 = s10.indexOf('k');
        System.out.println(idx1);
        System.out.println(idx2);
    }
}
