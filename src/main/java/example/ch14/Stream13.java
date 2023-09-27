package example.ch14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 *    - 스트림의 그룹화(N분할) 스트림의 N분할
 *      groupingBy()
 *
 *          {@code : 스트림의 요소를 그룹화.
 *              Collector groupingBy(Function classifier)
 *              Collector groupingBy(Function classifier, Collector downstream)
 *              Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
 *          }
 *          {@code : 학생을 반별로 그룹화.
 *              Map<Integer, List<Student>> stuByBan = stuStream
 *                              .collect(groupingBy(Student::getBan, toList())); // toList() 생략가능.
 *          }
 *          {@code : 다중 그룹화
 *              Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = stuStream
 *                              .collect(groupingBy(Student::getHak,    // 1. 학년별 그룹화
 *                                       groupingBy(Student::getBan)    // 2. 반별 그룹화
 *                              ));
 *          }
 *          {@code : 다중 그룹화(mapping()사용)
 *              Map<Integer, Map<Integer, Set<Student, Level>>> stuByHakAndBan = stuStream
 *                  .collect(
 *                      groupingBy(Student::getHak, groupingBy(Student::getBan,
 *                          mapping(s-> {                                                   // 성적등급(Level)으로 변환. List<Student> -> Set(Student.Level>
 *                              if     (s.getScore() >= 200) return Student.Level.HIGH;
 *                              else if(s.getScore() >= 100) return Student.Level.MID;
 *                              else                         return Student.Level.LOW;
 *                          } , toSet())   //mapping()     // enum Level { HIGH, MID, LOW }
 *                      ))  // groupingBy()
 *                  ); // collect()
 *          }
 */

class Student3 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    Student3(String name, boolean isMale, int hak, int ban, int score) {
        this.name	= name;
        this.isMale	= isMale;
        this.hak   	= hak;
        this.ban	= ban;
        this.score 	= score;
    }

    String	getName() 	 { return name;    }
    boolean isMale()  	 { return isMale;  }
    int		getHak()   	 { return hak;	   }
    int		getBan()  	 { return ban;	   }
    int		getScore()	 { return score;   }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    enum Level {
        HIGH, MID, LOW
    }
}

public class Stream13 {
    public static void main(String[] args){
        Student3[] stuArr = {
                new Student3("나자바", true,  1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true,  1, 1, 200),
                new Student3("이지미", false, 1, 2, 150),
                new Student3("남자바", true,  1, 2, 100),
                new Student3("안지미", false, 1, 2,  50),
                new Student3("황지미", false, 1, 3, 100),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true,  1, 3, 200),
                new Student3("나자바", true,  2, 1, 300),
                new Student3("김지미", false, 2, 1, 250),
                new Student3("김자바", true,  2, 1, 200),
                new Student3("이지미", false, 2, 2, 150),
                new Student3("남자바", true,  2, 2, 100),
                new Student3("안지미", false, 2, 2,  50),
                new Student3("황지미", false, 2, 3, 100),
                new Student3("강지미", false, 2, 3, 150),
                new Student3("이자바", true,  2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student3::getBan));

        for(List<Student3> ban : stuByBan.values()) {
            for(Student3 s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                    if(s.getScore() >= 200) return Student3.Level.HIGH;
                    else if(s.getScore() >= 100) return Student3.Level.MID;
                    else                         return Student3.Level.LOW;
                }));

        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet()); // 그룹별 출력을 위해 TreeSet 이용.

        for(Student3.Level key : keySet) {
            System.out.println("["+key+"]");

            for(Student3 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                    if(s.getScore() >= 200) return Student3.Level.HIGH;
                    else if(s.getScore() >= 100) return Student3.Level.MID;
                    else                         return Student3.Level.LOW;
                }, counting()));    //counting().
        for(Student3.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();
/*
		for(List<Student3> level : stuByLevel.values()) {
			System.out.println();
			for(Student3 s : level) {
				System.out.println(s);
			}
		}
*/
        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan)
                        ));

        for(Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
            for(List<Student3> ban : hak.values()) {
                System.out.println();
                for(Student3 s : ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
                Stream.of(stuArr)
                       .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(Student3::getScore)) // maxBy().
                                                , Optional::get // Optional에서 꺼내서 결과를 출력.
                                        )
                                )
                       ));

        for(Map<Integer, Student3> ban : topStuByHakAndBan.values())
            for(Student3 s : ban.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),      // 문자열 생성 후 그룹핑.
                        mapping(s-> {
                            if(s.getScore() >= 200) return Student3.Level.HIGH;
                            else if(s.getScore() >= 100) return Student3.Level.MID;
                            else                    return Student3.Level.LOW;
                        } , toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("["+key+"]" + stuByScoreGroup.get(key));
        }
    }
}