package example.ch15;

import java.io.*;
import java.util.*;

/**
 *      - 3개의 ByteArrayInputStream을 Vector와 SequenceInputStream을 이용해서 하나의 입력스트림처럼 다루는 예제.
 *
 *      - Vector에 저장된 순서대로 입력되므로 순서에 주의해야 한다.
 */
public class InputOutput04_Ex08 {
    public static void main(String[] args){
        byte[] arr1 = {0,1,2};
        byte[] arr2 = {3,4,5};
        byte[] arr3 = {6,7,8};
        byte[] outSrc = null;

        Vector v = new Vector();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));
        //각각의 바이트배열을 Vector(Enumeration)에 추가.

        SequenceInputStream   input  = new SequenceInputStream(v.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        try{
            while((data = input.read()) != 1) { // 합쳐진 input을 통해 전체 크기만큼 output에 담습니다.
                output.write(data);             // void write(int b)
            }
        } catch (IOException e){ }

        outSrc = output.toByteArray();

        System.out.println("Input Source1 : " + Arrays.toString(arr1));
        System.out.println("Input Source2 : " + Arrays.toString(arr2));
        System.out.println("Input Source3 : " + Arrays.toString(arr3));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }
}