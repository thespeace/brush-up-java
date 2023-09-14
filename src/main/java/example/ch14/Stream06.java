package example.ch14;

import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream06 {
    public static void main(String[] args){

        /*    - 스트림의 중간연산(5/7)
                스트림의 요소 변환하기 - map()     */

        // Stream<R> map(Function<? super T, ? extends R> mapper) // Stream<T> -> stream<R>

        //Stream<File>객체를 map((File f)-> f.getName())을 통해 Stream<String>객체로 변환.
        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));
        Stream<String> fileNameStream = fileStream.map(File::getName); // (f)->f.getName();
        fileNameStream.forEach(System.out::println); // 스트림의 모든 파일의 이름을 출력.

        // ex) 파일 스트림(Stream<File>)에서 파일 확장자(대문자)를 중복없이 뽑아내기.
        Stream<File> fileStream1 = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));
        fileStream1.map(File::getName)                           // Stream<File> -> Stream<String>
                .filter(s->s.indexOf(".")!=-1)                   // 파일 이름 전체에서 확장자가 없는 것은 제외
                .map(s->s.substring(s.indexOf(".")+1)) // Stream<String> -> Stream<String>, 확장자만 추출.
                .map(String::toUpperCase)                        // Stream<String> -> Stream<String>, 모두 대문자로 변환.
                .distinct()
                .forEach(System.out::println); // JAVABAKTXT



        /*    - 스트림의 중간연산(6/7)
                스트림의 요소를 소비하지 않고 엿보기 - peek()     */

        // Stream<T> peek(Consumer<? super T> action)    // 중간 연산(스트림을 소비X)
        // void      forEach(Consumer<? super T> action) // 최종 연산(스트림을 소비O)

        Stream<File> fileStream2 = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1.txt"));
        fileStream2.map(File::getName)                           // Stream<File> -> Stream<String>
                .filter(s->s.indexOf(".")!=-1)                   // 파일 이름 전체에서 확장자가 없는 것은 제외
                .peek(s-> System.out.printf("filename=%s%n", s)) // 중간 작업 결과 확인, 중간 중간에 디버깅 용도로 사용된다.
                .map(s->s.substring(s.indexOf(".")+1)) // Stream<String> -> Stream<String>, 확장자만 추출.
                .peek(s-> System.out.printf("extension=%s%n", s)) // 중간 작업 결과 확인, 중간 중간에 디버깅 용도로 사용된다.
                .map(String::toUpperCase)                        // Stream<String> -> Stream<String>, 모두 대문자로 변환.
                .distinct()
                .forEach(System.out::println); // JAVABAKTXT



        /*    - 스트림의 중간연산(7/7)
                스트림의 스트림을 스트림으로 변환 - flatMap()     */
        Stream<String[]> strArrStrm = Stream.of(new String[]{"abc", "def", "ghi"} , new String[]{"ABC", "GHI", "JKLMN"});

        // Stream<String[]> --> Stream<Stream<String>>.
//        Stream<Stream<String>> strStrStrrm = strArrStrm.map(Arrays::stream);

        // 여러개의 문자열 배열을 하나의 문자열 배열인 것 처럼 변환하는 것.
        // Stream<String[]> --> Stream<String>.
        Stream<String> strStrStrm = strArrStrm.flatMap(Arrays::stream); // Arrays.stream(T[])


        Stream<String[]> strArrStrm1 = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm1.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)        // 스트림의 요소를 모두 소문자로 변경.
                .distinct()     // 중복 제거
                .sorted()       // 정렬
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try",
        };

        // 문자열 배열이 있을 때, 단어 하나 하나를 스트림의 요소( Stream<String> )로 만들기.
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // line.split(" +") : 문자열을 하나 이상의 공백으로 나눈다.(정규식으로 1개 이상의 공백을 캐치한다.)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }
}