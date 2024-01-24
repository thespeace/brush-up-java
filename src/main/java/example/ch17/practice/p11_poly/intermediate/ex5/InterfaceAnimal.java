package example.ch17.practice.p11_poly.intermediate.ex5;

/**
 *  - 인터페이스
 *    자바는 순수 추상 클래스를 더 편리하게 사용할 수 있는 인터페이스라는 기능을 제공한다.
 *    순수 추상 클래스에서 약간의 편의 기능이 추가된다.
 *      1.인터페이스의 메서드는 모두 public, abstract이다.
 *      2.메서드에 public abstract를 생략할 수 있다. 참고로 생략이 권장된다.
 *      3.인터페이스는 다중 구현(다중 상속)을 지원한다.
 *      4.인터페이스에서 멤버 변수는 public, static, final이 모두 포함되었다고 간주한다. 즉 상수만 생성할 수 있다.
 * */
public interface InterfaceAnimal {
    void sound();
    void move();
}

/**
 *  - 상속 vs 구현
 *    상속은 이름 그대로 부모의 기능을 물려 받는 것이 목적이다.
 *    하지만 인터페이스는 모든 메서드가 추상 메서드이다.
 *    따라서 물려받을 수 있는 기능이 없고, 오히려 인터페이스에 정의한 모든 메서드를 자식이 오버라이딩 해서 기능을 구현해야 한다.
 *    인터페이스는 메서드 이름만 있는 설계도이고, 이 설계도가 실제 어떻게 작동하는지는 하위 클래스에서 모두 구현해야 한다.
 *    따라서 인터페이스의 경우 상속이 아니라 해당 인터페이스를 구현한다고 표현한다.
 *    상속과 구현은 사람이 표현하는 단어만 다를 뿐이지 자바 입장에서는 똑같다. 일반 상속 구조와 동일하게 작동한다.
 *
 *
 *  - 인터페이스를 사용해야 하는 이유
 *    1. 제약 : 좋은 프로그램은 제약이 있는 프로그램이다.
 *    2. 다중 구현 : 클래스 상속은 부모를 하나만 지정할 수 있다. 반면에 인터페이스는 부모를 여러명 두는 다중 구현(다중 상속)이 가능하다.
 *
 *
 *  - 참고 : 자바 8에 등장한 default 메서드를 사용하면 인터페이스도 메서드를 구현할 수 있다.
 *          자바 9에 등장한 인터페이스의 private 메서드도 마찬가지이다.
 *          하지만 이것은 예외적으로 아주 특별한 경우에만 사용해야 한다.
 * */
