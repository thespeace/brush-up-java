package example.ch17.practice.p06_access.a;

public class PublicClassInnerMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 class1 = new DefaultClass1(); // default는 같은 패키지 내부에서 접근가능.
        DefaultClass2 class2 = new DefaultClass2();
    }
}
