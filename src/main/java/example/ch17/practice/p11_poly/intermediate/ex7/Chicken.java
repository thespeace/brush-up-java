package example.ch17.practice.p11_poly.intermediate.ex7;

public class Chicken extends AbstractAnimal implements Fly{

    @Override
    public void sound() {
        System.out.println("꼬끼오");
    }

    @Override
    public void fly() {
        System.out.println("닭 날기");
    }
}
