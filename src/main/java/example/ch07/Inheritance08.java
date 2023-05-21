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
         *    - final : 마지막의, 변경될 수 없는
         *      1. 클래스    : 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.
         *                    그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다. -> 상속계층도의 제일 마지막에 위치.
         *      2. 메서드    : 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.
         *      3. 멤버 변수 : 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.
         *      4. 지역 변수 : 변수 앞에 fianl이 붙으면, 값을 변경할 수 없는 상수가 된다.
         *
         *    - abstract : 추상의, 미완성의
         *      1. 클래스 : 클래스 내에 추상 메서드가 선언되어 있음을 의미한다.
         *      2. 메서드 : 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다.
         *      추상 클래스는 미완성이기 때문에 인스턴스 생성불가.
         *          ex) AbstractTest a = new AbstractText(); // Error.
         *      추상 클래스를 상속받아서 완전한 클래스를 만든 후에 객체 생성 가능.
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

//final 사용 예
final class FinalText{ // 부모(조상)이 될 수 없는 클래스
    final int MAX_SIZE = 10; // 값을 변경할 수 없는 멤버변수(상수)

    final int getMaxSize(){ // 오버라이딩(조상 메서드를 덮어쓰는 것) 할 수 없는 메서드(변경불가)
        final int LV = MAX_SIZE; // 값을 변경할 수 없는 지역변수(상수)
        return MAX_SIZE;
    }
}

//abstract 사용 예
abstract class Abstractest{ // 추상 클래스(추상 메서드를 포함한 클래스)
    abstract void move(); // 추상 메서드(구현부가 없는 메서드 : 미완성 메서드(선언부 O, 구현부 X))
}