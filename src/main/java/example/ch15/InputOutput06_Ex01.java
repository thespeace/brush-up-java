package example.ch15;

import java.io.*;

/**
 *      - BufferedReader의 readLine()을 이용해서 파일을 라인단위로 읽은 다음 indexOf()를 이용해서 ';'를 포함하고 있는지 확인하여 출력하는 예제.
 *
 *      - 파일에서 특정 문자 또는 문자열을 포함한 라인을 쉽게 찾아낼 수 있음을 보여 준다.
 */
public class InputOutput06_Ex01 {
    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("src\\main\\java\\example\\ch15\\InputOutput06_Ex01.java");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            for(int i = 1; (line = br.readLine())!=null; i++) {
                // ';'를 포함한 라인을 출력한다.
                if(line.indexOf(";") != -1)
                    System.out.println(i + " : " + line);
            }

            br.close();
        } catch (IOException e){ }
    }
}