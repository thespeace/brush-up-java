package example.ch15;

import java.io.*;

/**
 *      - StringReader와 StringWriter를 이용한 간단한 예제.
 */
public class InputOutput05_Ex04 {
    public static void main(String[] args){
        String inputData = "ABCD";
        StringReader input  = new StringReader(inputData);
        StringWriter output = new StringWriter();

        int data = 0;

        try {
            while((data = input.read()) != -1) {
                output.write(data); // void write(int b)
            }
        } catch (IOException e){ }

        System.out.println("Input data  : " + inputData);
        System.out.println("Output Data : " + output.toString());
        System.out.println("Output Data : " + output.getBuffer().toString());
    }
}