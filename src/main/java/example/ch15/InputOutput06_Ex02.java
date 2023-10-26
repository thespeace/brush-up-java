package example.ch15;

import java.io.*;

/**
 *      - InputStreamReader를 이용해서 현재 사용중인 OS의 인코딩을 확인하는 예제, 실행하는 OS의 종류에 따라 인코딩이 다를 수 있다.
 */
public class InputOutput06_Ex02 {
    public static void main(String[] args){
        String line = "";
        try {
            InputStreamReader isr = new InputStreamReader(System.in); // BufferedReader의 readLine()을 이용하면 사용자의 화면입력을 라인단위로 입력받으면 편리하다.
            BufferedReader br = new BufferedReader(isr); // 그래서 BufferedREader와 InputStream인 System.in을 연결하기 위해 InputStreamReader를 사용하였다.
                                                         // JDK1.5부터는 Scanner가 추가되어 이왕 같은 방식을 사용하지 않아도 간단하게 처리가 가능하다.
            System.out.println("사용중인 OS의 인코딩 : " + isr.getEncoding());

            do {
                System.out.print("문장을 입력하세요. 마치시려면 q를 입력하세요. >");
                line = br.readLine(); // 사용자의 화면입력을 라인단위로 입력받기.
                System.out.println("입력하신 문장 : " + line);
            } while(!line.equalsIgnoreCase("q"));

//          br.close(); // System.in과 같은 표준입출력은 닫지 않아도 된다.
            System.out.println("프로그램을 종료합니다.");
        } catch (IOException e){ }
    }
}