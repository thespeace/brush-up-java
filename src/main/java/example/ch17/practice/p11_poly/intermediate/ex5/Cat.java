package example.ch17.practice.p11_poly.intermediate.ex5;

public class Cat implements InterfaceAnimal{

    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이 이동");
    }
}
