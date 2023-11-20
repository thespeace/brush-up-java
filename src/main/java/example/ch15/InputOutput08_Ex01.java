package example.ch15;

/**
 *      - 이후 예제를 위한 클래스.
 */
public class InputOutput08_Ex01 implements java.io.Serializable{
    String name;
    String password;
    int age;

    public InputOutput08_Ex01() {
        this("Unknown", "1111", 0);
    }

    public InputOutput08_Ex01(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String toString(){
        return "(" + name + "," + password + "," + age + ")";
    }
}
