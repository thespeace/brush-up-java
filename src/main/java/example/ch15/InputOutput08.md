# 직렬화(Serialization)
#### 직렬화는 객체를 컴퓨터에 저장했다가 다음에 다시 꺼내 쓸 수 있고, 네트워크를 통해 컴퓨터 간에 서로 객체를 주고받을 수 있는 것을 가능하게 해준다.
## 1. 직렬화란?
* 직렬화(Serialization)란 객체를 데이터 스트림으로 만드는 것을 뜻한다. 다시 얘기하면 객체에 저장된 데이터를 스트림에 쓰기(write)위해 연속적인(serial) 데이터로 변환하는 것을 말한다.
* 반대로 스트림으로부터 데이터를 읽어서 객체를 만드는 것을 역직렬화(deserialization)라고 한다.
* 객체를 저장하거나 전송하려면 당연히 직렬화를 할 수 밖에 없는데, 여기서 객체란 무엇이며 객체를 저장한다는 것은 무엇을 의미하는가에 대해서 다시 한 번 정리하고 넘어가는 것이 좋다.
  * 객체는 클래스에 정의된 인스턴스변수의 집합이다. 객체에는 클래스변수나 메서드가 포함되지 않는다. 객체는 오직 인스턴스변수들로만 구성되어 있다.
  * 객체를 생성하면 사실 메서드는 포함되지 않고 인스턴스변수만 포함한다. 인스턴스변수는 인스턴스마다 다른 값을 가질 수 있어야 하기 때문에 별도의 메모리공간이 필요하지만 메서드는 변하는 것이 아니라서 메모리를 낭비해 가면서 인스턴스마다 같은 내용의 코드(메서드)를 포함시킬 이유는 없다.
  * 위 내용이 잘 이해가 되지 않는다면 인스턴스 메서드와 static 메서드의 차이에 대해서 더 알아보고 오자.
* 그래서 객체를 저장한다는 것은 바로 객체의 모든 인스턴스 변수의 값을 저장한다는 것과 같은 의미이다. 어떤 객체를 저장하고자 한다면, 현재 객체의 모든 인스턴스변수의 값을 저장하기만 하면 된다. 그리고 저장했던 객체를 다시 생성하려면, 객체를 생성한 후에 저장했던 값을 읽어서 생성한 객체의 인스턴스변수에 저장하면 되는 것이다.
* 클래스에 정의된 인스턴스변수가 단순히 기본형일 때는 인스턴스변수의 값을 저장하는 일이 간단하지만, 인스턴스변수의 타입이 참조형 일 때는 그리 간단하지 않다. 예를 들어 인스턴스변수의 타입이 배열이라면 배열에 저장된 값들도 모두 저장되어야할 것이다.
* 그러나 우리는 객체를 어떻게 직렬화해야 하는지 전혀 고민하What is serialization?지 않아도 된다. 다만 객체를 직렬화/역직렬화할 수 있는 ObjectInputStream과 ObjectOutputStream을 사용하는 방법만 알면 된다.
<br>
+두 객체가 동일한지 판단하는 기준이 두 객체의 인스턴스변수의 값들이 같고 다름이라는 것을 상기하자.

***

## 2. ObjectInputStream, ObjectOutputStream.
* 직렬화(스트림에 객체를 출력)에는 ObjectOutputStream을 사용하고 역직렬화(스트림으로부터 객체를 입력)에는 ObjectInputStream을 사용한다.
* 각각 InputStream과 OutputStream을 직접 상속받지만 기반스트림을 필요로 하는 보조스트림이다. 그래서 객체를 생성할 때 입출력(직렬화/역직렬화)할 스트림을 지정해주어야 한다.
  ```java
  ObjectInputStream(InputStream in)
  ObjectOutputStream(OutputStream out)
  ``` 
<br>

* 만일 파일에 객체를 저장(직렬화)하고 싶다면 다음과 같이 하면 된다.
  ```java
  FileOutputStream fos = new FileOutputStream("objectfile.ser");
  ObjectOutputStream = new ObjectOutputStream(fos);
  
  out.writeObject(new UserInfo());
  // 위 코드는 objectFile.ser이라는 파일에 UserInfo객체를 직렬화하여 저장한다. 
  // 출력할 스트림(FileOutputStream)을 생성해서 이를 기반스트림으로 하는 ObjectOutputStream을 생성한다.
  // ObjectOutputStream의 writeObject(Object obj)를 사용해서 객체를 출력하면, 객체가 파일에 직렬화되어 저장된다.
  ```
