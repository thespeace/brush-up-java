package example.ch07;

public class Inheritance09 {
    public static void main(String[] args){
        /**
         *    - 접근 제어자(access modifier)
         *      1. private   : 같은 클래스 내에서만 접근이 가능하다.                               ( 접근 가능 : 같은 클래스 )
         *      2. (default) : 같은 패키지 내에서만 접근이 가능하다.                               ( 접근 가능 : 같은 클래스, 같은 패키지)
         *      3. protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.  ( 접근 가능 : 같은 클래스, 같은 패키지, 자손클래스(다른 패키지) )
         *      4. public    : 접근 제한이 전혀 없다.                                            ( 접근 가능 : 같은 클래스, 같은 패키지, 자손클래스(다른 패키지), 전체 )
         *
         *      접근 범위 : public > protected > (default) > private
         */

        System.out.println("실습 예시) Inheritance09_Parent, Inheritance09_Child를 통해 접근 제어자 접근 여부 확인.");

        /**
         *    - 접근 제어자 간단 정리.
         *      1. private   : 파일 내에서만 접근 가능.
         *      2. (default) : 폴더 내에서만 접근 가능.
         *      3. protected : 폴더 + 자식 파일내에서만 접근 가능.
         *      4. public    : 제한 없음.
         */
    }
}
