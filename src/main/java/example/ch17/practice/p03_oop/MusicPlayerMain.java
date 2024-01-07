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

/**
 * - 절차 지향 프로그래밍의 한계
 *
 * 지금까지 클래스를 사용해서 관련된 데이터를 하나로 묶고, 또 메서드를 사용해서 각각의 기능을 모듈화했다.
 * 덕분에 상당히 깔끔하고 읽기 좋고, 유지보수 하기 좋은 코드를 작성할 수 있었다. 하지만 여기서 더 개선할 수 는 없을까?
 *
 * 우리가 작성한 코드의 한계는 바로 데이터와 기능이 분리되어 있다는 점이다.
 * 음악 플레이어의 데이터는 MusicPlayerData 에 있는데, 그 데이터를 사용하는 기능은 MusicPlayerMain에 있는 각각의 메서드에 분리되어 있다.
 * 그래서 음악 플레이어와 관련된 데이터는 MusicPlayerData를 사용해야 하고, 음악 플레이어와 관련된 기능은 MusicPlayerMain의 각 메서드를 사용해야 한다.
 *
 * 데이터와 그 데이터를 사용하는 기능은 매우 밀접하게 연관되어 있다. 각각의 메서드를 보면 대부분 MusicPlayerData의 데이터를 사용한다.
 * 따라서 이후에 관련 데이터가 변경되면 MusicPlayerMain부분의 메서드들도 함께 변경해야 한다.
 * 그리고 이렇게 데이터와 기능이 분리되어 있으면 유지보수 관점에서도 관리 포인트가 2곳으로 늘어난다.
 *
 * 객체 지향 프로그래밍이 나오기 전까지는 지금과 같이 데이터와 기능이 분리되어 있었다. 따라서 지금과 같은 코드가 최선이었다.
 * 하지만 객체 지향 프로그래밍이 나오면서 데이터와 기능을 온전히 하나로 묶어서 사용할 수 있게 되었다.
 * */