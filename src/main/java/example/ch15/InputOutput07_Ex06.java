package example.ch15;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *      - 이전 예제에서 데이터를 저장한 score2.dat파일에서 국어과목의 점수만 합계를 내는 예제.
 *        @see InputOutput07_Ex05
 */

public class InputOutput07_Ex06 {
    public static void main(String[] args){
        int sum = 0;

        try{
            RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
            int i = 4;

            while(true) {     // 한 학생의 데이터가 번호와 3과목의 점수로 모두 4개의 int값(4 * 4 = 16 byte)으로 되어 있기 때문에-
                raf.seek(i);  //  i += 16과 같이 파일 포인터의 값을 16씩 증가시켜가면서 readInt()를 호출 했다.
                sum += raf.readInt();
                i+=16;
            }

        } catch (EOFException e){
            System.out.println("sum : " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}