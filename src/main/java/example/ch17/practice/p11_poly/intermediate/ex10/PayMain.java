package example.ch17.practice.p11_poly.intermediate.ex10;

import java.util.Scanner;

//결제 시스템
public class PayMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();

        while(true) {
            System.out.print("결제 수단을 입력하세요 : ");    //만일, 결제수단을 추가하길 원한다면 PayStore 코드만 변경해주면 된다.
            String payOption = scanner.nextLine();

            if(payOption.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            System.out.print("결제 금액을 입력하세요 : ");
            int amount = scanner.nextInt();
            scanner.nextLine();
            payService.processPay(payOption, amount);
        }

/*
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
*/

    }
}

