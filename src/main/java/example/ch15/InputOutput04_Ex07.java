package example.ch15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *      @see InputOutput04_Ex06
 *      - 위 예제를 try-with-resources문을 이용해서 더 간결하게 변경한 예제.
 */
public class InputOutput04_Ex07 {
    public static void main(String[] args){
        int sum = 0;
        int score = 0;

        try ( FileInputStream fis = new FileInputStream("score.dat");
              DataInputStream dis = new DataInputStream(fis)) {

            while(true) {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }

        }catch (EOFException e){
            System.out.println("점수의 총합은 " + sum + "입니다.");
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}