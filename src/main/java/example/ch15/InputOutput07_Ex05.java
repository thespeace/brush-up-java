package example.ch15;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *      - int배열 score에 저장된 데이터를 score2.dat에 저장한 다음, 저장된 내용을 readInt()로 읽어서 출력하는 예제.
 */

public class InputOutput07_Ex05 {
    public static void main(String[] args){

//                   번호, 국어, 영어, 수학
        int[] score = {1,  100,  90,  90,
                       2,   70,  90, 100,
                       3,  100, 100, 100,
                       4,   70,  60,  80,
                       5,   70,  90, 100
        };

        try{
            RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
            for(int i = 0; i < score.length; i++) {
                raf.writeInt(score[i]);
            }

//            while(true) {
//                System.out.println(raf.readInt());
//            }
/*
 *      - 실행하면, score2.dat파일은 생성되지만 화면에는 아무것도 출력되지 않는다. 그 이유는 writeInt()를 수행하면서
 *        파일 포인터의 위치가 파일의 마지막으로 이동되었기 때문이다. 그 다음에 readInt()를 호출했으므로 파일의 앞부분이 아닌
 *        마지막 부분부터 읽기 시작하기 때문에 아무 것도 읽지 못하고 EOFException이 발생해서 무한 반복문을 벗어나게 된다.
 *        그래서 다음과 같이 seek(long pos)를 이용해서 파일포인터의 위치를 다시 처음으로 이동시킨 다음에 readInt()를 호출하도록 해야 한다.
 */
            raf.seek(0);
            while(true) {
                System.out.println(raf.readInt());
            }
//          이처럼 RandomAccessFile을 'rw(읽기쓰기)모드'로 생성해서 작업할 때는 이러한 점을 염두에 두어야 한다.

        } catch (EOFException eof){
            // readInt()를 호출했을 때 더 이상 읽을 내용이 없으면 EOFException이 발생한다.
            eof.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}