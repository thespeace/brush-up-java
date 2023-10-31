package example.ch15;

import java.io.*;

/**
 *      - 파일에 출력작업이 수행되었을 때 파일 포인터의 위치가 어떻게 달라지는지 보여주는 예제.
 *
 *      - int가 4 byte이기 때문에 writeInt()를 호출한 다음 파일 포인터의 위치가 0에서 4로 바뀐 것을 알 수 있다.
 *        마찬가지로 8 byte인 long을 출력하는 writeLong()을 호출한 후에는 파일 포인터의 위치가 4에서 12로 변경된 것을 알 수 있다.
 */

public class InputOutput07_Ex04 {
    public static void main(String[] args){
        try{
            RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
            System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
            raf.writeInt(100);
            System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
            raf.writeLong(100L);
            System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}