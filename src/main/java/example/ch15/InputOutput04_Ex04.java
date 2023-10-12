package example.ch15;

import java.io.*;

/**
 *      @see InputOutput04_Ex02
 *      - 이전 예제를 실행해서 만들어진 sample.dat 파일을 읽어서 콘솔에 출력하는 예제.
 *
 *      - 파일로부터 데이터를 읽어 올 때, 아무런 변환이나 자릿수를 셀 필요없이 단순히 readInt()와 같이 읽어 올 데이터의 타입에 맞는 메서드를 사용하기만 하면 된다.
 *        만약 문자로 데이터를 저장하면, 다시 데이터를 읽어 올 때 문자들을 실제 값으로 변환하는, 예를 들면 문자열 "100"을 숫자 100으로 변환하는 과정을 거쳐야 하고,
 *        또 읽어야 할 데이터의 개수를 결정해야하는 번거로움이 있다.
 *        하지만 이처럼 DataInputStream과 DataOutputStream을 사용하면, 데이터를 변환할 필요도 없고, 자리수를 세어서 따지지 않아도 되므로 편리하고 빠르게
 *        데이터를 저장하고 읽을 수 있게 된다.
 */
public class InputOutput04_Ex04 {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("sample.dat");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());
            dis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}