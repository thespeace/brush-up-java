package example.ch17.practice.p11_poly.intermediate.ex2;

import example.ch17.practice.p11_poly.intermediate.ex1.Animal;
import example.ch17.practice.p11_poly.intermediate.ex1.Cat;
import example.ch17.practice.p11_poly.intermediate.ex1.Caw;
import example.ch17.practice.p11_poly.intermediate.ex1.Dog;

//배열과 for문을 사용해서 example1 예시의 중복을 제거해보자.
public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        Animal[] animalArr = {dog, cat, caw, new Duck()}; //추가 가능, 배열을 같은 타입의 데이터만 나열할 수 있지만 모두 Animal의 자식이므로 가능하다.

        for (Animal animal : animalArr) {
            soundAnimal(animal); //구체적인 클래스를 참조하는 것이 아니라 Animal이라는 추상적인 부모를 참조하기 때문에 코드 변경 없이 유지 새로운 동물을 추가할 수 있다.
        }
    }

    //변하지 않는 부분
    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}

/**
 *  새로운 기능이 추가되었을 때 변하는 부분을 최소화 하는 것이 잘 작성된 코드이다.
 *  이렇게 하기 위해서는 코드에서 변하는 부분과 변하지 않는 부분을 명확하게 구분하는 것이 좋다.
 *
 *  + 새로운 기능이 추가되었을 때 변하는 부분을 최소화하는 것이 잘 작성된 코드이다.
 *    샷건 효과를 줄이자. 초탄의 범위를 최소화 하자.
 *
 *
 *
 *  - 남은 문제
 *
 *    1.Animal 클래스를 생성할 수 있는 문제
 *      개, 고양이, 소가 실제 존재하는 것은 당연하지만, 동물이라는 추상적인 개념이 실제로 존재하는 것은 이상하다.
 *      사실 이 클래스는 다형성을 위해서 필요한 것이지 직접 인스턴스를 생성해서 사용할 일은 없다.
 *      하지만 Animal도 클래스이기 때문에 인스턴스를 생성하고 사용하는데 아무런 제약이 없다.
 *      누군가 실수로 `new Animal()`을 사용해서 `Animal`의 인스턴스를 생성할 수 있다는 것이다.
 *      이렇게 생성된 인스턴스는 작동은 하지만 제대로된 기능을 수행하지는 않는다.
 *
 *    2.Animal 클래스를 상속 받는 곳에서 sound() 메서드 오버라이딩을 하지 않을 가능성
 *      예를 들어서 `Animal`을 상속 받은 `Pig`클래스를 만든다고 가정해보자.
 *      우리가 기대하는 것은 `Pig`클래스가 `sound()`메서드를 오버라이딩 해서 "꿀꿀"이라는 소리가 나도록 하는 것이다.
 *      그런데 개발자가 실수로 `sound()`메서드를 오버라이딩 하는 것을 빠트릴 수 있다.
 *      이렇게 되면 부모의 기능을 상속받는다. 따라서 코드상 아무런 문제가 발생하지 않는다.
 *      물론 프로그램을 실행하면 기대와 다르게 "꿀꿀"이 아니라 부모 클래스에 있는 `Animal.sound()`가 호출될 것이다.
 *
 *    좋은 프로그램은 제약이 있는 프로그램이다. `추상 클래스`와 `추상 메서드`를 사용하면 이런 문제를 한번에 해결할 수 있다.
 * */