package example.ch17.practice.p05_package;

import example.ch17.practice.p05_package.b.User;

public class PackageMain {
    public static void main(String[] args) {

        //사용자와 같은 위치는 경로 생략.
        Data data = new Data();

        //패키지가 다르면 패키지 전체 경로 포함 클래스 작성.
        example.ch17.practice.p05_package.a.User user = new example.ch17.practice.p05_package.a.User();

        //같은 이름의 클래스가 있다면 둘 중 하나만 import해서 사용할 수 있다.
        User user2 = new User();
    }
}

/**
 * - 패키지 규칙
 *
 *   1.패키지의 이름과 위치는 폴더(디렉토리) 위치와 같아야 한다.(필수)
 *   2.패키지 이름은 모두 소문자를 사용한다.(관례)
 *   3.패키지 이름의 앞 부분에는 일반적으로 회사의 도메인 이름을 거꾸로 사용한다. 예를 들어, com.company.myapp과 같이 사용한다(관례)
 *      3_1. 이 부분은 필수는 아니다. 하지만 수 많은 외부 라이브러리가 함께 사용되면 같은 패키지에 같은 클래스 이름이 존재할 수도 있다.
 *           이렇게 도메인 이름을 거꾸로 사용하면 이런 문제를 방지할 수 있다.
 *      3_2. 내가 오픈소스나 라이브러리를 만들어서 외부에 제공한다면 꼭 지키는 것이 좋다.
 *      3_3. 내가 만든 어플리케이션을 다른 곳에 공유하지 않고, 직접 배포한다면 보통 문제가 되지 않는다.
 * */


/**
 * - 패키지 활용
 *
 *   패키지를 구성할 때 서로 관련된 클래스는 하나의 패키지에 모으고, 관련이 적은 클래스는 다른 패키지로 분리하는 것이 좋다.
 *   예시) 전체 구조도
 *        com.helloShop
 *              user
 *                  User
 *                  UserService
 *              product
 *                  Product
 *                  ProductService
 *              order
 *                  Order
 *                  OrderService
 *                  OrderHistory
 *
 *        큰 애플리케이션은 대략 이런식으로 패키지를 구성한다고 이해하면 된다.
 *        참고로 이것은 정답은 아니고 프로젝트 규모와 아키텍처에 따라서 달라진다.
 * */
