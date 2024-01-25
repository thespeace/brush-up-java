package example.ch17.practice.p11_poly.intermediate.ex9;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS를 발송합니다 : " + message);
    }
}
