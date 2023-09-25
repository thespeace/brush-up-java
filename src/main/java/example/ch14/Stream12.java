package example.ch14;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 *    - 스트림의 그룹화와 분할.
 *      Collectors의 메서드.
 *
 *          partitioningBy() 예제는 스트림을 2분할한다.
 *          {@code
 *              Collector partitioningBy(predicate predicate)
 *              Collector partitioningBy(predicate predicate, Collector downstream)
 *          }
 *
 *          groupingBy()는 스트림을 n분할한다.
 *          {@code
 *              Collector groupingBy(Function classifier)
 *              Collector groupingBy(Function classifier, Collector downstream)
 *              Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
 *          }
 *
 *
 *
 *    - 스트림의 분할 : partitioningBy()
 *
 *      {@code : Collectors의 메서드 구조.
 *          Collector partitioningBy(predicate predicate)
 *          Collector partitioningBy(predicate predicate, Collector downstream)
 *      }
 *
 *      {@code : 기본 사용 법.
 *          Map<Boolean, List<Student>> stuBySex = stuStream
 *                              .collect(partitioningBy(Student::isMale)); // 학생들을 성별(분할 기준)로 분할, boolean타입으로 map에 저장.
 *          List<Student> maleStudent   = stuBySex.get(true);  // Map에서 남학생 목록을 얻는다.
 *          List<Student> femailStudent = stuBySex.get(false); // Map에서 여학생 목록을 얻는다.
 *      }
 *
 *      {@code : counting() 사용, 분할 + 통계.
 *          Map<Boolean, Long> stuNumBySex = stuStream
 *                              .collect(partitioningBy(Student::isMale, Collectors.counting())); // counting()도 가능, 분할 + 통계.
 *          System.out.println("남학생 수 :" + stuNumBySex.get(true));  // 남학생 수 : 8
 *          System.out.println("여학생 수 :" + stuNumBySex.get(false)); // 여학생 수 : 10
 *      }
 *
 *      {@code : maxBy() 사용, 분할 + 통계.
 *          Map<Boolean, Optional<Student>> topScoreBySex = stuStream.
 *                              .collect(partitioningBy(Student::isMale, maxBy(comparingInt(Student::getScore)))); // maxBy()도 가능, 분할 + 통계
 *          System.out.println("남학생 1등 :" + topScoreBySex.get(true));  // 남학생 1등 : 8
 *          System.out.println("여학생 1등 :" + topScoreBySex.get(false)); // 여학생 1등 : 10
 *      }
 *
 *      {@code : 다중 분할
 *          Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex = stuStream
 *                              .collect(partitioningBy(Student::isMale,            // 1. 성별로 분할(남/녀)
 *                                       partitioningBy(s->s.getScore() < 150)));   // 2. 성적으로 분할(불합격/합격)
 *
 *          List<Student> failedMaleStu = failedStuBySex.get(true, get(true));     // 불합격한 남자.
 *          List<Student> failedFemaleStu = failedStuBySex.get(false, get(true));  // 불합격한 여자.
 *      }
 */
class Student2 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name	= name;
        this.isMale	= isMale;
        this.hak	= hak;
        this.ban	= ban;
        this.score  = score;
    }
    String	getName()    { return name;	}
    boolean  isMale()     { return isMale;	}
    int      getHak()     { return hak;	}
    int      getBan()     { return ban;	}
    int      getScore()   { return score;	}

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }
    // groupingBy()에서 사용
    enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
}

public class Stream12 {
    public static void main(String[] args){
            Student2[] stuArr = {
                    new Student2("나자바", true,  1, 1, 300),
                    new Student2("김지미", false, 1, 1, 250),
                    new Student2("김자바", true,  1, 1, 200),
                    new Student2("이지미", false, 1, 2, 150),
                    new Student2("남자바", true,  1, 2, 100),
                    new Student2("안지미", false, 1, 2,  50),
                    new Student2("황지미", false, 1, 3, 100),
                    new Student2("강지미", false, 1, 3, 150),
                    new Student2("이자바", true,  1, 3, 200),
                    new Student2("나자바", true,  2, 1, 300),
                    new Student2("김지미", false, 2, 1, 250),
                    new Student2("김자바", true,  2, 1, 200),
                    new Student2("이지미", false, 2, 2, 150),
                    new Student2("남자바", true,  2, 2, 100),
                    new Student2("안지미", false, 2, 2,  50),
                    new Student2("황지미", false, 2, 3, 100),
                    new Student2("강지미", false, 2, 3, 150),
                    new Student2("이자바", true,  2, 3, 200)
            };

            System.out.printf("1. 단순분할(성별로 분할)%n");
            Map<Boolean, List<Student2>> stuBySex =  Stream.of(stuArr) // stuArr -> Stream -> partitioningBy()로 성별로 분할하여 리스트에 담기.
                    .collect(partitioningBy(Student2::isMale));

            List<Student2> maleStudent   = stuBySex.get(true);  //남학생
            List<Student2> femaleStudent = stuBySex.get(false); //여학생

            for(Student2 s : maleStudent)   System.out.println(s);
            for(Student2 s : femaleStudent) System.out.println(s);


            System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
            Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                    .collect(partitioningBy(Student2::isMale, counting())); // counting().

            System.out.println("남학생 수 :"+ stuNumBySex.get(true));
            System.out.println("여학생 수 :"+ stuNumBySex.get(false));


            System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
            Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                    .collect(partitioningBy(Student2::isMale,
                            maxBy(comparingInt(Student2::getScore)) // maxBy().
                    ));
            System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
            System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

            Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                    .collect(partitioningBy(Student2::isMale,
                            collectingAndThen(
                                    maxBy(comparingInt(Student2::getScore)), Optional::get // Optional::get으로 Optional에 있는걸 꺼내서 Student2에 담기.
                            )
                    ));

            System.out.println("남학생 1등 :"+ topScoreBySex2.get(true));
            System.out.println("여학생 1등 :"+ topScoreBySex2.get(false));

            System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

            Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex =
                    Stream.of(stuArr).collect(partitioningBy(Student2::isMale, // key : value(map(map)) 형태.
                            partitioningBy(s -> s.getScore() <= 100))
                    );
            List<Student2> failedMaleStu   = failedStuBySex.get(true).get(true);
            List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

            for(Student2 s : failedMaleStu)   System.out.println(s);
            for(Student2 s : failedFemaleStu) System.out.println(s);
    }
}