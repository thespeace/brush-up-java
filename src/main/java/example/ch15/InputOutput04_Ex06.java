package example.ch15;

import java.io.*;

/**
 *      @see InputOutput04_Ex05
 *      - 위 예제에서 출력된 파일을 읽어서 데이터의 총합을 구해보자.
 */
public class InputOutput04_Ex06 {
    public static void main(String[] args){
        int sum = 0;
        int score = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("score.dat");
            dis = new DataInputStream(fis);

            while(true) {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }
        }catch (EOFException e){ // 더 이상 읽을 데이터가 없으면 EOFException을 발생.
                                 // 다른 입력스트림들과는 달리 무한반복문과 EOFException을 처리하는 catch문을 이용해서 데이터를 읽는다.
            System.out.println("점수의 총합은 " + sum + "입니다.");
        }catch (IOException ie){
            ie.printStackTrace();
        }finally { // while문이 무한 반복문이기 때문에 finally블럭에서 스트림을 닫도록 처리.
            try{
                if(dis!=null)    // DataInputStream이 null인지 확인.
                    dis.close(); // 스트림을 닫는다. IOException이 발생시킬 수 있으므로 try-catch블럭 사용.
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}

/**
 *      - 지금까지는 try블럭 내에서 스트림을 닫아주었지만, 작업도중에 예외가 발생해서 스트림을 닫지 못하고 try블럭을 빠져나갈 수 있기 때문에
 *        이처럼 finally블럭을 이용해서 스트림을 닫아주는 것이 더 확실한 방법이다.(다른 예제는 복잡해지는 것을 막기위해 간단히 try블럭 내에서 스트림을 닫도록 코드를 작성한 것.)
 *
 *          + 사실 프로그램이 종료될 때, 가비지 컬렉터가 사용하던 자원들을 모두 해제 해주기 때문에 이렇게 간단한 예제는 스트림을 닫지 않아도 별문제가 되지는 않는다.
 *            그래도 가능하면 스트림을 사용한 직후에 바로 닫아서 자원을 반환하는 것이 좋다.
 *
 *      - JDK1.7부터는 try-with-resources문을 이용해서 close()를 직접 호출하지 않아도 자동호출되도록 할 수 있다.
 *        @see example.ch15.InputOutput04_Ex07
 */