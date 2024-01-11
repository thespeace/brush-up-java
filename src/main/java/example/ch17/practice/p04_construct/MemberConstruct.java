package example.ch17.practice.p04_construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    //객체를 생성하는 시점에 어떤 작업을 하고 싶다면 생성자(Constructor)를 이용하면 된다.
    //객체를 생성하는 시점에 즉시 필요한 기능을 수행할 수 있다.
    //장점 : 중복 호출 제거.
    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    /**
     * - 생성자 vs 메서드
     *
     *   생성자의 이름은 클래스 이름과 같아야 한다. 따라서 첫 글자도 대문자로 시작한다.
     *   생성자는 반환 타입이 없다. 비워두어야 한다.
     * */
}
