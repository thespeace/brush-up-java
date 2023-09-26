package example.ch14;

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

public class Stream13 {
    public static void main(String[] args){
    }
}