package example.ch05;

public class Array02 {
    public static void main(String[] args){
        /**
         *    - 배열의 길이
         *      배열이름.length - 배열의 길이(int형 상수)
         *          "배열은 한번 생성하면 그 길이를 바꿀 수 없다."
         *              왜 길이를 바꿀 수 없을까?
         *                  메모리 공간에 integer타입 5개의 배열의 공간을 확보하려고 한다면, 4byte * 5 = 20byte만큼의 공간을 연속적으로 사용하게 됩니다.
         *                  메모리 공간에서 20byte만큼의 공간을 찾아서 할당을 하게 되는데, 공간이 더 필요해서 5개의 배열을 추가한다면 20byte만큼의 공간이 더 필요하게 되고, 총 40byte만큼의 공간을 사용해야하는데,
         *                  처음 할당되었던 공간 20byte 뒤에 연결을 해야하는데, 그 뒤의 메모리의 공간이 비었다는 보장이 없다. 그렇기 때문에 새로 40byte만큼의 공간으로 이동을 하는 규칙이 정해져 있기 때문에,
         *                  공간이 부족하다면 새로 큰 크기의 배열을 생성해야 한다.
         */

        // index범위 : 0~4
        int[] arr = new int[5];
        int tmp = arr.length;
        System.out.println("arr배열의 길이는 : " + tmp);

        for(int i = 0; i < tmp; i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }

//        for(int i = 0; i < 6; i++){
//            System.out.println("arr["+i+"]="+arr[i]); //해당 배열의 인덱스의 범위를 벗어나면 ArrayindexOutOfBoundsException이 발생.
//        }

        /**
         *    - 배열의 초기화
         *      배열의 각 요소에 처음으로 값을 저장하는 것
         */

        int[] score1 = new int[5]; //길이가 5인 int형 배열을 생성한다.
        score1[0] = 50;            // 각 요소에 직접 값을 저장한다.
        score1[1] = 60;
        score1[2] = 70;
        score1[3] = 80;
        score1[4] = 90;

        // 위의 직접 값 초기화을 간편하게 작성.
        int[] score2 = new int[]{50, 60, 70, 80, 90}; // <- 잘 쓰지 않고 아래의 문법을 사용합니다.
        int[] score3 = {50, 60, 70, 80, 90}; // <- 해당 식을 실무에선 보통 99% 사용한다. new int[]를 생략할 수 있다. 해당 식은 선언식과 초기화식을 나누어 사용할 순 없다.


    }
}
