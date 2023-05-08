package example.ch06;

public class OOP08 {
    public static void main(String[] args){
        /**
         *    - 클래스 변수와 인스턴스 변수
         *      객체의 속성 중에는 개별적인 속성이 있고 공통적인 속성이 있습니다.
         *          1. 개별 속성 : 인스턴스 변수
         *          2. 공통 속성 : 클래스 변수(모든 인스턴스가 공통적으로 갖는 속성) + static
         *              ex) 포커 카드의 공통 속성은 "높이", "넓이", 개별 속성은 "무늬", "색깔".  <- 아래의 예시(Card.class) 참고.
         *
         *
         */

        // 클래스 사용
        Card c = new Card(); // 객체 생성.

    }
}
class Card {
    String kind; //무늬, 인스턴스 변수(개별 속성)
    int number;  //숫자, 인스턴스 변수(개별 속성)

    static int width = 100;  //폭, 클래스 변수(공통 속성)
    static int height = 250; //높이, 클래스 변수(공통 속성)
}
