package example.ch15;

import java.io.*;
import java.util.Arrays;

public class InputOutput02_Ex03 {
    public static void main(String[] args) {
        // 모든 내용을 출력하는 대신 값을 읽어온 만큼만 출력하는 예제.
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];	// 이전 예제와 배열의 크기가 다르다.

        ByteArrayInputStream  input  = null;
        ByteArrayOutputStream output = null;

        input  = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

//        System.out.println("Input Source  :" + Arrays.toString(inSrc));

        //read(), write()이 IOException을 발생시킬 수 있기 때문에 try-catch문 사용.
        try {
            while(input.available() > 0) { // available()은 블락킹(blocking)없이 읽어 올 수 있는 바이트의 수를 반환한다.
                                           // 블락킹이란? 데이터를 읽어 올 때 데이터를 기다리기 위해 멈춰있는 것은 뜻한다. ex) 사용자가 데이터를 입력하기 전까지 기다린다.

//                input.read(temp);   //예상과 다른 결과의 이유는 마지막에 읽은 배열의 9번째와 10번째 요소값인 8과 9만을 출력해야하는데 temp에 남아 있던 6, 7까지 출력했기 때문.
//                output.write(temp); //보다 나은 성능을 위해서 temp에 담긴 내용을 지우고 쓰는게 아니라 기존 내용 위에 덮어 쓴다. 그래서 temp의 내용이 [4,5,6,7]이었는데, 8과 9를 읽고 난 후, [8,9,6,7]이 된다.
//                outSrc = output.toByteArray();
//                printArrays(temp, outSrc);

                int len = input.read(temp);     // 위 코드의 문제점 수정.
                output.write(temp, 0, len); // 출력시, temp에 저장된 모든 내용을 출력하는 대신 값을 읽어온 만큼만 출력하도록 변경, 올바른 결과를 얻었다.
            }
        } catch(IOException e) {}

        outSrc = output.toByteArray();

        System.out.println("Input Source  : " + Arrays.toString(inSrc));
        System.out.println("temp          : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }

//    static void printArrays(byte[] temp, byte[] outSrc) {
//        System.out.println("temp          :" +Arrays.toString(temp));
//        System.out.println("Output Source :" +Arrays.toString(outSrc));
//    }
}
