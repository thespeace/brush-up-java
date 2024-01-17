package example.ch17.practice.p09_final.ex;

public class Member {

    private final String id; // id는 불변, final 키워드 사용.
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changeData(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("id : "+ id + ", name : " + name);
    }
}
