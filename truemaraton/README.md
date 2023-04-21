# 연습문제

## 문제 내용 <br>


```
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항

마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.

completion의 길이는 participant의 길이보다 1 작습니다.

참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.

참가자 중에는 동명이인이 있을 수 있습니다.

```

## 문제 풀이 

```kotlin 
// participant : 참여 선수
// completion : 완주 선수
// return : 완주 못한 선수
fun solution(participant : Array<String>, completion : Array<String>) : String{
    var answer = ""
    for(name in completion.indices){
        if(participant[name] == completion[name]){
            completion.get(name)
        }else {
            answer = participant.get(name)
        }
    }
    return answer
}

// participant : 참여 선수
// completion : 완주 선수
// return : 완주 못한 선수
fun editSolution(participant : Array<String>, completion : Array<String>) : String{
    participant.sort() // 참가자 배열 정렬
    completion.sort() // 완주자 배열 정렬

    for(name in completion.indices){
        if(participant[name] != completion[name]){ // 완주자와 참가자가 다른 경우
            return participant[name] // 해당 참가자 이름 반환
        }
    }
    return participant.last() // 모든 완주자와 일치하는 경우, 마지막 참가자 이름 반환
}
```
> 둘다 똑같은 내용의 함수를 반환하지만 시간 복잡도나 세부적인 요인은 다릅니다. <br>
> 위에건 O(n^2) 라면 밑에 것은 O(nlogn) 입니다.

### 최종본
```kotlin 
fun logSolution(participant: Array<String>, completion: Array<String>): String {
    val hash = HashMap<String, Int>()
    for (name in participant) {
        hash[name] = hash.getOrDefault(name, 0) + 1
    }
    for (name in completion) {
        hash[name] = hash.getOrDefault(name, 0) - 1
    }
    for ((key, value) in hash) {
        if (value > 0) {
            return key
        }
    }
    return hash.toSortedMap().toString()
}
```

> 시간 복잡도 O(n) 해시 맵을 사용하여 변환하였습니다. 
> ChatGPT로 검사하면서 알게되었지만 확실히 속도가 개선된 것을 확인 하였습니다.
