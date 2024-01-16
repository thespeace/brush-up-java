package example.ch17.practice.p09_final;

public class FinalLocalMain {
    public static void main(String[] args) {
        //final 지역 변수 : final 키워드가 붙으면 더는 값을 변경할 수 없다.
        final int data1;
        data1 = 10; //최초 한번만 할당 가능
//        data1 = 20; //컴파일 오류 발생.

        final int data2 = 10;
//        data2 = 20;

        method(10);
    }

    static void method(final int parameter) {
//        parameter = 20; //매개변수의 값 변경 불가, 컴파일 오류 발생.
    }
}
