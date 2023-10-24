# 문자기반의 보조스트림
## 1. BufferedReader와 BufferedWriter
* BufferedReader/BufferedWriter는 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할을 한다. 버퍼를 이용하면 입출력의 효율이 비교할 수 없을 정도로 좋아지기 때문에 사용하는 것이 좋다.
* BufferedReader의 readLine()을 사용하면 데이터를 라인단위로 읽을 수 있고 BufferedWriter는 newLine()이라는 줄바꿈 해주는 메서드를 가지고 있다.
  > BufferedReader을 이용한 간단한 예제 : [InputOutput06_Ex01.java](./InputOutput06_Ex01.java)