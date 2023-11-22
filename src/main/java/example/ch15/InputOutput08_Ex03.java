package example.ch15;

import java.io.*;
import java.util.ArrayList;

/**
 *        @see InputOutput08_Ex02
 *      - 이 전의 예제에서 직렬화한 객체를 역직렬화하는 예제.
 *        전과는 반대로 FileInputStream과 ObjectInputStream을 그리고 writeObject()대신 readObject()를 사용했다는 점을 제외하고는 거의 같다.
 *
 *      - ObjectInputStream의 readObject()로 직렬화한 객체를 역직렬화하였는데, readObject()의 리턴타입이 Object이므로 원래의 타입으로 형변환을 해주어야 한다.
 *        한 가지 주의해야할 점은 객체를 역직렬화 할 때는 직렬화할 때의 순서와 일치해야 한다는 것이다.
 *        예를 들어 객체 u1, u2, list의 순서로 직렬화 했다면, 역직렬화 할 때도 ul, u2, list의 순서로 처리해야 한다.
 *        그래서 직렬화할 객체가 많을 때는 각 객체를 개별적으로 직렬화하는 것보다 ArrayList와 같은 컬렉션에 저장해서 직렬화하는 것이 좋다.
 *        역직렬화할 때 ArrayList 하나만 역직렬화 하면 되므로 역직렬화할 객체의 순서를 고려하지 않아도 되기 때문이다.
 */
public class InputOutput08_Ex03 {
    public static void main(String[] args) {
        try {
            String fileName = "UserInfo.ser";
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream in = new ObjectInputStream(bis);

            // 객체를 읽을 때는 출력한 순서와 일치해야한다.
            InputOutput08_Ex01 u1 = (InputOutput08_Ex01)in.readObject();
            InputOutput08_Ex01 u2 = (InputOutput08_Ex01)in.readObject();
            ArrayList list = (ArrayList)in.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}