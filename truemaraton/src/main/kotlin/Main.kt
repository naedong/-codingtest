fun main(args: Array<String>) {


    var len = arrayOf("mislav", "stanko", "mislav", "ana")
    var com = arrayOf("mislav", "stanko", "ana")
    // itSolution(len,com)
    println(editSolution(len,com))
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.

}

// participant : 참여 선수
// completion : 완주 선수
// return : 완주 못한 선수
fun solution(participant : Array<String>, completion : Array<String>) : String{
    var answer = ""
    // 정답

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
    // 정답
    participant.sort() // 참가자 배열 정렬
    completion.sort() // 완주자 배열 정렬

    for(name in completion.indices){
        if(participant[name] != completion[name]){ // 완주자와 참가자가 다른 경우
            println(participant[name])
            return participant[name] // 해당 참가자 이름 반환
        }
    }
    return participant.last() // 모든 완주자와 일치하는 경우, 마지막 참가자 이름 반환
}



