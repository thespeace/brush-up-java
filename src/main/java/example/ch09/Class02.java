package example.ch09;

import java.util.Objects;

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
        System.out.println(str1.equals(str2)); // true.
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        System.out.println(str1 == str2); // false.
        System.out.println(str1.hashCode() == str2.hashCode()); // true.

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        /**
         *    - toString(), toString()의 오버라이딩
         *      toString() : 객체를 문자열(String)으로 변환하기 위한 메서드, 즉 인스턴스 변수들을 문자열로 변환하기 위한 메서드.
         *          public String toString() { // Object클래스의 toString()
         *              return getclass().getName()+"@"+Integer.toHexString(hashCode());
         *                   // 설계도객체.클래스이름 +@(at, 위치를 의미)+정수형.16진수로 변환하여 출력(객체 주소 값);
         *          }
         */

        //toString 오버라이딩 예시
        Card c1 = new Card();
        Card c2 = new Card();
        System.out.println(c1.toString()); // 오버라이딩으로 메서드 변경 : 클래스이름@주소값 -> 변수값 호출.
        System.out.println(c2.toString());

        // + equals() 오버라이딩 예시
        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode()); // 규칙! : equals 결과가 같게 오버라이딩 했다면, hashCode()도 같게 오버라이딩 해주어야 한다.
        System.out.println(c2.hashCode());
    }
}
class Card{
    String kind;
    int number;

    Card(){
        this("SPADE", 1);
    }
    Card(String kind,int number){
        this.kind = kind;
        this.number = number;
    }
    public String toString(){
        return "kind : " + kind + ", number : " + number;
    }
    public int hashCode() { // equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다.
        return Objects.hash(kind, number); // int hash(Object... values) {...} : 매개변수가 가변인자(Object...)라서 호출시 지정하는 값의 개수가 정해져있지 않다.
    }
    public boolean equals(Object obj){
        if(!(obj instanceof Card)) // 타입 체크.
            return false;

        Card c = (Card)obj; // 형변환.
        return this.kind.equals(c.kind) && this.number == c.number;
    }
}

