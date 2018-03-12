**Enum Utility**
----------------

\-`jdk 8`

\-`no dependency`

Enum은 상태정보를 저장하기에 좋은 class이다. 특히, Status Pattern이 필요하거나 상태를 그루핑할 때에 많이 사용한다. 하지만, Enum을 단순히 상태만 표기하는 경우도 있겠지만, Code나 Value등의 매핑정보가 필요한 경우를 같이 담아두는 경우도 많다. 특히, DATABASE에 입력하거나, View에 보여줄 경우에 이러한 경우가 많다.

-	아래의 소스는 Enum을 사용하는 간단한 예시이다.

```
enum Status {
    READY(1),
    BIGIN(2),
    END(3);

    final int id;
    Status(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
```

Enum에서는 `Enum.valueOf`을 사용하여 이름으로 Constant를 가져오는 static method를 제공한다.
 - `Status.valueOf("READY") == Status.READY`

하지만, id를 사용하여 Constant를 가져오는 메소드는 없다. 하여, 자바8의 Functional Interface를 사용하여, Enum Constant를 가져오는 Utility를 만들었다.

```
@Test
public void firstConstant() throws Exception {
  Status status = EnumConstants.findFirst(Status.class, e -> e.getId()==1).get();
  assertThat(status, is(Status.READY));
}
```

또한, Enum은 abstract class를 만들수 없어, 공통화 작업은 interface로 해야한다. 가장 많이 쓸것 같은 Code, Value에 관한 interface를 3종류 추가한다.

 - `EnumCode`
 - `EnumValue`
 - `EnumValues`
