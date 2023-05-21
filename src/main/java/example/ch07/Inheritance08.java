package example.ch07;

public class Inheritance08 {
    public static void main(String[] args){
        /**
         *    - 제어자(modifier) == 형용사(명사 앞에 붙어서 명사를 꾸며줌)
         *      클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여.
         *
         *          1. 접근제어자 : public, protected, (default), private -> 단 하나만 명시 가능.
         *          2. 그     외 : static, final, abstract, native, transient, synchronized, volatile, strictfp
         *      
         *      하나의 대상에 여러 제어자를 같이 사용가능(접근 제어자는 하나만)
         *          ex) public static final int WIDTH = 200;
         *
         *    - static : 클래스의, 공통적인
         *      1. 멤버변수 : 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.
         *                   클래스 변수는 인스턴스를 생성하지 않고도 사용 가능하다.
         *                   클래스가 메모리에 로드될 때 생성된다.
         *      2. 메서드  : 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.
         *                  static 메서드 내에서는 객체가 필요한 인스턴스 멤버들을 직접 사용할 수 없다.
         *
         */

    }
}

//static 사용 예
class StaticTest {
    static int width = 200;  // 클래스변수(static 변수), 간단 초기화(명시적 초기화).
    static int height = 120; // 클래스변수(static 변수).

    static { // 클래스 초기화 블럭
        // static 변수의 복잡한 초기화 수행
    }

    static int max(int a, int b) { // 클래스 메서드(static메서드)
        return a > b ? a : b; // 인스턴스 변수/메서드 사용 불가.
    }
}