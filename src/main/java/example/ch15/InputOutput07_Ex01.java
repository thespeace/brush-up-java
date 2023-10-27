package example.ch15;

import java.io.*;

/**
 *      - 표준 입출력(System.in, System.out)을 사용한 예제.
 *
 *          {@code : 명령 프롬프트(cmd.exe)
 *              ...example>ch15> java InputOutput07_Ex01.java
 *              hello
 *              input : 104, (char)input : h
 *              input : 101, (char)input : e
 *              input : 108, (char)input : l
 *              input : 108, (char)input : l
 *              input : 111, (char)input : o
 *              input : 13, (char)input :       <- 특수문자라서 화면에 보이지 않는다.(Enter키를 누르는 것은 두개의 특수문자 \r, \n이 입력된 것으로 간주.)
 *              input : 10, (char)input :          \r은 캐리지 리턴, 즉 커서를 현재 라인의 첫 번째 컬럼으로 이동시키고 \n은 커서를 다음 줄로 이동시키는 줄바꿈을 한다.
 *              (개행문자가 출력되어 줄바꿈 되었다)      그래서 Enter키를 누르면, 캐리지리턴과 줄바꿈이 수행되어 다음 줄의 첫 번재 칼럼으로 커서가 이동하는 것이다.
 *              ^Z                              <- Ctrl + Z를 눌러서 입력의 끝(EOF)를 알린다.
 *              ...example>ch15>
 *          }
 *              + ^z(Ctrl키와 z키를 동시에 누름)와 엔터를 누르면 프로그램 종료.
 *
 *      1. 예제를 실행하면 System.in.read()가 호출되면, 코드의 진행을 멈추고 콘솔에 커서가 깜빡이며 사용자의 입력을 기다린다.
 *
 *      2. 콘솔입력은 버퍼를 가지고 있기 때문에 Backspace키를 이용해서 편집이 가능하며 한번에 버퍼의 크기만큼 입력이 가능하다.
 *        그래서 Enter키나 입력의 끝을 알리는 '^z'를 누르기 전까지는 아직 데이터가 입력 중인 것으로 간주되어 커서가 입력을 계속 기다리는
 *        상태(블락킹 상태)에 머무르게 된다.
 *
 *      3. 콘솔에 데이터를 입력하고 Eneter키를 누르면 입력대기상태에서 벗어나 입력된 데이터를 읽기 시작하고 입력된 데이터를 모두 읽으면 다시 입력대기 상태가 된다.
 *
 *      4. 이러한 과정이 반복되다가 사용자가 '^z'를 입력하면, read()는 입력이 종료되었음을 인식하고 -1을 반환하여 while문을 벗어나 프로그램이 종료된다.
 */
public class InputOutput07_Ex01 {
    public static void main(String[] args){
        try {
            int input = 0;

            while((input=System.in.read()) != -1) {
                System.out.println("input : " + input + ", (char)input : " + (char)input);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

/**
 *      - 여기서 한 가지 문제는 Enter키도 사용자입력으로 간주되어 매 입력마다 \r, \n이 붙기 때문에 이 둘을 제거해주어야 하는 불편함이 있다는 것이다.
 *        이러한 불편함을 제거하려면 전에 살펴본 것과 같이 System.in에 BufferedReader를 이용해서 readLine()을 통해 라인단위로 데이터를 입력받으면 된다.
 *
 *      - 텍스트기반의 사용자인터페이스 시대에 탄생한 C언어는 콘솔이 데이터를 입력받는 주요 수단이었지만, 자바가 탄생한 그래픽기반의 사용자인터페이스 시대는
 *        콘솔을 통해서 데이터를 입력받는 경우는 드물기 때문에 Java에서 콘솔을 통한 입력에 대한 지원이 미약했다.
 *        나중에 Scanner와 Console같은 클래스가 추가되면서 많이 보완되었다.
 */