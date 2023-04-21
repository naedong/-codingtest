# 연습문제

* 문제 내용
```
문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.

먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.

이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 
처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.

s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.

만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.

제한사항
1 ≤ s의 길이 ≤ 10,000
s는 영어 소문자로만 이루어져 있습니다.
```


## 문자열 나누기

```kotlin
    // 정답 변수
    var answer  = 0
    // 값을 비교하기 위한 배열
    // 문제 내용에 글자의 횟수를 각각 셉니다 라는 내용이 있기에 필수 
    var arr = intArrayOf(0, 0)
    // 단어 확인을 하기 위한 체크 
    var check = ' '
    for(n in 0 until s.length)
    {
       if(check == ' ') check = s.get(n)
       if(check == s.get(n)) ++ arr[0]
       else ++ arr[1]
        if(arr[0] == arr[1]){
           check = ' '
           arr = intArrayOf(0, 0)
           ++ answer
        }
    }
    // 남은 단어는 ++ 처리 
    if(check != ' ') ++ answer
    return answer
```
> 위와 같은 방식으로 처리를 하였으며 
> 구조 자체가 단순하며 형태가 같다면
> 밑에 처럼 단순한 구조로 바꾸어도 괜찮을 거 같습니다. 

```kotlin
    var count = 0
    val charArray = s.toCharArray()
    for (i in 0 until charArray.size - 1 step 2) {
        if (charArray[i] != charArray[i + 1]) {
            count++
        }
    }
    return count
```

