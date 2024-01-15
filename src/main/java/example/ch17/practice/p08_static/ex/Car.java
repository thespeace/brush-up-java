package example.ch17.practice.p08_static.ex;

public class Car {
    private static int totalCars = 0;
    private String name;

    public Car(String name) {
        System.out.println("차량 구입, 이름 : " + name);
        this.name = name;
        totalCars++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량 수 : " + totalCars);
    }
}
