# 문자기반의 보조스트림
## 1. BufferedReader와 BufferedWriter
* BufferedReader/BufferedWriter는 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할을 한다. 버퍼를 이용하면 입출력의 효율이 비교할 수 없을 정도로 좋아지기 때문에 사용하는 것이 좋다.
* BufferedReader의 readLine()을 사용하면 데이터를 라인단위로 읽을 수 있고 BufferedWriter는 newLine()이라는 줄바꿈 해주는 메서드를 가지고 있다.
  > BufferedReader을 이용한 간단한 예제 : [InputOutput06_Ex01.java](./InputOutput06_Ex01.java)

<br>

---
## 2. InputStreamReader와 OutputStreamWriter
* InputStreamReader/OutputStreamWriter는 이름에서 알 수 있는 것과 같이 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할을 한다.
* 바이트기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환하는 작업을 수행한다.
* InputStreamReader와 OutputStreamWriter은 Reader/Writer의 자손이다.<br><br>
* InputStreamReader의 생성자와 메서드

  | 생성자 / 메서드                                              | 설 명                                                      |
  |--------------------------------------------------------|----------------------------------------------------------|
  | InputStreamReader(InputStream in)                      | OS에서 사용하는 기본 인코딩의 문자로 변환하는 InputStream<br/>Reader를 생성한다. |
  | InputStreamReader(InputStream in,<br/>String encoding) | 지정된 인코딩을 사용하는 InputStreamReader를 생성한다.                   |
  | String getEncoding()                                   | InputStreamReader의 인코딩을 알려 준다.                           |
<br>

* OutputStreamWriter의 생성자와 메서드

  | 생성자 / 메서드                                                 | 설 명                                                       |
  |-----------------------------------------------------------|-----------------------------------------------------------|
  | OutputStreamWriter(OutputStream out)                      | OS에서 사용하는 기본 인코딩의 문자로 변환하는 Output<br/>StreamWriter를 생성한다. |
  | OutputStreamWriter(OutputStream out,<br/>String encoding) | 지정된 인코딩을 사용하는 OutputStreamWriter를 생성한다.                   |
  | String getEncoding()                                      | OutputStreamWriter의 인코딩을 알려 준다.                           |
<br>

* 한글윈도우에서 중국어로 작성된 파일을 읽을 때 InputStreamReader(InputStream in, String encoding)을 이용해서 인코딩이 중국어로 되어 있다는 것을 지정해주어야 파일의 내용이 깨지지 않고 올바르게 보일 것이다. 인코딩을 지정해 주지 않는다면 OS에서 사용하는 인코딩을 사용해서 파일을 해석해서 보여 주기 때문에 원래 작성된 데로 볼 수 없을 것이다.
* 이와 마찬가지로 OutputStreamWriter를 이용해서 파일에 텍스트데이터를 저장할 때 생성자 OutputStreamWriter(OutputStream out, String encoding)를 이용해서 인코딩을 지정하지 않으면 OS에서 사용하는 인코딩으로 데이터를 저장할 것이다.
  ```java
  // 시스템 속성에서 sun.jnu.encoding의 값을 보면 OS에서 사용하는 인코딩의 종류를 알 수 있다.
  Properties prop = System.getProperties();
  System.out.println(prop.get("sun.jnu.encoding"));
  ```

  > InputStreamReader를 이용한 간단한 예제 : [InputOutput06_Ex02.java](./InputOutput06_Ex02.java)