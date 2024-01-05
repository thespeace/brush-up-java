package example.ch17.practice.p02_ref;

public class VarChange {
    public static void main(String[] args) {

        //기본형과 변수 대입
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //a 변경
        a = 20;
        System.out.println("변경 a = 20");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //b 변경
        b = 30;
        System.out.println("변경 b = 30");
        System.out.println("a = " + a);
        System.out.println("b = " + b);


        //참조형과 변수 대입
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA; // 복사해서 사용, 참조하는 것.

        System.out.println("dataA 참조값=" + dataA);
        System.out.println("dataB 참조값=" + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);

        //dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);

        //dataB 변경
        dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
    }
}

/**
 * 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다.
 *
 *      기본형은 변수에 들어 있는 실제 사용하는 값을 복사해서 대입하고, 참조형은 변수에 들어 있는 참조값을 복사해서 대입한다.
 * */