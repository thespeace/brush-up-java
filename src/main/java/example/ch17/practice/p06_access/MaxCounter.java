package example.ch17.practice.p06_access;

public class MaxCounter {
    private int count = 0;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increament() {
        //검증 로직
        if(count >= max) {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }

        //실행 로직
        count++;
    }

    public int getCount(){
        return count;
    }
}
