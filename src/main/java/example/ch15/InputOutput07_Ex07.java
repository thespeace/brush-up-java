package example.ch15;

import java.io.*;

/**
 *      - File인스턴스를 생성하고 메서드를 이용해서 파일의 경로와 구분자 등의 정보를 출력하는 예제.
 */

public class InputOutput07_Ex07 {
    public static void main(String[] args) throws IOException {

        File f = new File("c:\\jdk1.8\\work\\ch15\\InputOutput07_Ex07.java"); // 파일의 경로.
//      File dir = new File("c:\\jdk1.8\\work\\ch15");
//      File f = new File(dir, "InputOutput07_Ex07.java");

        String fileName = f.getName();
        int pos = fileName.lastIndexOf(".");

        System.out.println("경로를 제외한 파일이름 - " + f.getName());
        System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0,pos));
        System.out.println("확장자 - " + fileName.substring(pos+1));

        /*
         * 절대 경로(absolute path)는 파일시스템의 루트(root)로부터 시작하는 파일의 전체 경로를 의미한다. OS에 따라 다르지만, 하나의 파일에 대해
         * 둘 이상의 절대경로가 존재할 수 있다. 현재 디렉토리를 의미하는 '.'와 같은 기호나 링크를 포함하고 있는 경우가 이에 해당 한다.
         * 그러나 정규경로(canonical path)는 기호나 링크 등을 포함하지 않는 유일한 경로를 의미한다.
         */
        System.out.println("경로를 포함한 파일이름 - " + f.getPath());
        System.out.println("파일의 절대경로 - " + f.getAbsolutePath());
        System.out.println("파일의 정규경로 - " + f.getCanonicalPath());
        System.out.println("파일이 속해 있는 디렉토리 - " + f.getParent());
        System.out.println();
        System.out.println("File.pathSeparator - " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
        System.out.println("File.separator - " + File.separator);
        System.out.println("File.separatorChar - " + File.separatorChar);
        System.out.println();
        System.out.println("user.dir=" + System.getProperty("user.dir")); //현재 프로그램이 실행 중인 디렉토리.

        // OS에서 시스템변수로 설정하는 classpath외에 sun.boot.class.path라는 시스템속성에 기본적인 classpath가 있어서
        // 기존적인 경로들은 이미 설정되어 있다. 그래서 JDK설치 후 classpath를 따로 지정해주지 않아도 되는 것이다.
        // 이 속성은 JDK1.2이후부터 추가된 것이라 그 이전의 버전에서는 rt.jar와 같은 파일을 classpath에 지정해주어야 했다.
        System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));



        /*
         * 한 가지 더 알아두어야 할 것은 File인스턴스를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다.
         * 파일명이나 디렉토리명으로 지정된 문자열이 유효하지 않더라도 컴파일 에러나 예외를 발생시키지 않는다.
         * 새로운 파일을 생성하기 위해서는 File인스턴스를 생성한 다음, 출력스트림을 생성하거나 creatNewFile()을 호출해야한다.
         */
        // 1. 이미 존재하는 파일을 참조할 때
//        File f = new File("c:\\jdk1.8\\work\\ch15\\InputOutput07_Ex07.java");
        // 2. 기존에 없는 파일을 새로 생성할 때
//        File f = new File("c:\\jdk1.8\\work\\ch15\\InputOutput07_Ex07.java");
//        f.createNewFile(); // 새로운 파일이 생성된다.
    }
}