package example.ch15;

import java.io.*;
import java.util.ArrayList;

/**
 *      - 생성한 객체를 직렬화하여 파일(UserInfo.ser)에 저장하는 예제이다.
 *
 *      - 버퍼를 이용한 FileOutputStream을 기반으로 하는 ObjectOutputStream을 생성한 다음, writeObject()를 이용해서
 *        객체를 ObjectOutputStream에 출력하면 UserInfo.ser 파일에 객체가 직렬화되어 저장된다.
 *
 *      - 객체를 직렬화 하는 것은 이처럼 허무하게 간단하지만, 객체에 정의된 모든 인스턴스변수에 대한 참조를 찾아들어가기 때문에
 *        상당히 복잡하고 시간이 걸리는 작업이 될 수 있다.
 */
public class InputOutput08_Ex02 {
    public static void main(String[] args) {
        try {
            String fileName = "UserInfo.ser"; // 확장자를 직렬화의 약자인 'ser'로 하는 것이 보통이지만 이에 대한 제약은 없다.
            FileOutputStream     fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            ObjectOutputStream out = new ObjectOutputStream(bos);

            InputOutput08_Ex01 u1 = new InputOutput08_Ex01("JavaMan","1234",30);
            InputOutput08_Ex01 u2 = new InputOutput08_Ex01("JavaWoman","4321",26);

            ArrayList<InputOutput08_Ex01> list = new ArrayList<>(); // ArrayList 객체를 직렬화하면 ArrayList에 저장된 모든 객체들과
            list.add(u1);                                           // 각 객체의 인스턴스변수가 참조하고 있는 객체들까지 모두 직렬화된다.
            list.add(u2);

            // 객체를 직렬화한다.
            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화가 잘 끝났습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}