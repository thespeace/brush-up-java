package example.ch15;

import java.io.*;

/**
 *      - int형 배열 score의 값들을 DataOutputStream을 이용해서 score.dat파일에 출력하는 예제.
 *
 *        @see InputOutput04_Ex06
 *        다음 예제에서 score.dat파일을 읽어서 총합을 구해보자.
 */
public class InputOutput04_Ex05 {
    public static void main(String[] args){
        int[] score = { 100, 90, 95, 85, 50}; // int의 크기가 4byte이므로 모두 20byte의 데이터가 저장되어 있다.
        try {
            FileOutputStream fos = new FileOutputStream("score.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            for(int i = 0; i < score.length; i++){
                dos.writeInt(score[i]);
            }
            dos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}