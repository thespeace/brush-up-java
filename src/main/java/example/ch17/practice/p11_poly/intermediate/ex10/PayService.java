package example.ch17.practice.p11_poly.intermediate.ex10;

public class PayService {

    //변하지 않는 부분, 새로운 결제 수단을 추가했을 때 Pay를 사용하는 클라이언트 코드인 PayService의 변경을 최소화 할 수 있어야 한다.
    public void processPay(String option, int amount) {

        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

        Pay pay = PayStore.findPay(option); //역할(Pay)에만 의존
        boolean result = pay.pay(amount);

        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }

}
