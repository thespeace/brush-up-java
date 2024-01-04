package example.ch17.practice.p01_class;

//학생 정보 출력 프로그램 만들기
public class Class {

    public static void main(String[] args) {
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Grade = 90;

        String student2Name = "학생2";
        int student2Age = 16;
        int student2Grade = 80;

        System.out.println("이름: " + student1Name + " 나이:" + student1Age + " 성적:" + student1Grade);
        System.out.println("이름: " + student2Name + " 나이:" + student2Age + " 성적:" + student2Grade);


        //배열로 바꾸어 보자 -
        String[] studentNames = {"학생3", "학생4", "학생5", "학생6"};
        int[] studentAges = {15, 16, 17, 20};
        int[] studentGrade = {90, 80, 70, 60};

        for (int i = 0; i < studentNames.length; i++)
            System.out.println("이름: " + studentNames[i] + " 나이:" + studentAges[i] + " 성적:" + studentGrade[i]);


        //이름, 나이, 성적을 각각 따로 나누어서 관리하는 것은 사람이 관리하기 좋은 방식이 아니다.
        //사람이 관리하기 용이하게 학생이라는 개념을 하나로 묶어서 관리해보자.
        //클래스를 도입해 보자 -
        Student student1; //변수 선언
        student1 = new Student(); //객체(인스턴스) 생성
        student1.name = "학생7"; //멤버 변수 참조
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생8";
        student2.age = 14;
        student2.grade = 80;

        System.out.println("이름: " + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
        System.out.println("이름: " + student2.name + " 나이:" + student2.age + " 성적:" + student2.grade);


        //배열을 도입해보자 -
//        Student[] students = new Student[2];
        Student[] students = new Student[] {student1, student2};

//        for(int i = 0; i < students.length; i++) {
//            Student s = students[i];
//            System.out.println("이름: " + s.name + " 나이:" + s.age + " 성적:" + s.grade);
//        }

        for(Student s : students) { //향상된 for문, 단축키 `iter`
            System.out.println("이름: " + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }


    }
}

/**
 * - 객체 vs 인스턴스
 * 둘 다 클래스에서 나온 실체라는 의미에서 비슷하게 사용되지만, 용어상 인스턴스는 객체보다 좀 더 관계에 초점을 맞춘 단어이다.
 * 특정 클래스와의 관계를 명확히 할 때 인스턴스라는 용어를 주로 사용한다.
 * */