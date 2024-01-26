package example.ch17.practice.p11_poly.intermediate.ex10;

//결제 수단을 관리하고 보관하고 선택
public abstract class PayStore {

    //변하는 부분
    public static Pay findPay(String option) { //static 으로 기능을 제공한다. 추상 클래스로 선언해서 객체 생성을 막는다.
        if(option.equals("kakao")) {
            return new KakaoPay();
        } else if (option.equals("naver")) {
            return new NaverPay();
        } else if (option.equals("new")) {
            return new NewPay();
        } else {
            return new DefaultPay(); //null을 반환하지 않도록 null object 패턴 도입
        }
    }
}
