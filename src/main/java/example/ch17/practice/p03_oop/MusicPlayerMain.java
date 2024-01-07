package example.ch17.practice.p03_oop;

//절차 지향 프로그래밍 -> 객체 지향 프로그래밍
public class MusicPlayerMain {
    public static void main(String[] args) {


/*      절차 지향 프로그래밍

        int volume = 0;
        boolean isOn = false;

        //음악 플레이어 켜기
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다");

        //볼륨 증가
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);

        //볼륨 증가
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);

        //볼륨 감소
        volume--;
        System.out.println("음악 플레이어 볼륨:" + volume);

        //음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }

        //음악 플레이어 끄기
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
*/

/**
 * 음악 플레이어와 관련된 데이터 묶기
 *
 * 장점 : 이후에 프로그램 로직이 더 복잡해져서 다양한 변수들이 추가되더라도 음악 플레이어와 관련된 변수들은 MusicPlayerData data 객체에 속해있으므로 쉽게 구분할 수 있다.
 */
        MusicPlayerData data = new MusicPlayerData(); //음악 플레이어에 사용되는 volume , isOn 속성을 MusicPlayerData 의 멤버 변수에 포함했다.

        //음악 플레이어 켜기
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");

        //볼륨 증가
        data.volume++;
        System.out.println("음악 플레이어 볼륨:" + data.volume);

        //볼륨 증가
        data.volume++;
        System.out.println("음악 플레이어 볼륨:" + data.volume);

        //볼륨 감소
        data.volume--;
        System.out.println("음악 플레이어 볼륨:" + data.volume);

        //음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + data.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }

        //음악 플레이어 끄기
        data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
        System.out.println("=================================\n");


/**
 * 메서드 추출
 * 각각의 기능을 메서드로 만든 덕분에 각각의 기능이 모듈화 되었다. 덕분에 다음과 같은 장점이 생겼다
 *
 * 장점 : 1.중복 제거: 로직 중복이 제거되었다. 같은 로직이 필요하면 해당 메서드를 여러번 호출하면 된다.
 *       2.변경 영향 범위: 기능을 수정할 때 해당 메서드 내부만 변경하면 된다.
 *       3.메서드 이름 추가: 메서드 이름을 통해 코드를 더 쉽게 이해할 수 있다.
 */
        MusicPlayerData data1 = new MusicPlayerData();
        //음악 플레이어 켜기
        on(data1);
        //볼륨 증가
        volumeUp(data1);
        //볼륨 증가
        volumeUp(data1);
        //볼륨 감소
        volumeDown(data1);
        //음악 플레이어 상태
        showStatus(data1);
        //음악 플레이어 끄기
        off(data1);

    }

    static void on(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }

    static void off(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }

    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("음악 플레이어 볼륨:" + data.volume);
    }

    static void volumeDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("음악 플레이어 볼륨:" + data.volume);
    }

    static void showStatus(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + data.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }

}
