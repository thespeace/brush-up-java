# 자바란?
   * 프로그래밍언어로 컴퓨터 프로그램(애플리케이션)을 만드는데 사용됩니다.
   * 기본적으로 JRE(실행환경)+ JDK(개발도구0) +API(라이브러리)를 제공합니다. 때문에 쉽고 빠르게 애플리케이션을 개발 가능합니다.
# 자바는 어디에 쓰이나요?
   * PC 애플리케이션(Eclipse, IntelliJ, Spring Boot)
   * 웹 애플리케이션(Website)
   * 모바일 애플리케이션(안드로이드)
   * 빅 데이터(Hadoop)
   * 게임(마인 크래프트), 과학, 소형기기 등
# 왜 자바인가요?
   * 다양한 분야에서 활발히 사용
   * 20년 동안 프로그래밍 언어 1,2위
   * 배우기 쉽고 풍부한 학습자료(전반적인 프로그래밍 지식 및 컴퓨터 관련 지식들)
   * 모던 프로그래밍 언어(객체지향 + 함수형)
   * 실무에서 가장 많이 사용하여 취업에 유리
# 자바의 역사
   * JDK 1.0(Jan 23, 1996) : 처음 발표
   * J2SE 1.2(Dec 8, 1998) : 큰 변화와 발전으로 인해 Java2로 불리움, 3가지 버전으로 나뉘어 출시
     1) J2SE(Standard Edition) : 가장 일반적인 자바
     2) J2ME(Micro Edition) : 모바일이나 소형기기에 사용하기 위한 버전
     3) J2EE(Enterprise Edition) : 큰 기업용 버전
   * J2SE 5.0(Sep 30, 2004) : 중요한 기능들이 추가되며 큰 변화
   * Java SE 8(Mar 18, 2014) : 5버전과 마찬가지로 중요기능 추가
   * 현재(Mar 31, 2023) Java 21버전까지 출시되었으며 11버전부터 6개월마다 버전발표를 하고 있습니다. 그전에는 2~3년마다 발표하는 하였는데 이렇게 버전 발표를 하는 이유는, 8버전 까지는 자바가 굉장히 많이 쓰이기 때문에 안정성의 이유로 새로운 기능들을 추가하는 것을 최대한 신중하게 검토했습니다. 9버전부터는 안정성도 중요하지만 트랜드에 맞춰 최신 기능들을 반영하기 위해서 빠르게 발표를 하고 있습니다. 하지만 핵심적인 기능들을 크게 변화하지 않고 있습니다. 실무에서는 8버전을 많이쓰고 있지만 최신기능을 사용하기위해 버전 업그레이드를 하는 추세가 되어가고 있습니다.
# 자바의 특징
   * 자동 메모리 관리 : 자바가 나오기 전까지는 프로그래머가 직접 메모리를 관리해주어야 했는데, 자바에서는 GC(가비지 컬렉터)가 메모리를 알아서 정리를 해줍니다.(메모리를 사용한 후 반환해주는 역할)
   * 멀티 쓰레드를 지원 : 하나의 프로그램에서 동시에 여러가지 작업을 가능하게 해줍니다.
   * 풍부한 라이브러리로 쉽게 개발 가능
   * **운영체제에 독립적** : 아래(JVM)에 설명
# 자바 가상 머신(JVM)
   * Java Virtual Machine, 자바 프로그램 실행환경을 만들어 주는 소프트웨어로 자바 프로그램이 실행되는 가상 컴퓨터입니다.
   * 자바 프로그램은 JVM위에서 실행이 되기때문에 OS와 독립적일 수 있습니다.
   * 한번 작성하면, 어디서든 실행(Write once, run anywhere)
# 자바 개발 도구의 설치와 설정
1. 자바 개발 도구(JDK) 설치[(Download jdk from Oracle Site)](https://www.oracle.com/java/technologies/downloads/#java11)
2. 통합 개발 환경 설치(eclipse or [STS](https://spring.io/tools) / [IntelliJ](https://www.jetbrains.com/ko-kr/idea/)) 
3. window) 시스템 환경 변수 > Path 편집 > 다운받은 JDK의 bin폴더를 추가하고 맨위로 올리기.
# 메모장을 이용하여 첫 번째 자바프로그램 작성
1. 메모장에 아래의 내용을 적고 확장자를 꼭 java로 작성하여 저장해줍니다.( ex : Hello.java)
```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world"); // 화면에 글자를 출력한다.
    }
}
```
2. cmd창을 열어 아래의 명령어들을 통해 프로그램을 실행시켜 봅시다.
```bash
cd Hello.java #실행 시키고자 하는 경로로 진입.
javac Hello.java #컴파일
dir #컴파일 된 파일인 .class 파일이 있는지 확인, 자바 버츄얼 머신이 알아들을 수 있는 기계어로 변환(컴파일)된 것입니다.
type Hello.java #바이너리파일, 이진파일로 사람이 알아볼 수 없는 언어로 되어있는 것을 확인.
type Hello.java #사람이 알아들을 수 있는 텍스트파일을 확인.
java Hello #실행할때는 확장자를 붙이지 않습니다. 프로그램 실행. 해당 코드가 출력된다.
```
* 만일 위의 과정 중 컴파일 할때 에러가 발생하게 되는 것을 **컴파일 에러**라고 하며, 컴파일이 되지 않습니다. 컴파일러가 어디서 어떤 에러가 발생했는지 알려줍니다.
* 자바에서는 대문자와 소문자를 구별하기 때문에 주의해야 하며, 오타로 인한 오류메시지는 "**cannot find symbol**"입니다.
* 1. javac.exe : **자바 컴파일러**, 사람이 작성한 문장을 기계어로 번역, 소스 파일(.java)을 클래스 파일(.class)로 변환
  2. java.exe : **자바 인터프리터**, 자바 프로그램(클래스 파일)을 실행
  3. 클래스 : 자바 프로그램의 단위, 자바 프로그램은 클래스들로 구성되어야 하며, 자바 프로그램은 최소한 하나 이상의 클래스로 이루어져야 합니다. 그리고 자바의 모든 문장들은 클래스의 { } 안에 있어야 합니다.
     * { : 클래스의 시작
     * } : 클래스의 끝
  4. main메서드 : 자바 프로그램의 시작점으로 이 메서드없이는 실행이 불가합니다. 인터프리터(java.exe)가 지정한 클래스파일의 main 메서드를 찾아서 **첫 문장부터 순서대로 실행**되고, 모든 문장을 수행하면 프로그램이 종료됩니다. 