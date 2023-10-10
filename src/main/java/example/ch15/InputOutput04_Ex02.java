package example.ch15;

import java.io.*;

/**
 *      - FileOutputStream을 기반으로 하는 DataOutputStream을 생성한 후, DataOutputStream의 메서드들을 이용해서 sample.dat파일에 값들을 출력하는 간단한 예제.
 *
 *      - 이 때 출력한 값들은 이진 데이터(binary data)로 저장 된다. 문자 데이터(text data)가 아니므로 문서 편집기로 sample.dat을 열어 봐도 알 수 없는 글자들로
 *        이루어져 있을 텐데, 파일을 16진수 코드로 볼 수 있는 UltraEdit, ByteArrayOutputStream을 사용하면 이진데이터를 확인 할 수 있다.
 */
public class InputOutput04_Ex02 {
    public static void main(String[] args){

        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try{
            fos = new FileOutputStream("sample.dat");
            dos = new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}