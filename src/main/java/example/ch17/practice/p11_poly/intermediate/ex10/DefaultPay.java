package example.ch17.practice.p11_poly.intermediate.ex10;

//null object 패턴 도입, DefaultPay 사용하면 null 체크를 피할 수 있다.
public class DefaultPay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
