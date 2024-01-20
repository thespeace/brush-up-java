package example.ch17.practice.p10_extends.super2;

public class Super2Main {
    public static void main(String[] args) {
        ClassC classC = new ClassC(); //초기화는 최상위 부모부터 이루어진다. 왜냐하면 자식 생성자의 첫줄에서 부모의 생성자를 호출해야 하기 때문이다.
                                      //결과적으로 상속 관계의 생성자 호출은 부모에서 자식 순서로 실행된다. 부모의 데이터를 먼저 초기화하고 그 다음에 자식의 데이터를 초기화하는 것.

        ClassB classB = new ClassB(100);
    }
}