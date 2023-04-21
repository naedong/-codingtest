fun main(args: Array<String>) {
    var players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    var callings  = arrayOf("kai", "kai", "mine", "mine")

    solution(players, callings).forEach { it ->
        println(it)
    }
}

fun solution(players : Array<String>, callings : Array<String>) : Array<String> {
    for(player in callings.indices){
        if(players.indexOf(callings[player]) != null ){
            var number = players.indexOf(callings[player])
            var str = players[number - 1]
            players[if(number == 0 ) {number} else { number - 1}] = players[number]
            players[number] = str
        }
    }
    return players
}

fun editSolution(players : Array<String>, callings : Array<String>) : Array<String>{
    // 각 선수의 현재 등수를 나타내는 변수(rank)를 선언하고, 1등부터 순서대로 초기화합니다.
    val rankMap = mutableMapOf<String, Int>()
    for ((index, player) in players.withIndex()) {
        rankMap[player] = index + 1
    }

    // callings 배열을 순회하며, 각 호출된 선수의 현재 등수를 추출하고 이전 선수와 등수를 비교합니다.
    for (i in callings.indices) {
        val current = rankMap[callings[i]]!!
        val previous = rankMap[callings[if(i == 0 ) { i } else { i - 1}]]!!
        if (current < previous) {
            // 만약 호출된 선수의 등수가 이전 선수의 등수보다 작다면, 두 선수의 등수를 교환하고, 각 선수의 현재 등수를 업데이트합니다.
            rankMap[callings[i]] = previous
            rankMap[callings[i - 1]] = current
        }
    }
    println(rankMap.toList().sortedBy { it.second }.map { it.first }.toString())
    // 등수 순으로 선수 이름을 정렬하여 반환합니다.
    return rankMap.toList().sortedBy { it.second }.map { it.first }.toTypedArray()

}