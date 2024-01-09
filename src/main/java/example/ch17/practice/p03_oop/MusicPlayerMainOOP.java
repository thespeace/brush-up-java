package example.ch17.practice.p03_oop;

//객체를 사용하기만 한다.
public class MusicPlayerMainOOP {
    public static void main(String[] args) {
        MusicPlayerDataOOP player = new MusicPlayerDataOOP();

        //음악 플레이어 켜기
        player.on();

        //볼륨 증가
        player.volumeUp();

        //볼륨 증가
        player.volumeUp();

        //볼륨 감소
        player.volumeDown();

        //음악 플레이어 상태
        player.showStatus();

        //음악 플레이어 끄기
        player.off();
    }
}


/**
 * - 캡슐화
 *
 * MusicPlayer 를 보면 음악 플레이어를 구성하기 위한 속성과 기능이 마치 하나의 캡슐에 쌓여있는 것 같다.
 * 이렇게 속성과 기능을 하나로 묶어서 필요한 기능을 메서드를 통해 외부에 제공하는 것을 캡슐화라 한다.
 *
 * 객체 지향 프로그래밍 덕분에 음악 플레이어 객체를 사용하는 입장에서 진짜 음악 플레이어를 만들고 사용하는 것 처럼 친숙하게 느껴진다.
 * 그래서 코드가 더 읽기 쉬운 것은 물론이고, 속성과 기능이 한 곳에 있기 때문에 변경도 더 쉬워진다.
 * 예를 들어서 MusicPlayer 내부 코드가 변하는 경우에 다른 코드는 변경하지 않아도 된다.
 * MusicPlayer 의 volume 이라는 필드 이름이 다른 이름으로 변한다고 할 때 MusicPlayer 내부만 변경하면 된다.
 * 또 음악 플레이어가 내부에서 출력하는 메시지를 변경할 때도 MusicPlayer 내부만 변경하면 된다.
 * 이 경우 MusicPlayer 를 사용하는 개발자는 코드를 전혀 변경하지 않아도 된다.
 * 물론 외부에서 호출하는 MusicPlayer 의 메서드 이름을 변경한다면 MusicPlayer 를 사용하는 곳의 코드도 변경해야 한다.
 */