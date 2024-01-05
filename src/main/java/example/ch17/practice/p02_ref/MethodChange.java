package example.ch17.practice.p02_ref;

public class MethodChange {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전: a = " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: a = " + a);

        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }
    static void changePrimitive(int x) {
        x = 20;
    }
    static void changeReference(Data dataX) { // int dataX = dataA
        dataX.value = 20;
    }
}
