package example.ch17.practice.p07_memory;

//지역 변수는 스택 영역에, 객체(인스턴스)는 힙 영역에 관리되는 것을 확인해보자-
public class JavaMemoryStackHeapMain {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(); //스택 프레임 생성.
        System.out.println("main end"); // 힙 영역의 Data 인스턴스를 참조하는 곳이 없으니 프로그램에서 더는 사용하지 않는 객체가 된 것.
    }                                   // 메모리만 차지하는 이런 객체는 GC(가비지 컬렉션)가 메모리에서 제거한다.

    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10); //힙 영역에 Data 인스턴스를 생성, 참조값 data1에 보관.
        method2(data1);
        System.out.println("method1 end"); // method1()가 종료(스택 프레임 제거)되면서 매개변수도 함께 제거.
    }

    static void method2(Data data2) { //힙 영역에 생성된 Data 인스턴스를 참조. 즉 두개의 메소드가 힙 영역의 Data 인스턴스를 참조.
        System.out.println("method2 start");
        System.out.println("data.getValue() : " + data2.getValue());
        System.out.println("method2 end"); // method2()가 종료(스택 프레임 제거)되면서 매개변수도 함께 제거.
    }
}

// 참고 : 힙 영역 외부가 아닌, 힙 영역 안에서만 인스턴스끼리 서로 참조하는 경우에도 GC의 대상이 된다.