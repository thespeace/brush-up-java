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
* InputStreamReader와 OutputStreamWriter은 Reader/Writer의 자손이다.
* InputStreamReader의 생성자와 메서드

| 생성자 / 메서드                                              | 설 명                                                      |
|--------------------------------------------------------|----------------------------------------------------------|
| InputStreamReader(InputStream in)                      | OS에서 사용하는 기본 인코딩의 문자로 변환하는 InputStream<br/>Reader를 생성한다. |
| InputStreamReader(InputStream in,<br/>String encoding) | 지정된 인코딩을 사용하는 InputStreamReader를 생성한다.                   |
| String getEncoding()                                   | InputStreamReader의 인코딩을 알려 준다.                           |
