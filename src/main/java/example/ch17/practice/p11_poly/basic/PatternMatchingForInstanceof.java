package example.ch17.practice.p11_poly.basic;

public class PatternMatchingForInstanceof {
    public static void main(String[] args) {
        //자바 16부터는 instanceof를 사용하면서 동시에 변수를 선언할 수 있다.
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call(Parent parent) {
        parent.parentMethod();

        if(parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음, 직접 다운캐스팅 하는 코드를 생략할 수 있다.");
            child.childMethod();
        }
    }
}
