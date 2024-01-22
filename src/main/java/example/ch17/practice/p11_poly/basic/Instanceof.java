package example.ch17.practice.p11_poly.basic;

public class Instanceof {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);

        /**
         *  - instanceof
         *    오른쪽 대상의 자식 타입을 왼쪽에서 참조하는 경우에도 true를 반환한다.
         *    쉽게 이야기해서 오른쪽에 있는 타입에 왼쪽에 있는 인스턴스의 타입이 들어갈 수 있는지 대입해보면 된다.
         * */
        Parent parent = new Parent();
        System.out.println(parent instanceof Parent); //parent는 Child의 인스턴스

        System.out.println(new Parent() instanceof  Parent);//parent가 Parent의 인스턴스를 참조하는 경우 : ture
        System.out.println(new Child() instanceof  Parent); //parent가 Child의 인스턴스를 참조하는 경우 : true

        //이해를 위한 예시(대입 방법)
        System.out.println(new Parent() instanceof Parent); //Parent p = new Parent() : 같은 타입, true.
        System.out.println(new Child() instanceof  Parent); //Parent p = new Child() : 부모는 자식을 담을 수 있다, true.
        System.out.println(new Parent() instanceof Child);  //Child c = new Parent() : 자식은 부모를 담을 수 없다. false.
        System.out.println(new Child() instanceof  Child);  //Child c = new Child() : 같은 타입 true.
    }

    private static void call(Parent parent) {
        parent.parentMethod();

        if(parent instanceof Child) { //다운캐스팅을 수행하기 전에 먼저 instanceof를 사용해서 원하는 타입으로 변경이 가능한지 확인한 다음에 다운캐스팅을 수행하는 것이 안전하다.
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스 아님");
        }
    }
}
