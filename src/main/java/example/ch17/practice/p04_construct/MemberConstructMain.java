package example.ch17.practice.p04_construct;

import java.util.Arrays;

public class MemberConstructMain {
    public static void main(String[] args) {
        // 생성자 호출 : 생성자를 호출하는 방법은 다음 코드와 같이 new 명령어 다음에 생성자 이름과 매개변수에 맞추어 인수를 전달하며 된다.
        MemberConstruct member1 = new MemberConstruct("user1",15,90);
        MemberConstruct member2 = new MemberConstruct("user2",16,80);

        MemberConstruct[] members = {member1, member2};

        for (MemberConstruct s : members) {
            System.out.println("이름 = " + s.name + ", 나이 = " + s.age + ", 성적 = " + s.grade);
        }
    }
}

/**
 *  - 제약(생성자 호출 필수)
 *
 *    생성자의 진짜 장점은 객체를 생성할 때 직접 정의한 생성자가 있다면 직접 정의한 생성자를 반드시 호출해야 한다는 점이다.
 *    즉, 생성자를 사용하면 필수값 입력을 보장할 수 있다.
 *    좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약이 있는 프로그램이다라는 말이 있듯이 적절한 제약을 줄 수 있다.
 *    참고로 생성자를 메서드 오버로딩 처럼 여러개 정의할 수 있는데, 이 경우에는 하나만 호출하면 된다.
 * */