<br>

* 역직렬화 방법 역시 간단하다. 직렬화할 때와는 달리 입력스트림을 사용하고 writeObject(Object obj)대신 readObject()를 사용하여 저장된 데이터를 읽기만 하면 객체로 역직렬화된다.
* 다만 readObject()의 반환타입이 Object이기 때문에 객체 원래의 타입으로 형변환 해주어야 한다.
  ```java
  FileInputStream fis = new FileInputStream("objectfile.ser");
  ObjectInputStream in = new ObjectInputStream(fis);
  
  UserInfo info = (UserInfo)in.readObject();
  ```

<br>

* ObjectInputStream과 ObjectOutputStream의 메서드

  | ObjectInputStream                      | ObjectOutputStream                       |
  |----------------------------------------|------------------------------------------|
  | void defaultReadObject()               | void defaultWriteObject()                |
  | int read()                             | void write(byte[] buf)                   |
  | int read(byte[] buf, int off, int len) | void write(byte[] buf, int off, int len) |
  | boolean readBoolean()                  | void write(int val)                      |
  | byte readByte()                        | void writeBoolean(boolean val)           |
  | char readChar()                        | void writeByte(int val)                  |
  | double readDouble()                    | void writeBytes(String str)              |
  | float readFloat()                      | void writeChar(int val)                  |
  | int readInt()                          | void writeChars(String str)              |
  | long readLong()                        | void writeDouble(double val)             |
  | short readShort()                      | void writeFloat(float val)               |
  | Object readObject()                    | void writeInt(int val)                   |
  | int readUnsignedByte()                 | void writeLong(long val)                 |
  | int readUnsignedShort()                | void writeObject(Object obj)             |
  | Object readUnshared()                  | void writeShort(int val)                 |
  | String readUTF()                       | void writeUnshared(Object obj)           |
  |                                        | void writeUTF(String str)                |

* 이 메서드들은 직렬화와 역직렬화를 직접 구현할 때 주로 사용되며, defaultReadObject()와 defaultWriteObject()는 자동 직렬화를 수행한다.
* 객체를 직렬화/역직렬화하는 작업은 객체의 모든 인스턴스변수가 참조하고 있는 모든 객체에 대한 것이기 때문에 상당히 복잡하며 시간도 오래 걸린다. readObject()와 writeObject()를 사용한 자동 직렬화가 편리하기는 하지만 직렬화 작업시간을 단축시키려면 직렬화하고자 하는 개체의 클래스에 추가적으로 다음과 같은 2개의 메서드를 직접 구현해주어야 한다.
  ```java
  private void writeObject(ObjectOutputStream out) throws IOException {
    // write메서드를 사용해서 직렬화를 수행한다.
  }
  
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    // read메서드를 사용해서 역직렬화를 수행한다.
  }
  
  // 위 메서드에 대한 구현은 나중에 예제를 통해 자세히 알아보자
  ```

<br>

***

## 3. 직렬화가 가능한 클래스 만들기 : Serializable, transient
<br>

* 직렬화가 가능한 클래스를 만드는 방법은 간단하다. 직렬화하고자 하는 클래스가 java.io.Serializable인터페이스를 구현하도록 하면 된다.
  ```java
    public class UserInfo {
        String name;
        String password;
        int age;
    }
  
    //위의 UserInfo라는 클래스가 있을 때, 이 클래스를 직렬화 가능하도록 변경-
    public class UserInfo implements java.io.Serializable {
        String name;
        String password;
        int age;
    }
  ```
  <br>
* Serializable 인터페이스는 아무런 내용도 없는 빈 인터페이스지만, 직렬화를 고려하여 작성한 클래스인지를 판단하는 기준이 된다.
  ```java public interface Serialzable { }``` 
