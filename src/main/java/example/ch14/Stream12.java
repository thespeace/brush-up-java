package example.ch14;

/**
 *    - 스트림의 그룹화와 분할.
 *      Collectors의 메서드.
 *
 *          partitioningBy()는 스트림을 2분할한다.
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

public class Stream12 {
    public static void main(String[] args){

    }
}