package example.ch06;

public class OOP05 {
    public static void main(String[] args){
        /**
         *    - 객체 배열
         *      객체 배열 == 참조변수 배열
         */

        Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv타입의 참조변수 배열 ( Tv tv1,tv2,tv3;  ->  Tv[] tvArr = new Tv[3]; )

        // 객체를 생성해서 초기화, 배열의 각 요소에 저장! * 선언문은 참조변수 배열만 만들었을 뿐이니 객체를 만들어서 꼭 초기화 시켜줘야한다. *
        tvArr[0] = new Tv(); // ex) 주소 : 0x100
        tvArr[1] = new Tv(); // ex) 주소 : 0x200
        tvArr[2] = new Tv(); // ex) 주소 : 0x300

        // 위의 선언과 초기화 식을 간단하게.
        Tv[] SimpleTvArr = { new Tv(), new Tv(), new Tv() };

    }
}
