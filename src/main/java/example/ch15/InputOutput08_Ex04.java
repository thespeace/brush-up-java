package example.ch15;

import java.io.*;
import java.util.ArrayList;

/**
 *      - 직렬화되지 않는 조상으로부터 상속받은 인스턴스변수에 대한 직렬화를 구현한 예제.
 */
class InputOutput08_Ex04_1 {
    String name;
    String password;

    InputOutput08_Ex04_1(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

public class InputOutput08_Ex04 extends InputOutput08_Ex04_1 implements java.io.Serializable {
    int age;

    public InputOutput08_Ex04() {
        this("Unknown", "1111", 0);
    }
    public InputOutput08_Ex04(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    public String toString(){
        return "{" + name + "," + password + "," + age + "}";
    }

    //직렬화될 객체의 클래스에 아래와 같이 writeObject()와 readObject()를 추가해서 조상으로부터 상속받은 인스턴스 변수인
    //name과 password가 직접 직렬화되도록 해야한다. 이 메서드들은 직렬화/역직렬화 작업시에 자동적으로 호출된다.
    //이 두 메서드의 접근 제어자는 private인데 단순히 미리 정해진 규칙이다.
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name); //타입이 String이기에 writeUTF()사용, writeInt() 등등 인스턴스변수의 타입에 맞는 것을 선택해서 사용하면 된다.
        out.writeUTF(password);
        out.defaultWriteObject(); // 클래스 자신에 정의된 인스턴스변수 age의 직렬화를 수행한다.
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();//타입이 String이기에 readUTF()사용, readInt() 등등 인스턴스변수의 타입에 맞는 것을 선택해서 사용하면 된다.
        password = in.readUTF();
        in.defaultReadObject();
    }
}