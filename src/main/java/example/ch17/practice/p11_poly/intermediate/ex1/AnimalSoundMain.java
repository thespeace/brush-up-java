package example.ch17.practice.p11_poly.intermediate.ex1;

// 타입의 한계를 다형성을 활용해서 최적화 해보자.
public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog(); //Animal dog = new Dog(); 가능
        Cat cat = new Cat(); //Animal cat = new Cat(); 가능
        Caw caw = new Caw(); //Animal caw = new Caw(); 가능

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
    }

    private static void soundAnimal(Animal animal) { //다형적 참조 : 부모는 자식을 담을 수 있다.
        System.out.println("동물 소리 테스트 시작");
        animal.sound(); //오버라이딩된 메서드가 절대적 우선권을 가진다.
        System.out.println("동물 소리 테스트 종료");
    }

}
