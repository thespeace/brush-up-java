package example.ch01;

import java.io.IOException;

public class Part01_Print {
    public static void main(String[] args) throws IOException {
        // System.out : *표준 출력 스트림*으로 전달 받은 데이터를 스트림을 통해 출력 장치로 전달되어 사용자에게 출력.
        // print()    : 출력 후, 줄바꿈 안함.
        // println()  : 출력 후, 줄바꿈.
        System.out.println("Hello world!");
        // TODO System 클래스의 표준 입력(in), 표준 에러 출력(err)은 다음에 알아 보도록 하자.
    }
}
