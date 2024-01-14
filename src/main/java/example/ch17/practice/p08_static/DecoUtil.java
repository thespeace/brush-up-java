package example.ch17.practice.p08_static;

//문자열을 꾸미는 단순 기능만을 제공하는 메서드
public class DecoUtil {
    public static String deco(String str) { //static, 정적 메서드 또는 클래스 메서드.
        return "*" + str + "*";
    }
}
