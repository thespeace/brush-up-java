package example.ch17.practice.p11_poly.basic;

public class PolyMain {
    public static void main(String[] args) {

        //부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        //자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        //부모 변수가 자식 인스턴스 참조(다형적 참조) : 부모 타입은 자신은 물론이고, 자신을 기준으로 모든 자식 타입을 참조할 수 있다.(손자도 가능)
        System.out.println("Parent -> Child");
        Parent poly = new Child(); //부모 타입은 자식을 참조 가능, 자식을 부모에 대입.
        poly.parentMethod();
//        poly.childMethod(); // 자식 메서드는 호출 불가(다형적 참조의 한계) : 힙 영역에 생성된 인스턴스를 확인하고, 부모 클래스타입부터 시작해서 기능을 찾는데, 자식 방향으로는 찾아 내려갈 수가 없다.

        //자식 변수가 부모 인스턴스 참조 불가능.
//        Child poly1 = new Parent(); // 컴파일 오류.

    }
}
