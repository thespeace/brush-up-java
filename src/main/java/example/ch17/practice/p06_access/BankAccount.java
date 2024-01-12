package example.ch17.practice.p06_access;

public class BankAccount {

    private int balance; //데이터 필드는 외부에 직접 노출하지 않는다. BankAccount가 제공하는 메서드를 통해서만 접근할 수 있다.

    public BankAccount() {
        balance = 0;
    }

    //public 메서드 : deposit - 입금
    public void deposit(int amount) {
        if(isAmountValid(amount)) {
            balance += amount;
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    //public 메서드 : withdraw - 출금
    public void withdraw(int amount) {
        if(isAmountValid(amount) && balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다.");
        }
    }

    //public 메서드 : getBalance - 잔고 확인
    public int getBalance() {
        return balance;
    }


    //private 메서드 : isAmountValid - 입력 금액을 검증하는 기능은 내부에서만 필요한 기능이다. 따라서 private를 사용했다.
    private boolean isAmountValid(int amount) {
        //금액이 0보다 커야함
        return amount > 0;
    }

    /**
     *  - 캡슐화를 안전하게 완성할 수 있게 해주는 장치 : 접근 제어자.
     *
     *    1. 데이터를 숨겨라 : 객체의 데이터는 객체가 제공하는 기능인 메서드를 통해서 접근해야 한다
     *    2. 기능을 숨겨라 : 사용자 입장에서 꼭 필요한 기능만 외부에 노출하자. 나머지 기능은 모두 내부로 숨기자.
     *
     *
     *  Q1.만약 isAmountValid() 를 외부에 노출하면 어떻게 될까?
     *     BankAccount 를 사용하는 개발자 입장에서는 사용할 수 있는 메서드가 하나 더 늘었다.
     *     여러분이 BankAccount 를 사용하는 개발자라면 어떤 생각을 할까?
     *     아마도 입금과 출금 전에 본인이 먼저 isAmountValid() 를 사용해서 검증을 해야 하나? 라고 의문을 가질 것이다.
     *
     *  Q2.만약 balance 필드를 외부에 노출하면 어떻게 될까?
     *     BankAccount 를 사용하는 개발자 입장에서는 이 필드를 직접 사용해도 된다고 생각할 수 있다.
     *     왜냐하면 외부에 공개하는 것은 그것을 외부에서 사용해도 된다는 뜻이기 때문이다.
     *     결국 모든 검증과 캡슐화가 깨지고 잔고를 무한정 늘리고 출금하는 심각한 문제가 발생할 수 있다.
     *
     *  접근 제어자와 캡슐화를 통해 데이터를 안전하게 보호하는 것은 물론이고, BankAccount 를 사용하는 개발자 입장에서 해당 기능을 사용하는 복잡도도 낮출 수 있다.
     * */
}
