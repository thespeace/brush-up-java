package example.ch17.practice.p09_final.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId","seo");
        member.print();
        member.changeData("kim");
        member.print();
    }
}
