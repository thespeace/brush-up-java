package example.ch15;
import java.io.*;
import java.util.Arrays;

public class InputOutput02_Ex01 {
    public static void main(String[] args) {
        // ByteArrayInputStream/ByteArrayOutputStream을 이용해서 바이트배열 inSrc의 데이터를 outSrc로 복사하는 예제.
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        int data = 0;

        while((data = input.read())!=-1) // int read()에서 호출한 반환값을 변수 data에 저장, data에 저장된 값이 -1이 아닌지 비교.
            output.write(data);	// void write(int b)

        outSrc = output.toByteArray(); // 스트림의 내용을 byte배열로 반환한다.

        System.out.println("Input Source  :" + Arrays.toString(inSrc));
        System.out.println("Output Source :" + Arrays.toString(outSrc));

        // 바이트배열은 사용하는 자원이 메모리 밖에 없으므로 가비지컬렉터에 의해 자동적으로 자원을 반환하므로 close()를 이용해서 스트림을 닫지 않아도 된다.
        // read()와 write(int b)를 사용하기 때문에 한 번에 1byte만 읽고 쓰므로 작업효율이 떨어진다.
    }
}
