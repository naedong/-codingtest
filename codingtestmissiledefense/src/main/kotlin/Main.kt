
import java.util.*


fun main(args: Array<String>) {
    var targets = arrayOf(
        intArrayOf(4,5), intArrayOf(4,8),intArrayOf(10,14),
        intArrayOf(11,13), intArrayOf(5,12), intArrayOf(3,7), intArrayOf(1,4) )
    solution(targets)
}


fun solution( targets : Array<IntArray>) : Int {
    var answer = 0
    var center = targets.get(0).last()
    for(target in targets.indices){
        if(targets.get(target).first() < center) {
            continue
        }
        answer ++
    }
    return answer
}


// 밑에는 인터넷 참조하여 변경한 코드
fun editSoultion(targets: Array<IntArray>) : Int{
    var START = 0
    var END= 1


   Arrays.sort(targets) { t1: IntArray, t2: IntArray -> println(t1.get(END) - t2.get(END))
        t1.get(END) - t2.get(END) }

    //맨 처음에는 기준이 없으므로
    //첫번째 미사일을 기준으로 삼는다.

    //맨 처음에는 기준이 없으므로
    //첫번째 미사일을 기준으로 삼는다.
    var missleEnd = targets[0][END]

    var answer = 1

    for (target in targets.indices) {
        val newMissle = targets[target]

        //새로운 미사일이 기존 미사일의 끝 이전에 있으므로 해당 미사일은 같이 터트릴수 있다.
        if (newMissle[START] < missleEnd) {
            continue
        }

        missleEnd = newMissle[END]
        answer++
    }
    return answer
}


// gpt에게 코드 부탁해서 짠 코드
fun gptSolution( targets: Array<IntArray> ) : Int{
    targets.sortBy { it[0] } // targets 배열을 s값을 기준으로 정렬합니다.
    var missile = mutableListOf<Int>()  // 요격가능한 개구간의 끝점 값을 저장할 리스트 missile을 초기화 합니다.
    for( target in targets) {  // targets  배열의 각 폭격 미사일의 시작점보다 작거나 같은 요격 가능한 개구간을 찾아, 해당 미사일의 끝점 값을 misile에 추가 합니다.
        val start = target[0]
        val end = target[1]
        var idx = 0
        while (idx < missile.size && missile[idx] < start){ // 끝점값이 현재 폭격 미사일의 시작점보다 작거나 같은 요격 가능한 개구간 찾기
            idx ++
        }
        if(idx == missile.size){ // 새로운 요격 미사일
            missile.add(end)
        }
        else { // 기존의 요격 미사일 사용
            missile[idx] = minOf(missile[idx], end)
        }
    }
    return missile.size
}