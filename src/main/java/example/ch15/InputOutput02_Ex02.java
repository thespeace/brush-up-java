package example.ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class InputOutput02_Ex02 {
    public static void main(String[] args) {
        //int read(byte[] b, int off, int len)와 void write(byte[] b, int off, int len)를 사용해서 입출력하는 방법을 보여주는 예제.
        //byte배열을 사용해서 한 번에 배열의 크기만큼 읽고 쓸 수 있다.

        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream  input  = null;
        ByteArrayOutputStream output = null;

        input  = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        input.read(temp,0,temp.length); // 읽어 온 데이터를 배열 temp에 담는다(10byte 입력).
        output.write(temp,5, 5);    // temp[5]부터 5개의 데이터를 write한다(5byte 출력).

        outSrc = output.toByteArray();

        System.out.println("Input Source  :" + Arrays.toString(inSrc));
        System.out.println("temp          :" + Arrays.toString(temp));
        System.out.println("Output Source :" + Arrays.toString(outSrc));

        //배열을 이용한 입출력은 작업의 효율을 증가시키므로 가능하면 입출력 대상에 따라 알맞은 크기의 배열을 사용하는 것이 좋다.
    }
}
