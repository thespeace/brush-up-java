package example.ch17.practice.p03_oop;

/**
 * - 객체 지향 프로그래밍(OOP)
 *
 * 데이터와 기능을 하나로 묶어서 음악 플레이어라는 개념을 온전히 하나의 클래스에 담아보자.
 * 프로그램을 작성하는 절차도 중요하지만 지금은 음악 플레이어라는 개념을 객체로 온전히 만드는 것이 더 중요하다. 음악 플레이어라는 객체를 지향해보자.
 *
 * 그러기 위해서는 프로그램의 실행 순서 보다는 음악 플레이어 클래스를 만드는 것 자체에 집중해야 한다.
 * 음악 플레이어가 어떤 속성(데이터)을 가지고 어떤 기능(메서드)을 제공하는지 이 부분에 초점을 맞추어야 한다.
 * 지금부터 우리는 음악 플레이어를 개발하는 개발자가 될 것이다. 이것을 어떻게 사용할지는 분리해서 생각하자.
 * 쉽게 이야기해서 음악 플레이어를 만들어서 제공하는 개발자와 음악 플레이어를 사용하는 개발자가 분리되어 있다고 생각하면 된다.
 *
 *
 * - 음악 플레이어
 *   속성: volume , isOn
 *   기능: on() , off() , volumeUp() , volumeDown() , showStatus()
 */
public class MusicPlayerDataOOP {
    int volume = 0;
    boolean isOn = false;

    void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }

    void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }

    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

    void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

    void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}

/**
 * 해당 클래스에 음악 플레이어에 필요한 속성과 기능을 모두 정의했다.
 * 이제 음악 플레이어가 필요한 곳에서 이 클래스만 있으면 온전한 음악 플레이어를 생성해서 사용할 수 있다.
 * 음악 플레이어를 사용하는데 필요한 모든 속성과 기능이 하나의 클래스에 포함되어 있다.
 * */
