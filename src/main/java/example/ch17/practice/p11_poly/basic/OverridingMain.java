package example.ch17.practice.p11_poly.basic;

public class OverridingMain {
    public static void main(String[] args) {
        //자식 변수가 자식 인스턴스 참조
        OverridingChild child = new OverridingChild();
        System.out.println("Child -> Child");
        System.out.println("value : " + child.value);
        child.method();

        //부모 변수가 부모 인스턴스 참조
        OverridingParent parent = new OverridingParent();
        System.out.println("Parent -> Parent");
        System.out.println("value : " + parent.value);
        parent.method();

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        OverridingParent poly = new OverridingChild();
        System.out.println("Parent -> Child");
        System.out.println("value : " + poly.value); //변수는 오버라이딩X
        poly.method(); //메서드 오버라이딩! : 인스턴스에서 오버라이딩 된 메서드는 항상 우선권을 가진다.
    }
}

/**
 *  - 오버라이딩 된 메서드는 항상 우선권을 가진다.
 *    오버라이딩은 부모 타입에서 정의한 기능을 자식 타입에서 재정의하는 것이다.
 *    만약 자식에서도 오버라이딩 하고 손자에서도 같은 메서드를 오버라이딩을 하면 손자의 오버라이딩 메서드가 우선권을 가진다.
 *    더 하위 자식의 오버라이딩 된 메서드가 우선권(절대적 우선권)을 가지는 것이다.
 * */