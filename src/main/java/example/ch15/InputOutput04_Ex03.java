package example.ch15;

import java.io.*;
import java.util.Arrays;

/**
 *      @see InputOutput04_Ex02
 *      - 이전 예제를 변경해서 FileOutputStream대신 ByteArrayOutputStream을 사용한 예제.
 */
public class InputOutput04_Ex03 {
    public static void main(String[] args){

        ByteArrayOutputStream bos = null;
        DataOutputStream dos = null;

        byte[] result = null;
        try{
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            dos.writeInt(10);       // 결과의 첫 번째 4byte [0, 0, 0, 10] 출력.
            dos.writeFloat(20.0f);  // 이어서 두 번째 4byte [65, -96, 0, 0] 출력.
            dos.writeBoolean(true); // 이어서 마지막 1byte 1 출력.

            result = bos.toByteArray();

            String[] hex = new String[result.length];

            for(int i=0; i<result.length; i++){
                if(result[i] < 0){
                    hex[i] = String.format("%02x", result[i]+256); // 256을 더해서 부호 없는 정수값으로 변환(0~255).
                }else{
                    hex[i] = String.format("%02x", result[i]); // String.format()을 사용해서 10진 정수를 16진 정수로 변환.
                }
            }

            System.out.println("10진수 : " + Arrays.toString(result));
            System.out.println("16진수 : " + Arrays.toString(hex));

            dos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
/**
 *      - 이처럼 ByteArrayInputStream/ByteArrayOutputStream을 사용하면 byte단위의 데이터 변환 및 조작이 가능하다.
 *          + InputStream의 read()는 반환타입이 int이며 0~255의 값을 반환하므로 256을 더하거나 뺄 필요가 없다.
 *            반면에 read(byte[] b)와 같이 byte배열을 사용하는 경우 상황에 따라 0~255범위의 값으로 변환해야할 필요가 있다.
 *
 *      - 사실 DataOutputStream에 의해서 어떻게 저장되는지 몰라도 DataOutputStream의 write메서드들로 기록한 데이터는
 *        DataInputStream의 read메서드들로 읽기만 하면 된다.
 *        이 때 한 가지 주의해야 할 것은 이 예제와 같이 여러 가지 종류의 자료형으로 출력한 경우, 읽을 때는 반드시 쓰인 순서대로 읽어야 한다는 것이다.
 */