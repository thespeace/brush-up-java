package example.ch17.practice.p06_access;

public class Speaker { //클래스 레벨
    private int volume; //필드

    public Speaker(int volume) {
        this.volume = volume;
    } //생성자

    public void volumeUp() { //메서드
        if(volume >= 100) {
            System.out.println("음량을 증가할 수 없습니다. 최대 음량입니다.");
        } else {
            volume += 10;
            System.out.println("음량을 10 증가합니다.");
        }
    }

    void volumeDown() {
        volume -= 10;
        System.out.println("volumeDown 호출");
    }

    void showVolume() {
        System.out.println("현재 음량: " + volume);
    }
}

/**
 * - 접근 제어자의 종류
 *   private : 모든 외부 호출을 막는다.
 *   default (package-private): 같은 패키지안에서 호출은 허용한다.
 *   protected : 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.
 *   public : 모든 외부 호출을 허용한다.
 *   순서대로 private 이 가장 많이 차단하고, public 이 가장 많이 허용한다.
 *   private -> default -> protected -> public
 *
 * - 접근 제어자의 핵심은 속성과 기능을 외부로부터 숨기는 것이다.
 *   private 은 나의 클래스 안으로 속성과 기능을 숨길 때 사용, 외부 클래스에서 해당 기능을 호출할 수 없다.
 *   default 는 나의 패키지 안으로 속성과 기능을 숨길 때 사용, 외부 패키지에서 해당 기능을 호출할 수 없다.
 *   protected 는 상속 관계로 속성과 기능을 숨길 때 사용, 상속 관계가 아닌 곳에서 해당 기능을 호출할 수 없다.
 *   public 은 기능을 숨기지 않고 어디서든 호출할 수 있게 공개한다.
 * */