* Serializable을 구현한 클래스를 상속받는다면, Serializable을 구현하지 않아도 된다.
  ```java
  // UserInfo는 Serializable을 구현하지 않았지만 조상인 SuperUserInfo가 Serializable을 구현하였으므로 UserInfo역시 직렬화가 가능하다.
  public class SuperUserInfo implements Serializable {
    String name;
    String password;
  }
  public class UserInfo extends SuperUserInfo {
    int age;
  }
  // UserInfo객체를 직렬화하면 조상인 SuperUserInfo에 정의된 인스턴스변수 name, password도 함께 직렬화된다.
  ```
  <br>
* 다음과 같이 조상클래스가 Serializable을 구현하지 않았다면 자손클래스를 직렬화할 때, 조상클래스에 정의된 인스턴스변수 name과 password는 직렬화 대상에서 제외된다.
  ```java
  public class SuperUserInfo {
    String name;
    String password;
  }
  public class UserInfo extends SuperUserInfo implements Serializable {
    int age;
  }
  // 조상클래스에 정의된 인스턴스변수 name과 password를 직렬화 대상에 포함시키기 위해서는 조상클래스가 Serializable을 구현하도록 하던가, 
  // UserInfo에서 조상의 인스턴스변수들이 직렬화되도록 처리하는 코드를 직접 추가해 주어야한다. 직접 추가하는 방법은 추후에 살펴보자.
  ```
  <br>
* java.io.NotSerializableException이 발생하면서 직렬화에 실패하는 코드.
  ```java
  public class UserInfo implements Serializable {
    String name;
    String password;
    int age;
  
    Object obj = new Object(); // Object객체는 직렬화할 수 없다.
  }
  // 직렬화할 수 없는 클래스의 객체를 인스턴스변수가 참조하고 있기 때문에 직렬화에 실패했다.
  // 모든 클래스의 최고조상인 Object는 Serializable을 구현하지 않았기 때문에 직렬화할 수 없다.
  // 만일 Object가 Serializable을 구현했다면 모든 클래스가 직렬화 될 수 있을 것이다.
  ```
  <br>
* 위의 경우와 비교해서 다음과 같은 경우에는 직렬화가 가능하다.
  ```java
  public class UserInfo implements Serializable {
    String name;
    String password;
    int age;
  
    Object obj = new String("abc"); // String은 직렬화될 수 있다.
  } 
  // 인스턴스변수 obj의 타입이 직렬화가 안 되는 Object이긴 하지만 실제로 저장된 객체는
  // 직렬화가 가능한 String인스턴스이기 때문에 직렬화가 가능하다.
  // 인스턴스변수의 타입이 아닌 실제로 연결된 객체의 종류에 의해서 결정된다는 것을 기억하자.
  ```
  <br>
* 직렬화하고자 하는 객체의 클래스에 직렬화가 안 되는 객체에 대한 참조를 포함하고 있다면, 제어자 transient를 붙여서 직렬화 대상에서 제외되도록 할 수 있다. 또는 password와 같이 보안상 직렬화되면 안 되는 값에 대해서 transient를 사용할 수 있다. 다르게 표현하면 transient가 붙은 인스턴스변수의 값은 그 타입의 기본값으로 직렬화된다고 볼 수 있다.
  ```java
  public class UserInfo implements Serializable {
    String name;
    transient String password; // 직렬화 대상에서 제외된다.
    int age;
  
    transient Object obj = new Object(); // 직렬화 대상에서 제외된다.
  }  
  // UserInfo객체를 역직렬화하면 참조변수인 obj와 password의 값은 null이 된다.
  ```

> UserInfo 예제를 위한 클래스 소스 : [InputOutput08_Ex01.java](./InputOutput08_Ex01.java)\
> 객체를 직렬화하여 파일에 저장하는 예제 : [InputOutput08_Ex02.java](./InputOutput08_Ex02.java)\
> 직렬화된 객체 파일을 역직렬화하는 예제 : [InputOutput08_Ex03.java](./InputOutput08_Ex03.java)\
> 직렬화되지 않는 조상으로부터 상속받은 인스턴스변수에 대한 직렬화를 구현한 예제 : [InputOutput08_Ex04.java](./InputOutput08_Ex04.java)