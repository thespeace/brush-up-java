package example.ch07;

public class Inheritance06 {
    public static void main(String[] args){
        /**
         *    - 패키지(package)
         *      서로 관련된 클래스의 묶음 ex) Java 8 기준으로 약 4000개의 클래스가 존재한다. 관리를 위해 작은 단위로 나누어서 저장하기 위해 생긴것이 package이다.
         *      클래스를 컴파일하면 클래스 파일(*.class), 마찬가지로 패키지는 폴더. 하위 패키지는 하위 폴더라고 합니다.
         *      클래스의 실제 이름(full name)은 패키지를 포함합니다.(java.lang.String)
         *      rt.jar(runtime : 실행할때, 실행중을 의미 / jar : 클래스파일 묶어놓은 것을 의미.)는 클래스들을 압축한 파일로 자바 프로그램을 실행하는 데에 필요한 클래스들을 묶어놓은 파일.(JDK설치경로\jre\lib에 위치)
         *          -> java 9부터는 rt.jar파일을 모듈(module)개념으로 대체. rt.jar파일의 용량이 커서 작은 모듈로 나누어 모듈로 저장.
         *
         *    - 패키지의 선언
         *      패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
         *          ex) package 프로젝트명/경로/...;  -> 구체적인 예시 : package com.example.ch07; -실행-> c:\jdk1.8\work> java com.example.ch07.Inheritance06
         *      같은 소스 파일의 클래스들은 모두 같은 패키지에 속하게 된다.
         *      패키지 선언이 없으면 이름없는(unnamed)패키지(default package)에 속하게 된다.
         *
         *    - 클래스 패스(classpath)
         *      클래스 파일(*.class)의 위치를 알려주는 경로(path), 패키지 루트로 이동하지 않고도 어느곳에서나 클래스패스를 통해놓은 클래스파일을 자바로 실행할 수 있게 할 수 있다.
         *      환경변수(O.S 랩에서 관리하는 변수) classpath로 관리(게시판>시스템 변수 편집)하며, 경로간의 구분자는 ';'를 사용. 여러 경로를 등록 가능하다.
         *          ex) O.S 환경변수를 등록한 후, cmd창 : set classpath=경로.
         *      classpath(환경변수)에 패키지의 루트를 등록줘야 한다.
         */

    }
}
