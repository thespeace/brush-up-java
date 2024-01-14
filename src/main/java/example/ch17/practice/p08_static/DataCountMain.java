package example.ch17.practice.p08_static;

// 생성된 객체의 수를 세기.
public class DataCountMain {
    public static void main(String[] args) {
        Data data1 = new Data("A");
        System.out.println("A count : " + Data.count); // 클래스를 통한 접근 : 메서드 영역의 정적 변수에 접근하려면 클래스명을 사용해 직접 접근하여 호출.

        Data data2 = new Data("B");
        System.out.println("B count : " + data2.count); // 인스턴스를 통한 접근 : 추천 하지 않는다. 인스턴스 변수라는 오해를 일으킬수 있기때문에 가독성을 위해 클래스 접근이 좋다.

        Data data3 = new Data("C");
        System.out.println("C count : " + Data.count);
    }
}
