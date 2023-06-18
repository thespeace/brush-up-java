package example.ch09;

public class Class02 {
    public static void main(String[] args){
        /**
         *    - hashCode()
         *      객체의 해시코드(hash code)를 반환하는 메서드
         *      Object클래스의 hashCode()는 객체의 주소를 int(정수)로 변환해서 반환
         *      equals()를 오버라이딩하면, hashCode()도 오버라이딩해야 한다.
         *      ** equals()의 결과가 true인 두 객체의 해시코드는 같아야 하기 때문 **
         *      System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일
         */
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1 == str2);
        System.out.println(str1.hashCode() == str2.hashCode());

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        /**
         *    - toString(), toString()의 오버라이딩
         *      toString() : 객체를 문자열(String)으로 변환하기 위한 메서드
         */
    }
}

