package example.ch17.practice.p04_construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    //초기값 설정 기능 제공 메서드 추가
    void initMember(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    /**
     * - this
     *
     *  매개변수의 이름과 맴버 변수의 이름이 같은 경우 this 를 사용해서 둘을 명확하게 구분해야 한다.
     *  this 는 인스턴스 자신을 가리킨다.
     *  매개변수와 멤버 변수의 이름이 다르다면 생략가능하다.(매개변수에 변수 이름이 존재하지 않는다면 멤버변수에서 찾기 때문)
     * */
}

/**
 * - 생성자가 필요한 이유
 *
 *   프로그래밍을 하다보면 객체를 생성하고 이후에 바로 초기값을 할당해야 하는 경우가 많다. 따라서 앞서 initMember(...) 와 같은 메서드를 매번 만들어야 한다.
 *   그래서 대부분의 객체 지향 언어는 객체를 생성하자마자 즉시 필요한 기능을 좀 더 편리하게 수행할 수 있도록 생성자라는 기능을 제공한다.
 *   생성자를 사용하면 객체를 생성하는 시점에 즉시 필요한 기능을 수행할 수 있다.
 *   생성자는 앞서 살펴본 initMember(...) 와 같이 메서드와 유사하지만 몇가지 다른 특징이 있다.
 * */