package example.ch17.practice.p11_poly.intermediate.ex10;

//결제 시스템
public class PayMain {
    public static void main(String[] args) {
        PayService payService = new PayService();

        //kakao 결제
        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);

        //naver 결제
        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        //잘못된 결제 수단 선택
        String payOption3 = "bad";
        int amount3 = 15000;
        payService.processPay(payOption3, amount3);

        //새로운 결제 수단 추가
        String payOption4 = "new";
        int amount4 = 20000;
        payService.processPay(payOption4, amount4);
    }
}

