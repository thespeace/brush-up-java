package example.ch06;

public class OOP08 {
    public static void main(String[] args){
        /**
         *    - 클래스 변수와 인스턴스 변수
         *      객체의 속성 중에는 개별적인 속성이 있고 공통적인 속성이 있습니다.
         *          1. 개별 속성 : 인스턴스 변수
         *          2. 공통 속성 : 클래스 변수(모든 인스턴스가 공통적으로 갖는 속성) + static
         *                        ex) 포커 카드의 공통 속성은 "높이", "넓이", 개별 속성은 "무늬", "색깔".  <- 아래의 예시(Card.class) 참고.
         *                       클래스 변수는 오직 한개로만 존재한다. 객체를 몇개를 생성해도 단 하나이다. 그 이유는 값을 하나만 저장해서 유지하고, 메모리도 절약할 수 있는 이점이 있기 때문이다.
         */

        System.out.println("Card.width = " + Card.width); // 클래스 변수는 객체 생성없이 사용 가능(자동으로 만들어짐)
        System.out.println("Card.height = " + Card.height);

        // 클래스 사용
        Card c1 = new Card(); // 객체 생성.
        c1.kind = "HEART";
        c1.number = 5; //인스턴스 객체 사용.

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 ("+ c1.width + ", " + c1.height + ")");
        System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 ("+ c2.width + ", " + c2.height + ")");
        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
        c1.width = 50;
        c1.height = 80; // 인스턴스 객체의 사용법과 똑같이 써도 작동하지만 권장하지 않는다.

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 ("+ c1.width + ", " + c1.height + ")");
        System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 ("+ c2.width + ", " + c2.height + ")"); //c2의 크기를 바꾸지 않았지만, 공유하는 클래스 변수의 값이 바뀐 걸 확인 할 수 있다.

        Card.width = 200;
        Card.height = 300; // 참조변수보다 클래스 이름을 사용해주는 것이 더 좋은 코드이다.

        System.out.println("최종 크기는 ("+ c2.width + ", " + c2.height + ")");

    }
}
class Card {
    String kind; //무늬, 인스턴스 변수(개별 속성)
    int number;  //숫자, 인스턴스 변수(개별 속성)

    static int width = 100;  //폭, 클래스 변수(공통 속성)
    static int height = 250; //높이, 클래스 변수(공통 속성)
}
