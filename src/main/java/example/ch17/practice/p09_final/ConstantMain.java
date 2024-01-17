package example.ch17.practice.p09_final;

public class ConstantMain {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 : " + Constant.MAX_USERS); // 매직 넘버(개발자를 당황시키는 수)가 아니라 처음보는 개발자도 알아볼 수 있도록 가독성이 증가한다.
        int currentUserCount = 999;
        process(++currentUserCount);
        process(++currentUserCount);
        process(++currentUserCount);
    }

    private static void process(int currentUserCount) {
        System.out.println("참여자 수 : " + currentUserCount);
        if(currentUserCount > Constant.MAX_USERS) {
            System.out.println("대기자로 등록합니다.");
        } else {
            System.out.println("게임에 참여합니다.");
        }
    }
}
