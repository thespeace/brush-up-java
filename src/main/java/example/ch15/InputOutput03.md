## FileInputStream과 FileOutputStream
* FileInputStream/FileOutputStream은 파일에 입출력을 하기 위한 스트림으로 실제 프로그래밍에서 많이 사용되는 스트림 중의 하나이다.
* FileInputStream과 FileOutputStream의 생성자

    | 생성자                                              | 설 명                                                                                                                                           |
    |--------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
    | FileInputStream(String name)                     | 지정된 파일이름(name)을 가진 실제 파일과 연결된 FileInput<br>Stream을 생성한다.                                                                                      |
    | FileInputStream(File file)                       | 파일의 이름이 String이 아닌 File인스턴스로 지정해주어야 하<br>는 점을 제외하고 FileInputStream(String name)와 같다.                                                          |
    | FileInputStream(FileDescriptor fdObj)            | 파일 디스크립터(fdObj)로 FileInputStream을 생성한다.                                                                                                       |
    | FileOutputStream(String name)                    | 지정된 파일이름(name)을 가진 실제 파일과의 연결된 File<br>OutputStream을 생성한다.                                                                                    |
    | FileOutputStream(String name, boolean<br>append) | 지정된 파일이름(name)을 가진 실제 파일과 연결된 File<br>OutputStream을 생성한다. 두번째 인자인 append를 true로<br>하면, 출력 시 기존의 파일내용의 마지막에 덧붙인다. false면,<br>기존의 파일내용을 덮어쓰게 된다. |
    | FileOutputStream(File file)                      | 파일의 이름을 String이 아닌 File인스턴스로 지정해주어야 하<br>는 점을 제외하고 FileOutputStream(String name)과 같다.                                                         |
    | FileOutputStream(File file, boolean<br/>append)  | 파일의 이름을 String이 아닌 File인스턴스로 지정해주어야 하<br/>는 점을 제외하고 FileOutputStream(String name, boolean<br/>append)과 같다.                                    |
    | FileOutputStream(FileDescriptor fdObj)           | 파일 디스크립터(fdObj)로 FileOutputStream을 생성한다.                                                                                                      |

