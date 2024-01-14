package example.ch17.practice.p08_static;

public class DecoMain {
    public static void main(String[] args) {
        String s = "hello java";
        String deco = DecoUtil.deco(s); //static 메서드 사용.

        System.out.println("before : " + s);
        System.out.println("after : " + deco);
    }
}
