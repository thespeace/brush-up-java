package example.ch07;

public class Inheritance14 {
    public static void main(String[] args){
        /**
         *    - 매개변수의 다형성(다형적 매개변수)
         *      참조형 매개변수는 메서드 호출시, "자신과 같은 타입 또는 자손타입"의 인스턴스를 넘겨줄 수 있다.
         *          ex) 1. Tv t = new SmartTv(); : 조상타입의 참조변수로 자손객체 다루기.
         *              2. 참조변수의 형변환 : 사용할 수 있는 멤버 갯수 조절.
         *              3. instanceof : 형변환 가능 여부 확인.
         *
         */

        Buyer b = new Buyer();

//        Desk desk = new Desk();
//        b.buy(desk);
        b.buy(new Desk()); //위의 두 줄을 줄인 코드.

//        Computer computer = new Computer();
//        b.buy(computer);
        b.buy(new Computer());

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
    }
}

class Product {
    int price;      // 제품 가격
    int bonusPoint; // 제품 구매시 제공하는 보너스 점수

    Product(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0); // 보너스 점수는 제품가격의 10%
    }
}
class Desk extends Product {
    Desk(){ // 조상클래스의 생성자 Product(int Price)를 호출한다.
        super(100); // 책상의 가격을 100만원으로 한다.
    }
    //Object클래스의 toString()을 오버라이딩한다.
    public String toString(){ return "Desk"; }
}
class Computer extends Product {
    Computer(){ super(200);}
    public String toString(){ return "Computer"; }
}

class Buyer { // 물건 사는 사람
    int money = 1000;   // 소유 금액
    int bonusPoint = 0; // 보너스 점수
    /*void buy(Desk d){
        money -= d.price;
        bonusPoint += d.bonusPoint;
    }
    void buy(Computer c){               //각 객체들을 해당 메서드에 매개변수로 사용하려면 필수적으로 오버로딩이 발생, 더불어 객체가 추가된다면 그만큼 오버로딩 메서드를 추가해줘야한다.
        money -= c.price;                 때문에 각 객체들의 조상타입을 매개변수로한 메서드를 추가해줌으로써, 해당 메서드 하나로 여러 자손 객체들을 불러와 사용할 수 있다.(다형성)
        bonusPoint += c.bonusPoint;       메서드를 하나만 작성해도 해당 매개변수의 자손객체들을 사용할 수 있기때문에, 유지보수도 수월해지고 코드도 줄어들게 된다.
    }                                     이와 같은 예시를 "다형적 매개변수"의 장점으로 볼 수 있다.
    void buy(Audio a){
        money -= a.price;
        bonusPoint += a.bonusPoint;
    }*/
    void buy(Product p){ // 매개변수의 자손타입들을 다 사용할 수 있다.
        if(money < p.price){
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을/를 구입하였습니다.");
        //System.out.println(p.toString() + "을/를 구입하였습니다.");
    }
}