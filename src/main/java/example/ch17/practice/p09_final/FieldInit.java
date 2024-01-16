package example.ch17.practice.p09_final;

public class FieldInit {

    static final int CONST_VALUE = 10; //상수(static final) 사용 시 대문자로 적는 관례.
    final int value = 10;

    //최초 초기화가 끝났으면 생성자를 통해서도 초기화 불가능.
//    public FieldInit(int value) {
//        this.value = value;
//    }
}
