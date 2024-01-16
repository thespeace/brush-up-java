package example.ch17.practice.p09_final;

public class ConstructInit {
    final int value; //final을 필드에서 사용할 경우 생성자를 통해서 최초만 초기화 가능.

    public ConstructInit(int value) {
        this.value = value;
    }
}
