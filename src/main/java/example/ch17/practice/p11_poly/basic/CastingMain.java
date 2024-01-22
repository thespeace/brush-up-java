package example.ch17.practice.p11_poly.basic;

public class CastingMain {
    public static void main(String[] args) {
        //부모 변수가 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        //단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        //poly.childMethod();

        //다운캐스팅(부모 타입 -> 자식 타입)
        Child child1 = (Child) poly; //캐스팅을 한다고 해서 타입이 변하는 것은 아니다.
        child1.childMethod();

        //일시적 다운캐스팅 : 해당 메서드를 호출하는 순간만 다운캐스팅, 타입 변경이 아니라 해당 참조값을 꺼내고 꺼낸 참조값이 Child타입이 되는 것.
        ((Child) poly).childMethod(); // 연산자 우선순위 신경 쓰기.

        //업캐스팅(자식 타입 -> 부모 타입)
        Child child2 = new Child();
        Parent parent1 = (Parent) child2;
        Parent parent2 = child2; //업캐스팅은 형변환 생략 가능, 자주 쓰기떄문에 생략 권장.

        parent1.parentMethod();
        parent2.parentMethod();
    }
}