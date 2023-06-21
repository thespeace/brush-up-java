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
    }
}
