package example.ch17.practice.p09_final;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data; // final 참조형 변수 선언.
        data = new Data();
//        data = new Data(); // 단 한번만 초기화 가능, 변경도 불가능.

        //하지만 참조 대상의 객체 값은 변경 가능.
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);

    }
}
